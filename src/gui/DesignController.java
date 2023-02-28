/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class DesignController implements Initializable {

    @FXML
    private Text username;
    @FXML
    private Text role;
    @FXML
    private Button blog;
    private Parent fxml;
    @FXML
    private AnchorPane root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
       username.setText(NewFXMain.user.getPrenom()+" "+NewFXMain.user.getNom());
       if(NewFXMain.user.getRole()==1)
           role.setText("Business Owner");
       else if(NewFXMain.user.getRole()==2)
           role.setText("Freelancer");           
       
        // TODO
    }    

    @FXML
    private void blog(ActionEvent event) {
        
         try {
               
          /*     btn_ajouter.setStyle("-fx-background-color: MediumSeaGreen");
                              btn_cvr.setStyle("-fx-background-color:  #330000");
               btn_msg.setStyle("-fx-background-color:  #330000");
           btn_all.setStyle("-fx-background-color:  #330000");
                      btn_mine.setStyle("-fx-background-color: #330000");*/


            fxml = FXMLLoader.load(getClass().getResource("FrontBlog.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxml);
        } catch (IOException e) {
          e.printStackTrace();
        }
    }
    
}
