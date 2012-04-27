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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.SpinnerNumberModel;
import webcamstudio.mixers.Frame;
import webcamstudio.mixers.MasterMixer;
import webcamstudio.mixers.SystemPlayer;

/**
 *
 * @author patrick
 */
public class MasterPanel extends javax.swing.JPanel implements MasterMixer.SinkListener {

    protected Viewer viewer = new Viewer();
    private SystemPlayer player = null;
    private MasterMixer mixer = MasterMixer.getInstance();
    final static public Dimension PANEL_SIZE = new Dimension(150, 400);

    /** Creates new form MasterPanel */
    public MasterPanel() {
        initComponents();
        spinFPS.setModel(new SpinnerNumberModel(5, 5, 30, 5));
        spinWidth.setValue(mixer.getWidth());
        spinHeight.setValue(mixer.getHeight());
        this.setVisible(true);
        viewer.setOpaque(true);
        panelPreview.add(viewer, BorderLayout.CENTER);
        player = SystemPlayer.getInstance(viewer);
        mixer.register(this);
        spinFPS.setValue(MasterMixer.getInstance().getRate());
        panChannels.add(new ChannelPanel(), BorderLayout.CENTER);
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
        tabMixers = new javax.swing.JTabbedPane();
        panChannels = new javax.swing.JPanel();
        panMixer = new javax.swing.JPanel();
        tglSound = new javax.swing.JToggleButton();
        lblWidth = new javax.swing.JLabel();
        lblHeight = new javax.swing.JLabel();
        spinWidth = new javax.swing.JSpinner();
        spinHeight = new javax.swing.JSpinner();
        btnApply = new javax.swing.JButton();
        lblHeight1 = new javax.swing.JLabel();
        spinFPS = new javax.swing.JSpinner();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("webcamstudio/Languages"); // NOI18N
        setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("PREVIEW"))); // NOI18N
        setLayout(new java.awt.BorderLayout());

        panelPreview.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        panelPreview.setMaximumSize(new java.awt.Dimension(180, 120));
        panelPreview.setMinimumSize(new java.awt.Dimension(180, 120));
        panelPreview.setName("panelPreview"); // NOI18N
        panelPreview.setPreferredSize(new java.awt.Dimension(180, 120));
        panelPreview.setLayout(new java.awt.BorderLayout());
        add(panelPreview, java.awt.BorderLayout.NORTH);

        tabMixers.setName("tabMixers"); // NOI18N

        panChannels.setName("panChannels"); // NOI18N
        panChannels.setLayout(new java.awt.BorderLayout());
        tabMixers.addTab(bundle.getString("CHANNELS"), panChannels); // NOI18N

        panMixer.setName("panMixer"); // NOI18N

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

        lblHeight1.setText(bundle.getString("FRAMERATE")); // NOI18N
        lblHeight1.setName("lblHeight1"); // NOI18N

        spinFPS.setName("spinFPS"); // NOI18N

        javax.swing.GroupLayout panMixerLayout = new javax.swing.GroupLayout(panMixer);
        panMixer.setLayout(panMixerLayout);
        panMixerLayout.setHorizontalGroup(
            panMixerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 193, Short.MAX_VALUE)
            .addGroup(panMixerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panMixerLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panMixerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panMixerLayout.createSequentialGroup()
                            .addGroup(panMixerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblHeight)
                                .addComponent(lblHeight1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblWidth))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panMixerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(spinFPS, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                .addComponent(spinHeight, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                .addComponent(spinWidth, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panMixerLayout.createSequentialGroup()
                            .addComponent(btnApply, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tglSound)))
                    .addContainerGap()))
        );
        panMixerLayout.setVerticalGroup(
            panMixerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 188, Short.MAX_VALUE)
            .addGroup(panMixerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panMixerLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panMixerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblWidth)
                        .addComponent(spinWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(panMixerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblHeight)
                        .addComponent(spinHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(panMixerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblHeight1)
                        .addComponent(spinFPS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(panMixerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tglSound)
                        .addComponent(btnApply))
                    .addContainerGap(42, Short.MAX_VALUE)))
        );

        tabMixers.addTab(bundle.getString("MIXER"), panMixer); // NOI18N

        add(tabMixers, java.awt.BorderLayout.CENTER);
        tabMixers.getAccessibleContext().setAccessibleName(bundle.getString("MIXER")); // NOI18N
    }// </editor-fold>//GEN-END:initComponents

    private void tglSoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglSoundActionPerformed
        if (tglSound.isSelected()) {
            try {
                player.play();
            } catch (LineUnavailableException ex) {
                Logger.getLogger(MasterPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            player.stop();
        }
    }//GEN-LAST:event_tglSoundActionPerformed

    private void btnApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApplyActionPerformed
        int w = (Integer) spinWidth.getValue();
        int h = (Integer) spinHeight.getValue();
        if (tglSound.isSelected()) {
            player.stop();
        }
        mixer.stop();
        mixer.setWidth(w);
        mixer.setHeight(h);
        mixer.setRate((Integer) spinFPS.getValue());
        mixer.getInstance().start();
        if (tglSound.isSelected()) {
            try {
                player.play();
            } catch (LineUnavailableException ex) {
                Logger.getLogger(MasterPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnApplyActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApply;
    private javax.swing.JLabel lblHeight;
    private javax.swing.JLabel lblHeight1;
    private javax.swing.JLabel lblWidth;
    private javax.swing.JPanel panChannels;
    private javax.swing.JPanel panMixer;
    private javax.swing.JPanel panelPreview;
    private javax.swing.JSpinner spinFPS;
    private javax.swing.JSpinner spinHeight;
    private javax.swing.JSpinner spinWidth;
    private javax.swing.JTabbedPane tabMixers;
    private javax.swing.JToggleButton tglSound;
    // End of variables declaration//GEN-END:variables

    @Override
    public void newFrame(Frame frame) {
        player.addFrame(frame);
    }
}
