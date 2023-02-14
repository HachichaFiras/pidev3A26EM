/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.pidev.entity;

import java.time.LocalDateTime;


/**
 *
 * @author 21624
 */
public class Formation {
    private int id ;
    private String description;
    private int nbre_max;
    private String tittre;
    private String lien_Meet;
    private LocalDateTime date;

    public Formation(int id, String description, int nbre_max, String tittre, String lien_Meet, LocalDateTime date) {
        this.id = id;
        this.description = description;
        this.nbre_max = nbre_max;
        this.tittre = tittre;
        this.lien_Meet = lien_Meet;
        this.date = date;
    }

   
    public Formation( String description, int nbre_max, String tittre, String lien_Meet, LocalDateTime date) {
        this.id = id;
        this.description = description;
        this.nbre_max = nbre_max;
        this.tittre = tittre;
        this.lien_Meet = lien_Meet;
        this.date = date;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNbre_max() {
        return nbre_max;
    }

    public void setNbre_max(int nbre_max) {
        this.nbre_max = nbre_max;
    }

    public String getTittre() {
        return tittre;
    }

    public void setTittre(String tittre) {
        this.tittre = tittre;
    }

    public String getLien_Meet() {
        return lien_Meet;
    }

    public void setLien_Meet(String lien_Meet) {
        this.lien_Meet = lien_Meet;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Formation{" + "id=" + id + ", description=" + description + ", nbre_max=" + nbre_max + ", titre=" + tittre + ", lien_Meet=" + lien_Meet + '}'+"Date:"+this.date;
    }
    
    
}
