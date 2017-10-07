package gci.app.views;

import gci.app.controller.Controller;
import java.sql.SQLException;
import javax.swing.JFrame;

public final class AdministratorDesktopView extends JFrame implements MenuView{
    private final Controller controller;

    public AdministratorDesktopView(Controller controller) {
        initComponents();
        setLocationRelativeTo(null);
        this.controller = controller;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logoutButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        managePasswordButton = new javax.swing.JButton();
        createOperatorButton = new javax.swing.JButton();
        manageCostButton = new javax.swing.JButton();
        deleteOperatorButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GCI '16");
        setMaximumSize(new java.awt.Dimension(440, 320));
        setMinimumSize(new java.awt.Dimension(440, 320));
        setPreferredSize(new java.awt.Dimension(440, 320));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        logoutButton.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 10)); // NOI18N
        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        jLabel1.setText("GCI '16");

        managePasswordButton.setText("Manage Password Operator");
        managePasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managePasswordButtonActionPerformed(evt);
            }
        });

        createOperatorButton.setText("Create Operator");
        createOperatorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createOperatorButtonActionPerformed(evt);
            }
        });

        manageCostButton.setText("Manage Cost");
        manageCostButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageCostButtonActionPerformed(evt);
            }
        });

        deleteOperatorButton.setText("Delete Operator");
        deleteOperatorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteOperatorButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(managePasswordButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(createOperatorButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteOperatorButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(manageCostButton, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoutButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(createOperatorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(managePasswordButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deleteOperatorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(manageCostButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void manageCostButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageCostButtonActionPerformed
        dispose();
        try {
            controller.doAction(this, evt.getActionCommand());
        } catch (SQLException ex){}
        dispose();
        try {
            controller.doAction(this, evt.getActionCommand());
        } catch (SQLException ex){}
    }//GEN-LAST:event_manageCostButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        setVisible(false);
        try {
            controller.doAction(this, evt.getActionCommand());
        }
        catch(SQLException ex){}
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void createOperatorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createOperatorButtonActionPerformed
        setVisible(false);
        try {
            controller.doAction(this, evt.getActionCommand());
        }
        catch(SQLException ex){}
    }//GEN-LAST:event_createOperatorButtonActionPerformed

    private void managePasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managePasswordButtonActionPerformed
        setVisible(false);
        try {
            controller.doAction(this, evt.getActionCommand());
        }
        catch(SQLException ex){}
    }//GEN-LAST:event_managePasswordButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void deleteOperatorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteOperatorButtonActionPerformed
        setVisible(false);
        try {
            controller.doAction(this, evt.getActionCommand());
        }
        catch(SQLException ex){}
    }//GEN-LAST:event_deleteOperatorButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createOperatorButton;
    private javax.swing.JButton deleteOperatorButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton manageCostButton;
    private javax.swing.JButton managePasswordButton;
    // End of variables declaration//GEN-END:variables
}
