/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import esprit.entity.Blog;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FXMLBlogDetailController implements Initializable {

    private int id;
    
    @FXML
    private Text txt_id;
    @FXML
    private Text txt_titre;
    @FXML
    private Text txt_contenu;
    @FXML
    private Text txt_keywords;
    @FXML
    private Text txt_date;
    @FXML
    private Text txt_name;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
    txt_id.setText(id+"");
            // TODO
       
     
  
    }    

    public void display(Blog b){
            txt_id.setText(b.getId()+"");
            txt_titre.setText(b.getTitle());
            txt_contenu.setText(b.getContenu());
            txt_date.setText(b.getDateCreation().toString());
            
            
            txt_keywords.setText(b.getKeywords().toString());
            txt_name.setText(b.getActor().getNom()+b.getActor().getPrenom());

    }
    
    
    
    
}
