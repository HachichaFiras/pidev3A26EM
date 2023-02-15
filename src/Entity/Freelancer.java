/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Asus
 */
public class Freelancer extends User{
    
    private String bio,git,img_src,linkedin;

    public Freelancer() {
    }
    

    public Freelancer(int id, String email, String name, String last_name, String phone, String password, String adress) {
        super(id, email, name, last_name, phone, password, adress);
    }
    public Freelancer(int id,String email, String name, String last_name, String password) {
        super(id,email, name, last_name,password);
    }

    
    

    public Freelancer(String bio, String git, String img_src, String linkedin, int id, String email, String name, String last_name, String phone, String password, String adress) {
        super(id, email, name, last_name, phone, password, adress);
        this.bio = bio;
        this.git = git;
        this.img_src = img_src;
        this.linkedin = linkedin;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setGit(String git) {
        this.git = git;
    }

    public void setImg_src(String img_src) {
        this.img_src = img_src;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getBio() {
        return bio;
    }

    public String getGit() {
        return git;
    }

    public String getImg_src() {
        return img_src;
    }

    public String getLinkedin() {
        return linkedin;
    }

 
    

    
}
