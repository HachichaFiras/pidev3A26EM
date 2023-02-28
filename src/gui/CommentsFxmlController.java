/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import esprit.entity.Blog;
import esprit.entity.Comments;
import esprit.entity.KeyWords;
import esprit.services.Api;
import esprit.services.CommentaireServices;
import esprit.services.KeywordsServices;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class CommentsFxmlController implements Initializable {

    @FXML
    private ListView<String> list_cmt;
    @FXML
    private TextField txt_cmt;
    @FXML
    private Button commenter;

    Blog blog = null;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        // TODO
    }    
    
    
     public void display(Blog b){
          blog =b;
               CommentaireServices serv = new CommentaireServices();
            ArrayList<Comments> cmts = new ArrayList<>(serv.getAllByBlog(b));
            
            for(Comments c : cmts)
            {
                list_cmt.getItems().add("* " + c.getFreelancer().getNom()+" : "+c.getContenu()+"\n"+c.getDateCreation().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
            }
            
         
     }

    @FXML
    private void commenter(ActionEvent event) {
       CommentaireServices serv = new CommentaireServices();
        if(txt_cmt == null || txt_cmt.getText().isEmpty())
        {
               Alert alert = new Alert(Alert.AlertType.INFORMATION.INFORMATION);
		alert.setTitle("Erreur");
		alert.setHeaderText("Results:");
		alert.setContentText("Veillez ecrire un commentaire");

		alert.showAndWait();
        }
        else
        {
            
            
              Api api = new Api();
            try {
                
                
                if(api.POSTReq(txt_cmt.getText()) == 1)
                {
                    serv.ajouter(new Comments(NewFXMain.user, txt_cmt.getText() , LocalDateTime.now(), blog));
((Node)(event.getSource())).getScene().getWindow().hide();
           Alert alert = new Alert(Alert.AlertType.INFORMATION.INFORMATION);
		alert.setTitle("Succes");
		alert.setHeaderText("Results:");
		alert.setContentText("Commentaire ajoutèe avec success!");

		alert.showAndWait();
                
               
                
                }
                else{
                      
           Alert alert = new Alert(Alert.AlertType.INFORMATION.INFORMATION);
		alert.setTitle("Erreur");
		alert.setHeaderText("Results:");
		alert.setContentText("Commentaire n'est pas conforme aux regles de l'application ");

		alert.showAndWait();
                }
            
                
            } catch (Exception e) {
            }
 
                
         
        
        
        
    }
    }
    
     
}
    
/*   System.out.println(blog);
       
*/
