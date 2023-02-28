/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
/**
 *
 * @author Asus
 */
public class Blog {
    private int id;
    private String title;
    private String contenu;
    private LocalDateTime dateCreation;

    private  Utilisateur actor;
    
    private List<Comments> commentaires;
    private List<KeyWords> keywords;

    public Blog(int id, String title, String contenu, LocalDateTime dateCreation, Utilisateur actor, List<Comments> commentaires, List<KeyWords> keywords) {
        this.id = id;
        this.title = title;
        this.contenu = contenu;
        this.dateCreation = dateCreation;
        this.actor = actor;
        this.commentaires = commentaires;
        this.keywords = keywords;
    }

   public Blog(int id, String title, String contenu, LocalDateTime dateCreation, Utilisateur actor) {
        this.id = id;
        this.title = title;
        this.contenu = contenu;
        this.dateCreation = dateCreation;
        this.actor = actor;
     
    }

    public Utilisateur getActor() {
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

    public void setActor(Utilisateur actor) {
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
    

    @Override
    public String toString() {
        //DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
//ring strDate = dateFormat.format(this.dateCreation);  
        return "\nid = "+this.id +"\n - "+this.getContenu()+"\nDate Creation : "+(this.dateCreation) + "\n commentaire : "+this.commentaires+"\n";
    
    }

    
    
    
    
    
   
    
    
}
