package czatjava;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import java.net.Socket;

import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerWorker extends Thread {
    private final Socket clientSocket;
    private final Server server;
    private Client client;
    
    private DataOutputStream outputStream;
    private final HashSet<String> topicSet = new HashSet<>();

    public ServerWorker(Server server, Socket clientSocket) {
        this.server = server;
        this.clientSocket = clientSocket;
    }
    @Override
    public void run() {
        try {
            handleClientSocket();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(ServerWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    private void handleClientSocket() throws IOException, InterruptedException {
        DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream());
        this.outputStream = new DataOutputStream(clientSocket.getOutputStream());
        
        String line;
        while ( (line = inputStream.readUTF()) != null) {
            String[] tokens = StringUtils.split(line);
            if (tokens != null && tokens.length > 0) {
                String cmd = tokens[0];
                if ("logoff".equals(cmd) || "quit".equalsIgnoreCase(cmd)) {
                    handleLogoff();
                    break;
                } else if ("login".equalsIgnoreCase(cmd)) {
                    handleLogin(outputStream, tokens);
                } else if ("register".equalsIgnoreCase(cmd)) {
                    handleRegister(outputStream, tokens);
                } else if ("msg".equalsIgnoreCase(cmd)) {
                    String[] tokensMsg = StringUtils.split(line, null, 3);
                    handleMessage(tokensMsg);
                } else if ("join".equalsIgnoreCase(cmd)) {
                    handleJoin(tokens);
                } else if ("leave".equalsIgnoreCase(cmd)) {
                    handleLeave(tokens);
                } else {
                    String msg = "unknown " + cmd + "\n";
                    outputStream.write(msg.getBytes());
                }
            }
        }
        clientSocket.close();
    }
    public boolean isMemberOfTopic(String topic) {
        return topicSet.contains(topic);
    }
    private void handleJoin(String[] tokens) {
        if (tokens.length > 1) {
            String topic = tokens[1];
            topicSet.add(topic);
        }
    }
    private void handleLeave(String[] tokens) {
        if (tokens.length > 1) {
            String topic = tokens[1];
            topicSet.remove(topic);
        }
    }
    // format: "msg" "login" body...
    // format: "msg" "#topic" body...
    private void handleMessage(String[] tokens) throws IOException {
        String sendTo = tokens[1];
        String body = tokens[2];

        boolean isTopic = sendTo.charAt(0) == '#';

        List<ServerWorker> workerList = server.getWorkers();
        for(ServerWorker worker : workerList) {
            if (isTopic) {
                if (worker.isMemberOfTopic(sendTo)) {
                    String outMsg = "msg " + sendTo + ":" + client.getLogin() + " " + body + "\n";
                    worker.send(outMsg);
                }
            } else {
                if (sendTo.equalsIgnoreCase(worker.getLogin())) {
                    String outMsg = "msg " + client.getLogin() + " " + body + "\n";
                    worker.send(outMsg);
                }
            }
        }
    }
    public String getLogin() {
        if(client != null){
            return client.getLogin();
        }
        return null;
    }
    private void handleRegister(DataOutputStream outputStream, String[] tokens) throws IOException {
        if(tokens.length == 5){
            String name = tokens[1];
            String login = tokens[2];
            String password = tokens[3];
            int age = Integer.parseInt(tokens[4]);
            server.register(name, login, password, age);
            
            String msg = "ok register\n";
            outputStream.writeUTF(msg);
            System.out.println("Pomyślnie zarejestrowano: " + tokens[2]);
        }
    }
    private void handleLogin(DataOutputStream outputStream, String[] tokens) throws IOException {
        if (tokens.length == 3) {
            String login = tokens[1];
            String password = tokens[2];
            
            this.client = server.findClient(login);
            
            if (this.client != null) {
                String msg = "ok login\n";
                outputStream.writeUTF(msg);
                System.out.println("Zalogowano pomyślnie: " + client.getLogin());
                
                server.addToView(client);

                List<ServerWorker> workerList = server.getWorkers();

                // send current user all other online logins
                for(ServerWorker worker : workerList) {
                    if (worker.getLogin() != null && client.getLogin() != null) {
                        if (!client.getLogin().equals(worker.getLogin())) {
                            String msg2 = "online " + worker.getLogin() + "\n";
                            send(msg2);
                        }
                    }
                }
                // send other online users current user's status
                String onlineMsg = "online " + client.getLogin() + "\n";
                for(ServerWorker worker : workerList) {
                    if (!client.getLogin().equals(worker.getLogin())) {
                        worker.send(onlineMsg);
                    }
                }
            } else {
                String msg = "error login\n";
                outputStream.writeUTF(msg);
                System.err.println("Login failed for " + login);
            }
        }
    }
    private void handleLogoff() throws IOException {
        server.removeWorker(this);
        server.removeFromView(client);
        
        List<ServerWorker> workerList = server.getWorkers();
        
        // send other online users current user's status
        String offlineMsg = "offline " + client.getLogin() + "\n";
        for(ServerWorker worker : workerList) {
            if (!client.getLogin().equals(worker.getLogin())) {
                worker.send(offlineMsg);
            }
        }
        clientSocket.close();
    }
    private void send(String msg) throws IOException {
        if (client.getLogin() != null) {
            outputStream.writeUTF(msg);
        }
    }
}