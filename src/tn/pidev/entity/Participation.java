/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.pidev.entity;

import java.util.Date;

/**
 *
 * @author 21624
 */
public class Participation {
    private String date;
    private int id;

    public Participation(String date, int id) {
        this.date = date;
        this.id = id;
    }

    public Participation() {
    }

    public Participation(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Participation{" + "date=" + date + ", id=" + id + '}';
    }
    
}
