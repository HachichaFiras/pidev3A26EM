/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import esprit.entity.Blog;
import esprit.entity.Comments;
import esprit.entity.KeyWords;
import esprit.services.BlogServices;
import esprit.services.CommentaireServices;
import esprit.services.KeywordsServices;
import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FrontBlogController implements Initializable {


    @FXML
    private AnchorPane pane;
    @FXML
    private ScrollPane scroll;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
         SplitPane split_pane = new SplitPane();
  
         BlogServices b = new BlogServices();
         List<Blog> tous  = new ArrayList<>(b.getAll());
         CommentaireServices cs = new CommentaireServices();
    
         
         
         int i=0;
         
            // create labels and add it to splitPane
           for(Blog g : tous)
           {
               String comm = "";
               for(Comments c : cs.getAllByBlog(g))
                   comm+="\n"+c.getFreelancer().getPrenom()+" "+c.getFreelancer().getNom()+" : "+c.getContenu();
               
             

// create a label
  GridPane root = new GridPane();
                 root.setPadding(new Insets(20));
       root.setHgap(80);
       root.setVgap(40);    
       
       root.add(new Label("Titre : " + g.getTitle()), 0,0);
       root.add(new Label( g.getContenu()), 0,1);
       root.add(new Label( g.getActor().getNom()), 1,2);
               Hyperlink link = new Hyperlink("Commentaire");

     root.add(link, 0, 3);
     link.setOnAction(e -> {
      
         
         
           try {
       
     FXMLLoader loader=new FXMLLoader(getClass().getResource("CommentsFxml.fxml"));
            Parent root1 =  loader.load();

            CommentsFxmlController secController=loader.getController();
            secController.display(g);

            Stage stage=new Stage();
              stage.setTitle("Commentaires");
              
            stage.setScene(new Scene(root1));
            stage.show();         
            
            
            
            
        }          catch (IOException ex) {
                       Logger.getLogger(FrontBlogController.class.getName()).log(Level.SEVERE, null, ex);
                   }
         
         
         
});
       
                Label label = new Label("Titre" + g.getTitle()  + "\n"+g.getContenu()+comm);
              
              
                TextField tf = new TextField();

                // set preferred height
                label.setPrefHeight(200);
                label.setPrefWidth(800);
                label.positionInArea(scroll, 70, 0, 0, 0, 80, Insets.EMPTY, HPos.LEFT, VPos.BASELINE, true);
                
           split_pane.getItems().addAll(root);
           i++;
           }
  
             
            
                        split_pane.setOrientation(Orientation.VERTICAL);

            pane.getChildren().addAll(split_pane);
            scroll.setContent(pane);

  
       
       
        // TODO
    }    
    
}
