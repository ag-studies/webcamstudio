/**
 *  WebcamStudio for GNU/Linux
 *  Copyright (C) 2008  Patrick Balleux
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * 
 */
package webcamstudio.sources;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import org.gstreamer.*;
import webcamstudio.controls.ControlAudio;
import webcamstudio.controls.ControlRescale;

/**
 *
 * @author pballeux
 */
public class VideoSourceMovie extends VideoSource implements org.gstreamer.elements.RGBDataSink.Listener {

    protected VideoSourceMovie() {
        frameRate = 24;
        captureWidth = 320;
        captureHeight = 240;
        doRescale = true;
        keepRatio=true;
    }

    public VideoSourceMovie(java.io.File loc) {

        location = loc.getAbsolutePath();
        name = loc.getName();
        hasSound = true;
        volume = 10;
        frameRate = 24;
        captureWidth = 320;
        captureHeight = 240;
        doRescale = true;
        keepRatio=true;
    }

    public VideoSourceMovie(java.net.URL loc) {

        location = loc.toString();
        name = loc.toString();
        hasSound = true;
        volume = 10;
        frameRate = 24;
        captureWidth = 320;
        captureHeight = 240;
        doRescale = true;
        keepRatio=true;
    }

    public VideoSourceMovie(String loc) {
        location = loc;
        name = loc;
        
        hasSound = true;
        volume = 10;
        frameRate = 24;
        captureWidth = 320;
        captureHeight = 240;
        doRescale = true;
        keepRatio=true;
    }

    public void setName(String n) {
        name = n;
    }

    public void stopSource() {
        stopMe = true;
        if (pipe != null) {

            pipe.stop();
            pipe.getState();
            elementSink = null;
            java.util.List<Element> list = pipe.getElements();
            for (int i = 0; i < list.size(); i++) {
                list.get(i).disown();
                pipe.remove(list.get(i));
            }
            pipe = null;
        }
        elementSink = null;
        image = null;
        pixels = null;
        tempimage = null;
        isPlaying = false;
    }

