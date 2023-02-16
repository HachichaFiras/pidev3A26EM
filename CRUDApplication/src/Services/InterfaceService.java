/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.List;

/**
 *
 * @author medaz
 */
public interface InterfaceService<rap>{
     public void ajouter(rap r);
    public List<rap> getAll();
    public boolean findById(int id);
    
}
