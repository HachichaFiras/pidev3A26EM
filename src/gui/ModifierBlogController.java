/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import esprit.entity.Blog;
import esprit.entity.Comments;
import esprit.services.CommentaireServices;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class ModifierBlogController implements Initializable {

    @FXML
    private Text txt_id;
    @FXML
    private Text txt_date;
    @FXML
    private TextField txt_titre;
    @FXML
    private TextField txt_contenu;
    @FXML
    private TableView<String> list_cmt;
Blog blog = null;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        CommentaireServices serv = new CommentaireServices();
      ArrayList<Comments> cmt = new ArrayList<>(serv.getAllByBlog(blog));
      
      
          TableColumn<String, Hyperlink> column3 =
    new TableColumn<>("title");
  column3.setCellValueFactory(
    new PropertyValueFactory<>("title"));

  
  TableColumn<String, Hyperlink> column2 =
    new TableColumn<>("dateCreation");
  column2.setCellValueFactory(
    new PropertyValueFactory<>("dateCreation"));
      
      
           list_cmt.getColumns().addAll(column3,column2);
           
           for(Comments c: cmt)
           {
               list_cmt.getItems().add(1,c.getFreelancer().getNom());
           }

  
        // TODO
    }    
    
    public void AfficherBlog(Blog b)
    {
blog =b;    }
    
}
