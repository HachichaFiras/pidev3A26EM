/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Config.Connexionbd;
import Entity.Blog;
import Entity.Freelancer;
import interfaces.CrudInterface;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Asus
 */
public class FreelancerServices  implements CrudInterface<Freelancer>{
    
    
       Connection cnx;
    public FreelancerServices() {
        
            cnx = Connexionbd.getInstance().getCnx();

    }

    @Override
    public void ajouter(Freelancer t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Freelancer> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Freelancer findById(int id) {
 Freelancer f=null ;
        Statement stmt;
        try {
            String sql = "select * from personne where id = "+id;
            
          stmt = cnx.createStatement();
            
               ResultSet rs =  stmt.executeQuery(sql);
                
                if(rs.next()){
                    f = new Freelancer(rs.getInt(1), rs.getString(2));
                }
                return f;
                    
            
        } catch (SQLException ex) {
               System.out.println(ex.getMessage());
        }
        return f;


    }

    @Override
    public void update(Freelancer t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Freelancer t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}
