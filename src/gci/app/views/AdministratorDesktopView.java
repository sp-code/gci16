package gci.app.views;

import gci.app.controller.Controller;
import java.sql.SQLException;
import javax.swing.JFrame;

public final class AdministratorDesktopView extends MenuView implements View{
    private final Controller controller;

    public AdministratorDesktopView(Controller controller) {
        super(controller);
        initComponents();
        setLocationRelativeTo(null);
        this.controller = controller;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logoutButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        deleteOperatorButton = new javax.swing.JButton();
        createOperatorButton = new javax.swing.JButton();
        manageCostButton = new javax.swing.JButton();

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

        deleteOperatorButton.setText("Delete Operator");
        deleteOperatorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteOperatorButtonActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(137, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(logoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(createOperatorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteOperatorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(manageCostButton, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(129, 129, 129))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoutButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(createOperatorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteOperatorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(manageCostButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void manageCostButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageCostButtonActionPerformed
        manageButton(this, evt.getActionCommand());
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

    private void deleteOperatorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteOperatorButtonActionPerformed
        setVisible(false);
        try {
            controller.doAction(this, evt.getActionCommand());
        }
        catch(SQLException ex){}
    }//GEN-LAST:event_deleteOperatorButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createOperatorButton;
    private javax.swing.JButton deleteOperatorButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton manageCostButton;
    // End of variables declaration//GEN-END:variables
}
