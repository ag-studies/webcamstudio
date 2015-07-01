/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webcamstudio.media.renderer;

import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;
import java.lang.System;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import static webcamstudio.WebcamStudio.audioFreq;
import webcamstudio.mixers.Frame;
import webcamstudio.mixers.WSImage;
import webcamstudio.streams.SourceMovie;
import webcamstudio.streams.SourceMusic;
import webcamstudio.streams.Stream;
import webcamstudio.util.Tools;

/**
 *
 * @author patrick (modified by karl)
 *
 * Capturer is used to read output from a running process, and capture audio or video data within that output.
 * The data is passed over a TCP socket.
 * Presently Capturer reads this data only when instructed to do so by
 * an outside caller, but it should be changed to run as a thread and
 * read in new data as soon as it's available.
 */
public class Capturer {
    private int vport = 0;
    private int aport = 0;
    private Stream stream;
    private ServerSocket videoServer = null;
    private ServerSocket audioServer = null;
    private WSImage[] imageBuffer = null;
    private AtomicInteger imagesBack = new AtomicInteger();
    private AtomicInteger imagesFront = new AtomicInteger();

    private byte[] audioBuffer = null;
    private AtomicInteger audioBack = new AtomicInteger();
    private AtomicInteger audioFront = new AtomicInteger();

    private int frameRate = 0;

    private Frame frame = null;
    private InputStream videoIn = null;
    private InputStream audioIn = null;
    private InputStream fakeVideoIn = null;
    private InputStream fakeAudioIn = null;
    private boolean vPauseFlag = false;
    private boolean aPauseFlag = false;
    private int streamTotalEnd = 0;
    private int totalPauseTime = 0;
    private int streamEndTime = 0;
    private int currTime = 0;
    private int pauseTime = 0;
    private Thread vCaptureThread = null;
    private Thread aCaptureThread = null;
    private boolean stop = false;

    // buffer sizes must be powers of two
    private final int frameBufferSize = (1 << 2);
    private final int audioBufferSize = (1 << 15);    // Should be big enough for a few frames of audio data...


