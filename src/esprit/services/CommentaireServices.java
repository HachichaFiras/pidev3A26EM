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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class CommentaireServices implements CrudInterface<Comments>{
    Connection cnx;
    public CommentaireServices() {
        
            cnx = MaConnection.getInstance().getCnx();

    }

    @Override
    public void ajouter(Comments t) {
  try {
            String sql = "insert into commentaire(user,blog,contenu,creationDate) values (?,?,?,?)";
                 Timestamp timestamp = Timestamp.valueOf(t.getDateCreation());
            PreparedStatement stmt = cnx.prepareStatement(sql);
           stmt.setInt(2,t.getBlog().getId());
           stmt.setInt(1,t.getFreelancer().getId());
            stmt.setTimestamp(4, timestamp);
            stmt.setString(3, t.getContenu() );
         
            stmt.executeUpdate();
            System.out.println("Commentaire Ajoutee avec success");
            
            
        } catch (SQLException ex) {
               System.out.println(ex.getMessage());
        }    }

    public List<Comments> getAllByBlog(Blog b) {

List<Comments> all = new ArrayList<>();
Comments c = null;
        Statement stmt;
        try {
            String sql = "SELECT * FROM commentaire join utilisateur on(utilisateur.id = commentaire.user) WHERE blog = "+b.getId()+" order by creationDate;";
            
          stmt = cnx.createStatement();
            
               ResultSet rs =  stmt.executeQuery(sql);
                
                while(rs.next()){
                    c = new Comments(new Utilisateur(rs.getInt(6),rs.getString("nom")+" "+ rs.getString("prenom")),rs.getString("contenu") , rs.getTimestamp("creationDate").toLocalDateTime(), b);
all.add(c);
                }
                return all;
                    
            
        } catch (SQLException ex) {
               System.out.println(ex.getMessage());
        }
        return 
                all;
    }

    @Override
    public Comments findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Comments t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Comments t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Comments> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
