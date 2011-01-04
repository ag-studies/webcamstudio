/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Broadcaster.java
 *
 * Created on 2009-10-25, 01:39:52
 */
package webcamstudio.components;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import org.gstreamer.Gst;
import webcamstudio.InfoListener;
import webcamstudio.exporter.VideoExporterGISS;
import webcamstudio.sources.VideoSource;

/**
 *
 * @author pballeux
 */
public class GISScaster extends javax.swing.JDialog implements InfoListener {

    private VideoExporterGISS broadcaster = null;
    private Mixer mixer = null;

    /** Creates new form Broadcaster */
    public GISScaster(Mixer m, java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        mixer = m;
        initComponents();
        slideAudioBitrate.setPaintLabels(true);
        slideVideoBitrate.setPaintLabels(true);
        loadPrefs();
    }

    private void loadPrefs(){
        java.util.prefs.Preferences prefs = java.util.prefs.Preferences.userNodeForPackage(this.getClass());
        txtName.setText(prefs.get("gissname",txtName.getText()));
        txtDescription.setText(prefs.get("gissdescription",txtDescription.getText()));
        txtGenre.setText(prefs.get("gissgenre",txtGenre.getText()));
        txtIP.setText(prefs.get("ip",txtIP.getText()));
        txtPort.setText(prefs.get("gissport",txtPort.getText()));
        txtMount.setText(prefs.get("gissmount",txtMount.getText()));
        txtPassword.setText(prefs.get("gisspassword",new String(txtPassword.getPassword())));
        prefs = null;
    }
    private void savePrefs(){
        java.util.prefs.Preferences prefs = java.util.prefs.Preferences.userNodeForPackage(this.getClass());
        prefs.put("gissname",txtName.getText());
        prefs.put("gissdescription",txtDescription.getText());
        prefs.put("gissgenre",txtGenre.getText());
        prefs.put("gissip",txtIP.getText());
        prefs.put("gissport",txtPort.getText());
        prefs.put("gissmount",txtMount.getText());
        prefs.put("gisspassword",new String(txtPassword.getPassword()));
        prefs = null;

    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpBrodcastFormat = new javax.swing.ButtonGroup();
        slideVideoBitrate = new javax.swing.JSlider();
        slideAudioBitrate = new javax.swing.JSlider();
        lblVideoBitrate = new javax.swing.JLabel();
        lblAudioBitrate = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        tglBroadcast = new javax.swing.JToggleButton();
        slideFrameRate = new javax.swing.JSlider();
        lblFrameRate = new javax.swing.JLabel();
        lblInfoMessage = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtDescription = new javax.swing.JTextField();
        txtGenre = new javax.swing.JTextField();
        txtIP = new javax.swing.JTextField();
        txtPort = new javax.swing.JTextField();
        txtMount = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnCreateAccount = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("webcamstudio/Languages"); // NOI18N
        setTitle(bundle.getString("GISSCASTER")); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        slideVideoBitrate.setMajorTickSpacing(20);
        slideVideoBitrate.setMaximum(150);
        slideVideoBitrate.setMinimum(20);
        slideVideoBitrate.setMinorTickSpacing(10);
        slideVideoBitrate.setPaintLabels(true);
        slideVideoBitrate.setPaintTicks(true);
        slideVideoBitrate.setSnapToTicks(true);
        slideVideoBitrate.setName("slideVideoBitrate"); // NOI18N

        slideAudioBitrate.setMajorTickSpacing(16);
        slideAudioBitrate.setMaximum(128);
        slideAudioBitrate.setMinimum(64);
        slideAudioBitrate.setMinorTickSpacing(8);
        slideAudioBitrate.setPaintLabels(true);
        slideAudioBitrate.setPaintTicks(true);
        slideAudioBitrate.setSnapToTicks(true);
        slideAudioBitrate.setName("slideAudioBitrate"); // NOI18N

        lblVideoBitrate.setText(bundle.getString("VIDEO_BITRATE")); // NOI18N
        lblVideoBitrate.setName("lblVideoBitrate"); // NOI18N

        lblAudioBitrate.setText(bundle.getString("AUDIO_BITRATE")); // NOI18N
        lblAudioBitrate.setName("lblAudioBitrate"); // NOI18N

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/tango/process-stop.png"))); // NOI18N
        btnClose.setText(bundle.getString("CLOSE")); // NOI18N
        btnClose.setName("btnClose"); // NOI18N
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        tglBroadcast.setFont(new java.awt.Font("DejaVu Sans", 1, 18));
        tglBroadcast.setForeground(new java.awt.Color(255, 0, 6));
        tglBroadcast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/tango/media-record.png"))); // NOI18N
        tglBroadcast.setText(bundle.getString("BROADCAST")); // NOI18N
        tglBroadcast.setName("tglBroadcast"); // NOI18N
        tglBroadcast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglBroadcastActionPerformed(evt);
            }
        });

        slideFrameRate.setMajorTickSpacing(10);
        slideFrameRate.setMaximum(30);
        slideFrameRate.setMinimum(1);
        slideFrameRate.setMinorTickSpacing(5);
        slideFrameRate.setPaintTicks(true);
        slideFrameRate.setName("slideFrameRate"); // NOI18N

        lblFrameRate.setText(bundle.getString("FRAMERATE")); // NOI18N
        lblFrameRate.setName("lblFrameRate"); // NOI18N

        lblInfoMessage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/gisstv2-32x32.png"))); // NOI18N
        lblInfoMessage.setText("   ");
        lblInfoMessage.setName("lblInfoMessage"); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/gisstv2-16x16.png"))); // NOI18N
        jLabel1.setText(bundle.getString("GISSNAME")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText(bundle.getString("DESCRIPTION")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setText(bundle.getString("GENRE")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel4.setText(bundle.getString("GISSSERVER")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        jLabel5.setText(bundle.getString("PORT")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        jLabel6.setText(bundle.getString("GISSMOUNTPOINT")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        jLabel7.setText(bundle.getString("PASSWORD")); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N

        txtName.setText("My Show");
        txtName.setName("txtName"); // NOI18N

        txtDescription.setName("txtDescription"); // NOI18N

        txtGenre.setText("Live");
        txtGenre.setName("txtGenre"); // NOI18N

        txtIP.setText("giss.tv");
        txtIP.setName("txtIP"); // NOI18N

        txtPort.setText("8000");
        txtPort.setName("txtPort"); // NOI18N

        txtMount.setText("myshow.ogg");
        txtMount.setName("txtMount"); // NOI18N

        txtPassword.setName("txtPassword"); // NOI18N

        btnCreateAccount.setText(bundle.getString("GISSCreateAccount")); // NOI18N
        btnCreateAccount.setName("btnCreateAccount"); // NOI18N
        btnCreateAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateAccountActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFrameRate, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(lblAudioBitrate, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(lblVideoBitrate, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtDescription, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGenre, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPort, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIP, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMount, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(slideVideoBitrate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(slideAudioBitrate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(slideFrameRate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                    .addComponent(tglBroadcast, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblInfoMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCreateAccount, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtGenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtMount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVideoBitrate, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(slideVideoBitrate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAudioBitrate, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(slideAudioBitrate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFrameRate)
                    .addComponent(slideFrameRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(tglBroadcast)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClose)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInfoMessage)
                    .addComponent(btnCreateAccount))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.setVisible(false);
        savePrefs();
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void tglBroadcastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglBroadcastActionPerformed
        if (tglBroadcast.isSelected()) {
            slideAudioBitrate.setEnabled(false);
            slideVideoBitrate.setEnabled(false);
            slideFrameRate.setEnabled(false);

            broadcaster = new VideoExporterGISS();
            broadcaster.setMixer(mixer);
            broadcaster.setListener(this);
            broadcaster.setVideoBitrate(slideVideoBitrate.getValue());
            broadcaster.setAudioBitrate(slideAudioBitrate.getValue() * 1000);
            broadcaster.setRate(slideFrameRate.getValue());
            broadcaster.setName(txtName.getText());
            broadcaster.setDescription(txtDescription.getText());
            broadcaster.setGenre(txtGenre.getText());
            broadcaster.setIp(txtIP.getText());
            broadcaster.setPort(txtPort.getText());
            broadcaster.setMount(txtMount.getText());
            broadcaster.setPassword(new String(txtPassword.getPassword()));
            broadcaster.startExport();
        } else {
            slideAudioBitrate.setEnabled(true);
            slideVideoBitrate.setEnabled(true);
            slideFrameRate.setEnabled(true);
            broadcaster.stopExport();
            broadcaster = null;
        }
    }//GEN-LAST:event_tglBroadcastActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        savePrefs();
        if (tglBroadcast.isSelected()) {
            broadcaster.stopExport();
            broadcaster = null;
        }
    }//GEN-LAST:event_formWindowClosing

    private void btnCreateAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateAccountActionPerformed
        try {
            try {
                Desktop.getDesktop().browse(new java.net.URL("http://giss.tv").toURI());
            } catch (URISyntaxException ex) {

            }
        } catch (IOException ex) {
            
        }
    }//GEN-LAST:event_btnCreateAccountActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Gst.init();
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                GISScaster dialog = new GISScaster(new Mixer(), new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnCreateAccount;
    private javax.swing.ButtonGroup grpBrodcastFormat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblAudioBitrate;
    private javax.swing.JLabel lblFrameRate;
    private javax.swing.JLabel lblInfoMessage;
    private javax.swing.JLabel lblVideoBitrate;
    private javax.swing.JSlider slideAudioBitrate;
    private javax.swing.JSlider slideFrameRate;
    private javax.swing.JSlider slideVideoBitrate;
    private javax.swing.JToggleButton tglBroadcast;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtGenre;
    private javax.swing.JTextField txtIP;
    private javax.swing.JTextField txtMount;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPort;
    // End of variables declaration//GEN-END:variables

    @Override
    public void info(String info) {
        lblInfoMessage.setText(info);
    }

    @Override
    public void error(String message) {
        lblInfoMessage.setText(message);
    }

    @Override
    public void newTextLine(String line) {
    }
}