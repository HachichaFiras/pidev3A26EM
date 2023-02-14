/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.pidev.service;

import java.util.List;
import tn.pidev.entity.Formation;

/**
 *
 * @author 21624
 */
public interface InterfaceService <p>{
     public void ajouter(p t);
    public List<p> getAll();
    public boolean findById(int id);
}
