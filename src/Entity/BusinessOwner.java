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
public class BusinessOwner extends User{

    public BusinessOwner() {
    }
    
    public BusinessOwner(int id, String email, String name, String last_name, String phone, String password, String adress) {
        super(id, email, name, last_name, phone, password, adress);
    }
    public BusinessOwner(int id, String email, String name, String last_name, String password) {
        super(id, email, name, last_name, password);
    }
    
    
 
    
    
}
