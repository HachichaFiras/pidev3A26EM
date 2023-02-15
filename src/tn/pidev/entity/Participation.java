/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.pidev.entity;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author 21624
 */
public class Participation {
    private int id;
    private LocalDateTime date_creation;
    private user user;
    private Formation formation;

    public Participation(LocalDateTime date_creation, user user, Formation formation) {
        this.date_creation = date_creation;
        this.user = user;
        this.formation = formation;
    }

    public Participation(int id, LocalDateTime date_creation, user user, Formation formation) {
        this.id = id;
        this.date_creation = date_creation;
        this.user = user;
        this.formation = formation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(LocalDateTime date_creation) {
        this.date_creation = date_creation;
    }

    public user getUser() {
        return user;
    }

    public void setUser(user user) {
        this.user = user;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    @Override
    public String toString() {
        return "Participation{" + "id=" + id + ", date_creation=" + date_creation + ", user=" + user + ", formation=" + formation + '}';
    }

   

    
    
}
