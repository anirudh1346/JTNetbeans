/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package selectjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author aniru
 */
public class SelectJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

    /**
     * @param args the command line arguments
     */
   
        String url = "jdbc:mysql://localhost:3306/bca2?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String user = "root";
        String password = "36Ka_8026";        
        // TODO code application logic here
        
        try {
            // Establish Connection
            Connection conn = DriverManager.getConnection(url, user, password);
            // Create a statement
            Statement stmt = conn.createStatement();
            //Execute Query
            String query = "SELECT * FROM NAMES";
            ResultSet rs = stmt.executeQuery(query);
            // Display Records
            while (rs.next()) {
                System.out.println("SRN: "+rs.getInt("SRN"));
                System.out.println("Name: " +rs.getString("name"));
                System.out.println("Marks: " +rs.getInt("marks"));
                System.out.println("Address: "+rs.getString("address"));
                System.out.println("Age: "+rs.getInt("age"));
            }
            
            //Close Resources
            rs.close();
            stmt.close();
            conn.close();
            } catch (Exception e) {
            e.printStackTrace();
            }

       
    }
    
}
