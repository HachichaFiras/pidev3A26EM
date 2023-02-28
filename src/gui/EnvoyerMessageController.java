/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import esprit.entity.KeyWords;
import esprit.entity.Utilisateur;
import esprit.services.BlogServices;
import esprit.services.UserService;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class EnvoyerMessageController implements Initializable {

    @FXML
    private MenuButton menu_user;
    @FXML
    private TextField txt_message;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
                   Collection<javafx.scene.control.MenuItem> menu = new ArrayList<javafx.scene.control.MenuItem>();

                   
                   UserService serv = new UserService();
                   ArrayList<Utilisateur> users = new ArrayList<>(serv.getAll());
                   
                        javafx.scene.control.MenuItem mm ;



      // To Creating a Observable List

for(Utilisateur u : users) {
    mm = new javafx.scene.control.MenuItem(u.getNom() + " " + u.getPrenom());
           String s = String.valueOf(u.getId());
            mm.setId(s);
            menu.add(mm);  
}

    menu_user.getItems().addAll(menu);
            
             menu.forEach((t) -> {

                 t.setOnAction((event) -> {
                     
                     handler(event);
                 });
             });
      
        
                   
                   
        // TODO
    }    

    @FXML
    private void btn_envoyer(ActionEvent event) {
        
        

        
        
        
    }

    @FXML
    private void handler(ActionEvent event) {
        
          javafx.scene.control.MenuItem item = (javafx.scene.control.MenuItem) event.getSource();

menu_user.getItems().clear();
BlogServices bs = new BlogServices();

        menu_user.setText(item.getText());
    }
    
}
