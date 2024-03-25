/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Form;

/**
 *
 * @author shiva
 */
import java.sql.*;

public class createFormTable {
    
    public static void main(String args[])
    {
        createFormTable ct = new createFormTable();
        ct.CreateTable();
    }
    
    public static void CreateTable()
    {   
        try {
            Connection con = GetConnection.getConnection();
        
        String q = "Create Table form(StudentID int primary key auto_increment, firstname varchar(100) not null, lastName varchar(100) not null, emailID varchar(50) not null, contact varchar(10) not null)";
        Statement stmt = con.createStatement();
        stmt.executeUpdate(q);
        
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        
    }
}
