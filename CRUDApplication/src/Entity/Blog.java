/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Asus
 */
public class Blog {
    private int id;
    private String title;
    private String contenu;
    private LocalDateTime dateCreation;

    private Freelancer actor;
    
    private List<Comments> commentaires;
    private List<KeyWords> keywords;

    public Blog(int id, String title, String contenu, LocalDateTime dateCreation, Freelancer actor, List<Comments> commentaires, List<KeyWords> keywords) {
        this.id = id;
        this.title = title;
        this.contenu = contenu;
        this.dateCreation = dateCreation;
        this.actor = actor;
        this.commentaires = commentaires;
        this.keywords = keywords;
    }

    public Freelancer getActor() {
        return actor;
    }

    public List<Comments> getCommentaires() {
        return commentaires;
    }

    public String getContenu() {
        return contenu;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public int getId() {
        return id;
    }

    public List<KeyWords> getKeywords() {
        return keywords;
    }

    public String getTitle() {
        return title;
    }

    public void setActor(Freelancer actor) {
        this.actor = actor;
    }

    public void setCommentaires(List<Comments> commentaires) {
        this.commentaires = commentaires;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setKeywords(List<KeyWords> keywords) {
        this.keywords = keywords;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    
    
    
    
   
    
    
}
