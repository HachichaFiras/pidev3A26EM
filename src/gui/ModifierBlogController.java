
package gui;

import esprit.entity.Blog;
import esprit.entity.Comments;
import esprit.entity.KeyWords;
import esprit.entity.Utilisateur;
import esprit.services.BlogServices;
import esprit.services.CommentaireServices;
import esprit.services.KeywordsServices;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
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
    private ListView<String> list_cmt;
Blog blog;
    @FXML
    private Button btn_modifer;
    
       final ListView<String> selectedItems = new ListView<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
txt_id.setVisible(false);
    }  

      
        // TODO*/
       
    
    public void AfficherBlog(Blog b)
    {
blog =b; 
  

txt_contenu.setText(b.getContenu());
txt_date.setText(b.getDateCreation().format(DateTimeFormatter.ISO_DATE));
txt_id.setText(b.getId()+"");
txt_titre.setText(b.getTitle());

   CommentaireServices serv = new CommentaireServices();
            ArrayList<Comments> cmts = new ArrayList<>(serv.getAllByBlog(b));
            
            for(Comments c : cmts)
            {
                list_cmt.getItems().add("* " + c.getFreelancer().getNom()+" : "+c.getContenu()+"\n"+c.getDateCreation().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
            }
            
            


















/*        CommentaireServices serv = new CommentaireServices();
      ArrayList<Comments> cmt = new ArrayList<>(serv.getAllByBlog(blog));
  
        System.out.println(cmt);
      
      
          TableColumn<Comments, Hyperlink> column3 =
    new TableColumn<>("user");
  column3.setCellValueFactory(
    new PropertyValueFactory<>("user"));

  
  TableColumn<Comments, Hyperlink> column2 =
    new TableColumn<>("dateCreation");
  column2.setCellValueFactory(
    new PropertyValueFactory<>("dateCreation"));
      
      
           list_cmt.getColumns().addAll(column3,column2);
           
           for(Comments c: cmt)
           {
               list_cmt.getItems().add(c);
           }

  
      //  System.out.println(blog);*/
    }

    @FXML
    private void Modifier(ActionEvent event) {
        
        
        
if(txt_titre.getText()==null|| txt_contenu.getText()==null ||txt_titre.getText().isEmpty()|| txt_contenu.getText().isEmpty())
{
    Alert alert = new Alert(Alert.AlertType.INFORMATION.INFORMATION);
		alert.setTitle("Erreur");
		alert.setHeaderText("Results:");
		alert.setContentText("Veuillez saisir tous les champs");

		alert.showAndWait();
}
else{
    
BlogServices bs = new BlogServices();
  String key = String.valueOf(LocalDateTime.now().getYear()).substring(2)+LocalDateTime.now().getDayOfYear()+LocalDateTime.now().getHour()+LocalDateTime.now().getMinute()+LocalDateTime.now().getSecond();
  System.out.println(key);
              
  KeywordsServices ks = new KeywordsServices();
        
Blog b = new Blog(Integer.parseInt(txt_id.getText()), txt_titre.getText(), txt_contenu.getText(), LocalDateTime.now(),NewFXMain.user,null, ks.getAllByBlog(blog));
bs.update(b);


((Node)(event.getSource())).getScene().getWindow().hide();

 Alert alert = new Alert(Alert.AlertType.INFORMATION.INFORMATION);
		alert.setTitle("Succes");
		alert.setHeaderText("Results:");
		alert.setContentText("Blog updated successfully!");
		alert.showAndWait();



}
        
    }

    
}
