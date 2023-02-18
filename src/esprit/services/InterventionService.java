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
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author medaz
 */
public class InterventionService implements InterfaceService<Intervention>{
 
    Connection cnx;

    public InterventionService() {
        cnx = MaConnection.getInstance().getCnx();
    }
        @Override
    public void ajouter(Intervention i) {
        try {
            String sql = "insert into intervention (dateCreation,titre,desvision,rap)"
                    + "values (?,?,?,?)";
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setTimestamp(1, Timestamp.valueOf(i.getDateCreation()));
            ste.setString(2, i.getTitre());
            ste.setString(3,i.getDescision());
            ste.setInt(5, i.getRap().getId());


            ste.executeUpdate();
            System.out.println("intervention ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }       }

    @Override
    public List<Intervention> getAll() {
        List<Intervention> it = new ArrayList<>();
        try {
            String sql = "select * from formation";
            Statement ste = cnx.createStatement();
            ResultSet s = ste.executeQuery(sql);
            while (s.next()) {
               
                Intervention it1 = new Intervention(s.getTimestamp("date").toLocalDateTime(),s.getString("titre"), s.getString("descision")  , new Rapport (s.getInt(1))  );
                         
                it.add(it1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return it;      }

    @Override
    public boolean findById(int id) {
         List<Intervention> in = new ArrayList<>();
          try {
            String sql = "select * from intervention where id = " +id;
            Statement ste = cnx.createStatement();
            ResultSet s = ste.executeQuery(sql);
            if (s.next()) {
              return true;
           //     Intervention in1 = new Intervention(s.getTimestamp("date").toLocalDateTime(),s.getString("titre"), s.getString("descision")  , new Rapport (s.getInt(1)) );
            //    in.add(in1); 
               
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         return false;     }
        
        public void supprimerIntervention(int id) {
        String sql = "delete from intervention where id = " +id;
        try {
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
}
        
        public void modifierIntervention(Intervention in) {
       // String sql = "update intervention set tittre = ? where id = ?";
        try(PreparedStatement ste = cnx.prepareStatement(QueryUtil.updateIntervention(in.getId()));) {
            
            ste.setString(1, in.getTitre());
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
