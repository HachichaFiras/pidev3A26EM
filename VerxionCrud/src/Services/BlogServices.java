/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import interfaces.CrudInterface;
import Entity.*;
import  Config.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class BlogServices implements CrudInterface<Blog>{
    Connection cnx;
    public BlogServices() {
        
            cnx = Connexionbd.getInstance().getCnx();

    }
    
    

    
    
    @Override
    public void ajouter(Blog t) {
           try {
            String sql = "insert into Blog(Title,contenue,dateCreation,actor) values (?,?,?,?)";
            
            PreparedStatement stmt = cnx.prepareStatement(sql);
            stmt.setString(1,t.getTitle());
            stmt.setString(2, t.getContenu());
            stmt.setDate(3, java.sql.Date.valueOf(t.getDateCreation().toLocalDate()));
            stmt.setInt(4, t.getActor().getId());
         
            stmt.executeUpdate();
            System.out.println("Blog Ajoutee avec success");
            
            
        } catch (SQLException ex) {
               System.out.println(ex.getMessage());
        }
        
        
    }

    @Override
    public List<Blog> getAll() {
   
        List<Blog> all = new ArrayList<>();
        Statement stmt;
        try {
            String sql = "select * from blog";
            
          stmt = cnx.createStatement();
            
               ResultSet rs =  stmt.executeQuery(sql);
                
                while(rs.next()){
                    Blog b = new Blog(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4).toLocalDateTime(), new Freelancer(rs.getInt(5), "name") );
                all.add(b);
                    
                }
                return all;
                    
            
        } catch (SQLException ex) {
               System.out.println(ex.getMessage());
        }
        return all;
            }

    @Override
    public Blog findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Blog t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Blog t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
