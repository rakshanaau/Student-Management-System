package org.anudip.sms.model;

public class Student {

    private int studentId;
    private String name;
    private String department;
    private String year;
    private String email;
    private String phone;

    public Student() {
    }

    public Student(int studentId, String name, String department,
                   String year, String email, String phone) {

        this.studentId = studentId;
        this.name = name;
        this.department = department;
        this.year = year;
        this.email = email;
        this.phone = phone;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {

        return "Student ID: " + studentId +
                " | Name: " + name +
                " | Department: " + department +
                " | Year: " + year +
                " | Email: " + email +
                " | Phone: " + phone;
    }
}