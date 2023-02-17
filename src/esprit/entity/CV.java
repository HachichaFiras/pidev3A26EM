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
    private int id,id_user;
    private String git,linkedin,img,bio,cv;

    public CV(int id_user, String git, String linkedin, String img, String bio, String cv) {
        this.id_user = id_user;
        this.git = git;
        this.linkedin = linkedin;
        this.img = img;
        this.bio = bio;
        this.cv = cv;
    }

    public CV(int id, int id_user, String git, String linkedin, String img, String bio, String cv) {
        this.id = id;
        this.id_user = id_user;
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
        return "CV{" + "id=" + id + ", id_user=" + id_user + ", git=" + git + ", linkedin=" + linkedin + ", img=" + img + ", bio=" + bio + ", cv=" + cv + '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
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

    public int getId_user() {
        return id_user;
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
