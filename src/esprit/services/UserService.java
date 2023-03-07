/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.services;

import esprit.cnx.MaConnection;
import esprit.entity.Utilisateur;
import esprit.interfaces.*;
import esprit.entity.*;
import esprit.cnx.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class UserService implements InterfaceService<Utilisateur>{
    Connection cnx;
    
    public UserService() {
        
            cnx = MaConnection.getInstance().getCnx();

    }

    @Override
    public void ajouter(Utilisateur t) {
        try{
            String sql = "insert into utilisateur(login,email,password,nom,prenom,adresse,role,domaine,numTel) values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setString(1,t.getLogin());
            ste.setString(2, t.getEmail());
            ste.setString(3,t.getPassword());
            ste.setString(4,t.getNom());
            ste.setString(5,t.getPrenom());
            ste.setString(6, t.getAdresse());
            ste.setInt(7, t.getRole());
            ste.setInt(8, t.getDomaine());
            ste.setInt(9,t.getNumTel());
            ste.executeUpdate();
            System.out.println("User added succesfully ");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    public List<Utilisateur> getAllFreelancers() {
        List<Utilisateur> freelancers = new ArrayList<>();
        try {
            String sql = "select * from utilisateur where role=3";
            Statement ste = cnx.createStatement();
            ResultSet s = ste.executeQuery(sql);
            while (s.next()) {

               Utilisateur f = new Utilisateur(s.getInt("id"),s.getInt("role"), s.getInt("domaine"), s.getInt("numTel"),s.getString("nom"),s.getString("email"), s.getString("password"), s.getString("prenom"), s.getString("login"), s.getString("adresse"));
               freelancers.add(f);
          

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return freelancers;
    }

    
    public List<Utilisateur> getAllBuissinessOwners() {
        List<Utilisateur> businessowners = new ArrayList<>();
        try {
            String sql = "select * from utilisateur where role=2";
            Statement ste = cnx.createStatement();
            ResultSet s = ste.executeQuery(sql);
            while (s.next()) {

               Utilisateur f = new Utilisateur(s.getInt("id"),s.getInt("role"), s.getInt("domaine"), s.getInt("numTel"),s.getString("nom"),s.getString("email"), s.getString("password"), s.getString("prenom"), s.getString("login"), s.getString("adresse"));
               businessowners.add(f);
          

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return businessowners;
    }

    @Override
    public List<Utilisateur> getAll() {
        List<Utilisateur> users = new ArrayList<>();
        try {
            String sql = "select * from utilisateur";
            Statement ste = cnx.createStatement();
            ResultSet s = ste.executeQuery(sql);
            while (s.next()) {

               Utilisateur f = new Utilisateur(s.getInt("id"),s.getInt("role"), 0, s.getInt("numTel"),s.getString("nom"),s.getString("email"), s.getString("password"), s.getString("prenom"), s.getString("login"), s.getString("adresse"));
               users.add(f);
          

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return users;
    }



    public void updateFreelancer(Utilisateur t) {
        String sql = "update utilisateur set domaine=?,nom=?,prenom=?,numTel=?,adresse=? where id=?";
        try {
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setInt(1, t.getDomaine());
            ste.setString(2, t.getNom());
            ste.setString(3, t.getPrenom());
            ste.setInt(4, t.getNumTel());
            ste.setString(5, t.getAdresse());
            ste.setInt(6,t.getId());
            ste.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void updateBusinessOwner(Utilisateur t) {
        String sql = "update utilisateur set domaine=?,nom=?,prenom=?,numTel=?,adresse=? where id=?";
        try {
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setInt(1, t.getDomaine());
            ste.setString(2, t.getNom());
            ste.setString(3, t.getPrenom());
            ste.setInt(4, t.getNumTel());
            ste.setString(5, t.getAdresse());
            ste.setInt(6,t.getId());
            ste.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    
    public void deleteUser(Utilisateur t) {
        String sql = "delete from utilisateur where id=?";
        try {
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setInt(1, t.getId());
            ste.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

 

    public Utilisateur findByid(int id) {
   try {
            String sql = "select * from utilisateur where id="+id;
            Statement ste = cnx.createStatement();
            ResultSet s = ste.executeQuery(sql);
            if (s.next()) {

               Utilisateur f = new Utilisateur(s.getInt("id"),s.getInt("role"), 0, s.getInt("numTel"),s.getString("nom"),s.getString("email"), s.getString("password"), s.getString("prenom"), s.getString("login"), s.getString("adresse"));
          return f;

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;


    }

    @Override
    public boolean findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
}
