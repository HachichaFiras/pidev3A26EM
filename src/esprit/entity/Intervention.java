/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.entity;

import java.time.LocalDateTime;
import java.util.Date;


public class Intervention {
  
    private int id ;
    private LocalDateTime dateCreation ;
    private String titre ;
    private String descision ;
    private Rapport rap ;

    public Intervention(int id, LocalDateTime dateCreation, String titre, String descision, Rapport rap) {
        this.id = id;
        this.dateCreation = dateCreation;
        this.titre = titre;
        this.descision = descision;
        this.rap = rap;
    }
 public Intervention( LocalDateTime dateCreation, String titre, String descision, Rapport rap) {
        this.id = id;
        this.dateCreation = dateCreation;
        this.titre = titre;
        this.descision = descision;
        this.rap = rap;
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

    public String getDescision() {
        return descision;
    }

    public void setDescision(String descision) {
        this.descision = descision;
    }

    public Rapport getRap() {
        return rap;
    }

    public void setRap(Rapport rap) {
        this.rap = rap;
    }

    @Override
    public String toString() {
        return "intervention{" + "id=" + id + ", dateCreation=" + dateCreation + ", titre=" + titre + ", descision=" + descision + ", rap=" + rap + '}';
    }
    
    
    
}
