package com.example.medicalrecordapp.Model;

import com.example.medicalrecordapp.db.DBHandler;
import com.example.medicalrecordapp.util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Student {
    public static void studentPage() {
        String studentId = Util.getStringInput("Enter Student ID:");
        String studentName = Util.getStringInput("Enter Student Name:");
        String collegeName = Util.getStringInput("Enter College Name:");
        String department = Util.getStringInput("Enter Department:");
        String studentClass = Util.getStringInput("Enter Class:");
        String emergencyContact = Util.getStringInput("Enter Emergency Contact:");

        saveStudentDetails(studentId, studentName, collegeName, department, studentClass, emergencyContact);
    }

    private static void saveStudentDetails(String studentId, String studentName, String collegeName,
                                           String department, String studentClass, String emergencyContact) {
        try (Connection connection = DBHandler.getConnection()) {
            String sql = "INSERT INTO stud_detail (StudentId, Studentname, collegeName, department, class, EmergencyContact) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, studentId);
            statement.setString(2, studentName);
            statement.setString(3, collegeName);
            statement.setString(4, department);
            statement.setString(5, studentClass);
            statement.setString(6, emergencyContact);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Student details saved successfully.");
            } else {
                System.out.println("Failed to save student details.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
