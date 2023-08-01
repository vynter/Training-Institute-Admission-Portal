package com.example.medicalrecordapp.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHandler {
    private static final String URL = "jdbc:mysql://localhost:3306/medical?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "tiger";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
