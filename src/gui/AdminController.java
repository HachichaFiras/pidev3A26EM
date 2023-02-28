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

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class AdminController implements Initializable {
 private Parent fxml;
    @FXML
    private AnchorPane root;
    @FXML
    private AnchorPane root1;
    @FXML
    private Button btn_mine;
    @FXML
    private Button btn_ajouter;
    @FXML
    private Button btn_cvr;
    @FXML
    private Button btn_msg;
    @FXML
    private Button btn_sts;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void stats(ActionEvent event) {
         
    }


    @FXML
    private void conversation(ActionEvent event) {
          try{
         
            fxml = FXMLLoader.load(getClass().getResource("conversation.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxml);
        } catch (IOException e) {
          e.printStackTrace();
        }
    }

    @FXML
    private void statistiques(ActionEvent event) {
          try{
         
            fxml = FXMLLoader.load(getClass().getResource("BlogStatistics.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxml);
        } catch (IOException e) {
          e.printStackTrace();
        }
    }

    @FXML
    private void blogs(ActionEvent event) {
          try{
         
            fxml = FXMLLoader.load(getClass().getResource("MesBlogs.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxml);
        } catch (IOException e) {
          e.printStackTrace();
        }
    }

    @FXML
    private void rapport(ActionEvent event) {
    }

    @FXML
    private void intervention(ActionEvent event) {
    }
    
}
