/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freelanceapplication;

import esprit.entity.Candidature;
import esprit.entity.Formation;
import esprit.entity.Offre;
import esprit.entity.Participation;
import esprit.entity.Utilisateur;
import esprit.services.FormationService;
import esprit.services.OffreServices;
import esprit.services.ParticipationService;
import esprit.services.candidatureServices;
import java.time.LocalDate;
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
        OffreServices so = new OffreServices();
       Offre o = new Offre(2, 1, "titre", "description", LocalDate.now(), u);
     //   so.ajouter(o);
//      so.update(o);
//      so.supprimerOffre(o);
Candidature c = new Candidature(0, 1, u, LocalDate.now(), o);
        candidatureServices cs = new candidatureServices();
        cs.ajouter(c);
// serv.ajouter(t);
     //  serv.updateFormation(t);
ParticipationService sc = new ParticipationService();
      //  System.out.println(sc.getAllbyUser(u));
     
        
        
    }
    
}
