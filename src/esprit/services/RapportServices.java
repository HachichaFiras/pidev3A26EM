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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author medaz
 */
public class RapportServices implements InterfaceService<Rapport> {
    
    Connection cnx;

    public RapportServices() {
        cnx = MaConnection.getInstance().getCnx();
    }
    
    @Override
    public void ajouter(Rapport r) {
        try {
            String sql = "insert into rapport(dateCreation,titre,description,user,etat  )"
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
    public List<Rapport> getAll() {
        List<Rapport> rap = new ArrayList<>();
        try {
            String sql = "select * from rapport";
            Statement ste = cnx.createStatement();
            ResultSet s = ste.executeQuery(sql);
            while (s.next()) {
            

                Rapport r1 = new Rapport(s.getInt("id"),s.getTimestamp("date").toLocalDateTime(),s.getString("titre"), s.getString("description") , new Utilisateur(s.getInt("user")),s.getInt("etat")  );
                         
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
         List<Rapport> rap = new ArrayList<>();
          try {
            String sql = "select * from rapport where id = " +id;
            Statement ste = cnx.createStatement();
            ResultSet s = ste.executeQuery(sql);
            if (s.next()) {
                isFound = true;
                Rapport r1 = new Rapport(s.getTimestamp("date").toLocalDateTime(),s.getString("titre"), s.getString("description")  , new Utilisateur(s.getInt(1)),s.getInt("etat")  );
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
    
   
}
