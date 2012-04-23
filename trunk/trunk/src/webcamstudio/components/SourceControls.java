/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webcamstudio.components;

import java.awt.Component;
import java.util.ArrayList;
import webcamstudio.streams.*;

/**
 *
 * @author patrick
 */
public class SourceControls {

    public static ArrayList<Component> getControls(Stream source) {
        ArrayList<Component> comps = new ArrayList<Component>();
        Component c = null;

        if (source instanceof SourceDesktop) {
        } else if (source instanceof SourceMovie) {
            c = new SourceEffects(source);
            c.setName("Effects");
            comps.add(c);
        } else if (source instanceof SourceWebcam) {
            c = new SourceEffects(source);
            c.setName("Effects");
            comps.add(c);
        } else if (source instanceof SourceText) {
        } else if (source instanceof SourceMusic) {
        } else if (source instanceof SourceImage) {
        } else if (source instanceof SourceImageGif) {
        } else if (source instanceof SourceQRCode) {
        }

        return comps;
    }
}
