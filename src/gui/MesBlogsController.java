/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import esprit.entity.Blog;
import esprit.entity.KeyWords;
import esprit.services.BlogServices;
import esprit.services.KeywordsServices;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.MenuButton;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class MesBlogsController implements Initializable {

    @FXML
    private TableView<Blog> list_blog;
    @FXML
    private MenuButton btn_key;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
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

        List<Blog> blogs = new ArrayList<>(bsvr.getAllByUser(NewFXMain.user));
        
        
  

  
// add column

         


        TableColumn<Blog, Hyperlink> column3 =
    new TableColumn<>("title");
  column3.setCellValueFactory(
    new PropertyValueFactory<>("title"));

  TableColumn<Blog, Hyperlink> column2 =
    new TableColumn<>("dateCreation");
  column2.setCellValueFactory(
    new PropertyValueFactory<>("dateCreation"));

TableColumn<Blog, Hyperlink> column1 =
    new TableColumn<>("id");
  column1.setCellValueFactory(
    new PropertyValueFactory<>("id"));

         list_blog.getColumns().addAll(column3,column2,column1);

        
        for(Blog b:blogs)
        {
             
                list_blog.getItems().add(b);
                

        }
       
      TableColumn<Blog, Blog> unfriendCol = new TableColumn<>("View");
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
       
     FXMLLoader loader=new FXMLLoader(getClass().getResource("ModifierBlog.fxml"));
            Parent root =  loader.load();

            
            ModifierBlogController secController = loader.getController();
            person.setKeywords(ks.getAllByBlog(person));
            secController.AfficherBlog(person);

            Stage stage=new Stage();
              stage.setTitle("Blog");
              
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
    
}
