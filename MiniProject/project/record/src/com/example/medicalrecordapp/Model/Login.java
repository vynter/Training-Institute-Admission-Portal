package com.example.medicalrecordapp.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {

    static String Driver = "com.mysql.cj.jdbc.Driver";
    static String URL = "jdbc:mysql://localhost:3306/medical?useSSL=false";
    static String USER = "root";
    static String PASSWORD = "tiger";

    public static boolean authenticate(String username, String password) throws ClassNotFoundException {
        Class.forName(Driver);

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = con.prepareStatement("SELECT * FROM login WHERE username = ?")) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String db_Password = rs.getString("password");
                return db_Password.equals(password);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void LoginPage() throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Student Health Record Application!");
        System.out.print("Enter the user name: ");
        String name = sc.nextLine();
        System.out.print("Enter the Password: ");
        String pass = sc.nextLine();

        if (authenticate(name, pass)) {
            Home.HomePage();
        } else {
            System.out.println("Invalid Credentials");
            System.out.println("Options:");
            System.out.println("1. Retry Login");
            System.out.println("2. Signup");
            System.out.print("Enter your option (1/2):");

            int option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1:
                    LoginPage();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
