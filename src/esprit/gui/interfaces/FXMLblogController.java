/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.gui.interfaces;

import esprit.entity.Blog;
import esprit.entity.KeyWords;
import esprit.services.BlogServices;
import esprit.services.KeywordsServices;
import java.awt.MenuItem;
import java.net.URL;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.input.DragEvent;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FXMLblogController implements Initializable {

    @FXML
    private Button btn_blog;
    @FXML
    private SplitMenuButton btn_menu;
    @FXML
    private ListView<?> list_blog;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
             System.out.println("haha");
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
        
        
            btn_menu.getItems().addAll(menu);
            
             menu.forEach((t) -> {

                 t.setOnAction((event) -> {
                     
                     handler(event);
                 });
             });
               
    
    
    }    
    



    private void getAllKeywords(DragEvent event) {
        
Collection<javafx.scene.control.MenuItem> menu = new ArrayList<javafx.scene.control.MenuItem>();
           System.out.println("ha");

        List<KeyWords> lk = new ArrayList<>();
           javafx.scene.control.MenuItem mm ;
    
        
        
            btn_menu.getItems().addAll(menu);
               
    }

   
    @FXML
    private void handler(ActionEvent event) {
        javafx.scene.control.MenuItem item = (javafx.scene.control.MenuItem) event.getSource();
                       System.out.println(item.getId());
                       
                      
        
      

    } 

    @FXML
    private void charger(ActionEvent event) {
    }

    @FXML
    private void selectKeyword(TouchEvent event) {
    }


}
