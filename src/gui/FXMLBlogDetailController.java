
package gui;

import com.sun.javafx.scene.control.skin.Utils;
import esprit.entity.Blog;
import esprit.entity.Comments;
import esprit.services.CommentaireServices;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FXMLBlogDetailController implements Initializable {

    private int id;
    
    private Text txt_id;
    @FXML
    private Text txt_titre;
    @FXML
    private Text txt_contenu;
    @FXML
    private Text txt_keywords;
    @FXML
    private Text txt_date;
    @FXML
    private Text txt_name;
    @FXML
    private ListView<String> list_cmt;
    @FXML
    private TextField txt_cmt;
    @FXML
    private Button btn_cmt;

    Blog blog = null;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
    txt_id.setText(id+"");
    
    
            // TODO
       
     
  
    }    

    public void display(Blog b){
        blog =b;
            txt_id.setText(b.getId()+"");
            txt_titre.setText(b.getTitle());
            txt_contenu.setText(b.getContenu());
            txt_date.setText(b.getDateCreation().toString());
            
            
            txt_keywords.setText(b.getKeywords().toString());
            txt_name.setText(b.getActor().getNom()+b.getActor().getPrenom());
            
            
            CommentaireServices serv = new CommentaireServices();
            ArrayList<Comments> cmts = new ArrayList<>(serv.getAllByBlog(b));
            
            for(Comments c : cmts)
            {
                list_cmt.getItems().add("* " + c.getFreelancer().getNom()+" : "+c.getContenu()+"\n"+c.getDateCreation().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
            }
            
            
            
            
            
            

    }

    @FXML
    private void commenter(ActionEvent event) {
        
        
        CommentaireServices serv = new CommentaireServices();
        if(txt_cmt == null || txt_cmt.getText().isEmpty())
        {
               Alert alert = new Alert(Alert.AlertType.INFORMATION.INFORMATION);
		alert.setTitle("Erreur");
		alert.setHeaderText("Results:");
		alert.setContentText("Veillez ecrire un commentaire");

		alert.showAndWait();
        }
        else
        {
            System.out.println(blog);
          serv.ajouter(new Comments(NewFXMain.user, txt_cmt.getText() , LocalDateTime.now(), blog));
((Node)(event.getSource())).getScene().getWindow().hide();

        }
        
        
    }
    
    
     
    
}
