/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webcamstudio.components;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import webcamstudio.sources.effects.Effect;
import webcamstudio.streams.Stream;

/**
 *
 * @author Patrick Balleux
 */
public class SourceEffects extends javax.swing.JPanel {

    private DefaultListModel listModel = new DefaultListModel();
    private Stream stream;
    /**
     * Creates new form SourceEffects
     */
    public SourceEffects(Stream s) {
        initComponents();
        stream = s;
        boolean found = false;
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for (Effect e : Effect.getEffects().values()) {
            found=false;
            for (Effect se : stream.getEffects()){
                if (se.getName().equals(e.getName())){
                    listModel.addElement(se);
                    model.addElement(se);
                    found=true;
                    break;
                }
            }
            if(!found){
                model.addElement(e);
            }
        }
        cboEffects.setModel(model);
        lstEffects.setModel(listModel);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstEffects = new javax.swing.JList();
        panSettings = new javax.swing.JPanel();
        cboEffects = new javax.swing.JComboBox();
        btnAddEffect = new javax.swing.JButton();
        btnDeleteEffect = new javax.swing.JButton();
        btnMoveUp = new javax.swing.JButton();
        btnMoveDown = new javax.swing.JButton();

        lstEffects.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstEffects.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstEffectsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstEffects);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("webcamstudio/Languages"); // NOI18N
        panSettings.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("SETTINGS"))); // NOI18N
        panSettings.setLayout(new java.awt.BorderLayout());

        cboEffects.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAddEffect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/tango/list-add.png"))); // NOI18N
        btnAddEffect.setAlignmentY(0.0F);
        btnAddEffect.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnAddEffect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEffectActionPerformed(evt);
            }
        });

        btnDeleteEffect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/tango/list-remove.png"))); // NOI18N
        btnDeleteEffect.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnDeleteEffect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteEffectActionPerformed(evt);
            }
        });

        btnMoveUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/tango/go-up.png"))); // NOI18N
        btnMoveUp.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnMoveUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoveUpActionPerformed(evt);
            }
        });

        btnMoveDown.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/tango/go-down.png"))); // NOI18N
        btnMoveDown.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnMoveDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoveDownActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panSettings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddEffect)
                            .addComponent(btnDeleteEffect)
                            .addComponent(btnMoveUp)
                            .addComponent(btnMoveDown, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(cboEffects, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboEffects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddEffect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteEffect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMoveUp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMoveDown)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panSettings, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddEffectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEffectActionPerformed
        listModel.addElement((Effect) cboEffects.getSelectedItem());
        stream.addEffect((Effect) cboEffects.getSelectedItem());
        lstEffects.revalidate();
    }//GEN-LAST:event_btnAddEffectActionPerformed

    private void lstEffectsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstEffectsValueChanged
        panSettings.removeAll();
        if (lstEffects.getSelectedValue() != null) {
            Effect e = (Effect)lstEffects.getSelectedValue();
            if (e.getControl()!=null)
            panSettings.add(e.getControl());
        }
        panSettings.revalidate();
        panSettings.repaint();
    }//GEN-LAST:event_lstEffectsValueChanged

    private void btnDeleteEffectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteEffectActionPerformed
        if (lstEffects.getSelectedValue()!=null){
            Effect e = (Effect)lstEffects.getSelectedValue();
            listModel.removeElement(e);
            stream.removeEffect(e);
            lstEffects.revalidate();
        }
    }//GEN-LAST:event_btnDeleteEffectActionPerformed

    private void btnMoveUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoveUpActionPerformed
        if (lstEffects.getSelectedValue()!=null){
            int indexSelected = lstEffects.getSelectedIndex();
            if (indexSelected>0){
                int indexPrevious = indexSelected-1;
                Effect previous = (Effect)listModel.getElementAt(indexPrevious);
                Effect selected = (Effect)listModel.getElementAt(indexSelected);
                listModel.setElementAt(selected, indexPrevious);
                listModel.setElementAt(previous, indexSelected);
                stream.getEffects().set(indexSelected,previous);
                stream.getEffects().set(indexPrevious,selected);
                lstEffects.setSelectedIndex(indexPrevious);
            }
            lstEffects.revalidate();
        }
    }//GEN-LAST:event_btnMoveUpActionPerformed

    private void btnMoveDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoveDownActionPerformed
        if (lstEffects.getSelectedValue()!=null){
            int indexSelected = lstEffects.getSelectedIndex();
            if (indexSelected != -1 && indexSelected<(listModel.size()-1)){
                int indexNext = indexSelected+1;
                Effect next = (Effect)listModel.getElementAt(indexNext);
                Effect selected = (Effect)listModel.getElementAt(indexSelected);
                listModel.setElementAt(selected, indexNext);
                listModel.setElementAt(next, indexSelected);
                stream.getEffects().set(indexSelected,next);
                stream.getEffects().set(indexNext,selected);
                lstEffects.setSelectedIndex(indexNext);
            }
            lstEffects.revalidate();
        }
    }//GEN-LAST:event_btnMoveDownActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddEffect;
    private javax.swing.JButton btnDeleteEffect;
    private javax.swing.JButton btnMoveDown;
    private javax.swing.JButton btnMoveUp;
    private javax.swing.JComboBox cboEffects;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lstEffects;
    private javax.swing.JPanel panSettings;
    // End of variables declaration//GEN-END:variables
}