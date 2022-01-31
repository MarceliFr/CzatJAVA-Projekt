package czatjava;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server extends Thread{
    private ServerSocket serverSocket;
    private Socket socket;
    
    private final int port;
    private final ArrayList<ServerWorker> workersList;
    private final BaseManager baseManager;
    private final CzatSerwer serverView;

    Server(int PORT, BaseManager baseManager, CzatSerwer serverView) {
        this.port = PORT;
        this.baseManager = baseManager;
        this.serverView = serverView;
        workersList = new ArrayList();
    }
    public ArrayList<ServerWorker> getWorkers(){
        return workersList;
    }
    void removeWorker(ServerWorker worker) {
        workersList.remove(worker);
    }
    @Override
    public void run(){
        try {
            serverSocket = new ServerSocket(port);
            while(true){
                socket = serverSocket.accept();
                ServerWorker sw = new ServerWorker(this, socket);
                workersList.add(sw);
                sw.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Client findClient(String login) {
        return baseManager.gerClient(login);
    }
    public void addToView(Client client) {
        serverView.getModel().addElement(client.toString());
    }
    public void removeFromView(Client client) {
        try{
            serverView.getModel().removeElement(client.toString());
        }catch(NullPointerException ex){
            System.out.println("Rozłączono przez zalogowaniem");
        }
    }
    public void register(String name, String login, String password, int age) {
        baseManager.insert(name, login, password, age);
    }
}