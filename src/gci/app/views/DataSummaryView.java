package gci.app.views;

import gci.app.controller.Controller;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JLabel;

public final class DataSummaryView extends JFrame implements View{
    private final Controller controller;
    
    public DataSummaryView(Controller controller) {
        initComponents();
        setLocationRelativeTo(null);
        this.controller = controller;
    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public JLabel getPhoneLabel() {
        return phoneLabel;
    }

    public JLabel getSurnameLabel() {
        return surnameLabel;
    }

    public JLabel getTaxCodeLabel() {
        return taxCodeLabel;
    }

    public JLabel getHomeAddressLabel() {
        return homeAddressLabel;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        generateButton = new javax.swing.JButton();
        dataSummaryLabel = new javax.swing.JLabel();
        identificativoLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        identificativoLabel2 = new javax.swing.JLabel();
        surnameLabel = new javax.swing.JLabel();
        taxCodeLabel = new javax.swing.JLabel();
        identificativoLabel3 = new javax.swing.JLabel();
        identificativoLabel5 = new javax.swing.JLabel();
        homeAddressLabel = new javax.swing.JLabel();
        identificativoLabel6 = new javax.swing.JLabel();
        phoneLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GCI '16");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        generateButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        generateButton.setText("GENERATE");
        generateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateButtonActionPerformed(evt);
            }
        });

        dataSummaryLabel.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        dataSummaryLabel.setText("Data Summary");

        identificativoLabel.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        identificativoLabel.setText("Name");

        nameLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        nameLabel.setText("#CustomerName");

        label.setFont(new java.awt.Font("Yu Gothic UI", 0, 24)); // NOI18N
        label.setText("GCI '16");

        identificativoLabel2.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        identificativoLabel2.setText("Surname");

        surnameLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        surnameLabel.setText("#CustomerSurname");

        taxCodeLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        taxCodeLabel.setText("#CustomerTaxCode");

        identificativoLabel3.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        identificativoLabel3.setText("Tax Code");

        identificativoLabel5.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        identificativoLabel5.setText("Home Address");

        homeAddressLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        homeAddressLabel.setText("#CustomerHomeAddress");

        identificativoLabel6.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        identificativoLabel6.setText("Phone");

        phoneLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        phoneLabel.setText("#CustomerPhone");

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(identificativoLabel3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(identificativoLabel)
                            .addComponent(identificativoLabel2)))
                    .addComponent(identificativoLabel6)
                    .addComponent(identificativoLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phoneLabel)
                    .addComponent(taxCodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(surnameLabel)
                    .addComponent(nameLabel)
                    .addComponent(homeAddressLabel))
                .addGap(67, 67, 67))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(backButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(generateButton)
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(dataSummaryLabel)
                        .addGap(122, 122, 122))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(label)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(dataSummaryLabel)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(identificativoLabel)
                    .addComponent(nameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(identificativoLabel2)
                    .addComponent(surnameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(identificativoLabel3)
                    .addComponent(taxCodeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(identificativoLabel5)
                    .addComponent(homeAddressLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneLabel)
                    .addComponent(identificativoLabel6))
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(generateButton)
                    .addComponent(backButton))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateButtonActionPerformed
        dispose();
        try {
            controller.doAction(this, evt.getActionCommand());
        } catch (SQLException ex){}
    }//GEN-LAST:event_generateButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        dispose();
        try {
            controller.doAction(this, evt.getActionCommand());
        } catch (SQLException ex){}
    }//GEN-LAST:event_backButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel dataSummaryLabel;
    private javax.swing.JButton generateButton;
    private javax.swing.JLabel homeAddressLabel;
    private javax.swing.JLabel identificativoLabel;
    private javax.swing.JLabel identificativoLabel2;
    private javax.swing.JLabel identificativoLabel3;
    private javax.swing.JLabel identificativoLabel5;
    private javax.swing.JLabel identificativoLabel6;
    private javax.swing.JLabel label;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JLabel taxCodeLabel;
    // End of variables declaration//GEN-END:variables


}
