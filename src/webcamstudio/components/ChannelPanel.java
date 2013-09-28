/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ChannelPanel.java
 *
 * Created on 23-Apr-2012, 12:17:31 AM
 */
package webcamstudio.components;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.DefaultListModel;
import webcamstudio.WebcamStudio;
import webcamstudio.channels.MasterChannels;
import webcamstudio.mixers.SystemPlayer;
import webcamstudio.streams.Stream;
import webcamstudio.util.Tools;




/**
 *
 * @author patrick (modified by karl)
 */
public class ChannelPanel extends javax.swing.JPanel implements WebcamStudio.Listener {

    MasterChannels master = MasterChannels.getInstance();
    public static DefaultListModel model = new DefaultListModel();
    public static DefaultComboBoxModel aModel = new DefaultComboBoxModel();
    public static ArrayList<String> CHCurrNext = new ArrayList<String>();
    public static ArrayList<Integer> CHTimers = new ArrayList<Integer>();
    public static ArrayList<String> ListChannels = new ArrayList<String>();
    ArrayList<Stream> streamS = MasterChannels.getInstance().getStreams();   
    String selectChannel=null;   
    int CHon =0;
    String CHNxName = null;
    int CHNextTime =0;
    int CHTimer = 0;
    public static Timer CHt=new Timer();
    String CHptS= null;
    public static Boolean StopCHpt=false;
    boolean inTimer=false;
    
    /**
     * Creates new form ChannelPanel
     */
    @SuppressWarnings("unchecked") 
    public ChannelPanel() {
        initComponents();
        final ChannelPanel instanceChPnl = this;
        lstChannels.setModel(model);
        lstNextChannel.setModel(aModel);
        WebcamStudio.setListener(instanceChPnl);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lstChannelsScroll = new javax.swing.JScrollPane();
        lstChannels = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnSelect = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        lstNextChannel = new javax.swing.JComboBox();
        ChDuration = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        StopCHTimer = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        CHProgressTime = new javax.swing.JProgressBar();
        btnStopAllStream = new javax.swing.JButton();
        btnRenameCh = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(238, 499));

        lstChannelsScroll.setName("lstChannelsScroll"); // NOI18N

