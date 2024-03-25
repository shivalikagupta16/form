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
public class GetConnection {
    private static Connection con;
    public static void main(String args[]){
        GetConnection gc = new GetConnection();
        gc.getConnection();
    }
    
    public static Connection getConnection(){
        try {
            
            if(con==null)
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/first","root","Shivalika@1611");
                
            }
            
        }catch (Exception e) {
            e.printStackTrace();
        }
        return con;
        }
    }

