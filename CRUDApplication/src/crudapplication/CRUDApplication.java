/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudapplication;

import Entity.rapport;
import Entity.user;
import Services.InterventionService;
import Services.RapportServices;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

/**
 *
 * @author Asus
 */
public class CRUDApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     RapportServices rs = new RapportServices ();
     user r1 = new user(1);
     
     //rapport f1 = new rapport(LocalDateTime.of(LocalDate.of(2023,03,12)),"titre1",  " description1", r1);
     rapport f1 = new rapport(LocalDateTime.of(LocalDate.of(2023,03,12)),"titre1",  " description1", r1);
     rs.ajouter(f1);
     
    //System.out.println(rs.getAll());
     //rs.supprimerRapport(5);
    //rs.modifierRapport(r1, "rapport1" );
       // System.out.println(rs.findById(8));
    
   InterventionService inte = new InterventionService ();
   // intervention inte = new intervention ("02/13/2023");
    // inte.ajouter(p);
    //System.out.println(inte.getAll());
    //inte.supprimerIntervention(1);
        //System.err.println(inte.findById(2));
       //System.out.println("Enter id of an intervention");
        //int updateId = Integer.parseInt(scanner.nextLine());
         //boolean isFound = fs.findById(updateId);
        //if (isFound  ){ 
          //  System.out.println("enter titre");
            //rapport 2 = new rapport(updateId, scanner.nextLine());
           //fs.modifierRapport(f2);
           //}
           
           
           System.out.println("Enter id of an intervention");
           int updateId = Integer.parseInt(scanner.nextLine());
           boolean isFound = inte.findById(updateId);
           if (isFound  ){ 
           System.out.println("enter date");
           // intervention int2 = new intervention(scanner.nextLine(),updateId);
          // ps.modifierIntervention(int2);
           }
               }
    
}
