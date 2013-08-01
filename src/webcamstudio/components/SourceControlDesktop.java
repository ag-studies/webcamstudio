/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SourceControlDesktop.java
 *
 * Created on 23-Apr-2012, 10:16:29 AM
 */
package webcamstudio.components;

import javax.swing.SpinnerNumberModel;
import webcamstudio.streams.SourceDesktop;

/**
 *
 * @author patrick (modified by karl)
 */
public class SourceControlDesktop extends javax.swing.JPanel {

    SourceDesktop source = null;
    /** Creates new form SourceControlDesktop */
    public SourceControlDesktop(SourceDesktop source) {
        initComponents();
        this.source=source;
        setName("Desktop");
        SpinnerNumberModel model = new SpinnerNumberModel(0, 0, 3000, 1);
        spinX.setModel(model);
        model = new SpinnerNumberModel(0, 0, 3000, 1);
        spinY.setModel(model);
        model = new SpinnerNumberModel(0, 0, 3000, 1);
        spinH.setModel(model);
        model = new SpinnerNumberModel(0, 0, 3000, 1);
        spinW.setModel(model);
        spinX.setValue(source.getDesktopX());
        spinY.setValue(source.getDesktopY());
        spinW.setValue(source.getDesktopW());
        spinH.setValue(source.getDesktopH());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        spinX = new javax.swing.JSpinner();
        spinY = new javax.swing.JSpinner();
        spinW = new javax.swing.JSpinner();
        spinH = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        spinN = new javax.swing.JSpinner();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("webcamstudio/Languages"); // NOI18N
        jLabel1.setText(bundle.getString("DESKTOP_CAPTURE_X")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText(bundle.getString("DESKTOP_CAPTURE_Y")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setText(bundle.getString("DESKTOP_CAPTURE_WIDTH")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel4.setText(bundle.getString("DESKTOP_CAPTURE_HEIGHT")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

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

        jLabel5.setText(bundle.getString("DESKTOP_CAPTURE_NUMBER")); // NOI18N
        jLabel5.setEnabled(false);
        jLabel5.setName("jLabel5"); // NOI18N

        spinN.setEnabled(false);
        spinN.setName("spinN"); // NOI18N
        spinN.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinNStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spinN)
                    .addComponent(spinH, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addComponent(spinY, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addComponent(spinX, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addComponent(spinW, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(spinX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(spinY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(spinW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(spinH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void spinXStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinXStateChanged
        source.setDesktopX((Integer)spinX.getValue());
    }//GEN-LAST:event_spinXStateChanged

    private void spinYStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinYStateChanged
        source.setDesktopY((Integer)spinY.getValue());
    }//GEN-LAST:event_spinYStateChanged

    private void spinWStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinWStateChanged
        source.setDesktopW((Integer)spinW.getValue());
    }//GEN-LAST:event_spinWStateChanged

    private void spinHStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinHStateChanged
        source.setDesktopH((Integer)spinH.getValue());
    }//GEN-LAST:event_spinHStateChanged

    private void spinNStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinNStateChanged
        source.setDesktopN((Integer)spinN.getValue());
    }//GEN-LAST:event_spinNStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSpinner spinH;
    private javax.swing.JSpinner spinN;
    private javax.swing.JSpinner spinW;
    private javax.swing.JSpinner spinX;
    private javax.swing.JSpinner spinY;
    // End of variables declaration//GEN-END:variables
}
