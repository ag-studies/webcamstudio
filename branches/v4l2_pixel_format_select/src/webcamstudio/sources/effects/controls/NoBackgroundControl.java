/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MosaicControl.java
 *
 * Created on 2010-01-15, 01:51:51
 */

package webcamstudio.sources.effects.controls;

import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import webcamstudio.sources.effects.NoBackground;
import webcamstudio.util.Tools;

/**
 *
 * @author pballeux (modified by karl)
 */
public class NoBackgroundControl extends javax.swing.JPanel {

    NoBackground effect = null;
    /** Creates new form MosaicControl
     * @param effect */
    public NoBackgroundControl(NoBackground effect) {
        initComponents();
        this.effect=effect;
        sliderR.setValue(effect.getRThreshold());
        sliderG.setValue(effect.getGThreshold());
        sliderB.setValue(effect.getBThreshold());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSnapShot = new javax.swing.JButton();
        lblPreview = new javax.swing.JLabel();
        sliderR = new javax.swing.JSlider();
        sliderG = new javax.swing.JSlider();
        sliderB = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(250, 162));
        setRequestFocusEnabled(false);

        btnSnapShot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/tango/camera-shot.png"))); // NOI18N
        btnSnapShot.setToolTipText("Take Snapshot");
        btnSnapShot.setName("btnSnapShot"); // NOI18N
        btnSnapShot.setPreferredSize(new java.awt.Dimension(32, 30));
        btnSnapShot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSnapShotActionPerformed(evt);
            }
        });

        lblPreview.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPreview.setToolTipText("");
        lblPreview.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblPreview.setName("lblPreview"); // NOI18N

        sliderR.setBackground(java.awt.Color.red);
        sliderR.setPaintLabels(true);
        sliderR.setPaintTicks(true);
        sliderR.setName("sliderR"); // NOI18N
        sliderR.setOpaque(true);
        sliderR.setPreferredSize(new java.awt.Dimension(206, 40));
        sliderR.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderRStateChanged(evt);
            }
        });

        sliderG.setBackground(java.awt.Color.green);
        sliderG.setPaintLabels(true);
        sliderG.setPaintTicks(true);
        sliderG.setName("sliderG"); // NOI18N
        sliderG.setOpaque(true);
        sliderG.setPreferredSize(new java.awt.Dimension(206, 40));
        sliderG.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderGStateChanged(evt);
            }
        });

        sliderB.setBackground(java.awt.Color.blue);
        sliderB.setPaintLabels(true);
        sliderB.setPaintTicks(true);
        sliderB.setName("sliderB"); // NOI18N
        sliderB.setOpaque(true);
        sliderB.setPreferredSize(new java.awt.Dimension(206, 40));
        sliderB.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderBStateChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Take a Snapshot");
        jLabel1.setName("jLabel1"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sliderG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sliderR, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSnapShot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPreview, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(sliderB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPreview, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSnapShot, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sliderR, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sliderG, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sliderB, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSnapShotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSnapShotActionPerformed
        effect.setBackgroundImage(null);
        Tools.sleep(500);
        BufferedImage img = effect.getLastImage();
        if (img != null){
            effect.setBackgroundImage(img);
            lblPreview.setIcon(new ImageIcon(img.getScaledInstance(100, 59, BufferedImage.SCALE_FAST)));
            lblPreview.repaint();
        }
    }//GEN-LAST:event_btnSnapShotActionPerformed

    private void sliderRStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderRStateChanged
        effect.setRThreshold(sliderR.getValue());
    }//GEN-LAST:event_sliderRStateChanged

    private void sliderGStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderGStateChanged
        effect.setGThreshold(sliderG.getValue());
    }//GEN-LAST:event_sliderGStateChanged

    private void sliderBStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderBStateChanged
        effect.setBThreshold(sliderB.getValue());
    }//GEN-LAST:event_sliderBStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSnapShot;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblPreview;
    private javax.swing.JSlider sliderB;
    private javax.swing.JSlider sliderG;
    private javax.swing.JSlider sliderR;
    // End of variables declaration//GEN-END:variables

}
