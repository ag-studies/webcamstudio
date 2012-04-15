/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * StreamPanel.java
 *
 * Created on 4-Apr-2012, 4:07:51 PM
 */
package webcamstudio.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import webcamstudio.streams.SourceText;


/**
 *
 * @author patrick
 */
public class StreamPanelText extends javax.swing.JPanel {

    SourceText stream = null;
    Viewer viewer = new Viewer();
    Timer timer = new Timer();

    /** Creates new form StreamPanel */
    public StreamPanelText(SourceText stream) {

        initComponents();
        
        viewer.setOpaque(true);
        viewer.setVisible(true);
        viewer.setBackground(Color.red);
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Font[] fonts = e.getAllFonts(); // Get the fonts
        for (Font f : fonts){
            model.addElement(f.getName());
        }
        cboFonts.setModel(model);
        
        this.stream = stream;
        spinX.setValue(stream.getX());
        spinY.setValue(stream.getY());
        spinW.setValue(stream.getWidth());
        spinH.setValue(stream.getHeight());
        cboFonts.setSelectedItem(stream.getFont());
        txtHexColor.setText(Integer.toHexString(stream.getColor()));
        spinZOrder.setValue(stream.getZOrder());
        timer.scheduleAtFixedRate(new RefreshPanelText(this), 0, 200);
        txtContent.setText(stream.getContent());
    }
   
