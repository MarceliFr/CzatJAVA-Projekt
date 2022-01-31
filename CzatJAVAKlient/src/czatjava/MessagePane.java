package czatjava;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MessagePane extends javax.swing.JFrame{
    private final CzatClient client;
    private final String toUser;
    
    private final ArrayList<MessageWindowListener> messageWindowListeners = new ArrayList<>();

    public MessagePane(CzatClient client, String toUser) {
        this.client = client;
        this.toUser = toUser;
        //client.addMessageListener(this);
        
        initComponents();
    }
    public String getToUser() {
        return toUser;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        czatTextArea = new javax.swing.JTextArea();
        czatTextFieldSend = new javax.swing.JTextField();
        czatButtonSend = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("do " + toUser + " - Klient");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        czatTextArea.setEditable(false);
        czatTextArea.setColumns(20);
        czatTextArea.setLineWrap(true);
        czatTextArea.setRows(5);
        jScrollPane1.setViewportView(czatTextArea);

        czatTextFieldSend.setText("jTextField1");
        czatTextFieldSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                czatTextFieldSendActionPerformed(evt);
            }
        });

        czatButtonSend.setText("Wyślij");
        czatButtonSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                czatButtonSendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(czatTextFieldSend)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(czatButtonSend, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(czatButtonSend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(czatTextFieldSend))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void czatButtonSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_czatButtonSendActionPerformed
        try {
            sendMessage();
        } catch (IOException ex) {
            Logger.getLogger(MessagePane.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_czatButtonSendActionPerformed
    private void czatTextFieldSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_czatTextFieldSendActionPerformed
        try {
            sendMessage();
        } catch (IOException ex) {
            Logger.getLogger(MessagePane.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_czatTextFieldSendActionPerformed
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        messageWindowListeners.forEach(listener -> {
            listener.closedWindow();
        });
    }//GEN-LAST:event_formWindowClosing
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MessagePane().setVisible(true);
//            }
//        });
//    }
    private void sendMessage() throws IOException {
        String text = czatTextFieldSend.getText();
        client.msg(toUser, text);
        System.out.println(text);
        czatTextFieldSend.setText("");
        czatTextArea.append(toUser + " " + text + "\n\n"); 
    }
//    @Override
//    public void onMessage(String fromLogin, String msgBody) {
//        czatTextArea.append(fromLogin + " " + msgBody); 
//    }
    void appendMsg(String fromLogin, String msgBody) {
        czatTextArea.append(fromLogin + " " + msgBody);
    }
    void addMessageWindoeListener(MessageWindowListener messageWindowListener) {
        messageWindowListeners.add(messageWindowListener);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton czatButtonSend;
    private static javax.swing.JTextArea czatTextArea;
    private javax.swing.JTextField czatTextFieldSend;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}