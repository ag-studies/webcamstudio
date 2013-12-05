/**
 *  WebcamStudio for GNU/Linux
 *  Copyright (C) 2008  Patrick Balleux
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * 
 */

package webcamstudio;

/**
 *
 * @author  pballeux
 */
public class About extends javax.swing.JDialog {
    
    /** Creates new form About
     * @param parent
     * @param modal */
    public About(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        lblVersion.setText(Version.version + " ("+ new Version().getBuild()+")");
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnClose = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAbout = new javax.swing.JTextArea();
        lblVersion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("WebcamStudio for GNU/Linux : About...");
        setModal(true);
        setResizable(false);

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/tango/process-stop.png"))); // NOI18N
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/icon.png"))); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("webcamstudio/Languages"); // NOI18N
        jLabel1.setText(bundle.getString("WEBCAMSTUDIO_FOR_GNU/LINUX")); // NOI18N

        txtAbout.setEditable(false);
        txtAbout.setColumns(20);
        txtAbout.setLineWrap(true);
        txtAbout.setRows(5);
        txtAbout.setText("WebcamStudio for GNU/Linux\nVisit: http://ws4gl.org/\nCopyright (C) 2009  Patrick Balleux\n\nThis program is free software: you can redistribute it and/or modify\nit under the terms of the GNU General Public License as published by\nthe Free Software Foundation, either version 3 of the License, or\n(at your option) any later version.\n\nThis program is distributed in the hope that it will be useful,\nbut WITHOUT ANY WARRANTY; without even the implied warranty of\nMERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the\nGNU General Public License for more details.\n\n You should have received a copy of the GNU General Public License\nalong with this program.  If not, see <http://www.gnu.org/licenses/>.\n\n**************************************\n\nMedia reading is done in part with the gstreamer-java library\nhttp://code.google.com/p/gstreamer-java/\n\nVLoopback support original code was \nfrom mjpegtools_yuv_to_v4l.c\nCopyright (c) Jan Panteltje 2008-always\nThis software is distributed under the \nGNU public license version 2\nSee his site : http://panteltje.com/panteltje/mcamip/\n(Thanks for your work Jan!)\n\nSplash/Background image by Hipdad\n(Thanks Chris!)\n\nIRC code based on Martyr\nhttp://martyr.sourceforge.net/\n\nSpecial Effect \"Night Vision 2\" was provided by Mark Dammer\nThanks Mark!\n\nSinglePaint 2.0 was forked from\nhttp://singlepaint.sourceforge.net/home/\nThanks Zsolt Palotai!\n\nAlso Thanks To G+ Community  WebcamStudio Reloaded:\nj c-chord ; César Medrano Mariscal  ;\nZach McCullough ; Enrique Avila ; Joshua lee\nCharles Maddox ; Uche Okonkwo ; Erikas Aubade ; \nToby Leheup ; Robert Belcher ; T Anthony H Frisby  ; \nChuck Daley  ;  andrew.silver0 .\n https://plus.google.com/communities/110329269823088092206\n\nHave a nice day!"); // NOI18N
        txtAbout.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtAbout);

        lblVersion.setText("0.12"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblVersion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 320, Short.MAX_VALUE)
                        .addComponent(btnClose))
                    .addComponent(jLabel1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClose)
                    .addComponent(lblVersion))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                About dialog = new About(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblVersion;
    private javax.swing.JTextArea txtAbout;
    // End of variables declaration//GEN-END:variables
    
}
