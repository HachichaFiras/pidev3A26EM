/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudapplication;

import Entity.rapport;
import Entity.user;
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
     
     // rapport r1 = new Formation("Python",30," java pour débutants","blabla",LocalDateTime.of(LocalDate.of(2023,03,12), LocalTime.of(20, 0)));
     rapport f1 = new rapport(LocalDateTime.of(LocalDate.of(2023,03,12),"titre1",  " description1", new user (1));
     fs.ajouter(f1);
     
    //System.out.println(fs.getAll());
     //fs.supprimerFormation(5);
    //fs.modifierFormation(f1, "angular" );
       // System.out.println(fs.findById(8));
    
   ParticipationService ps = new ParticipationService ();
   // Participation p = new Participation ("02/13/2023");
    // ps.ajouter(p);
    //System.out.println(ps.getAll());
    //ps.supprimerParticipation(1);
        //System.err.println(ps.findById(2));
       //System.out.println("Enter id of an formation");
        //int updateId = Integer.parseInt(scanner.nextLine());
         //boolean isFound = fs.findById(updateId);
        //if (isFound  ){ 
          //  System.out.println("enter titre");
            //Formation f2 = new Formation(updateId, scanner.nextLine());
           //fs.modifierFormation(f2);
           //}
           
           
           System.out.println("Enter id of an participation");
           int updateId = Integer.parseInt(scanner.nextLine());
           boolean isFound = ps.findById(updateId);
           if (isFound  ){ 
           System.out.println("enter date");
           // Participation p2 = new Participation(scanner.nextLine(),updateId);
          // ps.modifierParticipation(p2);
           }
               }
    
}
