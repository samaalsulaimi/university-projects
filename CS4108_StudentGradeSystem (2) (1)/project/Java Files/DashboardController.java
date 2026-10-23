/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentgradesystem;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class DashboardController implements Initializable {

    @FXML
    private Label studentsCountLabel;

    @FXML
    private TableView<Student> studentsTable;

    @FXML
    private TableColumn<Student, String> idColumn;

    @FXML
    private TableColumn<Student, String> nameColumn;

    @FXML
    private TableColumn<Student, Double> gradeColumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        idColumn.setCellValueFactory(
                new PropertyValueFactory<>("id"));

        nameColumn.setCellValueFactory(
                new PropertyValueFactory<>("name"));

        gradeColumn.setCellValueFactory(
                new PropertyValueFactory<>("grade"));

        studentsTable.setItems(
                FXCollections.observableArrayList(
                        FileManager.readStudents()
                )
        );

        studentsCountLabel.setText(
                String.valueOf(FileManager.readStudents().size())
        );
    }

    // ------------------ Navigation Buttons ------------------

    @FXML
    private void goToAddStudent(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/AddStudent.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void goToAddGrades(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/AddGrades.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void goToViewStudents(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/ViewStudents.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void goToViewReports(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/ViewReports.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void logout(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}