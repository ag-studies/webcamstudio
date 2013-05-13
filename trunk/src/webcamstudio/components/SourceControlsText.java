/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SourceControlsText.java
 *
 * Created on 30-Apr-2012, 1:44:47 PM
 */
package webcamstudio.components;

import java.awt.Color;
import javax.swing.SpinnerNumberModel;
import webcamstudio.streams.SourceText;
import webcamstudio.streams.SourceText.Shape;

/**
 *
 * @author patrick
 */
public class SourceControlsText extends javax.swing.JPanel {

    SourceText stream;

    /** Creates new form SourceControlsText */
    public SourceControlsText(SourceText stream) {
        this.stream = stream;
        initComponents();
        SpinnerNumberModel model = new SpinnerNumberModel(100, 0, 100, 1);
        spinBGOpacity.setModel(model);
        txtHexColor.setText(Integer.toHexString(stream.getBackgroundColor()));
        switch(stream.getBackground()){
            case NONE:
                rdNone.setSelected(true);
                break;
            case RECTANGLE:
                rdRect.setSelected(true);
                break;
            case OVAL:
                rdOval.setSelected(true);
                break;
            case ROUNDRECT:
                rdRoundRect.setSelected(true);
                break;
        }
        spinBGOpacity.setValue((int)(stream.getBackgroundOpacity()*100f));
        stream.setBackgroundOpacity(0/100f);
        stream.setBackground(Shape.NONE);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpShape = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        txtHexColor = new javax.swing.JFormattedTextField();
        btnSelectColor = new javax.swing.JButton();
        rdNone = new javax.swing.JRadioButton();
        rdRect = new javax.swing.JRadioButton();
        rdOval = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        spinBGOpacity = new javax.swing.JSpinner();
        rdRoundRect = new javax.swing.JRadioButton();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("webcamstudio/Languages"); // NOI18N
        setName(bundle.getString("TEXT")); // NOI18N

        jLabel1.setText(bundle.getString("BACKGROUNDCOLOR")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        try {
            txtHexColor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("HHHHHH")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtHexColor.setName("txtHexColor"); // NOI18N
        txtHexColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHexColorActionPerformed(evt);
            }
        });
        txtHexColor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtHexColorFocusLost(evt);
            }
        });

        btnSelectColor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/tango/applications-graphics.png"))); // NOI18N
        btnSelectColor.setToolTipText(bundle.getString("COLOR")); // NOI18N
        btnSelectColor.setName("btnSelectColor"); // NOI18N
        btnSelectColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectColorActionPerformed(evt);
            }
        });

        grpShape.add(rdNone);
        rdNone.setSelected(true);
        rdNone.setText(bundle.getString("NONE")); // NOI18N
        rdNone.setName("rdNone"); // NOI18N
        rdNone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdNoneActionPerformed(evt);
            }
        });

        grpShape.add(rdRect);
        rdRect.setText(bundle.getString("RECTANGLE")); // NOI18N
        rdRect.setName("rdRect"); // NOI18N
        rdRect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdRectActionPerformed(evt);
            }
        });

        grpShape.add(rdOval);
        rdOval.setText(bundle.getString("OVAL")); // NOI18N
        rdOval.setName("rdOval"); // NOI18N
        rdOval.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdOvalActionPerformed(evt);
            }
        });

        jLabel2.setText(bundle.getString("BACKGROUND_OPACITY")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        spinBGOpacity.setName("spinBGOpacity"); // NOI18N
        spinBGOpacity.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinBGOpacityStateChanged(evt);
            }
        });

        grpShape.add(rdRoundRect);
        rdRoundRect.setText(bundle.getString("ROUND_RECTANGLE")); // NOI18N
        rdRoundRect.setName("rdRoundRect"); // NOI18N
        rdRoundRect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdRoundRectActionPerformed(evt);
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
                        .addComponent(rdRoundRect)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdOval)
                            .addComponent(rdRect)
                            .addComponent(rdNone)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHexColor, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSelectColor)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinBGOpacity, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                        .addGap(44, 44, 44))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtHexColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelectColor)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rdNone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdRect)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdOval)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdRoundRect)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(spinBGOpacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtHexColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHexColorActionPerformed

        stream.setBackGroundColor(Integer.parseInt(txtHexColor.getText().trim(), 16));
    }//GEN-LAST:event_txtHexColorActionPerformed

    private void txtHexColorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHexColorFocusLost

        stream.setBackGroundColor(Integer.parseInt(txtHexColor.getText().trim(), 16));
    }//GEN-LAST:event_txtHexColorFocusLost

    private void btnSelectColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectColorActionPerformed

        ColorChooser c = new ColorChooser(null, true);
        c.setLocationRelativeTo(this);
        c.setVisible(true);
        Color color = c.getColor();
        if (color != null) {
            txtHexColor.setText(Integer.toHexString(color.getRGB()));
            stream.setBackGroundColor(color.getRGB());
        }
    }//GEN-LAST:event_btnSelectColorActionPerformed

    private void rdNoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdNoneActionPerformed
        stream.setBackground(Shape.NONE);
    }//GEN-LAST:event_rdNoneActionPerformed

    private void rdRectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdRectActionPerformed
        stream.setBackground(Shape.RECTANGLE);
        
    }//GEN-LAST:event_rdRectActionPerformed

    private void rdOvalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdOvalActionPerformed
        stream.setBackground(Shape.OVAL);
    }//GEN-LAST:event_rdOvalActionPerformed

    private void spinBGOpacityStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinBGOpacityStateChanged
        stream.setBackgroundOpacity((float)((Integer)spinBGOpacity.getValue())/100f);
    }//GEN-LAST:event_spinBGOpacityStateChanged

    private void rdRoundRectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdRoundRectActionPerformed
        stream.setBackground(Shape.ROUNDRECT);
    }//GEN-LAST:event_rdRoundRectActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSelectColor;
    private javax.swing.ButtonGroup grpShape;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton rdNone;
    private javax.swing.JRadioButton rdOval;
    private javax.swing.JRadioButton rdRect;
    private javax.swing.JRadioButton rdRoundRect;
    private javax.swing.JSpinner spinBGOpacity;
    private javax.swing.JFormattedTextField txtHexColor;
    // End of variables declaration//GEN-END:variables
}
