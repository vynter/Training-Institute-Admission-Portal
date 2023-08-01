package com.example.medicalrecordapp.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Medical {
    public static void MedicalPage() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();

        System.out.print("Enter Medical ID: ");
        String medicalId = scanner.nextLine();

        System.out.print("Enter Illness: ");
        String illness = scanner.nextLine();

        System.out.print("Enter Medication: ");
        String medication = scanner.nextLine();

        // Close the scanner to avoid resource leak
        // scanner.close();

        // Save medical records to the database
        saveMedicalRecords(studentId, medicalId, illness, medication);
    }

    private static void saveMedicalRecords(String studentId, String medicalId, String illness, String medication) {
        Scanner sc=new Scanner(System.in);
        try {
            // Replace the connection parameters with your MySQL credentials
            String url = "jdbc:mysql://localhost:3306/medical?useSSL=false";
            String user = "root";
            String password = "tiger";
            Connection connection = DriverManager.getConnection(url, user, password);

            String sql = "INSERT INTO medical_recordss (StudentId, MedicalId, Illness, Medication) " +
                    "VALUES (?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, studentId);
            statement.setString(2, medicalId);
            statement.setString(3, illness);
            statement.setString(4, medication);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Medical records saved successfully.");
                // Show.ShowPage();
                System.out.println("What next?");
                System.out.println("Enter another data(1)");
                System.out.println("View Data(2)");
                System.out.println("Exit(3)");
                int num=sc.nextInt();



                // int num=sc.nextInt();
                
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
                        MedicalPage();
                        break;
                }
            } else {
                System.out.println("Failed to save medical records.");
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

