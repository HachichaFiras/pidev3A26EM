
package gui;

import esprit.entity.Candidature;
import esprit.entity.Utilisateur;
import esprit.services.UserService;
import java.awt.Dimension;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class NewFXMain extends Application {
  public  static Utilisateur user = new Utilisateur(5, 1, 1, 22333333,"Hachicha", "FIRAS", "@mail", "Firas", "firas", "sfax");

            @Override
    public void start(Stage primaryStage) {
     Parent root;
        try {
            
            
            UserService serv = new UserService();
            user=serv.findByid(user.getId());
            
            if(user.getRole()==1)
            { 
	
//            
            root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
              Scene  scene = new Scene(root,920,600);
     
              
              


        primaryStage.setTitle("Freelanci Administrator");
        primaryStage.setScene(scene);
        primaryStage.show();
            }
            
            else 
            {Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	
//            
            root = FXMLLoader.load(getClass().getResource("BlogController.fxml"));
              Scene  scene = new Scene(root,920,820);
     
              

                


        primaryStage.setTitle("Freelanci");
        primaryStage.setScene(scene);
        primaryStage.show();
            }
        
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
