/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ControlDesktop.java
 *
 * Created on 2010-01-12, 23:50:21
 */
package webcamstudio.controls;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SpinnerNumberModel;
import webcamstudio.components.SourceListener;
import webcamstudio.layout.LayoutItem;
import webcamstudio.layout.transitions.Transition;
import webcamstudio.sources.VideoSourceMovie;
import webcamstudio.sources.VideoSourceMusic;

/**
 *
 * @author pballeux
 */
public class ControlPosition extends javax.swing.JPanel implements Controls {

    LayoutItem layout = null;
    String label = "Capture";
    private SourceListener listener = null;

    /** Creates new form ControlDesktop */
    public ControlPosition(LayoutItem src) {
        initComponents();
        this.layout = src;
        javax.swing.DefaultComboBoxModel transModelIn = new javax.swing.DefaultComboBoxModel(Transition.getTransitionIns().values().toArray());
        javax.swing.DefaultComboBoxModel transModelOut = new javax.swing.DefaultComboBoxModel(Transition.getTransitionOuts().values().toArray());
        spinVolume.setModel(new SpinnerNumberModel(10,0,100,1));
        spinDurationIn.setModel(new SpinnerNumberModel(1,0,10,1));
        spinDurationOut.setModel(new SpinnerNumberModel(1,0,10,1));
        spinDurationIn.setValue(src.getTransitionDurationIn());
        spinDurationOut.setValue(src.getTransitionDurationOut());
        spinVolume.setEnabled(layout.getSource().hasSound());
        spinVolume.setValue(new Integer(layout.getVolume()));
        if (layout.getSource() instanceof VideoSourceMusic) {
            transModelIn = new javax.swing.DefaultComboBoxModel(Transition.getAudioTransitions().values().toArray());
            transModelOut = new javax.swing.DefaultComboBoxModel(Transition.getAudioTransitions().values().toArray());
        }
        cboTransIn.setModel(transModelIn);
        cboTransOut.setModel(transModelOut);
        for (int i = 0; i < cboTransIn.getItemCount(); i++) {
            if (cboTransIn.getItemAt(i).getClass().getName().equals(src.getTransitionIn().getClass().getName())) {
                cboTransIn.setSelectedIndex(i);
                break;
            }
        }
        for (int i = 0; i < cboTransOut.getItemCount(); i++) {
            if (cboTransOut.getItemAt(i).getClass().getName().equals(src.getTransitionOut().getClass().getName())) {
                cboTransOut.setSelectedIndex(i);
                break;
            }
        }
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("webcamstudio.Languages");
        label = bundle.getString("POSITION");
        spinWidth.setValue(layout.getWidth());
        spinHeight.setValue(layout.getHeight());
        spinX.setValue(layout.getX());
        spinY.setValue(layout.getY());
        if (layout.getSource() instanceof VideoSourceMovie) {
            lblSeek.setVisible(true);
            spinSeek.setVisible(true);
            spinSeek.setValue((int)layout.getPosition());
        } else if (layout.getSource() instanceof VideoSourceMusic) {
            spinHeight.setEnabled(false);
            spinWidth.setEnabled(false);
            spinX.setEnabled(false);
            spinY.setEnabled(false);
            lblSeek.setVisible(true);
            spinSeek.setVisible(true);
            spinSeek.setValue((int)layout.getPosition());
        } else {
            lblSeek.setVisible(false);
            spinSeek.setVisible(false);
        }

        chkKeepRatio.setSelected(layout.isKeepingRatio());
        spinHeight.setEnabled(!layout.isKeepingRatio());


    }

