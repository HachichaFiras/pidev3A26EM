/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import esprit.entity.Utilisateur;
import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Asus
 */
public class NewFXMain extends Application {
  public  static Utilisateur user = new Utilisateur(5, 2, 1, 22333333,"Hachicha", "FIRAS", "@mail", "Firas", "firas", "sfax");

            @Override
    public void start(Stage primaryStage) {
     Parent root;
        try {
           	Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	
//            
            root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
              Scene scene = new Scene(root,1200,600);
     
              
              
              Collection<javafx.scene.control.MenuItem> menu = new ArrayList<javafx.scene.control.MenuItem>();

     


           primaryStage.setTitle("Ajouter Personne");
       primaryStage.setScene(scene);
        primaryStage.show();
      
        
        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }
        
    } 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
