/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudapplication;

import Entity.BusinessOwner;
import Entity.Freelancer;
import Services.BusinessOwnerServices;
import Services.FreelanceServices;
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
        ///                                 *** CRUD FREELANCER *** 
        /*FreelanceServices fs = new FreelanceServices();
        Freelancer f1 = new Freelancer(2,"nour.benAissa@gmail.com","Nouru","benAissa","password123");
        //fs.ajouter(f1);
    //Freelancer f1 = new Freelancer(1,"semer.belghoth@gmail.com","semer","belghith","password123");
    List<Freelancer> list = new ArrayList<Freelancer>();
    list = fs.getAll();
    //fs.update(f1);
    //fs.delete(f1);
    list.forEach((e) -> System.out.println(e.toString())); 
        */
    
    ///                                   *** CRUD BUSINESSOWNER *** 
    BusinessOwnerServices bs = new BusinessOwnerServices();
    //BusinessOwner b1 = new BusinessOwner(1,"semer.belghoth@gmail.com","semer","belghith","password123");
    BusinessOwner b1 = new BusinessOwner(2,"nour.benAissa@gmail.com","Nour","Ben Aissa","password123");
    //bs.ajouter(b1);
    List<BusinessOwner> listb = new ArrayList<BusinessOwner>();
    listb = bs.getAll();
    listb.forEach((e) -> System.out.println(e.toString())); 
    //bs.update(b1);
    bs.delete(b1);
    
    }
    
}
