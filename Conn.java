
package toursandtravel;


import java.sql.*;



public class Conn {
    Connection conn;
    Statement s;

    public Conn() {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            

           
            conn = DriverManager.getConnection("jdbc:mysql:///tourandtravel", "root", "Sohail0622");
         

           
            s = conn.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    
}

