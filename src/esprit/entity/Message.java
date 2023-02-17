/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.entity;

import java.time.LocalDateTime;

/**
 *
 * @author Asus
 */
public class Message {
    private int id;
    private Utilisateur source;
    private Utilisateur destinataire;
    private LocalDateTime date;
    private String contenu;
    

    public Message(Utilisateur source, Utilisateur destinataire, LocalDateTime date, String contenu) {
        this.source = source;
        this.destinataire = destinataire;
        this.date = date;
        this.contenu = contenu;
    }

    public Message(int id, Utilisateur source, Utilisateur destinataire, LocalDateTime date, String contenu) {
        this.id = id;
        this.source = source;
        this.destinataire = destinataire;
        this.date = date;
        this.contenu = contenu;
    }

    public String getContenu() {
        return contenu;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Utilisateur getDestinataire() {
        return destinataire;
    }

    public int getId() {
        return id;
    }

    public Utilisateur getSource() {
        return source;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setDestinataire(Utilisateur destinataire) {
        this.destinataire = destinataire;
    }

    public void setSource(Utilisateur source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "id = "+this.getId()+"\n source" + this.getSource()+ "\n destinataire"  + this.getDestinataire() + "\n date" +this.getDate();
    }
    
    
    
    
    
    
    
    
}
