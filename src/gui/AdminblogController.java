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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class AdminblogController implements Initializable {
    private Parent fxml;

    @FXML
    private AnchorPane root;
    @FXML
    private Text txt_wlc;
    @FXML
    private ImageView img_logo;
    @FXML
    private Button btn_all;
    @FXML
    private Button btn_mine;
    private Button btn_ajouter;
    @FXML
    private Button btn_cvr;
    @FXML
    private Button btn_msg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        txt_wlc.setText("vous etes connectè en tant que \nAdministrateur");
        btn_msg.setText("Rapports");
    }    

    

    @FXML
    private void mesBlogs(ActionEvent event) {
        try{
            btn_ajouter.setStyle("-fx-background-color: #330000");
                              btn_cvr.setStyle("-fx-background-color: #330000");
               btn_msg.setStyle("-fx-background-color:  #330000");
                      btn_mine.setStyle("-fx-background-color: #330000");     
           btn_all.setStyle("-fx-background-color: MediumSeaGreen");
            fxml = FXMLLoader.load(getClass().getResource("ConsulterBlog.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxml);
        } catch (IOException e) {
          e.printStackTrace();
        }
        
    }


    @FXML
    private void conversation(ActionEvent event) {
  try{
            btn_ajouter.setStyle("-fx-background-color: #330000");
                              btn_cvr.setStyle("-fx-background-color: #330000");
               btn_msg.setStyle("-fx-background-color:  #330000");
                      btn_mine.setStyle("-fx-background-color: #330000");     
           btn_all.setStyle("-fx-background-color: MediumSeaGreen");
            fxml = FXMLLoader.load(getClass().getResource("conversation.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxml);
        } catch (IOException e) {
          e.printStackTrace();
        }        
    }

    @FXML
    private void EnvoyerMessage(ActionEvent event) {
    }

    @FXML
    private void Stats(ActionEvent event) {
        
          try{
            btn_ajouter.setStyle("-fx-background-color: #330000");
                              btn_cvr.setStyle("-fx-background-color: #330000");
               btn_msg.setStyle("-fx-background-color:  #330000");
                      btn_mine.setStyle("-fx-background-color: #330000");     
           btn_all.setStyle("-fx-background-color: MediumSeaGreen");
            fxml = FXMLLoader.load(getClass().getResource("BlogStatistics.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxml);
        } catch (IOException e) {
          e.printStackTrace();
        }
    }
    
}
