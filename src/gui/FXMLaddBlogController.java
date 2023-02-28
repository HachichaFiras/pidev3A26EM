package gui;

import esprit.entity.Blog;
import esprit.entity.KeyWords;
import esprit.services.Api;
import esprit.services.BlogServices;
import esprit.services.KeywordsServices;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FXMLaddBlogController implements Initializable {

    @FXML
    private TextField txt_titre;
    @FXML
    private TextField txt_contenu;
    @FXML
    private Button btn_submit;
    @FXML
    private Text txt_id;

    
   final ListView<String> selectedItems = new ListView<>();
    @FXML
    private MenuButton menu_btn;
    @FXML
    private Button btn_addk;
    @FXML
    private TextField txt_key;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        txt_id.setVisible(false);
        
    
        
     KeywordsServices ks = new KeywordsServices();
      final List<CheckMenuItem> items = new ArrayList<>();
for(KeyWords k : ks.getAll())
{
    CheckMenuItem mm = new CheckMenuItem(k.getName());
    mm.setId(k.getId()+"");
    items.add(mm);
}BlogServices bs = new BlogServices();

                           txt_id.setText((bs.getNumber()+1)+"");
                               
     menu_btn.getItems().addAll(items);
 
      for (final CheckMenuItem item : items) {
         item.selectedProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newValue) {
               selectedItems.getItems().add(item.getId());
            } else {
               selectedItems.getItems().remove(item.getId());
            }
         });
      }
      
      
      
    }    
    

    @FXML
    private void submitAdd(ActionEvent event) {
        ArrayList<KeyWords> allk = new ArrayList<>();
selectedItems.getItems().forEach((t) -> {
   allk.add(new KeyWords((Integer.parseInt(t)), ""));
    System.out.println((Integer.parseInt(t)));
    
});
 
if(txt_titre.getText()==null|| txt_contenu.getText()==null ||txt_titre.getText().isEmpty()|| txt_contenu.getText().isEmpty())
{
    Alert alert = new Alert(Alert.AlertType.INFORMATION.INFORMATION);
		alert.setTitle("Erruer");
		alert.setHeaderText("Results:");
		alert.setContentText("Veillez sasir tous les champs");

		alert.showAndWait();
}
else{
BlogServices bs = new BlogServices();
  String key = String.valueOf(LocalDateTime.now().getYear()).substring(2)+LocalDateTime.now().getDayOfYear()+LocalDateTime.now().getHour()+LocalDateTime.now().getMinute()+LocalDateTime.now().getSecond();
  System.out.println(key);
              
        
Blog b = new Blog(Integer.parseInt(txt_id.getText()), txt_titre.getText(), txt_contenu.getText(), LocalDateTime.now(),NewFXMain.user,null, allk);
bs.ajouter(b);

  Alert alert = new Alert(Alert.AlertType.INFORMATION.INFORMATION);
		alert.setTitle("Succes");
		alert.setHeaderText("Results:");
		alert.setContentText("Blog added successfully!");

		alert.showAndWait();


}
    }

    @FXML
    private void ajouterkey(ActionEvent event) {
        
        if( txt_key.getText() == null ||txt_key.getText().isEmpty())
{
    Alert alert = new Alert(Alert.AlertType.INFORMATION.INFORMATION);
		alert.setTitle("Erreur");
		alert.setHeaderText("Results:");
		alert.setContentText("saisir un keyword");

		alert.showAndWait();
}
else{
            
            Api api = new Api();
            try {
                if(api.POSTReq(txt_key.getText()) == 1)
                {
                     KeywordsServices serv = new KeywordsServices();
          serv.ajouter(new KeyWords(txt_key.getText()));
           Alert alert = new Alert(Alert.AlertType.INFORMATION.INFORMATION);
		alert.setTitle("Succes");
		alert.setHeaderText("Results:");
		alert.setContentText("KEyword ajoutèe avec success!");

		alert.showAndWait();
                
               
                
                }
                else{
                      
           Alert alert = new Alert(Alert.AlertType.INFORMATION.INFORMATION);
		alert.setTitle("Erreur");
		alert.setHeaderText("Results:");
		alert.setContentText("KEyword n'est pas conforme aux regles de l'application ");

		alert.showAndWait();
                }
                    
                
            } catch (IOException ex) {
                Logger.getLogger(FXMLaddBlogController.class.getName()).log(Level.SEVERE, null, ex);
            }
       
                
                
               


    }
    }
    
}