    @Override
    public void setListener(SourceListener l) {
        listener = l;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSeek = new javax.swing.JLabel();
        spinHeight = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cboTransOut = new javax.swing.JComboBox();
        spinWidth = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        spinX = new javax.swing.JSpinner();
        cboTransIn = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        spinY = new javax.swing.JSpinner();
        btnMoveUp = new javax.swing.JButton();
        btnMoveDown = new javax.swing.JButton();
        btnPlay = new javax.swing.JButton();
        btnPause = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        spinVolume = new javax.swing.JSpinner();
        chkKeepRatio = new javax.swing.JCheckBox();
        spinSeek = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        spinDurationIn = new javax.swing.JSpinner();
        spinDurationOut = new javax.swing.JSpinner();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("webcamstudio/Languages"); // NOI18N
        lblSeek.setText(bundle.getString("SEEK")); // NOI18N
        lblSeek.setName("lblSeek"); // NOI18N

        spinHeight.setName("spinHeight"); // NOI18N
        spinHeight.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinHeightStateChanged(evt);
            }
        });

        jLabel1.setText(bundle.getString("TRANSITION_IN")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel6.setText(bundle.getString("HEIGHT")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        cboTransOut.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboTransOut.setName("cboTransOut"); // NOI18N
        cboTransOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTransOutActionPerformed(evt);
            }
        });

        spinWidth.setName("spinWidth"); // NOI18N
        spinWidth.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinWidthStateChanged(evt);
            }
        });

        jLabel2.setText(bundle.getString("TRANSITION_OUT")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel5.setText(bundle.getString("WIDTH")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        spinX.setName("spinX"); // NOI18N
        spinX.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinXStateChanged(evt);
            }
        });

        cboTransIn.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboTransIn.setName("cboTransIn"); // NOI18N
        cboTransIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTransInActionPerformed(evt);
            }
        });

        jLabel3.setText(bundle.getString("POSITION_X")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel4.setText(bundle.getString("POSITION_Y")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        spinY.setName("spinY"); // NOI18N
        spinY.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinYStateChanged(evt);
            }
        });

        btnMoveUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/tango/go-up.png"))); // NOI18N
        btnMoveUp.setToolTipText(bundle.getString("MOVE_UP")); // NOI18N
        btnMoveUp.setName("btnMoveUp"); // NOI18N
        btnMoveUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoveUpActionPerformed(evt);
            }
        });

        btnMoveDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/tango/go-down.png"))); // NOI18N
        btnMoveDown.setToolTipText(bundle.getString("MOVE_DOWN")); // NOI18N
        btnMoveDown.setName("btnMoveDown"); // NOI18N
        btnMoveDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoveDownActionPerformed(evt);
            }
        });

        btnPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/tango/media-playback-start.png"))); // NOI18N
        btnPlay.setToolTipText(bundle.getString("PLAY")); // NOI18N
        btnPlay.setName("btnPlay"); // NOI18N
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });

        btnPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/tango/media-playback-pause.png"))); // NOI18N
        btnPause.setToolTipText(bundle.getString("PAUSE")); // NOI18N
        btnPause.setName("btnPause"); // NOI18N
        btnPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPauseActionPerformed(evt);
            }
        });

        btnStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/tango/media-playback-stop.png"))); // NOI18N
        btnStop.setToolTipText(bundle.getString("STOP")); // NOI18N
        btnStop.setName("btnStop"); // NOI18N
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/tango/edit-delete.png"))); // NOI18N
        btnRemove.setToolTipText(bundle.getString("REMOVE")); // NOI18N
        btnRemove.setName("btnRemove"); // NOI18N
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        jLabel7.setText(bundle.getString("VOLUME")); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N

        spinVolume.setName("spinVolume"); // NOI18N
        spinVolume.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinVolumeStateChanged(evt);
            }
        });

        chkKeepRatio.setText(bundle.getString("KEEP_RATIO")); // NOI18N
        chkKeepRatio.setName("chkKeepRatio"); // NOI18N
        chkKeepRatio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkKeepRatioActionPerformed(evt);
            }
        });

        spinSeek.setName("spinSeek"); // NOI18N
        spinSeek.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinSeekStateChanged(evt);
            }
        });

        jLabel8.setText(bundle.getString("DURATION")); // NOI18N
        jLabel8.setName("jLabel8"); // NOI18N

        jLabel9.setText(bundle.getString("DURATION")); // NOI18N
        jLabel9.setName("jLabel9"); // NOI18N

        spinDurationIn.setName("spinDurationIn"); // NOI18N
        spinDurationIn.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinDurationInStateChanged(evt);
            }
        });

        spinDurationOut.setName("spinDurationOut"); // NOI18N
        spinDurationOut.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinDurationOutStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel7))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(spinSeek, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spinVolume, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spinWidth, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spinX, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboTransOut, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboTransIn, javax.swing.GroupLayout.Alignment.LEADING, 0, 109, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkKeepRatio)
                            .addComponent(spinHeight, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                            .addComponent(spinY, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                            .addComponent(spinDurationOut, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                            .addComponent(spinDurationIn, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)))
                    .addComponent(lblSeek)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPlay)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPause)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnStop)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMoveUp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMoveDown)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemove))
                    .addComponent(jLabel5))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTransIn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(spinDurationIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboTransOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(spinDurationOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(spinX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(spinY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(spinWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(spinHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(spinVolume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkKeepRatio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSeek)
                    .addComponent(spinSeek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPlay)
                    .addComponent(btnPause)
                    .addComponent(btnStop)
                    .addComponent(btnMoveUp)
                    .addComponent(btnMoveDown)
                    .addComponent(btnRemove))
                .addContainerGap(94, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnMoveUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoveUpActionPerformed
        if (listener != null) {
            listener.sourceMoveUp(layout.getSource());
        }
}//GEN-LAST:event_btnMoveUpActionPerformed

    private void btnMoveDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoveDownActionPerformed
        if (listener != null) {
            listener.sourceMoveDown(layout.getSource());
        }
}//GEN-LAST:event_btnMoveDownActionPerformed

    private void spinHeightStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinHeightStateChanged
        layout.setHeight((Integer) spinHeight.getValue());
        if (listener!=null){
            listener.sourceUpdate(layout.getSource());
        }
        if (layout.isActive()){
            layout.getSource().setOutputHeight(layout.getHeight());
        }
    }//GEN-LAST:event_spinHeightStateChanged

    private void spinWidthStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinWidthStateChanged
        layout.setWidth((Integer) spinWidth.getValue());
        if (layout.isKeepingRatio() && layout.getSource().getCaptureWidth()>0){
            int w = layout.getWidth();
            int h = w * layout.getSource().getCaptureHeight() / layout.getSource().getCaptureWidth();
            spinHeight.setValue(new Integer(h));
        }
        if (listener!=null){
            listener.sourceUpdate(layout.getSource());
        }
        if (layout.isActive()){
            layout.getSource().setOutputWidth(layout.getWidth());
        }
    }//GEN-LAST:event_spinWidthStateChanged

    private void spinYStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinYStateChanged
        layout.setY((Integer) spinY.getValue());
        if (listener!=null){
            listener.sourceUpdate(layout.getSource());
        }
        if (layout.isActive()){
            layout.getSource().setShowAtY(layout.getY());
        }
    }//GEN-LAST:event_spinYStateChanged

    private void spinXStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinXStateChanged
        layout.setX((Integer) spinX.getValue());
        if (listener!=null){
            listener.sourceUpdate(layout.getSource());
        }
        if (layout.isActive()){
            layout.getSource().setShowAtX(layout.getX());
        }
    }//GEN-LAST:event_spinXStateChanged

    private void cboTransInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTransInActionPerformed
        layout.setTransitionIn((Transition) cboTransIn.getSelectedItem());
        if (listener!=null){
            listener.sourceUpdate(layout.getSource());
        }

    }//GEN-LAST:event_cboTransInActionPerformed

    private void cboTransOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTransOutActionPerformed
        layout.setTransitionOut((Transition) cboTransOut.getSelectedItem());
        if (listener!=null){
            listener.sourceUpdate(layout.getSource());
        }

    }//GEN-LAST:event_cboTransOutActionPerformed

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        if (!layout.getSource().isPlaying() || layout.getSource().isPaused()) {
            if (layout.getSource().isPaused()) {
                layout.getSource().play();
            } else {
                layout.getSource().startSource();
            }
        }
    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPauseActionPerformed
        if (layout.getSource().isPlaying()) {
            layout.getSource().pause();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnPauseActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        if (layout.getSource().isPaused() || layout.getSource().isPlaying()) {
            layout.getSource().stopSource();
        }
    }//GEN-LAST:event_btnStopActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        if (listener != null) {
            listener.sourceRemoved(layout.getSource());
            listener = null;
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void spinVolumeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinVolumeStateChanged
        layout.setVolume((Integer)spinVolume.getValue());
    }//GEN-LAST:event_spinVolumeStateChanged

    private void chkKeepRatioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkKeepRatioActionPerformed
        if (chkKeepRatio.isSelected()){
            spinHeight.setEnabled(false);
        } else {
            spinHeight.setEnabled(true);
        }
        layout.setKeepRatio(chkKeepRatio.isSelected());
    }//GEN-LAST:event_chkKeepRatioActionPerformed

    private void spinSeekStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinSeekStateChanged
        layout.setPosition(((Integer)spinSeek.getValue()));
    }//GEN-LAST:event_spinSeekStateChanged

    private void spinDurationInStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinDurationInStateChanged
        layout.setTransitionDurationIn((Integer)spinDurationIn.getValue());
    }//GEN-LAST:event_spinDurationInStateChanged

    private void spinDurationOutStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinDurationOutStateChanged
        layout.setTransitionDurationOut((Integer)spinDurationOut.getValue());
    }//GEN-LAST:event_spinDurationOutStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMoveDown;
    private javax.swing.JButton btnMoveUp;
    private javax.swing.JButton btnPause;
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnStop;
    private javax.swing.JComboBox cboTransIn;
    private javax.swing.JComboBox cboTransOut;
    private javax.swing.JCheckBox chkKeepRatio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblSeek;
    private javax.swing.JSpinner spinDurationIn;
    private javax.swing.JSpinner spinDurationOut;
    private javax.swing.JSpinner spinHeight;
    private javax.swing.JSpinner spinSeek;
    private javax.swing.JSpinner spinVolume;
    private javax.swing.JSpinner spinWidth;
    private javax.swing.JSpinner spinX;
    private javax.swing.JSpinner spinY;
    // End of variables declaration//GEN-END:variables

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public void removeControl() {
        layout = null;
    }
}
