/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.entity;

import java.time.LocalDate;

/**
 *
 * @author FARAH
 */
public class Offre {
    private int id, etat ;
    private String titre, description; 
    private LocalDate date_creation;
    private Utilisateur owner;
   
   public Offre () {
       
   }

    public Offre(int id, int etat, String titre, String description, LocalDate date_creation, Utilisateur owner) {
        this.id = id;
        this.etat = etat;
        this.titre = titre;
        this.description = description;
        this.date_creation = date_creation;
        this.owner = owner;
    }
  public Offre( int etat, String titre, String description, LocalDate date_creation, Utilisateur owner) {
        this.id = id;
        this.etat = etat;
        this.titre = titre;
        this.description = description;
        this.date_creation = date_creation;
        this.owner = owner;
    }


    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate_creation() {
        return date_creation;
    }

    public int getEtat() {
        return etat;
    }

    public Utilisateur getOwner() {
        return owner;
    }

   

    public void setId(int id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate_creation(LocalDate date_creation) {
        this.date_creation = date_creation;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public void setOwner(Utilisateur owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "offre{" + "id=" + id + ", titre=" + titre + ", description=" + description + ", date_creation=" + date_creation + ", etat=" + etat + ", owner=" + owner + '}';
    }

   
   
} 