package com.example.medicalrecordapp.util;

import java.util.Scanner;

public class Util {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getIntInput(String prompt) {
        System.out.print(prompt + " ");
        return scanner.nextInt();
    }

    public static String getStringInput(String prompt) {
        System.out.print(prompt + " ");
        scanner.nextLine(); // Consume the newline character from previous input
        return scanner.nextLine();
    }

    public static void closeScanner() {
        scanner.close();
    }
}
