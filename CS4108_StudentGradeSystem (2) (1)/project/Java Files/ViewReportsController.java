/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentgradesystem;

/**
 *
 * @author 
 */
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ViewReportsController {

    @FXML
    private Label lblTotal;

    @FXML
    private Label lblAverage;

    @FXML
    private Label lblHighest;

    @FXML
    private Label lblLowest;

    @FXML
    public void initialize() {

        ArrayList<Student> students = FileManager.readStudents();

        if (students.isEmpty()) {
            lblTotal.setText("0");
            lblAverage.setText("0");
            lblHighest.setText("0");
            lblLowest.setText("0");
            return;
        }

        double total = 0;
        double highest = students.get(0).getGrade();
        double lowest = students.get(0).getGrade();

        for (Student s : students) {

            total += s.getGrade();

            if (s.getGrade() > highest) {
                highest = s.getGrade();
            }

            if (s.getGrade() < lowest) {
                lowest = s.getGrade();
            }
        }

        double average = total / students.size();

        lblTotal.setText(String.valueOf(students.size()));
       lblAverage.setText(String.format(java.util.Locale.US, "%.2f", average));
        lblHighest.setText(String.valueOf(highest));
        lblLowest.setText(String.valueOf(lowest));
    }

    @FXML
    private void goBack() throws Exception {

        Parent root = FXMLLoader.load(
                getClass().getResource("/fxml/ViewStudents.fxml"));

        Stage stage = (Stage) lblTotal.getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.show();
    }
}