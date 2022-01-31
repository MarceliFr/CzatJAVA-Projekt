package czatjava;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

public class UsersListPane extends javax.swing.JFrame implements UserStatusListener, MessageListener{
    private final CzatClient client;
    private ArrayList<MessagePane> msgPanes;
    DefaultListModel model;
    
    public UsersListPane(CzatClient client) {
        this.client = client;
        this.client.addUserStatusListener(this);
        client.addMessageListener(this);
        
        this.msgPanes = new ArrayList<>();
        model = new DefaultListModel<String>();
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        usersList = new javax.swing.JList<>();
        startCzatButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        usersList.setModel(model);
        usersList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        usersList.setToolTipText("");
        jScrollPane1.setViewportView(usersList);

        startCzatButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        startCzatButton.setText("Rozpocznij czat");
        startCzatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startCzatButtonActionPerformed(evt);
            }
        });

        exitButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        exitButton.setText("Wyloguj i wyjdź");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(startCzatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(startCzatButton)
                    .addComponent(exitButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            client.logoff();
        } catch (IOException ex) {
            Logger.getLogger(UsersListPane.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing
    private void startCzatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startCzatButtonActionPerformed
        if(!usersList.isSelectionEmpty()){
            String sendTo = usersList.getSelectedValue();
            MessagePane msgPane = new MessagePane(client, sendTo);
            msgPane.setVisible(true);
            msgPanes.add(msgPane);
        }
    }//GEN-LAST:event_startCzatButtonActionPerformed
//    public static void main(String args[]) throws IOException {
//        CzatClient client = new CzatClient("127.0.0.1", 1201);
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new UsersListPane(client).setVisible(true);
//            }
//        });
//    }
    @Override
    public void online(String login) {
        model.addElement(login);
    }
    @Override
    public void offline(String login) {
        model.removeElement(login);
    }
    @Override
    public void onMessage(String fromLogin, String msgBody) {
        System.out.println("Coś dotarło do widoku");
        if(!msgPanes.isEmpty()){
            for(MessagePane pane: msgPanes){
                if(pane.getToUser().equals(fromLogin)){
                    pane.setAlwaysOnTop(true);
                    pane.appendMsg(fromLogin, msgBody);
                    return;
                }
            }
        }
        MessagePane msgPane = new MessagePane(client, fromLogin);
        msgPane.setVisible(true);
        //msgPane.addMessageWindoeListener(this);
        msgPane.setAlwaysOnTop(true);
        msgPanes.add(msgPane);
    }
//    @Override
//    public void closedWindow() {
//        System.out.println("Okno zostaje zamknięte");
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton startCzatButton;
    private javax.swing.JList<String> usersList;
    // End of variables declaration//GEN-END:variables
}