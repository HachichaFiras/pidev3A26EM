/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudapplication;

import Entity.Blog;
import Entity.Freelancer;
import Entity.KeyWords;
import Services.BlogServices;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class CRUDApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        List<KeyWords> allkeys = new ArrayList<>();
        Freelancer f1 = new Freelancer(1, "Firas");
        KeyWords k1 = new KeyWords("Java");
        KeyWords k2 = new KeyWords("C");
        allkeys.add(k2);
        allkeys.add(k1);

        Blog b1 = new Blog( 1,"blog2", "contenue du blog", LocalDateTime.now(), f1, null, allkeys);
        
        BlogServices serv = new BlogServices();
        //serv.ajouter(b1);
        
        System.out.println(serv.getAll());
        
    }
    
}
