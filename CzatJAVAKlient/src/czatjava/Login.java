package czatjava;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame{
    private CzatClient client;
    
    public Login() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginButton = new javax.swing.JButton();
        loginTextField = new javax.swing.JTextField();
        ipLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        cancellButton = new javax.swing.JButton();
        newAccountButton = new javax.swing.JButton();
        loginLabel1 = new javax.swing.JLabel();
        ipTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        loginButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        loginButton.setText("Zaloguj");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        loginTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        ipLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ipLabel.setText("IP Serwera");

        passwordLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        passwordLabel.setText("Hasło");

        passwordField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        cancellButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cancellButton.setText("Anuluj");
        cancellButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancellButtonActionPerformed(evt);
            }
        });

        newAccountButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        newAccountButton.setText("Utwórz konto");
        newAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newAccountButtonActionPerformed(evt);
            }
        });

        loginLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        loginLabel1.setText("Login");

        ipTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(newAccountButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(passwordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(loginLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ipLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(loginTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancellButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ipLabel)
                    .addComponent(ipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginLabel1)
                    .addComponent(loginTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancellButton)
                    .addComponent(loginButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newAccountButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        try {
            String ip = ipTextField.getText();
            String login = loginTextField.getText();
            String password = passwordField.getText();
            this.client = new CzatClient(ip, 1201);
            client.connect();
            if (client.login(login, password)) {
                //client.setLogin(login);
                UsersListPane user = new UsersListPane(client);
                user.setVisible(true);
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Błędny lobin lub hasło.");
            }
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_loginButtonActionPerformed
    private void cancellButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancellButtonActionPerformed
        try {
            client.logoff();
            dispose();
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cancellButtonActionPerformed
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            client.logoff();
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing
    private void newAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newAccountButtonActionPerformed
        Register register = new Register(client);
        register.setVisible(true);
    }//GEN-LAST:event_newAccountButtonActionPerformed
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancellButton;
    private javax.swing.JLabel ipLabel;
    private javax.swing.JTextField ipTextField;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel loginLabel1;
    private javax.swing.JTextField loginTextField;
    private javax.swing.JButton newAccountButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    // End of variables declaration//GEN-END:variables
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }
}