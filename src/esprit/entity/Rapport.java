/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.entity;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


/**
 *
 * @author medaz
 */
public class Rapport {
    private int id ;
    private LocalDateTime dateCreation ;
    private String titre ;
    private String description ;
    private Utilisateur user ;
    private int etat ;

    public Rapport(int id, LocalDateTime dateCreation, String titre, String description, Utilisateur user, int etat) {
        this.id = id;
        this.dateCreation = dateCreation;
        this.titre = titre;
        this.description = description;
        this.user = user;
        this.etat = etat;
    }
 public Rapport( LocalDateTime dateCreation, String titre, String description, Utilisateur user, int etat) {
        this.id = id;
        this.dateCreation = dateCreation;
        this.titre = titre;
        this.description = description;
        this.user = user;
        this.etat = etat;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

  
   

    @Override
    public String toString() {
        return "rapport{" + "id=" + id + ", dateCreation=" + dateCreation + ", titre=" + titre + ", description=" + description + ", user=" + user + ", etat=" + etat + '}';
    }
    
    
    
}
