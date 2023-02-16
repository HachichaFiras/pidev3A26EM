/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Config.Connexionbd;
import Entity.*;
import interfaces.CrudInterfaceRap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author medaz
 */
public class RapportServices implements InterfaceService<rapport> {
    
    Connection cnx;

    public RapportServices() {
        cnx = Connexionbd.getInstance().getCnx();
    }
    
    @Override
    public void ajouter(rapport r) {
        try {
            String sql = "insert into rapport(dateCreation,titre,description,user,etats)"
                    + "values (?,?,?,?,?)";
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setTimestamp(1, Timestamp.valueOf(r.getDateCreation()));
            ste.setString(2, r.getTitre());
            ste.setString(3,r.getDescription());
            ste.setInt(4, r.getUser().getId());
            ste.setInt(5, r.getEtat());


            ste.executeUpdate();
            System.out.println("Formation ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    }

    
    @Override
    public List<rapport> getAll() {
        List<rapport> rap = new ArrayList<>();
        try {
            String sql = "select * from formation";
            Statement ste = cnx.createStatement();
            ResultSet s = ste.executeQuery(sql);
            while (s.next()) {
                rapport r1 = new rapport(s.getTimestamp("date").toLocalDateTime(),s.getString("titre"), s.getString("description")  , new user(s.getInt(1))  );
                         
                rap.add(r1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rap;    
    }

    
    
    @Override
    public boolean findById(int id) {
     boolean isFound = false;
         List<rapport> rap = new ArrayList<>();
          try {
            String sql = "select * from rapport where id = " +id;
            Statement ste = cnx.createStatement();
            ResultSet s = ste.executeQuery(sql);
            if (s.next()) {
                isFound = true;
                rapport r1 = new rapport(s.getTimestamp("date").toLocalDateTime(),s.getString("titre"), s.getString("description")  , new user(s.getInt(1))  );
                rap.add(r1); 
               
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         return isFound;     }
     
    
    public void supprimerRapport(int id) {
        String sql = "delete from rapport where id = " +id;
        try {
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
}
    
    public void modifierRapport(rapport r) {
       // String sql = "update formation set tittre = ? where id = ?";
        try(PreparedStatement ste = cnx.prepareStatement(QueryUtil.updateRapport(r.getId()));) {
            
            ste.setString(1, r.getTitre());
            //ste.setInt(1, f.getId());
            int rows = ste.executeUpdate();
            if (rows > 0){
                System.err.println("Succes");
            }
       } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
