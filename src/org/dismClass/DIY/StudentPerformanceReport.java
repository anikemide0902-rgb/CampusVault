package org.dismClass.DIY;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.dismClass.model.Student;

public class StudentPerformanceReport {

    public static void main(String[] args) {

        try {
            // Read student records from file
            ObjectInputStream input =
                    new ObjectInputStream(
                            new FileInputStream("students.ser"));

            ArrayList<Student> students =
                    (ArrayList<Student>) input.readObject();

            input.close();

            // Sort students by GPA in descending order
            List<Student> sortedStudents = students.stream()
                    .sorted(Comparator.comparingDouble(Student::getGpa).reversed())
                    .collect(Collectors.toList());

            // Display student performance report
            System.out.println("===== STUDENT PERFORMANCE REPORT =====");

            for (Student student : sortedStudents) {
                System.out.println(student);
                System.out.println("----------------------------");
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading student records.");
        }
    }
}