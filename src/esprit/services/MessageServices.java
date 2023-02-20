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
public class MessageServices implements CrudInterface<Message>{

    
     Connection cnx;
    public MessageServices() {
        
            cnx = MaConnection.getInstance().getCnx();

    }
    
    @Override
    public void ajouter(Message t) {
       try {
            String sql = "insert into message(source,dest,dateCreation,contenu) values (?,?,?,?)";
                 Timestamp timestamp = Timestamp.  valueOf(t.getDate());
            PreparedStatement stmt = cnx.prepareStatement(sql);
            stmt.setInt(1,t.getSource().getId());
            stmt.setInt(2,t.getDestinataire().getId());
            stmt.setTimestamp(3, timestamp);
            stmt.setString(4, t.getContenu());
            
         
            stmt.executeUpdate();
            System.out.println("Message Ajoutee avec success");
            
            
        } catch (SQLException ex) {
               System.out.println(ex.getMessage());
        }

    }

    @Override
    public List<Message> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Message findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Message t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Message t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    public List<Utilisateur> findByUser(Utilisateur p) {

   List<Utilisateur> all = new ArrayList<>();
      
        try {
            String sql = "Select * from (SELEct DISTINCT source from message where dest = ? union SELEct DISTINCT dest from message where source = ?) t1 join (select * from utilisateur ) t2 on (t2.id = t1.source)";
            
           PreparedStatement stmt = cnx.prepareStatement(sql);
            stmt.setInt(1,p.getId());
          stmt.setInt(2,p.getId());
         
            stmt.execute();
          
               ResultSet rs =  stmt.executeQuery();
                
                while(rs.next()){
                    
                    Utilisateur f = new Utilisateur(rs.getInt("id"),rs.getString("nom") + " " +rs.getString("prenom") );
                    
                all.add(f);
                }
                return all;
                    
            
        } catch (SQLException ex) {
               System.out.println(ex.getMessage());
        }
        return all;

    }
    
    public List<Message> getAllByuser(Utilisateur current , Utilisateur other  ){
         List<Message> all = new ArrayList<>();
        Message m = null;
      
        try {
            String sql = "SELECT * FROM `message` WHERE (dest = ? and source = ? ) or (dest = ? and source = ? ) order by dateCreation ";
            
           PreparedStatement stmt = cnx.prepareStatement(sql);
            stmt.setInt(1,other.getId());
             stmt.setInt(2,current.getId());
            stmt.setInt(3,current.getId());
            stmt.setInt(4,other.getId());

            stmt.execute();
          
               ResultSet rs =  stmt.executeQuery();
                
                while(rs.next()){
                    if(rs.getInt("source") == current.getId())
                      m = new Message(rs.getInt("id"), current, other, rs.getTimestamp("dateCreation").toLocalDateTime(), rs.getString("Contenu"));
                    else 
                      m = new Message(rs.getInt("id"), other, current, rs.getTimestamp("dateCreation").toLocalDateTime(), rs.getString("Contenu"));
                    
                all.add(m);
                }
                return all;
                    
            
        } catch (SQLException ex) {
               System.out.println(ex.getMessage());
        }
        return all;

    }

    
}
