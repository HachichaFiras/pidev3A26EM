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
public class OffreServices implements CrudInterface <Offre> {

 
    Connection cnx;
    public OffreServices() {
        
            cnx = MaConnection.getInstance().getCnx();
 }

    
    public void ajouter(Offre o) {
           try {
            String sql = "insert into offre(titre,description, dateCreation, etat, owner)"
                    + "values (?,?,?,?,?)";
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setString(1, o.getTitre());
            ste.setString(2, o.getDescription());
            ste.setDate(3,Date.valueOf(o.getDate_creation()) );
            ste.setInt(4, o.getEtat());
            ste.setInt(5, o.getOwner().getId());
            ste.execute();
            System.out.println("offre ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
            
    }

    @Override
    public List<Offre> getAll() {
         List<Offre> offres = new ArrayList<>();
        try {
            String sql = "select * from offre ";
            Statement ste = cnx.createStatement();
            ResultSet s = ste.executeQuery(sql);
            while (s.next()) {

                Offre o = new Offre(s.getInt("id"),s.getInt("etat"),s.getString("titre"), s.getString("description"), s.getDate("dateCreation").toLocalDate(),new Utilisateur(s.getInt("owner")));
                offres.add(o); 

              
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return offres;
    }

    
    

  
  public void update(Offre o) {
    String sql = "update offre set etat=? , titre = ? , description = ? where id = ?";
        try {
           PreparedStatement ste = cnx.prepareStatement(sql);
           ste.setString(2, o.getTitre());
           ste.setString(3, o.getDescription());
           ste.setInt(4,o.getId());
           ste.setInt(1,o.getEtat());
            ste.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    


    public void delete(Offre o) {
         String sql = "delete from offre where id=?";
       try {
         PreparedStatement ste = cnx.prepareStatement(sql);
           ste.setInt(1, o.getId());
           ste.executeUpdate();
      } catch (SQLException ex) {
            System.out.println(ex.getMessage());
       }
  }
          
   /* public void modifierOffre( Offre o) {
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
  }*/
    public void supprimerOffre(Offre o) {
        String sql = "delete from offre where id=?";
        try {
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setInt(1,o.getId());
            ste.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
  

    @Override
    public Offre findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


  
}