        lstChannels.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstChannels.setName("lstChannels"); // NOI18N
        lstChannels.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstChannelsValueChanged(evt);
            }
        });
        lstChannelsScroll.setViewportView(lstChannels);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("webcamstudio/Languages"); // NOI18N
        jLabel1.setText(bundle.getString("Name")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        txtName.setName("txtName"); // NOI18N

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/tango/list-add.png"))); // NOI18N
        btnAdd.setToolTipText(bundle.getString("ADD_CHANNEL")); // NOI18N
        btnAdd.setName("btnAdd"); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/tango/process-stop.png"))); // NOI18N
        btnRemove.setToolTipText(bundle.getString("REMOVE_CHANNEL")); // NOI18N
        btnRemove.setEnabled(false);
        btnRemove.setName("btnRemove"); // NOI18N
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnSelect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/tango/media-playback-start.png"))); // NOI18N
        btnSelect.setToolTipText(bundle.getString("APPLY_CHANNEL")); // NOI18N
        btnSelect.setEnabled(false);
        btnSelect.setName("btnSelect"); // NOI18N
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/tango/view-refresh.png"))); // NOI18N
        btnUpdate.setToolTipText(bundle.getString("UPDATE_CHANNEL")); // NOI18N
        btnUpdate.setEnabled(false);
        btnUpdate.setName("btnUpdate"); // NOI18N
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        lstNextChannel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        lstNextChannel.setName("lstNextChannel"); // NOI18N
        lstNextChannel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lstNextChannelActionPerformed(evt);
            }
        });

        ChDuration.setToolTipText("0 = Infinite");
        ChDuration.setName("ChDuration"); // NOI18N
        ChDuration.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ChDurationStateChanged(evt);
            }
        });

        jLabel2.setText(bundle.getString("NEXT_CHANNEL")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setText(bundle.getString("DURATION")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        StopCHTimer.setText(bundle.getString("STOP_CHANNEL_TIMER")); // NOI18N
        StopCHTimer.setName("StopCHTimer"); // NOI18N
        StopCHTimer.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        StopCHTimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopCHTimerActionPerformed(evt);
            }
        });

        jLabel4.setText(bundle.getString("CURRENT_CHANNEL_TIMER")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        CHProgressTime.setName("CHProgressTime"); // NOI18N

        btnStopAllStream.setText(bundle.getString("STOP_ALL")); // NOI18N
        btnStopAllStream.setName("btnStopAllStream"); // NOI18N
        btnStopAllStream.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopAllStreamActionPerformed(evt);
            }
        });

        btnRenameCh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/tango/view-refresh.png"))); // NOI18N
        btnRenameCh.setToolTipText(bundle.getString("RENAME_CHANNEL")); // NOI18N
        btnRenameCh.setEnabled(false);
        btnRenameCh.setName("btnRenameCh"); // NOI18N
        btnRenameCh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRenameChActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(StopCHTimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRenameCh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdd))
                    .addComponent(lstChannelsScroll)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSelect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ChDuration)
                            .addComponent(lstNextChannel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(CHProgressTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnStopAllStream, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnAdd)
                        .addComponent(btnRenameCh, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lstChannelsScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lstNextChannel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ChDuration))
                .addGap(13, 13, 13)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CHProgressTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnStopAllStream)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(StopCHTimer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRemove)
                    .addComponent(btnSelect)
                    .addComponent(btnUpdate)))
        );

        btnStopAllStream.getAccessibleContext().setAccessibleParent(StopCHTimer);
    }// </editor-fold>//GEN-END:initComponents

    private void lstChannelsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstChannelsValueChanged
        if (lstChannels.getSelectedIndex() != -1) {
            selectChannel = lstChannels.getSelectedValue().toString();
            int SelectCHIndex = lstChannels.getSelectedIndex();
            lstNextChannel.setSelectedItem(CHCurrNext.get(SelectCHIndex));
            ChDuration.setValue(CHTimers.get(SelectCHIndex)/1000);
            btnRemove.setEnabled(true);
            btnSelect.setEnabled(!inTimer);
            btnRenameCh.setEnabled(!inTimer);
            btnAdd.setEnabled(!inTimer);
            btnUpdate.setEnabled(true);
            } else {
                btnRemove.setEnabled(false);
                btnSelect.setEnabled(false);
                btnUpdate.setEnabled(false);
        }
    }//GEN-LAST:event_lstChannelsValueChanged
    @SuppressWarnings("unchecked") 
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String name = txtName.getText();
        if (name.length() > 0) {
            master.addChannel(name);
            model.addElement(name);
            aModel.addElement(name);
            CHCurrNext.add(name);
            CHTimers.add(CHTimer);
            ListChannels.add(name);
            lstChannels.revalidate();
            lstNextChannel.revalidate();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        String name = lstChannels.getSelectedValue().toString();
        int SelectCHIndex = lstChannels.getSelectedIndex();
        master.removeChannel(name);
        model.removeElement(name);
        aModel.removeElement(name);
        CHCurrNext.remove(name);
        CHTimers.remove(SelectCHIndex);
        ListChannels.remove(name);
        lstChannels.revalidate();
        lstNextChannel.revalidate();
        btnRenameCh.setEnabled(false);
    }//GEN-LAST:event_btnRemoveActionPerformed
    @SuppressWarnings("unchecked") 
    public static void AddLoadingChannel(String name) {
        if (name.length() > 0) {
            model.addElement(name);
            aModel.addElement(name);
            ListChannels.add(name);
       }
    }   
    @Override
    public void stopChTime(java.awt.event.ActionEvent evt) {
        StopCHTimerActionPerformed(evt);
    }
    
    @Override
    public void resetBtnStates(java.awt.event.ActionEvent evt) {
        btnRenameCh.setEnabled(false);
        btnSelect.setEnabled(false);
        txtName.setText("");
    }

    class UpdateCHtUITask extends TimerTask {
        @Override
        public void run() {
            CHptS=null;
            int CHpt=0;
            int CHpTemptime = CHNextTime/1000;
            CHProgressTime.setValue(0);
            CHProgressTime.setStringPainted(true);
            CHProgressTime.setMaximum(CHpTemptime);             
            while (CHpt<CHpTemptime && StopCHpt==false){
                CHptS = Integer.toString(CHpt);
                CHProgressTime.setValue(CHpt);
                CHProgressTime.setString(CHptS);
                Tools.sleep(1000);
                CHpt += 1;
            }
            UpdateCHtUITask.this.stop();
        }
        public void stop() {
            StopCHpt=true;
        }
   }
    
   class TSelectActionPerformed extends TimerTask {
        @Override
        public void run(){
            CHon = lstChannels.getSelectedIndex();
            CHNxName = CHCurrNext.get(CHon);
            int n =0;
            for (String h : ListChannels) {
                 if (h.equals(CHNxName)) {
                    CHNextTime = CHTimers.get(n);
                 }
                 n += 1;
            }
            lstChannels.setSelectedValue(CHNxName, true);
            String name = lstChannels.getSelectedValue().toString();
            System.out.println("Apply Select: "+name);
            master.selectChannel(CHNxName);
	    CHt=new Timer();
            CHt.schedule(new TSelectActionPerformed(),CHNextTime);
            CHNextTime = CHTimers.get(lstChannels.getSelectedIndex());
            StopCHpt=false;
            CHProgressTime.setValue(0);
            CHt.schedule(new UpdateCHtUITask(),0);
	}        
    }    
    
    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
        String name = lstChannels.getSelectedValue().toString();
        System.out.println("Apply Select: "+name);
        master.selectChannel(name);
        if (CHTimers.get(lstChannels.getSelectedIndex()) != 0) {
            inTimer=true;
            btnRenameCh.setEnabled(false);
            btnAdd.setEnabled(false);
            lstChannels.setEnabled(false);
            ChDuration.setEnabled(false);
            btnStopAllStream.setEnabled(false);
            btnSelect.setEnabled(false);
            CHt=new Timer();
            CHt.schedule(new TSelectActionPerformed(),CHTimers.get(lstChannels.getSelectedIndex()));
            CHNextTime = CHTimers.get(lstChannels.getSelectedIndex());
            StopCHpt=false;
            CHt.schedule(new UpdateCHtUITask(),0);
        }
    }//GEN-LAST:event_btnSelectActionPerformed
    
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String name = lstChannels.getSelectedValue().toString();
        master.updateChannel(name);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void lstNextChannelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lstNextChannelActionPerformed
        if (lstChannels.getSelectedIndex() != -1) {
           String nextChannel = lstNextChannel.getSelectedItem().toString();
           int ChIndex = lstChannels.getSelectedIndex();
//           String t = CHCurrNext.get(ChIndex);
           CHCurrNext.set(ChIndex, nextChannel);
           } 
    }//GEN-LAST:event_lstNextChannelActionPerformed

    private void ChDurationStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_ChDurationStateChanged
        CHTimer = ChDuration.getValue().hashCode()* 1000;
        if (lstChannels.getSelectedIndex() != -1) {
            int ChIndex = lstChannels.getSelectedIndex();
            CHTimers.set(ChIndex, CHTimer);
        }
    }//GEN-LAST:event_ChDurationStateChanged

    private void StopCHTimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopCHTimerActionPerformed
        CHt.cancel();
        CHt.purge();
        StopCHpt=true;
        lstChannels.setEnabled(true);
        ChDuration.setEnabled(true);
        btnStopAllStream.setEnabled(true);
        btnSelect.setEnabled(true);
        btnRenameCh.setEnabled(true);
        btnAdd.setEnabled(true);
        inTimer=false;
        CHProgressTime.setValue(0);
        CHProgressTime.setString("0");
        ResourceMonitorLabel label = new ResourceMonitorLabel(System.currentTimeMillis()+10000, "Channel Timer Stopped.");
        ResourceMonitor.getInstance().addMessage(label);
    }//GEN-LAST:event_StopCHTimerActionPerformed

    private void btnStopAllStreamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopAllStreamActionPerformed
        SystemPlayer.getInstance(null).stop();
        Tools.sleep(30);
        MasterChannels.getInstance().stopAllStream();
        for (Stream s : streamS){
            s.updateStatus();
        }
        Tools.sleep(30);
        ResourceMonitorLabel label = new ResourceMonitorLabel(System.currentTimeMillis()+10000, "All Stopped.");
        ResourceMonitor.getInstance().addMessage(label);
        System.gc();
    }//GEN-LAST:event_btnStopAllStreamActionPerformed
    @SuppressWarnings("unchecked")
    private void btnRenameChActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRenameChActionPerformed
        if (lstChannels != null) {
            String rnName = txtName.getText();
            String chName = lstChannels.getSelectedValue().toString();
            int SelectCHIndex = lstChannels.getSelectedIndex();
            master.removeChannel(chName);
            model.removeElement(chName);
            aModel.removeElement(chName);
            CHCurrNext.remove(chName);
            CHTimers.remove(SelectCHIndex);
            ListChannels.remove(chName);
            lstChannels.revalidate();
            lstNextChannel.revalidate();
            master.addChannel(rnName);
            model.addElement(rnName);
            aModel.addElement(rnName);
            CHCurrNext.add(rnName);
            CHTimers.add(CHTimer);
            ListChannels.add(rnName);
            lstChannels.revalidate();
            lstNextChannel.revalidate();
        }
    }//GEN-LAST:event_btnRenameChActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar CHProgressTime;
    private javax.swing.JSpinner ChDuration;
    private javax.swing.JButton StopCHTimer;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnRenameCh;
    private javax.swing.JButton btnSelect;
    private javax.swing.JButton btnStopAllStream;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList lstChannels;
    private javax.swing.JScrollPane lstChannelsScroll;
    private javax.swing.JComboBox lstNextChannel;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
    
}
