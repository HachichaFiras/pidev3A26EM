/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
/**
 *
 * @author medaz
 */
public interface CrudInterfaceRap<R>{
    
    public void ajouter(R r);
   
    public List<R> getAll();
   
    public  R findById(int id);
    
    public void update(R r);
        
    public void delete(R r);

    
}
