/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.cards;

import esprit.entity.Blog;
import esprit.services.BlogServices;
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
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class BlogController implements Initializable {

    @FXML
    private AnchorPane pane;
    @FXML
    private GridPane grv;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        BlogServices sr = new BlogServices();
        List<Blog> tous  = new ArrayList<Blog>(sr.getAll());
        int row=0;
        int colum =1;
        for(Blog b : tous)
        {  try {
            FXMLLoader fxmllooader = new FXMLLoader();
            fxmllooader.setLocation(getClass().getResource("CardBlog.fxml"));
          
               VBox blogp = fxmllooader.load();
CardBlogController cdr =    fxmllooader.getController();
cdr.setData(b);
               grv.add(blogp, 0, row);
               row++;
              GridPane.setMargin(blogp, new Insets(10));
                
                
                
                
            } catch (Exception ex) {
                Logger.getLogger(BlogController.class.getName()).log(Level.SEVERE, null, ex);
            }
     
        
        }
        
        
        // TODO
    }    
    
}
