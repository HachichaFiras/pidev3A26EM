/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import interfaces.CrudInterface;
import Entity.*;
import  Config.*;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Asus
 */
public class BlogServices implements CrudInterface<Blog>{
    Connection cnx;
    public BlogServices() {
        
            cnx = Connexionbd.getInstance().getCnx();

    }

    
    
    @Override
    public void ajouter(Blog t) {
        
        
    }

    @Override
    public List<Blog> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Blog findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Blog t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Blog t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
