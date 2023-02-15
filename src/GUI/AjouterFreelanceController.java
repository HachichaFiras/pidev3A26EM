/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AjouterFreelanceController implements Initializable {

    @FXML
    private TextField txtName;
    @FXML
    private TextField txtLastName;
    @FXML
    private Button btn;
    @FXML
    private TextField txtPassword;
    @FXML
    private TextField txtEmail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void Ajouter(ActionEvent event) {
        String name = txtName.getText();
        String Lastname = txtLastName.getText();
        String password = txtPassword.getText();
        String email = txtPassword.getText();

        
        
        

    }
    
}
