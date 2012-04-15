/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MasterPanel.java
 *
 * Created on 4-Apr-2012, 6:52:17 PM
 */
package webcamstudio.components;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import webcamstudio.mixers.Frame;
import webcamstudio.mixers.MasterMixer;
import webcamstudio.mixers.SystemAudioPlayer;

/**
 *
 * @author patrick
 */
public class MasterPanel extends javax.swing.JPanel {

    protected Viewer viewer = new Viewer();
    private Timer timer = new Timer();
    private SystemAudioPlayer audio = SystemAudioPlayer.getInstance();
        
    final static public Dimension PANEL_SIZE = new Dimension(150,400);
    /** Creates new form MasterPanel */
    public MasterPanel() {
        initComponents();
        spinWidth.setValue(MasterMixer.getWidth());
        spinHeight.setValue(MasterMixer.getHeight());
        this.setVisible(true);
//        this.setPreferredSize(MasterPanel.PANEL_SIZE);
//        this.setMaximumSize(MasterPanel.PANEL_SIZE);
        viewer.setOpaque(true);
        panelPreview.add(viewer, BorderLayout.CENTER);
        timer.scheduleAtFixedRate(new MasterRefreshPanel(this), 0, 200);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPreview = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        tglSound = new javax.swing.JToggleButton();
        lblWidth = new javax.swing.JLabel();
        lblHeight = new javax.swing.JLabel();
        spinWidth = new javax.swing.JSpinner();
        spinHeight = new javax.swing.JSpinner();
        btnApply = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        panelPreview.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        panelPreview.setName("panelPreview"); // NOI18N
        panelPreview.setLayout(new java.awt.BorderLayout());

        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("webcamstudio/Languages"); // NOI18N
        lblTitle.setText(bundle.getString("PREVIEW")); // NOI18N
        lblTitle.setName("lblTitle"); // NOI18N

        tglSound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/tango/audio-card.png"))); // NOI18N
        tglSound.setName("tglSound"); // NOI18N
        tglSound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglSoundActionPerformed(evt);
            }
        });

        lblWidth.setText(bundle.getString("WIDTH")); // NOI18N
        lblWidth.setName("lblWidth"); // NOI18N

        lblHeight.setText(bundle.getString("HEIGHT")); // NOI18N
        lblHeight.setName("lblHeight"); // NOI18N

        spinWidth.setName("spinWidth"); // NOI18N

        spinHeight.setName("spinHeight"); // NOI18N

        btnApply.setText(bundle.getString("APPLY")); // NOI18N
        btnApply.setName("btnApply"); // NOI18N
        btnApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApplyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPreview, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tglSound)
                .addContainerGap(89, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblWidth, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(lblHeight, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(spinWidth, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(spinHeight, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnApply, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelPreview, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tglSound)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWidth)
                    .addComponent(spinWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHeight)
                    .addComponent(spinHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnApply)
                .addContainerGap(139, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tglSoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglSoundActionPerformed
        if (tglSound.isSelected()){
            try {
                audio.play();
            } catch (LineUnavailableException ex) {
                Logger.getLogger(MasterPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            audio.stop();
        }
    }//GEN-LAST:event_tglSoundActionPerformed

    private void btnApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApplyActionPerformed
        int w = (Integer)spinWidth.getValue();
        int h = (Integer)spinHeight.getValue();
        MasterMixer.stop();
        MasterMixer.setWidth(w);
        MasterMixer.setHeight(h);
        MasterMixer.start();
    }//GEN-LAST:event_btnApplyActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApply;
    private javax.swing.JLabel lblHeight;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblWidth;
    private javax.swing.JPanel panelPreview;
    private javax.swing.JSpinner spinHeight;
    private javax.swing.JSpinner spinWidth;
    private javax.swing.JToggleButton tglSound;
    // End of variables declaration//GEN-END:variables
}

class MasterRefreshPanel extends TimerTask {

    MasterPanel panel = null;

    public MasterRefreshPanel(MasterPanel p) {
        panel = p;
    }

    @Override
    public void run() {
        if (panel != null) {
            Frame frame = MasterMixer.getCurrentFrame();
            if (frame != null) {
                panel.viewer.setImage(frame.getImage());
                panel.viewer.repaint();
            }
        }
    }
}