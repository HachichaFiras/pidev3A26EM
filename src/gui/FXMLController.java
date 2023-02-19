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
import javafx.scene.layout.AnchorPane;
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
    private MenuButton btn_key;
    @FXML
    private TableView<Blog> list_blog;
    @FXML
    private AnchorPane root;
    @FXML
    private Button btn_ajouter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
   

        Collection<javafx.scene.control.MenuItem> menu = new ArrayList<javafx.scene.control.MenuItem>();
   
        List<KeyWords> lk = new ArrayList<>();
        
        KeywordsServices serv = new KeywordsServices();
        lk.addAll(serv.getAll());
                  javafx.scene.control.MenuItem mm ;



      // To Creating a Observable List

        BlogServices servb = new BlogServices();



        for(KeyWords k : lk)
        {
            mm = new javafx.scene.control.MenuItem(k.getName());
           String s = String.valueOf(k.getId());
            mm.setId(s);
            menu.add(mm);
        }
        
        
          btn_key.getItems().addAll(menu);
            
             menu.forEach((t) -> {

                 t.setOnAction((event) -> {
                     
                     handler(event);
                 });
             });
               
        
        

        
        
        
        
        
        
KeywordsServices ks = new KeywordsServices();
        
             BlogServices bsvr = new BlogServices();
          // bsvr.ajouter(bl);

        List<Blog> blogs = new ArrayList<>(bsvr.getAll());
        
        
        TableColumn<Blog, String> column1= 
    new TableColumn<>("titre");
  column1.setCellValueFactory(
    new PropertyValueFactory<>("title"));
  
  
  TableColumn<Blog, String> column2 = 
              new TableColumn<>("Creation Date"); 
  column2.setCellValueFactory(
    new PropertyValueFactory<>("dateCreation"));
  
  
              new TableColumn<>("Creation Date"); 
  column2.setCellValueFactory(
    new PropertyValueFactory<>("dateCreation"));
// add column

         
        TableColumn<Blog, Hyperlink> column3 =
    new TableColumn<>("details");
  column1.setCellValueFactory(
    new PropertyValueFactory<>("details"));



         list_blog.getColumns().addAll(column1,column2,column3);

        
        for(Blog b:blogs)
        {
             
                list_blog.getItems().add(b);
                

        }
       
      TableColumn<Blog, Blog> unfriendCol = new TableColumn<>("Anti-social");
unfriendCol.setCellValueFactory(
    param -> new ReadOnlyObjectWrapper<>(param.getValue())
);

unfriendCol.setCellFactory(param -> new TableCell<Blog, Blog>() {
    private final Button deleteButton = new Button("view");

    @Override
    protected void updateItem(Blog person, boolean empty) {
        super.updateItem(person, empty);

        if (person == null) {
            setGraphic(null);
            return;
        }

        setGraphic(deleteButton);
        deleteButton.setOnAction(
            event -> {
      
           try {
       
     FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLBlogDetail.fxml"));
            Parent root =  loader.load();

            FXMLBlogDetailController secController=loader.getController();
            person.setKeywords(ks.getAllByBlog(person));
            secController.display(person);

            Stage stage=new Stage();
              stage.setTitle("New fruit dialog");
              
            stage.setScene(new Scene(root));
            stage.show();         
            
            
            
            
        } catch (IOException e) {
          e.printStackTrace();
        }
            }
        );
    }
});

list_blog.getColumns().add(unfriendCol); 

        
        // TODO
    }    

    private void changed(ListView.EditEvent<Blog> event) {
        
        
   
    }

    @FXML
    private void handler(ActionEvent event) {
        javafx.scene.control.MenuItem item = (javafx.scene.control.MenuItem) event.getSource();

list_blog.getItems().clear();
BlogServices bs = new BlogServices();

        btn_key.setText(item.getText());


  List<Blog> blogs = new ArrayList<>(bs.findByKeyword(Integer.valueOf(item.getId())));
        
// add column
        
        for(Blog b:blogs)
        {
             
                list_blog.getItems().add(b);

        }
        

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
            fxml = FXMLLoader.load(getClass().getResource("FXMLaddBlog.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxml);
        } catch (IOException e) {
          e.printStackTrace();
        }
        
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