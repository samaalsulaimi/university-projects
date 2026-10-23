/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentgradesystem;

import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private static final String FILE_NAME = "students.txt";

    public static void addStudent(Student student) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(student.getId() + "," + student.getName() + "," + student.getGrade());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving student: " + e.getMessage());
        }
    }

    public static ArrayList<Student> readStudents() {
        ArrayList<Student> students = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return students;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length == 3) {
                    String id = data[0];
                    String name = data[1];
                    double grade = Double.parseDouble(data[2]);

                    students.add(new Student(id, name, grade));
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading students: " + e.getMessage());
        }

        return students;
    }

    public static boolean studentExists(String id) {
        ArrayList<Student> students = readStudents();

        for (Student s : students) {
            if (s.getId().equals(id)) {
                return true;
            }
        }

        return false;
    }

    public static boolean updateGrade(String id, double grade) {
        ArrayList<Student> students = readStudents();
        boolean found = false;

        for (Student s : students) {
            if (s.getId().equals(id)) {
                s.setGrade(grade);
                found = true;
                break;
            }
        }

        if (found) {
            saveAllStudents(students);
        }

        return found;
    }

    private static void saveAllStudents(ArrayList<Student> students) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                writer.write(s.getId() + "," + s.getName() + "," + s.getGrade());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error updating students: " + e.getMessage());
        }
    }
}