/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * StreamDesktop.java
 *
 * Created on 15-Apr-2012, 12:29:14 AM
 */
package webcamstudio.components;

import java.awt.BorderLayout;
import webcamstudio.streams.Stream;

/**
 *
 * @author patrick (modified by karl)
 */
public class WSPreviewScreen extends javax.swing.JInternalFrame {
    
    /** Creates new form StreamFullDesktop
     * @param viewer */
    public WSPreviewScreen(PreViewer viewer) {
        initComponents();
        WSPreviewPanel p = new WSPreviewPanel(viewer);
        this.setLayout(new BorderLayout());
        this.add(p, BorderLayout.CENTER);
        this.setVisible(true);
        this.setClosable(false);
        this.setResizable(false);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        pack();
        
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setMaximizable(true);
        setResizable(true);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/tango/PreviewButton2.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(1280, 1024));
        setVisible(true);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public interface Listener {

        public void selectedSource(Stream source);
    }
}
