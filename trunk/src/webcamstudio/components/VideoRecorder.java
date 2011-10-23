/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * VideoRecorder.java
 *
 * Created on 2009-10-12, 16:01:57
 */
package webcamstudio.components;

import java.io.File;
import javax.swing.JFileChooser;
import webcamstudio.exporter.VideoExporter;

/**
 *
 * @author pballeux
 */
public class VideoRecorder extends javax.swing.JDialog implements Runnable {

    private java.io.File file = new java.io.File("video.ogg");
    private long timeStamp = 0;
    private boolean stopMe = false;
    private Mixer mixer = null;
    private VideoExporter export = null;

    /** Creates new form VideoRecorder */
    public VideoRecorder(Mixer m, java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        mixer = m;
        initComponents();
        txtSelectedFileName.setText(file.getAbsolutePath());
        new Thread(this).start();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtSelectedFileName = new javax.swing.JTextField();
        btnBrowseFile = new javax.swing.JButton();
        lblFileSize = new javax.swing.JLabel();
        lblRecordingTime = new javax.swing.JLabel();
        lblActualFileSize = new javax.swing.JLabel();
        tglButtonRecord = new javax.swing.JToggleButton();
        btnClose = new javax.swing.JButton();
        lblActualRecordingTime = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("webcamstudio/Languages"); // NOI18N
        setTitle(bundle.getString("VIDEO_RECORDER")); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        txtSelectedFileName.setEditable(false);
        txtSelectedFileName.setName("txtSelectedFileName"); // NOI18N

        btnBrowseFile.setText(bundle.getString("BROWSE")); // NOI18N
        btnBrowseFile.setName("btnBrowseFile"); // NOI18N
        btnBrowseFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseFileActionPerformed(evt);
            }
        });

        lblFileSize.setText(bundle.getString("FILE_SIZE")); // NOI18N
        lblFileSize.setName("lblFileSize"); // NOI18N

        lblRecordingTime.setText(bundle.getString("RECORDING_TIME")); // NOI18N
        lblRecordingTime.setName("lblRecordingTime"); // NOI18N

        lblActualFileSize.setText("0");
        lblActualFileSize.setName("lblActualFileSize"); // NOI18N

        tglButtonRecord.setFont(new java.awt.Font("DejaVu Sans", 0, 24));
        tglButtonRecord.setForeground(new java.awt.Color(232, 18, 1));
        tglButtonRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/tango/media-record.png"))); // NOI18N
        tglButtonRecord.setText(bundle.getString("RECORD")); // NOI18N
        tglButtonRecord.setName("tglButtonRecord"); // NOI18N
        tglButtonRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglButtonRecordActionPerformed(evt);
            }
        });

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/tango/process-stop.png"))); // NOI18N
        btnClose.setText(bundle.getString("CLOSE")); // NOI18N
        btnClose.setName("btnClose"); // NOI18N
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        lblActualRecordingTime.setText("0");
        lblActualRecordingTime.setName("lblActualRecordingTime"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tglButtonRecord, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                    .addComponent(btnClose, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblFileSize, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblRecordingTime, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblActualRecordingTime, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                    .addComponent(lblActualFileSize, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)))
                            .addComponent(txtSelectedFileName, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBrowseFile)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSelectedFileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrowseFile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFileSize)
                    .addComponent(lblActualFileSize))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRecordingTime)
                    .addComponent(lblActualRecordingTime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tglButtonRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClose)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBrowseFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseFileActionPerformed
        javax.swing.JFileChooser chooser = new javax.swing.JFileChooser(txtSelectedFileName.getText());

        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setMultiSelectionEnabled(false);
        chooser.setMultiSelectionEnabled(false);
        chooser.addChoosableFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("OGG", "OGG", "ogg"));
        chooser.addChoosableFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("FLV", "FLV", "flv"));
        if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            file = chooser.getSelectedFile();
            if (!file.getAbsolutePath().toLowerCase().endsWith(".ogg") && !file.getAbsolutePath().toLowerCase().endsWith(".flv")) {
                file = new File(file.getAbsolutePath() + ".ogg");
            }
            txtSelectedFileName.setText(file.getAbsolutePath());
        }
    }//GEN-LAST:event_btnBrowseFileActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        stopMe = true;
        if (tglButtonRecord.isSelected()) {
            tglButtonRecord.doClick();
        }
    }//GEN-LAST:event_formWindowClosing

    private void tglButtonRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglButtonRecordActionPerformed
        if (tglButtonRecord.isSelected()) {
            btnBrowseFile.setEnabled(false);
            txtSelectedFileName.setEnabled(false);
            btnClose.setEnabled(false);

            if (file.getAbsolutePath().endsWith("ogg")) {
                
            } else if (file.getAbsolutePath().endsWith("flv")) {
                
            } else {
                
            }

            export.setMixer(mixer);
            export.startExport();

            timeStamp = System.currentTimeMillis();
        } else {
            if (export != null) {
                export.stopExport();
                export = null;
            }
            btnBrowseFile.setEnabled(true);
            txtSelectedFileName.setEnabled(true);
            btnClose.setEnabled(true);
            timeStamp = 0;
        }
    }//GEN-LAST:event_tglButtonRecordActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        stopMe = true;
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                VideoRecorder dialog = new VideoRecorder(new Mixer(), new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowseFile;
    private javax.swing.JButton btnClose;
    private javax.swing.JLabel lblActualFileSize;
    private javax.swing.JLabel lblActualRecordingTime;
    private javax.swing.JLabel lblFileSize;
    private javax.swing.JLabel lblRecordingTime;
    private javax.swing.JToggleButton tglButtonRecord;
    private javax.swing.JTextField txtSelectedFileName;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        while (!stopMe) {
            try {
                if (file.exists()) {
                    lblActualFileSize.setText((new java.text.DecimalFormat().format((file.length() / 1024) / 1024f)) + " Mb");
                } else {
                    lblActualFileSize.setText("");
                }
                if (timeStamp == 0) {
                    lblActualRecordingTime.setText("");
                } else {
                    int delta = (int) ((System.currentTimeMillis() - timeStamp) / 1000);
                    int h = (delta / 3600);
                    delta -= (h * 3600);
                    int m = delta / 60;
                    delta -= m * 60;
                    int s = delta;
                    String time = "";
                    if (h < 10) {
                        time += "0";
                    }
                    time += h + ":";
                    if (m < 10) {
                        time += "0";
                    }
                    time += m + ":";
                    if (s < 10) {
                        time += "0";
                    }
                    time += s;
                    lblActualRecordingTime.setText(time);
                }


                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    }
}
