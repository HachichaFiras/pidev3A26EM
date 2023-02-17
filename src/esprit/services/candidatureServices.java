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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FARAH
 */
public class candidatureServices implements CrudInterface<Candidature> {
 Connection cnx;
    public candidatureServices() {
        
            cnx = MaConnection.getInstance().getCnx();
    }
       public void ajouter(Candidature c) {
        try {
            String sql = "insert into candidature(etat,offre,freelancer,dateCreation)"
                    + "values (?,?,?,?)";
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setInt(1, c.getEtat());
            ste.setInt(2, c.getOffre().getId());
            ste.setInt(3, c.getF().getId());
            ste.setDate(4,Date.valueOf(c.getDate_creation()) );
            ste.execute();
            
            System.out.println("candidature ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
       

    public List<Candidature> getAllByOffre(Offre f) {
         List<Candidature> candidatures = new ArrayList<>();
        try {
            String sql = "select * from candidature where offre = "+f.getId();
            Statement ste = cnx.createStatement();
            ResultSet s = ste.executeQuery(sql);
            while (s.next()) {


                
                Candidature c = new Candidature(s.getInt("id"), s.getInt("etat"),new Utilisateur(s.getInt("freelancer")),s.getDate("date").toLocalDate(),null);
                candidatures.add(c);

            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            
        }
        return candidatures;
    }
        
    
    public List<Candidature> getAllByUser(Utilisateur u) {
         List<Candidature> candidatures = new ArrayList<>();
        try {
            String sql = "select * from candidature where freelancer = "+u.getId();
            Statement ste = cnx.createStatement();
            ResultSet s = ste.executeQuery(sql);
            while (s.next()) {


                
                Candidature c = new Candidature(s.getInt("id"), s.getInt("etat"),new Utilisateur(s.getInt("freelancer")),s.getDate("date").toLocalDate(),null);
                candidatures.add(c);

            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            
        }
        return candidatures;
    }
            

  

    

    

    public void modifierCandidature(String string, Candidature c) {
       String sql = "update candidature set etat = ? where id=?";
        try {
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setInt(1, c.getEtat());
            ste.setInt(2,c.getId_c());
        
            ste.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
  
    }

    @Override
    public List<Candidature> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Candidature findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Candidature t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Candidature t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   

    
}
