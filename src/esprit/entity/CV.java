/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.entity;

/**
 *
 * @author ASUS
 */
public class CV {
    private int id;
    private String git,linkedin,img,bio,cv;
    private Utilisateur user;

    public CV(Utilisateur id_user, String git, String linkedin, String img, String bio, String cv) {
        this.user = id_user;
        this.git = git;
        this.linkedin = linkedin;
        this.img = img;
        this.bio = bio;
        this.cv = cv;
    }

    public CV(int id, Utilisateur id_user, String git, String linkedin, String img, String bio, String cv) {
        this.id = id;
        this.user = id_user;
        this.git = git;
        this.linkedin = linkedin;
        this.img = img;
        this.bio = bio;
        this.cv = cv;
    }

    public CV() {
    }

    @Override
    public String toString() {
        return "CV{" + "id=" + id + ", id_user=" + user + ", git=" + git + ", linkedin=" + linkedin + ", img=" + img + ", bio=" + bio + ", cv=" + cv + '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_user(Utilisateur id_user) {
        this.user = id_user;
    }

    public void setGit(String git) {
        this.git = git;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public int getId() {
        return id;
    }

    public Utilisateur getId_user() {
        return user;
    }

    public String getGit() {
        return git;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public String getImg() {
        return img;
    }

    public String getBio() {
        return bio;
    }

    public String getCv() {
        return cv;
    }
    
    
    
}
