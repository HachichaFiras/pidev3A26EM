/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author ASUS
 */
public class User {
    private int id;
    private String email,name,last_name,phone,password,adress;

    public User() {
    }
    
    public User(int id, String email, String name, String last_name, String phone, String password, String adress) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.last_name = last_name;
        this.phone = phone;
        this.password = password;
        this.adress = adress;
    }

    public User(int id,String email, String name, String last_name, String password) {
        this.id=id;
        this.email = email;
        this.name = name;
        this.last_name = last_name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", email=" + email + ", name=" + name + ", last_name=" + last_name + ", password=" + password + '}';
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public String getAdress() {
        return adress;
    }
    
    
    
}
