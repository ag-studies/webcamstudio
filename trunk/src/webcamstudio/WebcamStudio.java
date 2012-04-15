/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * WebcamStudio.java
 *
 * Created on 4-Apr-2012, 3:48:07 PM
 */
package webcamstudio;

import java.awt.BorderLayout;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.io.File;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;
import javax.swing.ImageIcon;
import webcamstudio.components.MasterPanel;
import webcamstudio.components.OutputRecorder;
import webcamstudio.components.ResourceMonitor;
import webcamstudio.components.StreamDesktop;
import webcamstudio.exporter.vloopback.VideoDevice;
import webcamstudio.mixers.MasterMixer;
import webcamstudio.streams.SinkFile;
import webcamstudio.streams.SourceDesktop;
import webcamstudio.streams.SourceText;
import webcamstudio.streams.SourceWebcam;
import webcamstudio.streams.Stream;

/**
 *
 * @author patrick
 */
public class WebcamStudio extends javax.swing.JFrame {

    Preferences prefs = null;

    /** Creates new form WebcamStudio */
    public WebcamStudio() {
        initComponents();
        MasterMixer.start();
        ImageIcon icon = new ImageIcon(this.getClass().getResource("/webcamstudio/resources/icon.png"));
        this.setIconImage(icon.getImage());

        panSources.add(new MasterPanel(), BorderLayout.WEST);


        for (VideoDevice d : VideoDevice.getOutputDevices()) {

            Stream webcam = new SourceWebcam(d.getFile());
            StreamDesktop frame = new StreamDesktop(webcam);
            desktop.add(frame, javax.swing.JLayeredPane.DEFAULT_LAYER);
        }
        desktop.setDropTarget(new DropTarget() {

            public synchronized void drop(DropTargetDropEvent evt) {
                try {
                    evt.acceptDrop(DnDConstants.ACTION_REFERENCE);
                    String files = evt.getTransferable().getTransferData(DataFlavor.stringFlavor).toString();
                    String[] lines = files.split("\n");
                    for (String line : lines) {
                        File file = new File(new URL(line.trim()).toURI());
                        if (file.exists()) {
                            Stream stream = Stream.getInstance(file);
                            if (stream != null) {
                                StreamDesktop frame = new StreamDesktop(stream);
                                desktop.add(frame, javax.swing.JLayeredPane.DEFAULT_LAYER);
                            }
                        }
                    }
                    evt.dropComplete(true);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        this.add(new ResourceMonitor(), BorderLayout.SOUTH);
        prefs = Preferences.userNodeForPackage(this.getClass());
        this.add(new OutputRecorder(), BorderLayout.WEST);
        loadPrefs();
    }

    private void loadPrefs() {
        int x = prefs.getInt("main-x", 100);
        int y = prefs.getInt("main-y", 100);
        int w = prefs.getInt("main-w", 800);
        int h = prefs.getInt("main-h", 400);
        this.setLocation(x, y);
        this.setSize(w, h);
    }

    private void savePrefs() {
        prefs.putInt("main-x", this.getX());
        prefs.putInt("main-y", this.getY());
        prefs.putInt("main-w", this.getWidth());
        prefs.putInt("main-h", this.getHeight());
        try {
            prefs.flush();
        } catch (BackingStoreException ex) {
            Logger.getLogger(WebcamStudio.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panSources = new javax.swing.JPanel();
        desktop = new javax.swing.JDesktopPane();
        toolbar = new javax.swing.JToolBar();
        btnAddDesktop = new javax.swing.JButton();
        btnAddText = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WebcamStudio");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panSources.setMinimumSize(new java.awt.Dimension(400, 400));
        panSources.setName("panSources"); // NOI18N
        panSources.setLayout(new java.awt.BorderLayout());

        desktop.setAutoscrolls(true);
        desktop.setMinimumSize(new java.awt.Dimension(400, 400));
        desktop.setName("desktop"); // NOI18N
        panSources.add(desktop, java.awt.BorderLayout.CENTER);

        getContentPane().add(panSources, java.awt.BorderLayout.CENTER);

        toolbar.setRollover(true);
        toolbar.setName("toolbar"); // NOI18N

        btnAddDesktop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/tango/user-desktop.png"))); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("webcamstudio/Languages"); // NOI18N
        btnAddDesktop.setToolTipText(bundle.getString("DESKTOP")); // NOI18N
        btnAddDesktop.setFocusable(false);
        btnAddDesktop.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAddDesktop.setName("btnAddDesktop"); // NOI18N
        btnAddDesktop.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAddDesktop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDesktopActionPerformed(evt);
            }
        });
        toolbar.add(btnAddDesktop);

        btnAddText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/tango/accessories-text-editor.png"))); // NOI18N
        btnAddText.setToolTipText(bundle.getString("TEXT")); // NOI18N
        btnAddText.setFocusable(false);
        btnAddText.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAddText.setName("btnAddText"); // NOI18N
        btnAddText.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAddText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTextActionPerformed(evt);
            }
        });
        toolbar.add(btnAddText);

        getContentPane().add(toolbar, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        savePrefs();
    }//GEN-LAST:event_formWindowClosing

    private void btnAddDesktopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDesktopActionPerformed
        SourceDesktop stream = new SourceDesktop();
        StreamDesktop frame = new StreamDesktop(stream);
        desktop.add(frame, javax.swing.JLayeredPane.DEFAULT_LAYER);
    }//GEN-LAST:event_btnAddDesktopActionPerformed

    private void btnAddTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTextActionPerformed
        SourceText stream = new SourceText("");
        StreamDesktop frame = new StreamDesktop(stream);
        desktop.add(frame, javax.swing.JLayeredPane.DEFAULT_LAYER);
    }//GEN-LAST:event_btnAddTextActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WebcamStudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WebcamStudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WebcamStudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WebcamStudio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new WebcamStudio().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddDesktop;
    private javax.swing.JButton btnAddText;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JPanel panSources;
    private javax.swing.JToolBar toolbar;
    // End of variables declaration//GEN-END:variables
}
