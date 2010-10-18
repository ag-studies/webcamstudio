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

import webcamstudio.sources.VideoSource;

/**
 *
 * @author pballeux
 */
public class ControlRescale extends javax.swing.JPanel implements Controls {

    VideoSource source = null;
    String label = "Capture";

    /** Creates new form ControlDesktop */
    public ControlRescale(VideoSource source) {
        initComponents();
        this.source = source;
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("webcamstudio.Languages");
        label = bundle.getString("FORMAT");
        spinWidth.setValue(source.getCaptureWidth());
        spinHeight.setValue(source.getCaptureHeight());
        slideFramerate.setValue(source.getFrameRate());
        chkRescaleEnabled.setSelected(source.isRescaled());

        slideFramerate.setEnabled(chkRescaleEnabled.isSelected());
        spinHeight.setEnabled(chkRescaleEnabled.isSelected());
        spinWidth.setEnabled(chkRescaleEnabled.isSelected());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblWidth = new javax.swing.JLabel();
        spinWidth = new javax.swing.JSpinner();
        lblHeight = new javax.swing.JLabel();
        spinHeight = new javax.swing.JSpinner();
        lblFramrate = new javax.swing.JLabel();
        slideFramerate = new javax.swing.JSlider();
        chkRescaleEnabled = new javax.swing.JCheckBox();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("webcamstudio/Languages"); // NOI18N
        lblWidth.setText(bundle.getString("WIDTH")); // NOI18N
        lblWidth.setName("lblWidth"); // NOI18N

        spinWidth.setEnabled(false);
        spinWidth.setName("spinWidth"); // NOI18N
        spinWidth.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinWidthStateChanged(evt);
            }
        });

        lblHeight.setText(bundle.getString("HEIGHT")); // NOI18N
        lblHeight.setName("lblHeight"); // NOI18N

        spinHeight.setEnabled(false);
        spinHeight.setName("spinHeight"); // NOI18N
        spinHeight.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinHeightStateChanged(evt);
            }
        });

        lblFramrate.setText(bundle.getString("FRAMERATE")); // NOI18N
        lblFramrate.setName("lblFramrate"); // NOI18N

        slideFramerate.setMajorTickSpacing(15);
        slideFramerate.setMaximum(30);
        slideFramerate.setMinorTickSpacing(5);
        slideFramerate.setPaintLabels(true);
        slideFramerate.setPaintTicks(true);
        slideFramerate.setEnabled(false);
        slideFramerate.setName("slideFramerate"); // NOI18N
        slideFramerate.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slideFramerateStateChanged(evt);
            }
        });

        chkRescaleEnabled.setText(bundle.getString("RESCALEENABLE")); // NOI18N
        chkRescaleEnabled.setName("chkRescaleEnabled"); // NOI18N
        chkRescaleEnabled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkRescaleEnabledActionPerformed(evt);
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(slideFramerate, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblWidth)
                                .addGap(18, 18, 18)
                                .addComponent(spinWidth, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblHeight)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spinHeight, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(lblFramrate)
                    .addComponent(chkRescaleEnabled))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chkRescaleEnabled)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWidth)
                    .addComponent(spinWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHeight)
                    .addComponent(spinHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(slideFramerate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(lblFramrate)))
                .addContainerGap(157, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void spinWidthStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinWidthStateChanged
        source.setCaptureWidth((Integer) spinWidth.getValue());

    }//GEN-LAST:event_spinWidthStateChanged

    private void spinHeightStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinHeightStateChanged
        source.setCaptureHeight((Integer) spinHeight.getValue());
    }//GEN-LAST:event_spinHeightStateChanged

    private void slideFramerateStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slideFramerateStateChanged
        source.setFrameRate(slideFramerate.getValue());
    }//GEN-LAST:event_slideFramerateStateChanged

    private void chkRescaleEnabledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkRescaleEnabledActionPerformed
        slideFramerate.setEnabled(chkRescaleEnabled.isSelected());
        spinHeight.setEnabled(chkRescaleEnabled.isSelected());
        spinWidth.setEnabled(chkRescaleEnabled.isSelected());
        source.doRescale(chkRescaleEnabled.isSelected());
        if (chkRescaleEnabled.isSelected()) {
            source.setCaptureWidth((Integer) spinWidth.getValue());
            source.setCaptureHeight((Integer) spinHeight.getValue());
            source.setFrameRate(slideFramerate.getValue());
        }
    }//GEN-LAST:event_chkRescaleEnabledActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkRescaleEnabled;
    private javax.swing.JLabel lblFramrate;
    private javax.swing.JLabel lblHeight;
    private javax.swing.JLabel lblWidth;
    private javax.swing.JSlider slideFramerate;
    private javax.swing.JSpinner spinHeight;
    private javax.swing.JSpinner spinWidth;
    // End of variables declaration//GEN-END:variables

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public void removeControl() {
        source=null;
    }
}
