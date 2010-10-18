/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webcamstudio.exporter.vloopback;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import java.awt.image.BufferedImage;
import webcamstudio.InfoListener;

/**
 *
 * @author patrick
 */
public class V4L2Loopback extends VideoOutput{


    public V4L2Loopback(InfoListener l){
        listener=l;
    }
    @Override
    public void open(String path, int w, int h, int pixFormat) {
        devicePath = path;
        this.pixFormat = pixFormat;
        devFD = CV4l2.INSTANCE.open_device(devicePath, w, h, pixFormat);
        if (devFD <= 0) {
            System.out.println("Error Opening Device");
        }
    }

    @Override
    public void close() {
        CV4l2.INSTANCE.close_device(devFD);
    }

    @Override
    public void write(BufferedImage bi) {
        if (flipImage){
            bi = flipper.cloneImage(bi);
            flipper.applyEffect(bi);
        }
        if (devFD != 0) {

            byte[] buffer = null;
            switch(pixFormat){
                case RGB24:
                    buffer = img2rgb24(bi);
                    break;
                case UYVY:
                    buffer = img2uyvy(bi);
                    break;
            }
            
            int countWritten = 0;
            countWritten = CV4l2.INSTANCE.writeData(devFD, buffer, buffer.length);
            if (countWritten != buffer.length) {
                System.out.println("Error Writing Data - " + countWritten);
            }
        }
    }


    public interface CV4l2 extends Library {

        CV4l2 INSTANCE = (CV4l2) Native.loadLibrary((Platform.isWindows() ? "webcamstudio" : "webcamstudio"),
                CV4l2.class);

        int close_device(int device);

        int open_device(String path, int w, int h, int pixFormat);

        int writeData(int device, byte[] buffer, int length);
    }
}