    public ImageIcon getIcon(){
        ImageIcon icon = null;
        if (stream.getPreview()!=null){
            icon = new ImageIcon(stream.getPreview().getScaledInstance(32, 32, BufferedImage.SCALE_FAST));
        }
        
        return icon;
    }
    public void remove() {
        timer.cancel();
        timer = null;
        stream.stop();
        stream = null;

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        spinX = new javax.swing.JSpinner();
        spinY = new javax.swing.JSpinner();
        spinW = new javax.swing.JSpinner();
        spinH = new javax.swing.JSpinner();
        tglActiveStream = new javax.swing.JToggleButton();
        spinZOrder = new javax.swing.JSpinner();
        labelX = new javax.swing.JLabel();
        labelY = new javax.swing.JLabel();
        labelW = new javax.swing.JLabel();
        labelH = new javax.swing.JLabel();
        labelFont = new javax.swing.JLabel();
        lblColor = new javax.swing.JLabel();
        labelZ = new javax.swing.JLabel();
        lblText = new javax.swing.JLabel();
        txtContent = new javax.swing.JTextField();
        cboFonts = new javax.swing.JComboBox();
        txtHexColor = new javax.swing.JFormattedTextField();

        setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        spinX.setName("spinX"); // NOI18N
        spinX.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinXStateChanged(evt);
            }
        });

        spinY.setName("spinY"); // NOI18N
        spinY.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinYStateChanged(evt);
            }
        });

        spinW.setName("spinW"); // NOI18N
        spinW.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinWStateChanged(evt);
            }
        });

        spinH.setName("spinH"); // NOI18N
        spinH.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinHStateChanged(evt);
            }
        });

        tglActiveStream.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/tango/media-playback-start.png"))); // NOI18N
        tglActiveStream.setName("tglActiveStream"); // NOI18N
        tglActiveStream.setRolloverEnabled(false);
        tglActiveStream.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/tango/media-playback-stop.png"))); // NOI18N
        tglActiveStream.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglActiveStreamActionPerformed(evt);
            }
        });

        spinZOrder.setName("spinZOrder"); // NOI18N
        spinZOrder.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinZOrderStateChanged(evt);
            }
        });

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("webcamstudio/Languages"); // NOI18N
        labelX.setText(bundle.getString("X")); // NOI18N
        labelX.setName("labelX"); // NOI18N

        labelY.setText(bundle.getString("Y")); // NOI18N
        labelY.setName("labelY"); // NOI18N

        labelW.setText(bundle.getString("WIDTH")); // NOI18N
        labelW.setName("labelW"); // NOI18N

        labelH.setText(bundle.getString("HEIGHT")); // NOI18N
        labelH.setName("labelH"); // NOI18N

        labelFont.setText(bundle.getString("FONT")); // NOI18N
        labelFont.setName("labelFont"); // NOI18N

        lblColor.setText(bundle.getString("COLOR")); // NOI18N
        lblColor.setName("lblColor"); // NOI18N

        labelZ.setText(bundle.getString("LAYER")); // NOI18N
        labelZ.setName("labelZ"); // NOI18N

        lblText.setText(bundle.getString("TEXT")); // NOI18N
        lblText.setName("lblText"); // NOI18N

        txtContent.setName("txtContent"); // NOI18N
        txtContent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContentActionPerformed(evt);
            }
        });
        txtContent.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtContentFocusLost(evt);
            }
        });

        cboFonts.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboFonts.setName("cboFonts"); // NOI18N
        cboFonts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboFontsActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelZ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelFont, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelW, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelY, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelX, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtHexColor, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                                    .addComponent(cboFonts, 0, 186, Short.MAX_VALUE)
                                    .addComponent(spinZOrder, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                                    .addComponent(spinX, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                                    .addComponent(spinY, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                                    .addComponent(spinW, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                                    .addComponent(spinH, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)))
                            .addComponent(txtContent, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                            .addComponent(tglActiveStream, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
                        .addGap(16, 16, 16)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblText)
                .addGap(4, 4, 4)
                .addComponent(txtContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelX)
                    .addComponent(spinX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelY)
                    .addComponent(spinY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelW)
                    .addComponent(spinW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelH)
                    .addComponent(spinH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFont)
                    .addComponent(cboFonts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblColor)
                    .addComponent(txtHexColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelZ)
                    .addComponent(spinZOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tglActiveStream)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tglActiveStreamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglActiveStreamActionPerformed
        if (tglActiveStream.isSelected()) {
            stream.read();
        } else {
            stream.stop();
        }
    }//GEN-LAST:event_tglActiveStreamActionPerformed

    private void spinZOrderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinZOrderStateChanged
        stream.setZOrder((Integer) spinZOrder.getValue());
    }//GEN-LAST:event_spinZOrderStateChanged

    private void spinWStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinWStateChanged
        stream.setWidth((Integer)spinW.getValue());
    }//GEN-LAST:event_spinWStateChanged

    private void spinHStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinHStateChanged
        stream.setHeight((Integer)spinH.getValue());
    }//GEN-LAST:event_spinHStateChanged

    private void spinXStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinXStateChanged
        stream.setX((Integer)spinX.getValue());
    }//GEN-LAST:event_spinXStateChanged

    private void spinYStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinYStateChanged
        stream.setY((Integer)spinY.getValue());
    }//GEN-LAST:event_spinYStateChanged

    private void txtContentFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContentFocusLost
        stream.updateContent(txtContent.getText());
    }//GEN-LAST:event_txtContentFocusLost

    private void txtContentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContentActionPerformed
         stream.updateContent(txtContent.getText());
    }//GEN-LAST:event_txtContentActionPerformed

    private void cboFontsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboFontsActionPerformed
        stream.setFont(cboFonts.getSelectedItem().toString());
    }//GEN-LAST:event_cboFontsActionPerformed

    private void txtHexColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHexColorActionPerformed
        stream.setColor(Integer.parseInt(txtHexColor.getText().trim(),16));
    }//GEN-LAST:event_txtHexColorActionPerformed

    private void txtHexColorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHexColorFocusLost
        stream.setColor(Integer.parseInt(txtHexColor.getText().trim(),16));
    }//GEN-LAST:event_txtHexColorFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboFonts;
    private javax.swing.JLabel labelFont;
    private javax.swing.JLabel labelH;
    private javax.swing.JLabel labelW;
    private javax.swing.JLabel labelX;
    private javax.swing.JLabel labelY;
    private javax.swing.JLabel labelZ;
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblText;
    private javax.swing.JSpinner spinH;
    private javax.swing.JSpinner spinW;
    private javax.swing.JSpinner spinX;
    private javax.swing.JSpinner spinY;
    private javax.swing.JSpinner spinZOrder;
    private javax.swing.JToggleButton tglActiveStream;
    private javax.swing.JTextField txtContent;
    private javax.swing.JFormattedTextField txtHexColor;
    // End of variables declaration//GEN-END:variables
}
class RefreshPanelText extends TimerTask {

    StreamPanelText panel = null;

    public RefreshPanelText(StreamPanelText p) {
        panel = p;
    }

    @Override
    public void run() {
        if (panel != null) {
            panel.viewer.setImage(panel.stream.getPreview());
            panel.viewer.repaint();
        }
    }
}