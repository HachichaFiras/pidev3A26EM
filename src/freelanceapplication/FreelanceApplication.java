/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freelanceapplication;

import esprit.entity.Formation;
import esprit.entity.Participation;
import esprit.entity.Utilisateur;
import esprit.services.FormationService;
import esprit.services.ParticipationService;
import java.time.LocalDateTime;

/**
 *
 * @author Asus
 */
public class FreelanceApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Utilisateur u = new Utilisateur(6, "Firas");
        
        FormationService serv = new FormationService();
        Formation t = new Formation("decription", 15, 1, "JAVA","facebk.com", LocalDateTime.now(), u);
        t.setId(3);
       // serv.ajouter(t);
     //  serv.updateFormation(t);
ParticipationService sc = new ParticipationService();
        System.out.println(sc.getAllbyUser(u));
     
        
        
    }
    
}
