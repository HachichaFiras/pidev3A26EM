/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.entity;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Asus
 */
public class Comments {
    private int id;
    private Utilisateur freelancer;
    private String contenu;
    private LocalDateTime dateCreation;
   private Blog blog;

    public Comments( Utilisateur freelancer, String contenu, LocalDateTime dateCreation, Blog blog) {
      
        this.freelancer = freelancer;
        this.contenu = contenu;
        this.dateCreation = dateCreation;
        this.blog = blog;
    }

    public Blog getBlog() {
        return blog;
    }

    public String getContenu() {
        return contenu;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public Utilisateur getFreelancer() {
        return freelancer;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Commentaire ["+ this.getFreelancer().getId()+ " : "+ this.getContenu()+" - " + this.dateCreation.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)+"] ";
    }



    
    
    
    
}
