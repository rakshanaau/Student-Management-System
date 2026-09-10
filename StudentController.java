package org.anudip.sms.controller;

import java.util.List;

import org.anudip.sms.exception.StudentNotFoundException;
import org.anudip.sms.model.Student;
import org.anudip.sms.service.StudentService;
import org.anudip.sms.service.StudentServiceImpl;
import org.anudip.sms.util.InputUtil;

public class StudentController {

    private StudentService service;

    public StudentController() {

        service = new StudentServiceImpl();
    }

    public void start() {

        while (true) {

            System.out.println();
            System.out.println("=================================");
            System.out.println("     STUDENT MANAGEMENT SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.println("=================================");

            int choice = InputUtil.getInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewAllStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    System.out.println("Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void addStudent() {

        System.out.println();
        System.out.println("----- ADD STUDENT -----");

        int id = InputUtil.getInt("Enter Student ID: ");

        String name =
                InputUtil.getString("Enter Name: ");

        String department =
                InputUtil.getString("Enter Department: ");

        String year =
                InputUtil.getString("Enter Year: ");

        String email =
                InputUtil.getString("Enter Email: ");

        String phone =
                InputUtil.getString("Enter Phone: ");

        Student student = new Student(
                id,
                name,
                department,
                year,
                email,
                phone
        );

        service.addStudent(student);
    }

    private void viewAllStudents() {

        System.out.println();
        System.out.println("----- ALL STUDENTS -----");

        List<Student> students =
                service.getAllStudents();

        if (students.isEmpty()) {

            System.out.println("No students found.");

            return;
        }

        for (Student student : students) {

            System.out.println(student);
        }
    }

    private void searchStudent() {

        System.out.println();
        System.out.println("----- SEARCH STUDENT -----");

        int id =
                InputUtil.getInt("Enter Student ID: ");

        try {

            Student student =
                    service.getStudentById(id);

            System.out.println(student);

        } catch (StudentNotFoundException e) {

            System.out.println(e.getMessage());
        }
    }

    private void updateStudent() {

        System.out.println();
        System.out.println("----- UPDATE STUDENT -----");

        int id =
                InputUtil.getInt("Enter Student ID: ");

        try {

            service.getStudentById(id);

            String name =
                    InputUtil.getString("Enter New Name: ");

            String department =
                    InputUtil.getString("Enter New Department: ");

            String year =
                    InputUtil.getString("Enter New Year: ");

            String email =
                    InputUtil.getString("Enter New Email: ");

            String phone =
                    InputUtil.getString("Enter New Phone: ");

            Student student = new Student(
                    id,
                    name,
                    department,
                    year,
                    email,
                    phone
            );

            service.updateStudent(student);

        } catch (StudentNotFoundException e) {

            System.out.println(e.getMessage());
        }
    }

    private void deleteStudent() {

        System.out.println();
        System.out.println("----- DELETE STUDENT -----");

        int id =
                InputUtil.getInt("Enter Student ID: ");

        try {

            service.deleteStudent(id);

        } catch (StudentNotFoundException e) {

            System.out.println(e.getMessage());
        }
    }
}