/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


/**
 *
 * @author medaz
 */
public class rapport {
    private int id ;
    private LocalDateTime dateCreation ;
    private String titre ;
    private String description ;
    private user user ;
    private int etat ;

    public rapport(int id, LocalDateTime dateCreation, String titre, String description, user user, int etat) {
        this.id = id;
        this.dateCreation = dateCreation;
        this.titre = titre;
        this.description = description;
        this.user = user;
        this.etat = etat;
    }

    public rapport() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public rapport(LocalDateTime toLocalDateTime, String string, String string0, user user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public rapport(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public user getUser() {
        return user;
    }

    public void setUser(user user) {
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
