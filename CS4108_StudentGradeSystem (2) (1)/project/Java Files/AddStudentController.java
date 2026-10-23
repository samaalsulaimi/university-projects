/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.studentgradesystem;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class AddStudentController {

    @FXML
    private TextField idField;

    @FXML
    private TextField nameField;

    @FXML
    private void addStudent() {
 Student student =
            new Student(idField.getText(), nameField.getText());

    FileManager.addStudent(student);

    System.out.println("Saved");    }

   @FXML
private void goBack(ActionEvent event) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("/fxml/Dashboard.fxml"));
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(new Scene(root));
    stage.show();
}
}
