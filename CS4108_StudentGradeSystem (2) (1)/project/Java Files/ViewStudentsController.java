/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.studentgradesystem;


import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ViewStudentsController {

    
    @FXML
    private TableView<Student> tableStudent;

    @FXML
    private TableColumn<Student, String> colId;

    @FXML
    private TableColumn<Student, String> colName;

    @FXML
    private TableColumn<Student, Double> colGrade;

    @FXML
    public void initialize() {

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colGrade.setCellValueFactory(new PropertyValueFactory<>("grade"));

        loadStudents();
    }

    private void loadStudents() {

        ArrayList<Student> students = FileManager.readStudents();

        tableStudent.setItems(
                FXCollections.observableArrayList(students)
        );
    }

    @FXML
    private void goBack() throws Exception {

        Parent root = FXMLLoader.load(
                getClass().getResource("/fxml/Dashboard.fxml"));

        Stage stage = (Stage) tableStudent.getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void goNext() throws Exception {

        Parent root = FXMLLoader.load(
                getClass().getResource("/fxml/ViewReports.fxml"));

        Stage stage = (Stage) tableStudent.getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.show();
    }
}
