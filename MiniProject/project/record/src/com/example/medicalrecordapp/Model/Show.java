package com.example.medicalrecordapp.Model;

import java.sql.*;
import java.util.Scanner;

public class Show {
    static String Driver = "com.mysql.cj.jdbc.Driver";
    static String URL = "jdbc:mysql://localhost:3306/medical?useSSL=false";
    static String USER = "root";
    static String PASSWORD = "tiger";

    public static void ShowPage() {
        Scanner sc = new Scanner(System.in);
        try {
            // Load the driver
            Class.forName(Driver);

            // Establish the connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Prompt the user to enter the Student ID
            System.out.print("Enter Student ID: ");
            String studentId = sc.nextLine();

            // Query to retrieve data from the three tables using a JOIN
            String sql = "SELECT stud_detail.StudentId, Studentname, collegeName, department, class, EmergencyContact, " +
                    "Age, BloodGroup, Height, Weight, MedicalId, Illness, Medication " +
                    "FROM stud_detail " +
                    "LEFT JOIN phy_detail ON stud_detail.StudentId = phy_detail.StudentId " +
                    "LEFT JOIN medical_recordss ON stud_detail.StudentId = medical_recordss.StudentId " +
                    "WHERE stud_detail.StudentId = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, studentId);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Check if data is found for the provided Student ID
            if (resultSet.next()) {
                // Retrieve and display the data
                System.out.println("Student ID: " + resultSet.getString("StudentId"));
                System.out.println("Student Name: " + resultSet.getString("Studentname"));
                System.out.println("College Name: " + resultSet.getString("collegeName"));
                System.out.println("Department: " + resultSet.getString("department"));
                System.out.println("Class: " + resultSet.getString("class"));
                System.out.println("Emergency Contact: " + resultSet.getString("EmergencyContact"));
                System.out.println("Age: " + resultSet.getInt("Age"));
                System.out.println("Blood Group: " + resultSet.getString("BloodGroup"));
                System.out.println("Height: " + resultSet.getString("Height"));
                System.out.println("Weight: " + resultSet.getString("Weight"));
                System.out.println("Medical ID: " + resultSet.getString("MedicalId"));
                System.out.println("Illness: " + resultSet.getString("Illness"));
                System.out.println("Medication: " + resultSet.getString("Medication"));
                System.out.println("What next?");
                System.out.println("Enter another data(1)");
                System.out.println("View Data(2)");
                System.out.println("Exit(3)");

                int num = sc.nextInt();

                switch (num) {
                    case 1:
                        Enter.EnterPage();
                        break;
                    case 2:
                        Show.ShowPage();
                        break;
                    case 3:
                        System.out.println("Thanks for Visiting!");
                        break;
                    default:
                        System.out.println("Invalid Input....");
                        ShowPage();
                        break;
                }
            } else {
                System.out.println("No data found for the provided Student ID.");
            }

            // Close the result set, statement, and connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the scanner
            sc.close();
        }
    }
}
