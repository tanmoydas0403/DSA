package com.tanmoy;

import java.util.Scanner;

public class Program1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the name: ");
        String name=in.next();

        System.out.println("Enter the department: ");
        String department=in.next();

//        switch (name){
//            case "Tanmoy" -> System.out.println("Title is: Das");
//            case "Subhajit" -> System.out.println("Title is : Misra");
//            case "Subha" -> System.out.println("Title is: Biswas");
//            default -> System.out.println("No entry available");
//        }

        switch (name) {
            case "Tanmoy":
                switch (department) {
                    case "IT":
                        System.out.println("Name is: " + name + " Das");
                        break;
                    case "Managment":
                        System.out.println("Name is: " + name + " Roy");
                        break;
                    default:
                        System.out.println("No records");
                }
                break;
            case "Subhajit":
                System.out.println("Title is : Misra");
                break;
            case "Subha":
                System.out.println("Title is: Biswas");
                break;
            default:
                System.out.println("No Entry available");
                break;
        }
    }
}
