/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.util.Date;


/**
 *
 * @author medaz
 */
public class rapport {
    private int id ;
    private Date date ;
    private String titre ;
    private String description ;

    public rapport( Date date, String titre, String description) {
        
        this.date = date;
        this.titre = titre;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    @Override
    public String toString() {
        return "rapport{" + "id=" + id + ", date=" + date + ", titre=" + titre + ", description=" + description + '}';
    }
    
    
    
}
