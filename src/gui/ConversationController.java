/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import esprit.entity.Blog;
import esprit.entity.Message;
import esprit.entity.Utilisateur;
import esprit.services.BlogServices;
import esprit.services.MessageServices;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Asus
 */
public class ConversationController implements Initializable {

    @FXML
    private MenuButton btn_menu;
    @FXML
    private ListView<String> list_message;
    @FXML
    private TextField txt_message;
    @FXML
    private Button btn_envoyer;
    private Utilisateur destinataire = new Utilisateur(-1);

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        MessageServices s = new MessageServices();
             // ObservableList<> books = FXCollections.observableArrayList(s.findByUser(NewFXMain.user));

             ArrayList<Utilisateur> users = new ArrayList<Utilisateur>(s.findByUser(NewFXMain.user));
             
        Collection<javafx.scene.control.MenuItem> menu = new ArrayList<javafx.scene.control.MenuItem>();
                          javafx.scene.control.MenuItem mm ;
                          for(Utilisateur u : users)
                          {
                                  mm = new javafx.scene.control.MenuItem(u.getNom());
                           String str = String.valueOf(u.getId());
            mm.setId(str);
            menu.add(mm);
                          }
                          
                              btn_menu.getItems().addAll(menu);
                              
                              
                                 menu.forEach((t) -> {

                 t.setOnAction((event) -> {
                     
                     handler(event);
                 });
             });
                              
                          
                          
                          
                          


      
    }    

    @FXML
    private void handler(ActionEvent event) {
        
        javafx.scene.control.MenuItem item = (javafx.scene.control.MenuItem) event.getSource();


list_message.getItems().clear();

MessageServices ms = new MessageServices();
        btn_menu.setText(item.getText());

Utilisateur u = NewFXMain.user;
u.setNom("Vous");
  List<Message> messages = new ArrayList<>(ms.getAllByuser(u, new Utilisateur(Integer.parseInt(item.getId()),item.getText())));
        
// add column

        destinataire.setId(Integer.parseInt(item.getId()));
        System.out.println(destinataire.getId());
        for(Message b: messages)
        {
             
                list_message.getItems().add(b.getDate()+"\n- "+b.getSource().getNom()+"  :  "+b.getContenu());

        }
        
    }

    @FXML
    private void envoyer(ActionEvent event) {
        
       if( destinataire.getId()==-1)
       {
             Alert alert = new Alert(Alert.AlertType.INFORMATION.INFORMATION);
		alert.setTitle("Erreur");
		alert.setHeaderText("Results:");
		alert.setContentText("Veillez selectionner un destinataire!");

		alert.showAndWait();
       }
       else{
           if(txt_message.getText()==null || txt_message.getText().isEmpty())
           {
               Alert alert = new Alert(Alert.AlertType.INFORMATION.INFORMATION);
		alert.setTitle("Erreur");
		alert.setHeaderText("Results:");
		alert.setContentText("Veillez Ecrire un message");

		alert.showAndWait();  
           }else 
           {
                 Message m = new Message(NewFXMain.user, destinataire, LocalDateTime.now(), txt_message.getText());
             MessageServices ms = new MessageServices();
             ms.ajouter(m);
             txt_message.clear();
                    
             
           }
           
           

       }
        
//  Message m = new Message(NewFXMain.user, new Utilisateur(Integer.parseInt(btn_menu.getId())), LocalDateTime.MAX, contenu)
        
    }
    
}