    public Capturer(Stream s, InputStream vid, InputStream aud) {
        stop = false;
        stream = s;
        frame = new Frame(stream.getCaptureWidth(), stream.getCaptureHeight(), stream.getRate());

        if (vid != null) videoIn = vid;
        if (aud != null) audioIn = aud;

        imageBuffer = new WSImage[frameBufferSize];
        for (int i = 0; i < frameBufferSize; i++) {
            imageBuffer[i] = new WSImage(stream.getCaptureWidth(), stream.getCaptureHeight(), BufferedImage.TYPE_INT_RGB);
        }

        audioBuffer = new byte[audioBufferSize];

        frameRate = stream.getRate();

        if (stream.hasAudio() && aud == null) {
            try {
                audioServer = new ServerSocket(0);
                aport = audioServer.getLocalPort();
            } catch (IOException ex) {
                Logger.getLogger(Capturer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (!stream.isOnlyAudio() && vid == null) {
            try {
                videoServer = new ServerSocket(0);
                vport = videoServer.getLocalPort();
            } catch (IOException ex) {
                Logger.getLogger(Capturer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (!stream.isOnlyAudio()) {
            vCaptureThread = new Thread(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            boolean noVideoPres = (videoIn == null);
                            Socket connection = (videoServer == null)? null : videoServer.accept();
                            System.out.println(stream.getName() + " Video accepted...");
                            String duration = stream.getStreamTime();
                            if (stream.hasFakeVideo() && connection != null) {
                                fakeVideoIn = connection.getInputStream();
                            }
                            while (noVideoPres)  {
                                Tools.sleep(20);
                                if (fakeAudioIn != null) {
                                    if (fakeAudioIn.available() != 0) {
                                        noVideoPres=false;
                                        Tools.sleep(stream.getVDelay());
                                        videoIn = fakeVideoIn;

                                        if (!duration.equals("N/A")) {
                                            int millisDuration = Integer.parseInt(duration.replace("s", ""))*1000;
                                            streamEndTime = (int) System.currentTimeMillis() + millisDuration;
                                            streamTotalEnd = streamEndTime;
                                        }
                                        System.out.println("Start Video ...");
                                    }
                                } else if (stream.getName().contains("Desktop")) {
                                    noVideoPres = false;
                                    Tools.sleep(stream.getVDelay());
                                    videoIn = connection.getInputStream();
                                    System.out.println("Start Dekstop Video ...");
                                } else if (stream.getClass().getName().contains("SourceWebcam")) {
                                    noVideoPres=false;
                                    Tools.sleep(stream.getVDelay());
                                    videoIn = connection.getInputStream();
                                    System.out.println("Start Webcam Video ...");
                                } else if (!stream.hasAudio()) {
                                    noVideoPres=false;
                                    Tools.sleep(stream.getVDelay());
                                    videoIn = fakeVideoIn;
                                    if (!duration.equals("N/A")) {
                                        int millisDuration = Integer.parseInt(stream.getStreamTime().replace("s", ""))*1000;
                                        streamEndTime = (int) System.currentTimeMillis() + millisDuration;
                                        streamTotalEnd = streamEndTime;
                                    }

                                    System.out.println("Start NoAudio Video ...");
                                }
                            } while (noVideoPres);

                        } catch (IOException ex) {
                            Logger.getLogger(Capturer.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        // Read source data until we're told to stop
                        try {
                            long prevFrameTime = System.currentTimeMillis();
                            while (!stop) {
                                // Store (img) into imageBuffer[].
                                // (x & (n-1)) where (n = 1 << z) is a cheap form of unsigned (x % n).
                                int frameBufferIndex = (imagesBack.get() & (frameBufferSize - 1));

                                // Capture straight into imageBuffer[]
                                getNextImage(imageBuffer[frameBufferIndex]);
                                long currentFrameTime = System.currentTimeMillis();

                                // Advance imagesBack if we have space.
                                // Note imagesBack and imagesFront aren't synchronized; this should be OK as integer update is probably atomic.
                                // It's relatively safe anyway since imagesBack is only updated here, and imagesFront is only ever incremented.
                                // - Note that we have to check that the queueSize AFTER incrementing is smaller than the limit - this is because the call to
                                //   getNextImage overwrites the element at imagesBack, which is the same element as imagesFront when the queue is full.
                                int queueSize = (imagesBack.get() - imagesFront.get());
                                if ((queueSize >= 0) && ((queueSize + 1) < frameBufferSize))
                                {
                                    imagesBack.incrementAndGet();
                                }

                                if (currentFrameTime < prevFrameTime + (1000 / frameRate))
                                {
                                    // Sleep for less than the nominal frame interval of (1000ms / frameRate) to help stay ahead of the producer.
                                    long sleeptime = ((1000 / frameRate) / 2);
                                    Tools.sleep(sleeptime);
                                }
                                prevFrameTime = currentFrameTime;
                            }
                        } catch (IOException e) {
                            // Probably we lost the socket connection...
                            // In which case there's not much point keeping the capture thread running.
                        }
                    }
                }, "vCapture");
            vCaptureThread.start();
        }

        if (stream.hasAudio()) {
            aCaptureThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            boolean noAudioPres = true;
                            Socket connection = audioServer.accept();
                            System.out.println(stream.getName() + " Audio accepted...");
                            if (stream.hasFakeAudio()) {
                                fakeAudioIn = connection.getInputStream();
                            }
                            do {
                                Tools.sleep(20);
                                if (fakeVideoIn != null)  {
                                    if (fakeVideoIn.available() != 0) {
                                        noAudioPres = false;
                                        Tools.sleep(stream.getADelay());
                                        audioIn = fakeAudioIn;
                                        System.out.println("Start Audio ...");
                                    }
                                } else if (stream.getName().endsWith(".mp3") || !stream.hasVideo() ) {
                                    noAudioPres = false;
                                    Tools.sleep(stream.getADelay());
                                    audioIn = connection.getInputStream();
                                    System.out.println("Start Audio ...");
                                }
                            } while (noAudioPres);
                        } catch (IOException ex) {
                            Logger.getLogger(Capturer.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        // Read source data until we're told to stop
                        try {
                            byte[] trashBuffer = new byte[2048];

                            while (!stop) {
                                // Read as much data as we can into the audio buffer.
                                int bufferIndex = (audioBack.get() & (audioBufferSize - 1));

                                // Upper bound for readSize is the amount of space between bufferIndex and the end of the buffer:
                                int readSize = (audioBufferSize - bufferIndex);

                                // But we're also bounded by (capacity - size):
                                int freeSpace = (audioBufferSize - (audioBack.get() - audioFront.get()));
                                if (readSize > freeSpace) readSize = freeSpace;

                                // If we've got space to read some data, then do so
                                if (readSize > 0)
                                {
                                    int readResult = audioIn.read(audioBuffer, bufferIndex, readSize);
                                    audioBack.addAndGet(readResult);
                                } else {
                                    // Buffer is full, apparently...  Which kind of stinks but we want to keep pulling data off that stream so it doesn't get backed
                                    // up with buffered data...  So we read data and drop it.
                                    audioIn.read(trashBuffer, 0, trashBuffer.length);
                                }

                                // Sleep only if there's enough audio data in the buffer for a frame:
                                if ((audioBack.get() - audioFront.get()) >= (audioFreq * 2 * 2 / frameRate))
                                {
                                    Tools.sleep((1000 / frameRate) / 2);
                                }
                            }
                        } catch (IOException e) {
                            // Probably the stream's been closed or lost, in which case we're done.
                        }
                    }
                }, "aCapture");
            aCaptureThread.start();
        }
    }

    public void abort() {
        try {
            // Signal the capture threads to stop
            stop = true;
            try {
                if (vCaptureThread != null) vCaptureThread.join(100);
                if (aCaptureThread != null) aCaptureThread.join(100);
            } catch (InterruptedException e) {
                // FIXME: what to do?
                // If the capture threads didn't end, closing the
                // streams (below) should do the trick...
            }

            // Close capture streams - if the capture threads are
            // still running (blocking on reads) they should get
            // IOExceptions as a result and end.
            if (videoServer != null) {
                videoServer.close();
                videoServer = null;
                videoIn = null;
                fakeVideoIn = null;
            }
            if (audioServer != null) {
                audioServer.close();
                audioServer = null;
                audioIn = null;
                fakeAudioIn = null;
            }
        } catch (IOException ex) {
            Logger.getLogger(Capturer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void vPause() {
        vPauseFlag = true;
        currTime = (int) System.currentTimeMillis();
//        System.out.println("VideoCapture Paused ...");
    }

    public void aPause() {
        aPauseFlag = true;
//        System.out.println("AudioCapture Paused ...");
    }

    public void vPlay() {
        vPauseFlag = false;
        totalPauseTime += pauseTime;
        streamTotalEnd = streamEndTime + totalPauseTime;
//        System.out.println("VideoCapture Resumed ...");
    }

    public void aPlay() {
        aPauseFlag = false;
//        System.out.println("AudioCapture Resumed ...");
    }

    public int getVideoPort() {
        return vport;
    }

    public int getAudioPort() {
        return aport;
    }

    private WSImage getNextImage(WSImage image) throws IOException {
        if (videoIn != null && !vPauseFlag) {
            if (stream instanceof SourceMovie || stream instanceof SourceMusic ) {
                if (vPauseFlag) {
                    image.readFully(videoIn);
                    return image;
                } else {
                    if ((int)System.currentTimeMillis() < streamTotalEnd) {
                        image.readFully(videoIn);
                        return image;
                    } else {
                        return null;
                    }
                }
            } else {
                image.readFully(videoIn);
                return image;
            }
        } else {
            return null;
        }
    }

    private BufferedImage toCompatibleImage(BufferedImage image) {
	GraphicsConfiguration gfx_config = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
	if (image.getColorModel().equals(gfx_config.getColorModel())) {
            return image;
        }
	BufferedImage new_image = gfx_config.createCompatibleImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
	Graphics2D g2d = (Graphics2D)new_image.getGraphics();
	g2d.drawImage(image, 0, 0, null);
	g2d.dispose();
	return new_image;
    }

    public Frame getFrame() {
        // Try to get one frame worth of video and audio from the respective buffers.
        BufferedImage frameImage = null;
        BufferedImage quantumImage = null;
        byte[] frameAudio = frame.getAudioData();
        int frameAudioSize = 0;

        // TODO: Handle situations like "vPause" and "aPause" - I guess aPause just turns audio off, and vPause uses an image from the image buffer but doesn't
        // consume it. But how does that impact the capture threads? I guess I need to know more about how SourceMovie, etc. work.   ---GEC
        if (stream.hasVideo()) {
            if ((imagesBack.get() - imagesFront.get()) > 0) {
                // There is at least one video frame available, so let's take it.
                quantumImage = imageBuffer[imagesFront.get() & (frameBufferSize - 1)];
            } else {
                // No video is available yet, so we can't construct a frame.
                return null;
            }
        }

        if (stream.hasAudio()) {
            // If audioFreq isn't evenly divisible by frameRate, we need to be a little bit flexible in how much buffered audio data we put in the frame.
            // It's always a multiple of 4 (so it's a whole number of 2 channel, 2 byte samples) and it's always close to (audioFreq * 4 / frameRate).
            int minAudioSizeForFrame = ((audioFreq / frameRate) * 4);
            int maxAudioSizeForFrame = (((audioFreq + frameRate - 1) / frameRate) * 4);
            int audioBufferSize = (audioBack.get() - audioFront.get());

            if (audioBufferSize < minAudioSizeForFrame) {
                // Not enough audio for a frame.
                return null;
            }

            // Copy out the maximum allowed number of audio bytes if we have enough, otherwise copy out the minimum
            frameAudioSize = minAudioSizeForFrame;
            if (audioBufferSize >= maxAudioSizeForFrame) {
                frameAudioSize = maxAudioSizeForFrame;
            }
        }

        // If we've come this far, we've got the data we need to produce a Frame. So...
        if (quantumImage != null) {
            frameImage = toCompatibleImage(quantumImage);
            frame.setImage(frameImage);

            // Indicate that we've consumed an image from the queue, unless it's the only one available...
            if ((imagesBack.get() - imagesFront.get()) > 1) {
                imagesFront.incrementAndGet();
            }
        }

        if (frameAudioSize > 0) {
            // Copy audio data out of the buffer. Note the data we're copying may wrap around the end of the buffer.
            int bufferIndex = (audioFront.get() & (audioBufferSize - 1));
            int copyLength = (audioBufferSize - bufferIndex);
            if (copyLength > frameAudioSize) {
                copyLength = frameAudioSize;
            }

            int targetIndex = 0;
            System.arraycopy(audioBuffer, bufferIndex, frameAudio, targetIndex, copyLength);

            // If the source data wraps around the end of the buffer, copy the rest of it from the start of the buffer array:
            if (copyLength < frameAudioSize) {
                bufferIndex = 0;
                targetIndex = copyLength;
                copyLength = (frameAudioSize - copyLength);

                System.arraycopy(audioBuffer, bufferIndex, frameAudio, targetIndex, copyLength);
            }

            // Advance audioFront to indicate we've consumed the data.
            audioFront.addAndGet(frameAudioSize);
        }

        // Frame should be good to go now, just set its properties (do we really need to do this every time?) and return it.
        frame.setOutputFormat(stream.getX(), stream.getY(), stream.getWidth(), stream.getHeight(), stream.getOpacity(), stream.getVolume());
        frame.setZOrder(stream.getZOrder());
        return frame;
    }
}
