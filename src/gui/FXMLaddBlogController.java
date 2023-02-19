/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import esprit.entity.KeyWords;
import esprit.services.BlogServices;
import esprit.services.KeywordsServices;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
     KeywordsServices ks = new KeywordsServices();
      final List<CheckMenuItem> items = new ArrayList<>();
for(KeyWords k : ks.getAll())
{
    items.add(new CheckMenuItem(k.getName()));
}
                                          
     menu_btn.getItems().addAll(items);
 
      for (final CheckMenuItem item : items) {
         item.selectedProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newValue) {
               selectedItems.getItems().add(item.getText());
            } else {
               selectedItems.getItems().remove(item.getText());
            }
         });
      }
    }    

    @FXML
    private void submitAdd(ActionEvent event) {
        
        System.out.println(selectedItems.getItems());
        
        
    }
    
}
