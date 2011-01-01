/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MediaPanelList.java
 *
 * Created on 2010-12-29, 17:22:09
 */
package webcamstudio.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import webcamstudio.exporter.VideoExporter;
import webcamstudio.sources.*;

/**
 *
 * @author patrick
 */
public class MediaPanelList extends javax.swing.JPanel {

    private ImageIcon iconMovie = null;
    private ImageIcon iconImage = null;
    private ImageIcon iconDevice = null;
    private ImageIcon iconAnimation = null;
    private ImageIcon iconFolder = null;
    private java.util.concurrent.ExecutorService pool = java.util.concurrent.Executors.newFixedThreadPool(1);
    private MediaListener listener = null;
    /** Creates new form MediaPanelList */
    public MediaPanelList(MediaListener l) {
        iconMovie = new ImageIcon(getToolkit().getImage(java.net.URLClassLoader.getSystemResource("webcamstudio/resources/tango/video-display.png")));
        initComponents();
        listener = l;
    }

    public void setPanelName(String name) {
        setBorder(javax.swing.BorderFactory.createTitledBorder(name));
    }

    public void addMedia(final VideoSource source) {
        ThreadedJButton media = new ThreadedJButton(source);
        media.setToolTipText("<HTML><BODY><center><img src='file://" + System.getenv("HOME") + "/.webcamstudio/thumbs/" + source.getLocation().replaceAll("/", "_").replaceAll("file:","") + ".png' width=128 height=128></center><br>"+source.getLocation()+"</BODY></HTML>");
        media.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                listener.addSource(source);
            }
        });
        pool.submit(media);
        add(media);
    }

    public void addMedia(VideoExporter export) {
        JButton media = new JButton();
        media.setToolTipText(export.getName());
        media.setIcon(iconMovie);
        add(media);

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBorder(javax.swing.BorderFactory.createTitledBorder("TEST"));
        setFocusable(false);
        setLayout(new java.awt.GridLayout(0, 5));
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

class ThreadedJButton extends JButton implements Runnable{
    VideoSource source = null;
    public ThreadedJButton(VideoSource source){
        this.source=source;
    }
    @Override
    public void run() {
        setIcon(source.getThumbnail());
    }

}
