package gci.app.views;

import gci.app.controller.Controller;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JLabel;

public final class LoginOKView extends JFrame implements View{
    private final Controller controller;
    
    public LoginOKView(Controller controller) {
        initComponents();
        setLocationRelativeTo(null);
        this.controller = controller;
    }
    
    public JLabel getIDLabel(){
        return this.idLabel;
    }
    
    public JLabel getUserTypeLabel(){
        return this.userTypeLabel;
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bContinue = new javax.swing.JButton();
        loginEffettuatoLabel = new javax.swing.JLabel();
        identificativoLabel = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        loginEffettuatoLabel1 = new javax.swing.JLabel();
        identificativoLabel1 = new javax.swing.JLabel();
        userTypeLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GCI '16");
        setPreferredSize(new java.awt.Dimension(440, 320));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        bContinue.setText("Go to Menù");
        bContinue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bContinueActionPerformed(evt);
            }
        });

        loginEffettuatoLabel.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        loginEffettuatoLabel.setText("Login Successful!");

        identificativoLabel.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        identificativoLabel.setText("Identifier");

        idLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        idLabel.setText("#userId");

        loginEffettuatoLabel1.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        loginEffettuatoLabel1.setText("GCI '16");

        identificativoLabel1.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        identificativoLabel1.setText("User Type");

        userTypeLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        userTypeLabel.setText("#userType");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(279, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(loginEffettuatoLabel1)
                    .addComponent(bContinue))
                .addGap(31, 31, 31))
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(loginEffettuatoLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(identificativoLabel1)
                            .addComponent(identificativoLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idLabel)
                            .addComponent(userTypeLabel))
                        .addGap(106, 106, 106))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(loginEffettuatoLabel1)
                .addGap(15, 15, 15)
                .addComponent(loginEffettuatoLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(identificativoLabel)
                    .addComponent(idLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userTypeLabel)
                    .addComponent(identificativoLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(bContinue)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bContinueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bContinueActionPerformed
        dispose();
        try {
            controller.doAction(this);
        } catch (SQLException ex){}
    }//GEN-LAST:event_bContinueActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bContinue;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel identificativoLabel;
    private javax.swing.JLabel identificativoLabel1;
    private javax.swing.JLabel loginEffettuatoLabel;
    private javax.swing.JLabel loginEffettuatoLabel1;
    private javax.swing.JLabel userTypeLabel;
    // End of variables declaration//GEN-END:variables


}
