package org.anudip.sms.service;

import java.util.List;

import org.anudip.sms.model.Student;

public interface StudentService {

    void addStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(int studentId);

    void updateStudent(Student student);

    void deleteStudent(int studentId);
}