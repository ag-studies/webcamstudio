/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Viewer.java
 *
 * Created on 4-Mar-2012, 3:07:06 PM
 */
package webcamstudio.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author patrick
 */
public class Viewer extends javax.swing.JPanel {

    private BufferedImage img = new BufferedImage(320,240,BufferedImage.TYPE_INT_ARGB);
    private int audioLeft = 0;
    private int audioRight=0;
    private boolean play = false;
    /** Creates new form Viewer */
    public Viewer() {
        initComponents();
    }

    public void setImage(BufferedImage image) {
        
        img=image;
        
    }
         
    public void setAudioLevel(int l, int r){
        audioLeft = l;
        audioRight = r;
    }
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D graph = (Graphics2D) g;
        int w = this.getWidth();
        int h = this.getHeight();
        graph.setBackground(Color.BLACK);
        graph.clearRect(0, 0, w, h);
        if (img != null) {
            int imgWidth = h * img.getWidth() / img.getHeight();
            int border = (w - imgWidth) / 2;
            graph.drawImage(img, border, 0, imgWidth, h, null);
        } else {
            graph.setColor(Color.WHITE);
            graph.drawString("No Image",10,10);
        }
        if (audioLeft > 0 || audioRight > 0){
            //graph.drawString(audioLeft + "," + audioRight, 10, 50);
            graph.setColor(Color.yellow);
            graph.fillRect(0, h - (audioLeft * h / 128), 20, (audioLeft * h / 128));
            graph.fillRect(w-20, h - (audioRight * h / 128), 20, (audioRight * h / 128));
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
