/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;
import java.sql.*;

/**
 *
 * @author Asus
 */
public class Connexionbd {
    
    
      private   Connection cnx ;
        String url = "jdbc:mysql://localhost:3306/freelance";
       String user ="root";
  String password ="";
  public static Connexionbd ct;

    private Connexionbd()  {
        try {
    cnx = DriverManager.getConnection(url, user, password);
                System.out.println("cnx sucess");

        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }

    }

    public static Connexionbd getInstance(){
        
        if(ct == null)
            ct = new Connexionbd();
         return ct;
        
    }
    
    public Connection getCnx() {
        return cnx;
    }
    
    
     
      
            
        }
        
        

