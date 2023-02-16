/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudapplication;

import Entity.Freelancer;
import Entity.candidature;
import Entity.offre;
import Services.candidatureServices;
import Services.offreServices;
import java.time.LocalDate;

/**
 *
 * @author Asus
 */
public class CRUDApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
      
        candidatureServices serv = new candidatureServices();
        candidature c = new candidature(1,2,new Freelancer(2, "farah"), LocalDate.now());
        serv.ajouter(c);
        c.setId_c(1);
      
       //System.out.println(serv.getAll());
       //serv.modifierCandidature("", c);
        
        
      //offreServices off = new offreServices();
     // offre o1 = new offre ("offre2", "Desktop java", LocalDate.now(),0, 1);
      //off.ajouter(o1);
     // o1.setId(3);
      // off.modifierOffre("",o1);
      //offre o1= offreServices.select(10);
      //off.setTitre(String titre);
      //off.supprimerOffre(o1);
      //System.out.println(off.getAll()); 
     
      //off.modifierOffre(o1);
      //System.out.println(off.getAll());
     }
   }
    

