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

public class AddGradesController {

    @FXML
    private TextField studentIdField;

    @FXML
    private TextField gradeField;
    
    
    @FXML
private void goBack(ActionEvent event) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("/fxml/Dashboard.fxml"));
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(new Scene(root));
    stage.show();
}

    @FXML
   private void saveGrade() {

    String id = studentIdField.getText();

    double grade = Double.parseDouble(gradeField.getText());

    if (FileManager.updateGrade(id, grade)) {

        System.out.println("Grade saved successfully");

    } else {

        System.out.println("Student ID not found");

    }
}
    }

