package czatjava;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

public class CzatClient{
    private final String serverName;
    private final int serverPort;
    private Socket socket;
    private DataInputStream serverIn;
    private DataOutputStream serverOut;

    private final ArrayList<UserStatusListener> userStatusListeners = new ArrayList<>();
    private final ArrayList<MessageListener> messageListeners = new ArrayList<>();

    public CzatClient(String serverName, int serverPort) {
        this.serverName = serverName;
        this.serverPort = serverPort;
    }
    public static void main(String[] args) throws IOException {
        CzatClient client = new CzatClient("127.0.0.1", 8818);
        client.addUserStatusListener(new UserStatusListener() {
            @Override
            public void online(String login) {
                System.out.println("ONLINE: " + login);
            }
            @Override
            public void offline(String login) {
                System.out.println("OFFLINE: " + login);
            }
        });
        client.addMessageListener(new MessageListener() {
            @Override
            public void onMessage(String fromLogin, String msgBody) {
                System.out.println("Masz wiadomość od " + fromLogin + " ===> " + msgBody);
            }
        });
        if (!client.connect()) {
            System.err.println("Connect failed.");
        } else {
            System.out.println("Connect successful");
            //client.logoff();
        }
    }
    public void msg(String sendTo, String msgBody) throws IOException {
        String cmd = "msg " + sendTo + " " + msgBody + "\n";
        serverOut.writeUTF(cmd);
    }
    public boolean login(String login, String password) throws IOException {
        String cmd = "login " + login + " " + password + "\n";
        serverOut.writeUTF(cmd);

        String response = serverIn.readUTF();
        System.out.println("Response Line:" + response);
        if ("ok login\n".equals(response)) {
            startMessageReader();
            System.out.println("Zalogowano");
            return true;
        } else if("error login\\n".equals(response)){
            System.out.println("Błądny login lub hasło");
            return false;
        }else{
            System.out.println("Błądny login lub hasło");
            return false;
        }
    }
    public void logoff() throws IOException {
        String cmd = "logoff\n";
        serverOut.writeUTF(cmd);
    }
    public boolean register(String name, String login, String password, int age) throws IOException{
        String cmd = "register " + name + " " + login + " " + password + " " + age + "\n";
        serverOut.writeUTF(cmd);

        String response = serverIn.readUTF();
        System.out.println("Response Line:" + response);
        if ("ok register\n".equals(response)) {
            startMessageReader();
            System.out.println("Użytkownik został zarejestrowany");
            return true;
        } else {
            return false;
        }
    }
    private void startMessageReader() {
        Thread t = new Thread() {
            @Override
            public void run() {
                readMessageLoop();
            }
        };
        t.start();
    }
    private void readMessageLoop() {
        try {
            String line;
            while ((line = serverIn.readUTF()) != null) {
                String[] tokens = StringUtils.split(line);
                if (tokens != null && tokens.length > 0) {
                    String cmd = tokens[0];
                    if ("online".equalsIgnoreCase(cmd)) {
                        handleOnline(tokens);
                    } else if ("offline".equalsIgnoreCase(cmd)) {
                        handleOffline(tokens);
                    } else if ("msg".equalsIgnoreCase(cmd)) {
                        String[] tokensMsg = StringUtils.split(line, null, 3);
                        handleMessage(tokensMsg);
                    }
                }
            }
        } catch (IOException ex) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void handleMessage(String[] tokensMsg) {
        String login = tokensMsg[1];
        String msgBody = tokensMsg[2];

        for(MessageListener listener : messageListeners) {
            listener.onMessage(login, msgBody);
        }
    }
    private void handleOffline(String[] tokens) {
        String login = tokens[1];
        for(UserStatusListener listener : userStatusListeners) {
            listener.offline(login);
        }
    }
    private void handleOnline(String[] tokens) {
        String login = tokens[1];
        for(UserStatusListener listener : userStatusListeners) {
            listener.online(login);
        }
    }
    public boolean connect() {
        try {
            this.socket = new Socket(serverName, serverPort);
            System.out.println("Client port is " + socket.getLocalPort());
            this.serverOut = new DataOutputStream(socket.getOutputStream());
            this.serverIn = new DataInputStream(socket.getInputStream());
            return true;
        }catch(ConnectException e){
            return false;
        } catch (IOException ex) {
            Logger.getLogger(CzatClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
//    public void disconnect(){
//        try {
//            this.socket.close();
//        } catch (IOException ex) {
//            Logger.getLogger(CzatClient.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    public void addUserStatusListener(UserStatusListener listener) {        System.out.println("Dodano userListener" + listener.getClass());
        userStatusListeners.add(listener);
    }
    public void removeUserStatusListener(UserStatusListener listener) {
        userStatusListeners.remove(listener);
    }
    public void addMessageListener(MessageListener listener) {
        messageListeners.add(listener);
    }
    public void removeMessageListener(MessageListener listener) {
        messageListeners.remove(listener);
    }
}