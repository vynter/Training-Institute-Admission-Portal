package com.example.medicalrecordapp.Model;

import java.sql.SQLException;
import java.util.Scanner;

public class Home {
    public static void HomePage() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("What do you want to perform?");
        System.out.println("Enter 1 for displaying the existing data");
        System.out.println("Enter 2 for entering new data");

        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                Show.ShowPage();
                break;
            case 2:
                Enter.EnterPage();
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }
}