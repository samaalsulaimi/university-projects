/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentgradesystem;


/**
 *
 * @author Samas
 */
import javafx.event.ActionEvent; 
import javafx.fxml.FXML; 
import javafx.fxml.FXMLLoader; 
import javafx.scene.Parent; 
import javafx.scene.Scene; 
import javafx.stage.Stage; 
import javafx.scene.Node; 
import javafx.scene.control.Label; 
import javafx.scene.control.PasswordField; 
import javafx.scene.control.TextField; 
 
public class LoginController { 
 
    @FXML 
    private TextField usernameField; 
 
    @FXML 
    private PasswordField passwordField; 
 
    @FXML 
    private Label messageLabel; 
 
    @FXML 
    private void handleLogin(ActionEvent event) { 
 
        String username = usernameField.getText(); 
        String password = passwordField.getText(); 
 
        if (username.equals("admin") && password.equals("1234")) { 
 
            try { 
 
                Parent root = 
                    FXMLLoader.load(getClass().getResource("/fxml/Dashboard.fxml"));
 
                Stage stage = 
                    (Stage)((Node)event.getSource()).getScene().getWindow(); 
 
                stage.setScene(new Scene(root)); 
                stage.show(); 
 
            } catch (Exception e) { 
                e.printStackTrace(); 
            } 
 
        } else { 
 
            messageLabel.setText("Wrong username or password"); 
 
        } 
    } 
}
