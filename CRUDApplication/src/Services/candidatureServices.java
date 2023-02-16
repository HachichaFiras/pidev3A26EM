/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Config.Connexionbd;
import Entity.Freelancer;
import Entity.candidature;
import interfaces.CrudInterfaceOffre;
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
public class candidatureServices implements CrudInterfaceOffre <candidature> {
 Connection cnx;
    public candidatureServices() {
        
            cnx = Connexionbd.getInstance().getCnx();
    }
       public void ajouter(candidature c) {
        try {
            String sql = "insert into candidature(etat,offre,freelancer,date_creation)"
                    + "values (?,?,?,?)";
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setInt(1, c.getEtat());
            ste.setInt(2, c.getOffre());
            ste.setInt(3, c.getF().getId());
            ste.setDate(4,Date.valueOf(c.getDate_creation()) );
            ste.execute();
            
            System.out.println("candidature ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
       

      @Override
    public List<candidature> getAll() {
         List<candidature> candidatures = new ArrayList<>();
        try {
            String sql = "select * from candidature";
            Statement ste = cnx.createStatement();
            ResultSet s = ste.executeQuery(sql);
            while (s.next()) {

                candidature c = new candidature(s.getInt(1), s.getInt(10),new Freelancer(s.getInt("freelancer"), null),s.getDate("date").toLocalDate());
                candidatures.add(c);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return candidatures;
    }

    @Override
    public candidature findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void modifierCandidature(String string, candidature c) {
       String sql = "update offre set etat=? set offre=? where id=?";
        try {
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setInt(1, c.getEtat());
            ste.setInt(2, c.getOffre());
            ste.setInt(3,c.getId_c());
        
            ste.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
  
    }
  

    
}