    @Override
    public void startSource() {
        String pipeline = "";
        try {
            isPlaying = true;
            if (location.toLowerCase().startsWith("http://") || location.toLowerCase().startsWith("https://")) {
                pipeline = "souphttpsrc location=\""+location+"\" ! decodebin name=decode ";
                loadSound=true;
            } else if (location.toLowerCase().startsWith("rtsp://")) {
                pipeline = "rtspsrc location=\""+location+"\" ! decodebin name=decode ";
                loadSound = true;
            } else if (location.toLowerCase().startsWith("tcp://")) {
                pipeline = "tcpclientsrc ";
                
                String[] addr = location.replaceFirst("tcp://", "").split(":");
                switch (addr.length) {
                    case 2:
                        pipeline+= " host=" +addr[0];
                        pipeline+= " port=" + addr[1];
                        break;
                    case 1:
                        pipeline+= " host=" +addr[0];
                        pipeline+= " port=4888";
                        break;
                }
                pipeline+= " ! decodebin  name=decode ";
                loadSound = true;
            } else if (location.toLowerCase().startsWith("rfb://")) {

                pipeline = "rfbsrc view-only=true incremental=false";
                String[] addr = location.replaceFirst("rfb://", "").split(":");
                switch (addr.length) {
                    case 3:
                        pipeline+= " host=" +addr[0];
                        pipeline+= " port=" +addr[1];
                        pipeline+= " password=" +addr[2];
                        break;
                    case 2:
                        pipeline+= " host=" +addr[0];
                        pipeline+= " port=" +addr[1];
                        break;
                    case 1:
                        pipeline+= " host=" +addr[0];
                        break;
                }
                loadSound = false;
            } else {
                pipeline="filesrc location=\""+location+"\" ! decodebin  name=decode ";
                loadSound = true;
            }

            pipeline += " ! ffmpegcolorspace ";
            if (outputHeight == 0 && outputWidth == 0) {
                outputWidth = captureWidth;
                outputHeight = captureHeight;
            }
            if (doRescale){
                pipeline += " ! videorate ! video/x-raw-yuv,framerate="+frameRate + "/1 ! videoscale add-borders=true ! video/x-raw-yuv,width=" + captureWidth + ",height=" + captureHeight;
            }
            if (activeEffect.length() != 0) {
                pipeline += " ! ffmpegcolorspace ! " + activeEffect + " ! ffmpegcolorspace ";
            }
            pipeline+= " ! alpha ! ffmpegcolorspace ! video/x-raw-rgb,bpp=32,depth=24, red_mask=65280, green_mask=16711680, blue_mask=-16777216 ! ffmpegcolorspace name=tosink";
            if (loadSound){
                pipeline += " decode. ! queue ! volume name=volume volume="+(double)volume / 100D +" ! audioconvert ! autoaudiosink ";
            }
            System.out.println(pipeline);
            pipe = Pipeline.launch(pipeline);
            elementSink = new org.gstreamer.elements.RGBDataSink("RGBDataSink" + uuId, this);
            elementSink.setPassDirectBuffer(false);
            pipe.add(elementSink);
            Element lastElement = pipe.getElementByName("tosink");
            lastElement.link(elementSink);
            if (loadSound){
                elementAudioVolume = pipe.getElementByName("volume");
            }
            pipe.getBus().connect(new Bus.EOS() {

                public void endOfStream(GstObject arg0) {
                    pipe.stop();
                    if (doLoop) {
                        pipe.setState(State.PLAYING);
                    } else {
                        info("ENDOFSTREAM");
                    }
                }
            });
            pipe.getBus().connect(new Bus.ERROR() {

                public void errorMessage(GstObject arg0, int arg1, String arg2) {
                    System.out.println("Movie Error:  " + arg0 + "," + arg1 + ", " + arg2);
                    error("Movie Error:  " + arg0 + "," + arg1 + ", " + arg2);
                    doLoop = false;
                }
            });
            pipe.setState(State.PLAYING);
            duration = pipe.queryDuration().toSeconds();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void rgbFrame(int w, int h, java.nio.IntBuffer buffer) {
        captureWidth = w;
        captureHeight = h;
        if (!isRendering) {
            isRendering = true;
            int[] array = new int[w * h];
            buffer.get(array);
            tempimage = graphicConfiguration.createCompatibleImage(captureWidth, captureHeight, java.awt.image.BufferedImage.TRANSLUCENT);
            if (activeEffect.equals("vertigotv") || activeEffect.equals("shagadelictv")) {
                for (int i = 0; i < array.length; i++) {
                    array[i] = array[i] | 0xFF000000;
                }
            }
            tempimage.setRGB(0, 0, captureWidth, captureHeight, array, 0, captureWidth);
            detectActivity(tempimage);
            applyEffects(tempimage);
            applyShape(tempimage);
            image = tempimage;
            isRendering = false;
        }

    }

    public void seek(long secs) {
        if (secs >= 0 && secs <= duration && pipe != null && pipe.isPlaying()) {
            pipe.pause();
            pipe.seek(ClockTime.fromSeconds(secs));
            pipe.play();
        }
    }

    public boolean canUpdateSource() {
        return false;
    }

    public long getSeekPosition() {
        long pos = 0;
        if (pipe != null && (pipe.isPlaying() || pipe.getState() == State.PAUSED)) {
            pos = pipe.queryPosition().toSeconds();
        }
        return pos;
    }

    public long getDuration() {
        duration = 0;
        if (pipe != null) {
            duration = pipe.queryDuration().toSeconds();
        }
        return duration;
    }

    @Override
    public boolean isPlaying() {
        return isPlaying;
    }

    @Override
    public void pause() {
        if (pipe != null) {
            pipe.pause();
        }
    }

    public void play() {
        if (pipe != null) {
            pipe.play();
        }
    }

    @Override
    public void setVolume(int v) {
        volume = v;
        elementAudioVolume.set("volume", (double) v / 100D);

    }

    @Override
    public boolean isPaused() {
        boolean retValue = false;
        if (pipe != null) {
            retValue = (pipe.getState() == State.PAUSED);
        }
        return retValue;
    }

    
    @Override
    public String toString() {
        return "Movie: " + new java.io.File(location).getName();
    }

    @Override
    public boolean hasText() {
        return false;
    }

    @Override
    public java.util.Collection<JPanel> getControls() {
        java.util.Vector<JPanel> list = new java.util.Vector<JPanel>();
        list.add(new ControlRescale(this));
        list.add(new webcamstudio.controls.ControlEffects(this));
        list.add(new webcamstudio.controls.ControlShapes(this));
        list.add(new webcamstudio.controls.ControlGSTEffects(this));
        list.add(new webcamstudio.controls.ControlActivity(this));
        list.add(new webcamstudio.controls.ControlFaceDetection(this));
        list.add(new ControlAudio(this));
        return list;
    }
    private Element effectSource = null;
    private Element currentEffect = null;
    private Element effectSink = null;
    private Element elementAudioVolume = null;
    private org.gstreamer.elements.RGBDataSink elementSink = null;
    private Pipeline pipe = null;
    private long duration = 0;

    @Override
    public ImageIcon getThumbnail() {
        ImageIcon icon = getCachedThumbnail();
        if (icon == null) {
            loadSound = false;
            startSource();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(VideoSourceMovie.class.getName()).log(Level.SEVERE, null, ex);
            }
            pipe.seek(ClockTime.fromSeconds(300));
            image = null;
            while (image == null) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(VideoSourceMovie.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            icon = new ImageIcon(image.getScaledInstance(32, 32, BufferedImage.SCALE_FAST));



            try {
                saveThumbnail(new ImageIcon(image.getScaledInstance(128, 128, BufferedImage.SCALE_FAST)));
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                Logger.getLogger(VideoSourceMovie.class.getName()).log(Level.SEVERE, null, ex);
            }
            stopSource();
            loadSound = true;
        }
        return icon;
    }
}
