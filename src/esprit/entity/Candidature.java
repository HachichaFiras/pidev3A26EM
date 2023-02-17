/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.entity;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author FARAH
 */
public class Candidature {
    private int id_c, etat;
    private Utilisateur f; 
    private LocalDate date_creation; 
    private Offre offre;
    

  public Candidature (){

}

    public Candidature(int id_c, int etat, Utilisateur f, LocalDate date_creation, Offre offre) {
        this.id_c = id_c;
        this.etat = etat;
        this.f = f;
        this.date_creation = date_creation;
        this.offre = offre;
    }
  
   public Candidature(int etat, Utilisateur f, LocalDate date_creation, Offre offre) {
        this.id_c = id_c;
        this.etat = etat;
        this.f = f;
        this.date_creation = date_creation;
        this.offre = offre;
    }
  


    public int getId_c() {
        return id_c;
    }

    public int getEtat() {
        return etat;
    }

    public Offre getOffre() {
        return offre;
    }



    public Utilisateur getF() {
        return f;
    }

   

    public LocalDate getDate_creation() {
        return date_creation;
    }

    public void setId_c(int id_c) {
        this.id_c = id_c;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }



    public void setDate_creation(LocalDate date_creation) {
        this.date_creation = date_creation;
    }

    public void setF(Utilisateur f) {
        this.f = f;
    }

    public void setOffre(Offre offre) {
        this.offre = offre;
    }


    



    @Override
    public String toString() {
        return "candidature{" + "id_c=" + id_c + ", etat=" + etat + ", offre=" + offre + ", f=" + f + ", date_creation=" + date_creation + '}';
    }
  
  }


