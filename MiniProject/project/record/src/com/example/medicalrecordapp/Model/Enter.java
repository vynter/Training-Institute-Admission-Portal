package com.example.medicalrecordapp.Model;

import java.util.Scanner;

public class Enter{

    public static void EnterPage()
    {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter which data do you want to Enter");
        System.out.println("Enter 1 to enter the Student Details");
        System.out.println("Enter 2 to enter the Medical Details");
        System.out.println("Enter 3 to enter the Physical Details");

        int option=sc.nextInt();
        switch (option) {
            case 1:
                Student.studentPage();
                break;
            case 2:
                // Student.StudentPage();
                Medical.MedicalPage();
                break;
            case 3:
                // Student.StudentPage();
                Physical.PhysicalPage();
                break;
        
            default:
                System.out.println("Invalid input....");
                EnterPage();
                break;
        }
    }
}