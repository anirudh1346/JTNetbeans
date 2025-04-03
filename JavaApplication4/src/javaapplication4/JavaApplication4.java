/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication4;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author aniru
 */
public class JavaApplication4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String url = "jdbc:mysql://localhost:3306/bca2";
        String user = "root";
        String password = "36Ka_8026";
        
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
        
        
        deleteRow(conn, 59);
        deleteColumn(conn, "age");
        } catch (Exception e){
                e.printStackTrace();
        }}   
        public static void deleteRow(Connection conn, int srn) {
            String deleteRowSQL = "DELETE FROM names WHERE srn = ?";
            try (PreparedStatement stmt = conn.prepareStatement(deleteRowSQL)) {
                stmt.setInt(1, srn);
                int rowsAffected = stmt.executeUpdate();
                System.out.println("Deleted "+ rowsAffected + "rows(s).");
            } catch (Exception e) {
                e.printStackTrace();   
            }
            
        }
        public static void deleteColumn(Connection conn, String columnName) {
            String delete = "ALTER TABLE names DROP COLUMN" + columnName;
            try(Statement stmt = conn.createStatement()) {
                stmt.executeUpdate(delete);
                System.out.println("column '" + columnName + "'deleted succesfully");
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
} 

