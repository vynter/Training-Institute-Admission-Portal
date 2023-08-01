package com.example.medicalrecordapp.Main;

import java.sql.SQLException;
import java.util.Scanner;

import com.example.medicalrecordapp.Model.Login;
import com.example.medicalrecordapp.Model.SignUp;

public class Main {

    public static void main(String args[]) throws SQLException {
        System.out.println("Welcome!");
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 1 to login");
        System.out.println("Enter 2 to SignUp");
        int choice = sc.nextInt();

        switch (choice) 
		{
            case 1:
                try {
                    Login.LoginPage();
                } catch (ClassNotFoundException e) {
                    System.out.println("Error: Class not found - " + e.getMessage());
                }
                break;
            case 2:
                try {
                    SignUp.SignUpPage();
                } catch (ClassNotFoundException e) {
                    System.out.println("Error: Class not found - " + e.getMessage());
                }
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
}
