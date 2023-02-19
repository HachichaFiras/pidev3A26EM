/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.gui;

import java.awt.Dimension;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import esprit.entity.KeyWords;
import esprit.services.KeywordsServices;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.VBox;

/**
 *
 * @author Asus
 */
public class NewFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       
        
        Parent root;
        try {
           	Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	
            
            root = FXMLLoader.load(getClass().getResource("interfaces/FXMLBlog.fxml"));
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
