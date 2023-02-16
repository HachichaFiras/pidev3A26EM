/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author medaz
 */
public class intervention {
    /*`id` int(11) NOT NULL,
  `dateCreation` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `titre` varchar(100) NOT NULL,
  `decision` varchar(300) NOT NULL,
  `rapport` int(11) NOT NULL*/
    private int id ;
    private LocalDateTime dateCreation ;
    private String titre ;
    private String descision ;
    private rapport rap ;

    public intervention(int id, LocalDateTime dateCreation, String titre, String descision, rapport rap) {
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

    public rapport getRap() {
        return rap;
    }

    public void setRap(rapport rap) {
        this.rap = rap;
    }

    @Override
    public String toString() {
        return "intervention{" + "id=" + id + ", dateCreation=" + dateCreation + ", titre=" + titre + ", descision=" + descision + ", rap=" + rap + '}';
    }
    
    
    
}
