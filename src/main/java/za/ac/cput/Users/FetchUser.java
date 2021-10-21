/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.Users;

import javax.swing.JOptionPane;

/**
 *
 * @author Mbuso Kotob's
 */
public class FetchUser extends javax.swing.JFrame {

    /**
     * Creates new form UpdateUser
     */
    public FetchUser()
    {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        userIDLabel = new javax.swing.JLabel();
        userIdInputField = new javax.swing.JTextField();
        fetchUserBttn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        userIDLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        userIDLabel.setText("User ID");

        userIdInputField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(254, 173, 104), 2, true));
        userIdInputField.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                userIdInputFieldActionPerformed(evt);
            }
        });

        fetchUserBttn.setBackground(new java.awt.Color(178, 149, 213));
        fetchUserBttn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fetchUserBttn.setForeground(new java.awt.Color(255, 255, 255));
        fetchUserBttn.setText("Fetch User");
        fetchUserBttn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                fetchUserBttnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(userIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userIdInputField)
                    .addComponent(fetchUserBttn, javax.swing.GroupLayout.DEFAULT_SIZE, 954, Short.MAX_VALUE))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(userIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(userIdInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(fetchUserBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userIdInputFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_userIdInputFieldActionPerformed
    {//GEN-HEADEREND:event_userIdInputFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userIdInputFieldActionPerformed

    private void fetchUserBttnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_fetchUserBttnActionPerformed
    {//GEN-HEADEREND:event_fetchUserBttnActionPerformed
        if(isValidId(userIdInputField.getText()))
        {
            int id = Integer.parseInt(this.userIdInputField.getText().trim());
            UpdateUser updateUserView = new UpdateUser(id);
            updateUserView.setVisible(true);
            this.setVisible(false);  
        }else{
            JOptionPane.showMessageDialog(null, "Invalid User ID");
        }
    }//GEN-LAST:event_fetchUserBttnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(FetchUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(FetchUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(FetchUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(FetchUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run()
            {
                new FetchUser().setVisible(true);
            }
        });
    }
    
    private boolean isValidId(String id)
    {
        return (id.isEmpty()) ? false : Integer.parseInt(userIdInputField.getText()) >= MINIMUM_VALID_ID;
    }
            
    private final int MINIMUM_VALID_ID = 100;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton fetchUserBttn;
    private javax.swing.JLabel userIDLabel;
    private javax.swing.JTextField userIdInputField;
    // End of variables declaration//GEN-END:variables
}
