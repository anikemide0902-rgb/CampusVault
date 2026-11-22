
package org.dismClass.main;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

import org.dismClass.model.Student;
import org.dismClass.exception.StudentNotFoundException;

public class CampusVaultApp {

    // Store student records
    static ArrayList<Student> students = new ArrayList<>();

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {


        int choice = 0;

        while (choice != 5) {

            System.out.println("\n===== CAMPUS VAULT =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Save Records");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");

            try {
                choice = Integer.parseInt(input.nextLine());

                switch (choice) {

                    case 1:
                        addStudent();
                        break;

                    case 2:
                        viewStudents();
                        break;

                    case 3:
                        searchStudent();
                        break;

                    case 4:
                        saveStudents();
                        break;

                    case 5:
                        saveStudents();
                        System.out.println("Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }

        input.close();
    }

    // Add student
    public static void addStudent() {

        System.out.print("Enter Student ID: ");
        String id = input.nextLine();

        System.out.print("Enter Name: ");
        String name = input.nextLine();

        System.out.print("Enter Department: ");
        String department = input.nextLine();

        System.out.print("Enter GPA: ");
        double gpa;

        try {
            gpa = Double.parseDouble(input.nextLine());

            Student student = new Student(id, name, department, gpa);

            students.add(student);

            System.out.println("Student added successfully!");

        } catch (NumberFormatException e) {
            System.out.println("Invalid GPA!");
        }
    }

    // View students
    public static void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student student : students) {
                System.out.println(student);
                System.out.println("----------------");
            }
        }
    }

    // Search student
    public static void searchStudent() {

        System.out.print("Enter Student ID: ");
        String id = input.nextLine();

        try {
            boolean found = false;

            for (Student student : students) {

                if (student.getStudentId().equalsIgnoreCase(id)) {
                    System.out.println(student);
                    found = true;
                    break;
                }
            }

            if (!found) {
                throw new StudentNotFoundException(
                        "Student not found!"
                );
            }

        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    // Save records
    public static void saveStudents() {

        try {
            ObjectOutputStream output =
                    new ObjectOutputStream(
                            new FileOutputStream("students.ser"));

            output.writeObject(students);
            output.close();

            System.out.println("Records saved!");

        } catch (IOException e) {
            System.out.println("Error saving records.");
        }
    }

}
