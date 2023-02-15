/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Config.Connexionbd;
import Entity.BusinessOwner;
import interfaces.CrudInterface;
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
public class BusinessOwnerServices implements CrudInterface<BusinessOwner>{
    Connection cnx;
    
    public BusinessOwnerServices() {
        
            cnx = Connexionbd.getInstance().getCnx();

    }
    
    
    @Override
    public void ajouter(BusinessOwner t) {
        try{
            String sql = "insert into businessOwners(email,password,name,last_name) values(?,?,?,?)";
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setString(1,t.getEmail());
            ste.setString(2, t.getPassword());
            ste.setString(3,t.getName());
            ste.setString(4,t.getLast_name());
            ste.executeUpdate();
            System.out.println("BusinessOwner added succesfully ");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<BusinessOwner> getAll() {
        List<BusinessOwner> businessOwners = new ArrayList<>();
        try {
            String sql = "select * from businessOwners";
            Statement ste = cnx.createStatement();
            ResultSet s = ste.executeQuery(sql);
            while (s.next()) {

                BusinessOwner f = new BusinessOwner(s.getInt("id"),s.getString("email"), s.getString("name"),
                        s.getString("last_name"), s.getString("password"));
                businessOwners.add(f);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return businessOwners;
    }

    @Override
    public BusinessOwner findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(BusinessOwner t) {
        String sql = "update businessOwners set name=?,last_name=? where id=?";
        try {
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setString(1, t.getName());
            ste.setString(2, t.getLast_name());
            ste.setInt(3,t.getId());
            ste.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void delete(BusinessOwner t) {
        String sql = "delete from businessOwners where id=?";
        try {
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setInt(1, t.getId());
            ste.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
