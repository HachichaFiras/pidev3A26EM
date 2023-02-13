/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Config.Connexionbd;
import Entity.*;
import interfaces.CrudInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class KeywordsServices  implements CrudInterface<KeyWords>{

    
     Connection cnx;
    public KeywordsServices () {
        
            cnx = Connexionbd.getInstance().getCnx();

    }

    @Override
    public void ajouter(KeyWords t) {
          try {
              
            String sql = "INSERT INTO keywords (name) \n" +
"SELECT ?\n" +
"WHERE NOT EXISTS \n" +
"    (SELECT name \n" +
"     FROM keywords\n" +
"     WHERE upper(name) = upper(?));";
            PreparedStatement stmt = cnx.prepareStatement(sql);
         
          stmt.setString(1, t.getName());
         stmt.setString(2, t.getName());

         
            stmt.executeUpdate();
            System.out.println("Keyword Ajoutee avec success");
            
            
        } catch (SQLException ex) {
               System.out.println(ex.getMessage());
        }

    }

    @Override
    public List<KeyWords> getAll() {
        
           List<KeyWords> all = new ArrayList<>();
        Statement stmt;
        try {
            String sql = "select * from keywords";
            
          stmt = cnx.createStatement();
            
               ResultSet rs =  stmt.executeQuery(sql);
                
                while(rs.next()){
                    KeyWords k = new KeyWords(rs.getInt("id"), rs.getString("name"));

                    all.add(k);
                    
                }
                return all;
                    
            
        } catch (SQLException ex) {
               System.out.println(ex.getMessage());
        }
        return all;
        
    }

    @Override
    public KeyWords findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(KeyWords t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(KeyWords t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
