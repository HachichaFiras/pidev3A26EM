/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.time.*;

/**
 *
 * @author Asus
 */
public class Comments {
    private int id;
    private Freelancer freelancer;
    private String contenu;
    private LocalDateTime dateCreation;

    public Comments(int id, Freelancer freelancer, String contenu, LocalDateTime dateCreation) {
        this.id = id;
        this.freelancer = freelancer;
        this.contenu = contenu;
        this.dateCreation = dateCreation;
    }
    
    
    
    public Comments(Freelancer freelancer, String contenu, LocalDateTime dateCreation) {
    
        this.freelancer = freelancer;
        this.contenu = contenu;
        this.dateCreation = dateCreation;
    }
    
    
}
