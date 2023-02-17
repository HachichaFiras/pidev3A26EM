/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.services;

import esprit.cnx.MaConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import esprit.entity.*;
import java.time.LocalDateTime;
import esprit.interfaces.InterfaceService;


/**
 *
 * @author 21624
 */
public class ParticipationService implements InterfaceService <Participation> {
     Connection cnx;

    public ParticipationService() {
        cnx = MaConnection.getInstance().getCnx();
    }
     
    @Override
    public void ajouter(Participation t) {
     
          try {
            String sql = "insert into participation(user,DateCreation,formation)"
                    + "values (?,?,?)";
            PreparedStatement ste = cnx.prepareStatement(sql);
           ste.setInt(1, t.getUser().getId());
             ste.setTimestamp(2, Timestamp.valueOf(t.getDate_creation()));
            ste.setInt(3,t.getFormation().getId());
            ste.executeUpdate();
            System.out.println("Participation ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Participation> getAllbyUser(Utilisateur u) {
          List<Participation> participations = new ArrayList<>();
        try {
            String sql = "select * from participation join formation on (participation.formation = formation.id) where user = "+u.getId();
            Statement ste = cnx.createStatement();
            ResultSet s = ste.executeQuery(sql);
            while (s.next()) {

              //  Participation p = new Participation(s.getTimestamp("date").toLocalDateTime(),s.getClass(),s.getString("formation"));*
        Formation f = new Formation(s.getInt("formation.id"),s.getString("description"), 0, 0, s.getString("titre"),s.getString("lien_meet"), s.getTimestamp("date").toLocalDateTime(),null, u);
   
        Participation p = new Participation(s.getInt("participation.id"),s.getTimestamp("DateCreation").toLocalDateTime(), u, f);
     
                  
                  participations.add(p);
              
            

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return participations;
    }

    
    public boolean findById(int id, Utilisateur u) {
          boolean isFound = false;
         List<Participation> participations = new ArrayList<>();
          try {
            String sql = "select * from participation where id = " +id;
            Statement ste = cnx.createStatement();
            ResultSet s = ste.executeQuery(sql);
            while (s.next()) {
                
                isFound = true;
                Formation f = new Formation(s.getInt("formation.id"),s.getString("description"), 0, 0, s.getString("titre"),s.getString("lien_meet"), s.getTimestamp("date").toLocalDateTime(),null, u);
                Participation p = new Participation(s.getTimestamp("DateCreation").toLocalDateTime(), u, f);
                participations.add(p); 

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         return isFound; 
    }
     public void supprimerParticipation(int id) {
        String sql = "delete from participation where id = " +id;
        try {
            PreparedStatement ste = cnx.prepareStatement(sql);
            //ste.setInt(1, p.getId());
            ste.executeUpdate();
            System.out.println("supprimer");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
     /*  public void modifierParticipation(Participation p) {
        try(PreparedStatement ste = cnx.prepareStatement(QueryUtil.updateParticipation(p.getId()));) {
            
            ste.setInt(1, p.getId());
            //ste.setInt(1, f.getId());
            int rows = ste.executeUpdate();
            if (rows > 0){
                System.err.println("Succes");
            }
       } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }*/

    @Override
    public List<Participation> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
