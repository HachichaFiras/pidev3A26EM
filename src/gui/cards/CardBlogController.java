/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.cards;

import esprit.entity.Blog;
import esprit.services.CommentaireServices;
import gui.CommentsFxmlController;
import gui.FrontBlogController;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class CardBlogController implements Initializable {

    private Text txt_title;
    @FXML
    private Text txt_contenu;
    @FXML
    private Text txt_date;
    @FXML
    private Text txt_nom;
    @FXML
    private Text txt_titre;
    @FXML
    private ImageView txt_img;
    @FXML
    private GridPane root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setData(Blog b){
        System.out.println(b);
        txt_titre.setText(b.getTitle());
        txt_contenu.setText(b.getContenu());
              long  day = ChronoUnit.DAYS.between(LocalDate.now(),b.getDateCreation());
              day = Math.abs(day);
              if(day==0)
                          txt_date.setText("publié Aujourd'hui");
              else if(day <32){
                          txt_date.setText("publié Il ya "+ day +"jours");


              }
              
              CommentaireServices srv = new CommentaireServices();
              
              
                             Hyperlink link = new Hyperlink("Commentaire ( "+srv.getAllByBlog(b).size()+" )");
     root.add(link, 0, 1);
     link.setOnAction(e -> {
      
         
         
           try {
       
     FXMLLoader loader=new FXMLLoader(getClass().getResource("CommentsFxml.fxml"));
            Parent root1 =  loader.load();

            CommentsFxmlController secController=loader.getController();
            secController.display(b);

            Stage stage=new Stage();
              stage.setTitle("Commentaires");
              
            stage.setScene(new Scene(root1));
            stage.show();         
            
            
            
            
        }          catch (IOException ex) {
                       Logger.getLogger(FrontBlogController.class.getName()).log(Level.SEVERE, null, ex);
                   }
         
         
         
});
              


     
        
    }
    
}
