/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author FARAH
 */
public class candidature {
    private int id_c, etat, offre;
    private Freelancer f; 
    private LocalDate date_creation; 
    

  public candidature (){

}
    public candidature(int id_c, int etat, int offre, Freelancer f, LocalDate date_creation) {
        this.id_c = id_c;
        this.etat = etat;
        this.offre = offre;
        this.f = f;
        this.date_creation = date_creation;
    }

    public candidature(int etat, int offre, Freelancer f, LocalDate date_creation) {
        this.etat = etat;
        this.offre = offre;
        this.f = f;
        this.date_creation = date_creation;
    }

    public candidature(Freelancer freelancer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_c() {
        return id_c;
    }

    public int getEtat() {
        return etat;
    }

    public int getOffre() {
        return offre;
    }

    public Freelancer getF() {
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

    public void setOffre(int offre) {
        this.offre = offre;
    }

    public void setF(Freelancer f) {
        this.f = f;
    }

    public void setDate_creation(LocalDate date_creation) {
        this.date_creation = date_creation;
    }

    @Override
    public String toString() {
        return "candidature{" + "id_c=" + id_c + ", etat=" + etat + ", offre=" + offre + ", f=" + f + ", date_creation=" + date_creation + '}';
    }
  
  }


