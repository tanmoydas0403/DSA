package com.tanmoy;

import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(true){
            int result=0;
            System.out.print("Enter the operator: ");
            char ch = in.next().trim().charAt(0);
            if(ch=='+'||ch=='-'||ch=='/'||ch=='*'||ch=='%'){
                System.out.print("Enter the 1st Number: ");
                int a = in.nextInt();
                System.out.print("Enter the 2nd Number: ");
                int b= in.nextInt();

                if(ch=='+'){
                    result = a+b;
                } else if (ch=='-') {
                    result = a-b;
                } else if (ch=='*') {
                    result = a*b;
                }else if(ch == '/'){
                    if(b!=0){
                        result = a/b;
                    }else {
                        System.out.println("Cannot Divided by Zero");
                    }
                }else {
                    result = a%b;
                }
            }else if(ch=='x'||ch=='X'){
                break;
            }else{
                System.out.println("Invalid Input");
            }
            System.out.println("Result is: "+result);
            System.out.println("If you end calculation press x or X");
        }
        System.out.println("Program End");
    }
}
