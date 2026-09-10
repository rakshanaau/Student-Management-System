
package org.anudip.sms.service;

import java.util.List;

import org.anudip.sms.exception.StudentNotFoundException;
import org.anudip.sms.model.Student;
import org.anudip.sms.repository.StudentRepository;
import org.anudip.sms.repository.StudentRepositoryImpl;

public class StudentServiceImpl implements StudentService {

    private StudentRepository repository;

    public StudentServiceImpl() {

        repository = new StudentRepositoryImpl();
    }

    @Override
    public void addStudent(Student student) {

        repository.addStudent(student);
    }

    @Override
    public List<Student> getAllStudents() {

        return repository.getAllStudents();
    }

    @Override
    public Student getStudentById(int studentId) {

        Student student = repository.getStudentById(studentId);

        if (student == null) {

            throw new StudentNotFoundException(
                    "Student with ID " + studentId + " not found.");
        }

        return student;
    }

    @Override
    public void updateStudent(Student student) {

        getStudentById(student.getStudentId());

        repository.updateStudent(student);
    }

    @Override
    public void deleteStudent(int studentId) {

        getStudentById(studentId);

        repository.deleteStudent(studentId);
    }
}