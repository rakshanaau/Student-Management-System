package org.anudip.sms.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.anudip.sms.database.DBConnection;
import org.anudip.sms.model.Student;

public class StudentRepositoryImpl implements StudentRepository {

    @Override
    public void addStudent(Student student) {

        String sql = "INSERT INTO students " +
                     "(student_id, name, department, year, email, phone) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, student.getStudentId());
            ps.setString(2, student.getName());
            ps.setString(3, student.getDepartment());
            ps.setString(4, student.getYear());
            ps.setString(5, student.getEmail());
            ps.setString(6, student.getPhone());

            ps.executeUpdate();

            System.out.println("Student added successfully.");

        } catch (SQLException e) {

            System.out.println("Error while adding student.");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Student> getAllStudents() {

        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM students";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Student student = new Student();

                student.setStudentId(rs.getInt("student_id"));
                student.setName(rs.getString("name"));
                student.setDepartment(rs.getString("department"));
                student.setYear(rs.getString("year"));
                student.setEmail(rs.getString("email"));
                student.setPhone(rs.getString("phone"));

                students.add(student);
            }

        } catch (SQLException e) {

            System.out.println("Error while retrieving students.");
            System.out.println(e.getMessage());
        }

        return students;
    }

    @Override
    public Student getStudentById(int studentId) {

        String sql = "SELECT * FROM students WHERE student_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Student student = new Student();

                student.setStudentId(rs.getInt("student_id"));
                student.setName(rs.getString("name"));
                student.setDepartment(rs.getString("department"));
                student.setYear(rs.getString("year"));
                student.setEmail(rs.getString("email"));
                student.setPhone(rs.getString("phone"));

                return student;
            }

        } catch (SQLException e) {

            System.out.println("Error while searching student.");
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public void updateStudent(Student student) {

        String sql = "UPDATE students SET " +
                     "name = ?, department = ?, year = ?, " +
                     "email = ?, phone = ? " +
                     "WHERE student_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getDepartment());
            ps.setString(3, student.getYear());
            ps.setString(4, student.getEmail());
            ps.setString(5, student.getPhone());
            ps.setInt(6, student.getStudentId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student updated successfully.");
            } else {
                System.out.println("Student not found.");
            }

        } catch (SQLException e) {

            System.out.println("Error while updating student.");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteStudent(int studentId) {

        String sql = "DELETE FROM students WHERE student_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, studentId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("Student not found.");
            }

        } catch (SQLException e) {

            System.out.println("Error while deleting student.");
            System.out.println(e.getMessage());
        }
    }
}