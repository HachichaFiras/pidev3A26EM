/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import esprit.entity.Blog;
import esprit.entity.KeyWords;
import esprit.entity.Utilisateur;
import esprit.services.BlogServices;
import esprit.services.GenerateKey;
import esprit.services.KeywordsServices;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;


/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FXMLController implements Initializable {
    private Parent fxml;

    @FXML
    private AnchorPane root;
    @FXML
    private Button btn_ajouter;
    @FXML
    private Button btn_cvr;
    @FXML
    private Text txt_wlc;
    @FXML
    private Button btn_msg;
    @FXML
    private Button btn_all;
    @FXML
    private Button btn_mine;
    @FXML
    private AnchorPane root1;
    @FXML
    private Text username;
    @FXML
    private Text role;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        username.setText(NewFXMain.user.getNom() + " "+NewFXMain.user.getPrenom());
    
   txt_wlc.setText("Bienvenu de nouveau \n"+NewFXMain.user.getNom()+" "+NewFXMain.user.getPrenom());
   
       HashMap<Integer, String> roles= new HashMap<Integer, String>();
       roles.put(1, "Administrateur");
                     roles.put(2, "Freelancer");

              roles.put(3, "Business Owner");
              role.setText(roles.get(NewFXMain.user.getRole()));

       


    }    

    private void changed(ListView.EditEvent<Blog> event) {
        
        
   
    }

    private void handler(ActionEvent event) {
        javafx.scene.control.MenuItem item = (javafx.scene.control.MenuItem) event.getSource();

    }

 
    
    
      private void addButtonToTable() {
          System.out.println("in");
        TableColumn<Blog, Void> colBtn = new TableColumn("Button Column");

        Callback<TableColumn<Blog, Void>, TableCell<Blog, Void>> cellFactory = new Callback<TableColumn<Blog, Void>, TableCell<Blog, Void>>() {
            @Override
            public TableCell<Blog, Void> call(final TableColumn<Blog, Void> param) {
                final TableCell<Blog, Void> cell = new TableCell<Blog, Void>() {

                    private final Button btn = new Button("Action");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            Blog data = getTableView().getItems().get(getIndex());
                            System.out.println("selectedData: " + data);
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

    
}

 
    @FXML
    private void ajouterBlog(ActionEvent event) {
        
           try {
               
               btn_ajouter.setStyle("-fx-background-color: MediumSeaGreen");
                              btn_cvr.setStyle("-fx-background-color:  #330000");
               btn_msg.setStyle("-fx-background-color:  #330000");
           btn_all.setStyle("-fx-background-color:  #330000");
                      btn_mine.setStyle("-fx-background-color: #330000");


            fxml = FXMLLoader.load(getClass().getResource("FXMLaddBlog.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxml);
        } catch (IOException e) {
          e.printStackTrace();
        }
        
    }

   

    @FXML
    private void conversation(ActionEvent event) {
        
           try {
               
   btn_ajouter.setStyle("-fx-background-color: #330000");
                              btn_cvr.setStyle("-fx-background-color:  MediumSeaGreen");
               btn_msg.setStyle("-fx-background-color:  #330000");
           btn_all.setStyle("-fx-background-color:  #330000");
                      btn_mine.setStyle("-fx-background-color: #330000");     
                      fxml = FXMLLoader.load(getClass().getResource("conversation.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxml);
        } catch (IOException e) {
          e.printStackTrace();
        }
    }


   
    

   

    @FXML
    private void Allblog(ActionEvent event) {
       try {
            btn_ajouter.setStyle("-fx-background-color: #330000");
                              btn_cvr.setStyle("-fx-background-color: #330000");
               btn_msg.setStyle("-fx-background-color:  #330000");
                      btn_mine.setStyle("-fx-background-color: #330000");     
           btn_all.setStyle("-fx-background-color: MediumSeaGreen");
            fxml = FXMLLoader.load(getClass().getResource("FrontBlog.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxml);
        } catch (IOException e) {
          e.printStackTrace();
        }
    }

    @FXML
    private void mesBlogs(ActionEvent event) {
         try {
             
                btn_ajouter.setStyle("-fx-background-color: #330000");
                              btn_cvr.setStyle("-fx-background-color: #330000");
               btn_msg.setStyle("-fx-background-color:  #330000");
           btn_all.setStyle("-fx-background-color:  #330000");
             
             btn_mine.setStyle("-fx-background-color: MediumSeaGreen");
            fxml = FXMLLoader.load(getClass().getResource("MesBlogs.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxml);
        } catch (IOException e) {
          e.printStackTrace();
        }
        
    }

    @FXML
    private void EnvoyerMessage(ActionEvent event) {
        
          try {
         
                   btn_ajouter.setStyle("-fx-background-color: #330000");
                              btn_cvr.setStyle("-fx-background-color: #330000");
           btn_all.setStyle("-fx-background-color:  #330000");
             
             btn_mine.setStyle("-fx-background-color: #330000");
              btn_msg.setStyle("-fx-background-color: MediumSeaGreen");
            fxml = FXMLLoader.load(getClass().getResource("EnvoyerMessage.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxml);
        } catch (IOException e) {
          e.printStackTrace();
        }
    }

    @FXML
    private void stats(ActionEvent event) {
        
    }

   

   


 
   
 
}
/*
  TableColumn<Blog, Blog> unfriendCol = new TableColumn<>("Anti-social");
unfriendCol.setCellValueFactory(
    param -> new ReadOnlyObjectWrapper<>(param.getValue())
);

unfriendCol.setCellFactory(param -> new TableCell<Blog, Blog>() {
    private final Button deleteButton = new Button("Unfriend");

    @Override
    protected void updateItem(Blog person, boolean empty) {
        super.updateItem(person, empty);

        if (person == null) {
            setGraphic(null);
            return;
        }

        setGraphic(deleteButton);
        deleteButton.setOnAction(
            event -> getTableView().getItems().remove(person)
        );
    }
});

list_blog.getColumns().add(unfriendCol); 
*/