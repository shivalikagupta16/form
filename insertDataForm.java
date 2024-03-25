/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Form;

/**
 *
 * @author shiva
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.*;
import javax.swing.JFileChooser;
public class insertDataForm {
    
    public static void main(String args[])
    {
        insertDataForm iF = new insertDataForm();
       
        iF.insertData();
        
    }
    
    public static void AlterTable(){
        try {
            Connection con = GetConnection.getConnection();
            String q = "Alter table form ADD Column image blob";
            Statement stmt = con.createStatement();
            stmt.executeUpdate(q);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
    
    public static void insertData(){
        try {
            Connection con = GetConnection.getConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            String q = "insert into form(firstName, lastName, emailID, contact, image) VALUES(?,?,?,?,?)";
            
            PreparedStatement pstmt = con.prepareStatement(q);
            
            System.out.println("Choose your image");
            JFileChooser JFile = new JFileChooser();
            JFile.showOpenDialog(null);
            File file = JFile.getSelectedFile();
            FileInputStream fis = new FileInputStream(file);
            
            pstmt.setBinaryStream(5,fis,fis.available());
            
            System.out.println("Enter the first name");
            String first = br.readLine();
            
            System.out.println("Enter the last name");
            String last = br.readLine();
            
            System.out.println("Enter your mail id");
            String mail = br.readLine();
            
            System.out.println("Enter your contact number");
            String contact = br.readLine();
            
            
            
            
            
            
            
            pstmt.setString(1,first);
            pstmt.setString(2,last);
            pstmt.setString(3,mail);
            pstmt.setString(4,contact);
            
            
            
            pstmt.executeUpdate();
            
            System.out.println("Updated row");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
