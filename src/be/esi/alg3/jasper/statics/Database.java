package be.esi.alg3.jasper.statics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
/**
 * Permet une connexion à la base de données pour générer les rapports et faire les 
 * recherches nécessaires.
 * @author Florian Desneux
 */
public class Database {
 
    public static Connection getConnection() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/eBiblioDB",
                    "app", "app");
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Database.getConnection() Error -->" + ex.getMessage());
            return null;
        }
    }
 
    public static void close(Connection con) {
        try {
            con.close();
        } catch (Exception ex) {
        }
    }
}