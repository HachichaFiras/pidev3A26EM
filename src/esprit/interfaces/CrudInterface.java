/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.interfaces;

import java.util.List;

/**
 *
 * @author Asus
 */
public interface CrudInterface<T> {
    
    public void ajouter(T t);
   
    public List<T> getAll();
   
    public  T findById(int id);
    
    public void update(T t);
        
    public void delete(T t);
    


    
    
    
}