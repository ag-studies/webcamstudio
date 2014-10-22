/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webcamstudio;

import javax.swing.ImageIcon;
import webcamstudio.streams.Stream;

/**
 *
 * @author atari
 */
public class WSPreview extends javax.swing.JFrame {
    Stream stream = null;
    public interface Listener {
        public void resetPreviewer(java.awt.event.ActionEvent evt);    
    }
    static Listener listenerPW = null;
    public static void setListenerPW(Listener l) {
        listenerPW = l;
    }
    /**
     * Creates new form FullScreenWindow
     */
    public WSPreview() {
        initComponents();
        ImageIcon icon = new ImageIcon(this.getClass().getResource("/webcamstudio/resources/icon.png"));
        this.setIconImage(icon.getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("WS Master Preview Screen");
        setPreferredSize(new java.awt.Dimension(400, 330));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        listenerPW.resetPreviewer(null);
    }//GEN-LAST:event_formWindowClosed

    /**
     * @param stream
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    }
