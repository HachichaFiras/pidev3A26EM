/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.pidev.entity;

/**
 *
 * @author 21624
 */
public class user {
    private int id ;
    private String nom;

    public user(int id) {
        this.id = id;
    }

    public user(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public user(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "user{" + "id=" + id + ", nom=" + nom + '}';
    }

  
    
}
