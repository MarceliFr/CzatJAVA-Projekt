package czatjava;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Register extends javax.swing.JFrame {
    private final CzatClient client;
    
    Register(CzatClient client) {
        this.client = client;
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameLabel = new javax.swing.JLabel();
        loginLabel = new javax.swing.JLabel();
        passwordLabel1 = new javax.swing.JLabel();
        passwordLabel2 = new javax.swing.JLabel();
        ageLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        ageTextField = new javax.swing.JTextField();
        loginTextField = new javax.swing.JTextField();
        passwordField1 = new javax.swing.JPasswordField();
        passwordField2 = new javax.swing.JPasswordField();
        registerButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        nameLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nameLabel.setText("Imię");

        loginLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        loginLabel.setText("Login");

        passwordLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        passwordLabel1.setText("Hasło");

        passwordLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        passwordLabel2.setText("Powtórz Hasło");

        ageLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ageLabel.setText("Wiek");

        nameTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        ageTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        loginTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        passwordField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        passwordField2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        registerButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        registerButton.setText("Zarejestruj");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(ageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(passwordLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loginLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nameTextField)
                    .addComponent(ageTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addComponent(loginTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addComponent(passwordField1)
                    .addComponent(passwordField2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(249, Short.MAX_VALUE)
                .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginLabel)
                    .addComponent(loginTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel1)
                    .addComponent(passwordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel2)
                    .addComponent(passwordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ageLabel)
                    .addComponent(ageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registerButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        int age = 0;
        String name = nameTextField.getText();
        String login = loginTextField.getText();
        String password1 = passwordField1.getText();
        String password2 = passwordField2.getText();
        age = Integer.parseInt(ageTextField.getText());
        if(walidate(name, login, password1, password2, age)){
            try {
                client.register(name, login, password2, age);
                JOptionPane.showMessageDialog(this, "Pomyślnie zarejstrowano: " + login);
                System.exit(0);
                //dispose();
            } catch (IOException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Podano błędne dane logowania.");
        }
    }//GEN-LAST:event_registerButtonActionPerformed
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Register().setVisible(true);
//            }
//        });
//    }
    private boolean walidate(String name, String login, String password1, String password2, int age) {
        if(name.equals("") || login.equals("") || password1.equals("") || password2.equals("") || age == 0){
            JOptionPane.showMessageDialog(this, "Wprowadź wszystkie dane do rejestracji");
            return false;
        }
        if(!password1.equals(password2)){
            JOptionPane.showMessageDialog(this, "Hasła nie zgadzają się");
        }
        return true;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ageLabel;
    private javax.swing.JTextField ageTextField;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JTextField loginTextField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JPasswordField passwordField1;
    private javax.swing.JPasswordField passwordField2;
    private javax.swing.JLabel passwordLabel1;
    private javax.swing.JLabel passwordLabel2;
    private javax.swing.JButton registerButton;
    // End of variables declaration//GEN-END:variables
}