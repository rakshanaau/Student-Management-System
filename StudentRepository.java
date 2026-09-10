package org.anudip.sms.repository;

import java.util.List;
import org.anudip.sms.model.Student;

public interface StudentRepository {

    void addStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(int studentId);

    void updateStudent(Student student);

    void deleteStudent(int studentId);
}