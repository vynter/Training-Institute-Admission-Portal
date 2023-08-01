package com.example.medicalrecordapp.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Physical {
    public static void PhysicalPage() {
        // Get user input for physical details
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Blood Group: ");
        String bloodGroup = scanner.nextLine();

        System.out.print("Enter Height: ");
        String height = scanner.nextLine();

        System.out.print("Enter Weight: ");
        String weight = scanner.nextLine();

        // Perform database insert operation using JDBC
        try {
            // Replace the connection parameters with your MySQL credentials
            String url = "jdbc:mysql://localhost:3306/medical?useSSL=false";
            String user = "root";
            String password = "tiger";

            Connection connection = DriverManager.getConnection(url, user, password);

            // SQL query to insert data into the database
            String insertQuery = "INSERT INTO phy_detail (StudentId, Age, BloodGroup, Height, Weight) " +
                    "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, studentId);
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3, bloodGroup);
            preparedStatement.setString(4, height);
            preparedStatement.setString(5, weight);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Physical details inserted successfully!");
                // Show.ShowPage();
                System.out.println("What next?");
                System.out.println("Enter another data(1)");
                System.out.println("View Data(2)");
                System.out.println("Exit(3)");



                int num=scanner.nextInt();
                
                switch (num) {
                    case 1:
                        Enter.EnterPage();
                        break;
                    case 2:
                        // Enter.EnterPage();
                        Show.ShowPage();
                        break;
                    case 3:
                        // Enter.EnterPage();
                        System.out.println("Thanks for Visiting!");
                        break;
                
                    default:
                        System.out.println("Invalid Input....");
                        PhysicalPage();
                        break;
                }

            } else {
                System.out.println("Failed to insert physical details.");
            }

            // Close the resources
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
