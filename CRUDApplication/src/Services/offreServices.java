/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Config.Connexionbd;
import Entity.Freelancer;
import Entity.candidature;
import Entity.offre;
import Entity.owner;
import interfaces.CrudInterfaceOffre;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author FARAH
 */
public class offreServices implements CrudInterfaceOffre <offre> {

    public static offre select(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    Connection cnx;
    public offreServices() {
        
            cnx = Connexionbd.getInstance().getCnx();
 }

    
    public void ajouter(offre o) {
           try {
            String sql = "insert into offre(titre,description, dateCreation, etat, owner)"
                    + "values (?,?,?,?,?)";
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setString(1, o.getTitre());
            ste.setString(2, o.getDescription());
            ste.setDate(3,Date.valueOf(o.getDate_creation()) );
            ste.setInt(4, o.getEtat());
            ste.setInt(5, o.getOwner());
            ste.execute();
            System.out.println("offre ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
            
    }

    @Override
    public List<offre> getAll() {
         List<offre> offres = new ArrayList<>();
        try {
            String sql = "select * from offre";
            Statement ste = cnx.createStatement();
            ResultSet s = ste.executeQuery(sql);
            while (s.next()) {

                offre o = new offre(s.getInt(1),s.getString("titre"), s.getString("description"), s.getDate("dateCreation").toLocalDate(),s.getInt(5), s.getInt(1));
                offres.add(o); 

              
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return offres;
    }

    
    @Override
    public offre findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
   // public void update(offre o, String titre) {
    //    String sql = "update offre set titre=? where id=?";
     //   try {
      //      PreparedStatement ste = cnx.prepareStatement(sql);
      //      ste.setString(1, titre);
       //     ste.setInt(3,o.getId());
      //      ste.executeUpdate();
     //   } catch (SQLException ex) {
     //       System.out.println(ex.getMessage());
      //  }

    //}
    


   // public void delete(offre o) {
       //  String sql = "delete from offre where id=?";
    //    try {
       //  PreparedStatement ste = cnx.prepareStatement(sql);
        //   ste.setInt(1, o.getId());
        //    ste.executeUpdate();
   //   } catch (SQLException ex) {
   //         System.out.println(ex.getMessage());
      // }
//  }
          
    public void modifierOffre( offre o) {
        String sql = "update offre set titre=? set description=? where id=?";
        try {
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setString(1, o.getTitre());
            ste.setString(2, o.getDescription());
            ste.setInt(3,o.getId());
            ste.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
  }
    public void supprimerOffre(offre o) {
        String sql = "delete from offre where id=?";
        try {
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setInt(1,o.getId());
            ste.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
   // public void RechercherOffre( offre o) {
      //  String sql = "select from set titre=? set description=? where id=?";
      //  try {
          //  PreparedStatement ste = cnx.prepareStatement(sql);
          //  ste.setString(1, o.getTitre());
         //   ste.setString(2, o.getDescription());
           // ste.setInt(3,o.getId());
         //   ste.executeUpdate();
       // } catch (SQLException ex) {
         //   System.out.println(ex.getMessage());
      //  }
    }
}