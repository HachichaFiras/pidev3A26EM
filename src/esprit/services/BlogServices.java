/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.services;

import esprit.interfaces.*;
import esprit.entity.*;
import esprit.cnx.*;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
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
        
            cnx = MaConnection.getInstance().getCnx();

    }
    
    

    
    
    @Override
    public void ajouter(Blog t) {
           try {
            String sql = "insert into Blog(Title,contenue,dateCreation,actor) values (?,?,?,?)";
                 Timestamp timestamp = Timestamp.valueOf(t.getDateCreation());
            PreparedStatement stmt = cnx.prepareStatement(sql);
            stmt.setString(1,t.getTitle());
            stmt.setString(2, t.getContenu());
            stmt.setTimestamp(3, timestamp);
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
                    Blog b = new Blog(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4).toLocalDateTime(), new Utilisateur(rs.getInt(5), "name") );
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

   Blog b=null ;
        Statement stmt;
        CommentaireServices serv = new CommentaireServices();
        try {
            String sql = "select * from blog where id = "+id;
            
          stmt = cnx.createStatement();
            
               ResultSet rs =  stmt.executeQuery(sql);
                
                if(rs.next()){

                    b = new Blog(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4).toLocalDateTime(), new Utilisateur(rs.getInt(5), "name"));                    
                }
                return b;
                    
            
        } catch (SQLException ex) {
               System.out.println(ex.getMessage());
        }
        return b;
    }

    public List<Blog> findByUser(int id) {

     List<Blog> all = new ArrayList<>();
   Blog b=null;
        Statement stmt;
        CommentaireServices serv = new CommentaireServices();
        try {
            String sql = "select * from blog where actor = "+id;
            
          stmt = cnx.createStatement();
            
               ResultSet rs =  stmt.executeQuery(sql);
                
                while(rs.next()){

                    b = new Blog(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getTimestamp(4).toLocalDateTime(), new Utilisateur(rs.getInt(5), "name"));                    
                    all.add(b);
                }
                return all;
                    
            
        } catch (SQLException ex) {
               System.out.println(ex.getMessage());
        }
        return all;
    }

    @Override
    public void update(Blog t) {
  try {
            String sql = "update blog set Title=? ,contenue = ? where id = ?";
            
            PreparedStatement stmt = cnx.prepareStatement(sql);
            stmt.setString(1,t.getTitle());
            stmt.setString(2, t.getContenu());
            stmt.setInt(3, t.getId());
         
            stmt.executeUpdate();
            System.out.println("Blog update avec success");
            
            
        } catch (SQLException ex) {
               System.out.println(ex.getMessage());
        }
            }

    
    
    @Override
    public void delete(Blog t) {
 try {
            String sql = "delete from blog where id = ? ";
            
            PreparedStatement stmt = cnx.prepareStatement(sql);

            stmt.setInt(1, t.getId());
         
            stmt.executeUpdate();
            System.out.println("Blog  delete avec success");
            
            
        } catch (SQLException ex) {
               System.out.println(ex.getMessage());
        }


    }

}
