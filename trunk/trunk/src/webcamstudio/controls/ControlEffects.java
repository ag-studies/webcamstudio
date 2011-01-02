/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ControlEffects.java
 *
 * Created on 2010-01-12, 23:50:50
 */
package webcamstudio.controls;

import java.awt.BorderLayout;
import webcamstudio.components.SourceListener;
import webcamstudio.sources.VideoSource;
import webcamstudio.sources.effects.Effect;

/**
 *
 * @author pballeux
 */
public class ControlEffects extends javax.swing.JPanel implements Controls {

    VideoSource source = null;
    String label = "Audio";
    javax.swing.DefaultListModel lstModel = new javax.swing.DefaultListModel();
    private SourceListener listener=null;
    /** Creates new form ControlEffects */
    public ControlEffects(VideoSource source) {
        initComponents();
        this.source = source;
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("webcamstudio.Languages");
        label = bundle.getString("EFFECTS");
        javax.swing.DefaultComboBoxModel model = new javax.swing.DefaultComboBoxModel(Effect.getEffects().values().toArray());
        cboEffects.setModel(model);
        lstEffects.setModel(lstModel);
        java.util.Vector<Effect> list = source.getEffects();
        for (Effect e : list) {
            lstModel.addElement(e);
        }
        updateControls();
    }

    private void updateControls() {
        btnAddEffect.setEnabled(!lstModel.contains(cboEffects.getSelectedItem()));
        btnRemoveEffect.setEnabled(lstEffects.getSelectedValue() != null);
        btnMoveDown.setEnabled(lstEffects.getSelectedValue() != null && lstEffects.getSelectedIndex() < (lstModel.getSize() - 1));
        btnMoveUp.setEnabled(lstEffects.getSelectedValue() != null && lstEffects.getSelectedIndex() > 0);
        lstEffects.revalidate();
        java.util.Vector<Effect> list = new java.util.Vector<Effect>();
        for (Object e : lstModel.toArray()) {
            list.add((Effect) e);
        }
        source.setEffects(list);
        panControl.removeAll();
        if (lstEffects.getSelectedValue() != null) {
            Effect e = (Effect) lstEffects.getSelectedValue();
            if (e.getControl() != null) {
                panControl.add(e.getControl(), BorderLayout.CENTER);
            }
        }
        panControl.revalidate();
        panControl.repaint();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scoll = new javax.swing.JScrollPane();
        lstEffects = new javax.swing.JList();
        cboEffects = new javax.swing.JComboBox();
        btnRemoveEffect = new javax.swing.JButton();
        btnAddEffect = new javax.swing.JButton();
        btnMoveUp = new javax.swing.JButton();
        btnMoveDown = new javax.swing.JButton();
        panControl = new javax.swing.JPanel();

        scoll.setName("scoll"); // NOI18N

        lstEffects.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstEffects.setName("lstEffects"); // NOI18N
        lstEffects.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstEffectsMouseClicked(evt);
            }
        });
        scoll.setViewportView(lstEffects);

        cboEffects.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboEffects.setName("cboEffects"); // NOI18N
        cboEffects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboEffectsActionPerformed(evt);
            }
        });

        btnRemoveEffect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/tango/go-previous.png"))); // NOI18N
        btnRemoveEffect.setEnabled(false);
        btnRemoveEffect.setName("btnRemoveEffect"); // NOI18N
        btnRemoveEffect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveEffectActionPerformed(evt);
            }
        });

        btnAddEffect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/tango/go-next.png"))); // NOI18N
        btnAddEffect.setName("btnAddEffect"); // NOI18N
        btnAddEffect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEffectActionPerformed(evt);
            }
        });

        btnMoveUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/tango/go-up.png"))); // NOI18N
        btnMoveUp.setName("btnMoveUp"); // NOI18N
        btnMoveUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoveUpActionPerformed(evt);
            }
        });

        btnMoveDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/tango/go-down.png"))); // NOI18N
        btnMoveDown.setName("btnMoveDown"); // NOI18N
        btnMoveDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoveDownActionPerformed(evt);
            }
        });

        panControl.setName("panControl"); // NOI18N
        panControl.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRemoveEffect, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(panControl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                            .addComponent(cboEffects, 0, 320, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddEffect)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnMoveUp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMoveDown))
                    .addComponent(scoll, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAddEffect)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRemoveEffect))
                            .addComponent(scoll, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnMoveUp)
                            .addComponent(btnMoveDown)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cboEffects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(panControl, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddEffectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEffectActionPerformed
        lstModel.addElement(cboEffects.getSelectedItem());
        updateControls();
    }//GEN-LAST:event_btnAddEffectActionPerformed

    private void btnRemoveEffectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveEffectActionPerformed
        lstModel.removeElement(lstEffects.getSelectedValue());
        updateControls();
    }//GEN-LAST:event_btnRemoveEffectActionPerformed

    private void lstEffectsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstEffectsMouseClicked
        updateControls();
    }//GEN-LAST:event_lstEffectsMouseClicked

    private void cboEffectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboEffectsActionPerformed
        updateControls();
    }//GEN-LAST:event_cboEffectsActionPerformed

    private void btnMoveUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoveUpActionPerformed
        Object effect = lstEffects.getSelectedValue();
        int index = lstModel.indexOf(effect);
        lstModel.remove(index);
        lstModel.insertElementAt(effect, index - 1);
        lstEffects.setSelectedValue(effect, true);
        updateControls();
    }//GEN-LAST:event_btnMoveUpActionPerformed

    private void btnMoveDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoveDownActionPerformed
        Object effect = lstEffects.getSelectedValue();
        int index = lstModel.indexOf(effect);
        lstModel.remove(index);
        lstModel.insertElementAt(effect, index + 1);
        lstEffects.setSelectedValue(effect, true);
        updateControls();
    }//GEN-LAST:event_btnMoveDownActionPerformed

    @Override
    public String getLabel() {
        return label;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddEffect;
    private javax.swing.JButton btnMoveDown;
    private javax.swing.JButton btnMoveUp;
    private javax.swing.JButton btnRemoveEffect;
    private javax.swing.JComboBox cboEffects;
    private javax.swing.JList lstEffects;
    private javax.swing.JPanel panControl;
    private javax.swing.JScrollPane scoll;
    // End of variables declaration//GEN-END:variables

    @Override
    public void removeControl() {
        source=null;
    }

    @Override
    public void setListener(SourceListener l) {
        listener=l;
    }
}
