/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.services;

import esprit.cnx.MaConnection;
import esprit.entity.CV;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import esprit.interfaces.*;
import esprit.entity.*;
import esprit.cnx.*;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class CvService implements InterfaceService<CV>{
    Connection cnx;
    
    public CvService() {
        
            cnx = MaConnection.getInstance().getCnx();

    }

    @Override
    public void ajouter(CV t) {
        try{
            String sql = "insert into CV(id_utlisateur,pdf_cv,img,link_github,link_linkedin,bio) values(?,?,?,?,?,?)";
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setInt(1,t.getId_user().getId());
            ste.setString(2, t.getCv());
            ste.setString(3,t.getImg());
            ste.setString(4,t.getGit());
            ste.setString(5,t.getLinkedin());
            ste.setString(6, t.getBio());
            ste.executeUpdate();
            System.out.println("CV added succesfully ");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

  
    public CV findByIdFreelancer(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void update(CV t) {
        String sql = "update CV set pdf_cv=?,img=?,link_github=?,link_linkedin=?,bio=? where id=?";
        try {
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setString(1, t.getCv());
            ste.setString(2, t.getImg());
            ste.setString(3, t.getGit());
            ste.setString(4, t.getLinkedin());
            ste.setString(5, t.getBio());
            ste.setInt(6,t.getId());
            ste.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(CV t) {
        String sql = "delete from CV where id=?";
        try {
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setInt(1, t.getId());
            ste.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<CV> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
