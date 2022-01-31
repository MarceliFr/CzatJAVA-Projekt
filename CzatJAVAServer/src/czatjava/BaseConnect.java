package czatjava;

import java.sql.SQLException;

public class BaseConnect {
    public static final int PORT = 1201;
    
    public static void main(String args[]) throws SQLException {
        BaseManager baseManager = new BaseManager("Klienci");
        baseManager.connect();
        baseManager.selectAll();
        
        CzatSerwer serverView = new CzatSerwer();
        serverView.setVisible(true);
        
        Server server = new Server(PORT, baseManager, serverView);
        server.start();
    }
}