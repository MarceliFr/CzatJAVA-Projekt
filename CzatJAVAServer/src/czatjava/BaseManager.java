package czatjava;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

class BaseManager {
    private final String fileName;
    private Connection conn;
    
    public BaseManager(String fileName) {
        this.fileName = fileName;
    }
    public void connect() throws SQLException {
        String url = "jdbc:sqlite:C:/sqlite/db/" + fileName;
        conn = DriverManager.getConnection(url);
        if (conn != null) {
            DatabaseMetaData meta = conn.getMetaData();
            System.out.println("The driver name is " + meta.getDriverName());
        }
    }
    public void createTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS USERS (\n"
                + "	ID integer PRIMARY KEY,\n"
                + "	NAME text NOT NULL,\n"
                + "	LOGIN text NOT NULL,\n"
                + "     PASSWORD text NOT NULL,\n"
                + "     AGE integer NOT NULL\n"
                + ");";
        
        Statement stmt = conn.createStatement();
        stmt.execute(sql);
    }
    public void insert(String name, String login, String password, int age) {
        String sql = "INSERT INTO USERS(name,login,password,age) VALUES(?,?,?,?)";
        
        try (
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, login);
            pstmt.setString(3, password);
            pstmt.setInt(4, age);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public Client gerClient(String login) {
        try {
            String sql1 = "SELECT * FROM USERS WHERE login = '"+ login +"';";
            Statement stmt2 = conn.createStatement();
            ResultSet rs2 = stmt2.executeQuery(sql1);
//            while (rs2.next()) {
//                System.out.println(rs2.getInt("id") +  "\t" + 
//                               rs2.getString("name") + "\t" +
//                               rs2.getString("login") + "\t" +
//                               rs2.getString("password") + "\t" +
//                               rs2.getInt("age"));
//                }
            if(!rs2.isClosed()){
                String name = rs2.getString("name");
                String loginC = rs2.getString("login");
                String password = rs2.getString("password");
                int age = rs2.getInt("age");
                
                System.out.println("Jeszcze tu działa");
                Client client = new Client(name, loginC, password, age);
                return client;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    void selectAll() throws SQLException {
        String sql = "SELECT * FROM USERS";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
            
        // loop through the result set
        while (rs.next()) {
            System.out.println(rs.getInt("id") +  "\t" + 
                               rs.getString("name") + "\t" +
                               rs.getString("login") + "\t" +
                               rs.getString("password") + "\t" +
                               rs.getInt("age"));
        }
    }
}