/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.pidev.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import tn.pidev.entity.Formation;
import tn.pidev.tools.MaConnection;

/**
 *
 * @author 21624
 */
public class FormationService implements InterfaceService <Formation>{
     Connection cnx;

    public FormationService() {
        cnx = MaConnection.getInstance().getCnx();
    }
     
    @Override
    public void ajouter(Formation t) {
       try {
            String sql = "insert into formation(tittre,description,nombreMax,lienMeet,date)"
                    + "values (?,?,?,?,?)";
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setString(1, t.getTittre());
            ste.setString(2, t.getDescription());
             ste.setInt(3, t.getNbre_max());
            ste.setString(4,t.getLien_Meet());
            ste.setTimestamp(5, Timestamp.valueOf(t.getDate()));
            ste.executeUpdate();
            System.out.println("Formation ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Formation> getAll() {
        List<Formation> formations = new ArrayList<>();
        try {
            String sql = "select * from formation";
            Statement ste = cnx.createStatement();
            ResultSet s = ste.executeQuery(sql);
            while (s.next()) {

             
                Formation f1 = new Formation(s.getInt(1), s.getString("lienMeet"),   s.getInt("nombreMax"),  s.getString("tittre"), s.getString("lienMeet"),s.getTimestamp("date").toLocalDateTime());
                
              
                formations.add(f1);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return formations;
    }

    @Override
    public boolean findById(int id) {
        boolean isFound = false;
         List<Formation> formations = new ArrayList<>();
          try {
            String sql = "select * from formation where id = " +id;
            Statement ste = cnx.createStatement();
            ResultSet s = ste.executeQuery(sql);
            if (s.next()) {
                
                isFound = true;
                            Formation f1 = new Formation(s.getInt(1), s.getString("lienMeet"),   s.getInt("nombreMax"),  s.getString("tittre"), s.getString("lienMeet"),s.getTimestamp("date").toLocalDateTime());

                formations.add(f1); 

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         return isFound; 
      
    }
     public void supprimerFormation(int id) {
        String sql = "delete from formation where id = " +id;
        try {
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
}
     public void modifierFormation(Formation f) {
       // String sql = "update formation set tittre = ? where id = ?";
        try(PreparedStatement ste = cnx.prepareStatement(QueryUtil.updateFormation(f.getId()));) {
            
            ste.setString(1, f.getTittre());
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