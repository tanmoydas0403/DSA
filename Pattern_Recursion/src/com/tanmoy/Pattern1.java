package com.tanmoy;

public class Pattern1 {
    public static void main(String[] args) {
        print(4);
        triangle(4, 0);
    }

    static void print(int size){
        if(size == 0){
            return;
        }
        print1(size);
        System.out.println();
        print(--size);
    }

    static void print1(int count){
        if(count == 0){
            return;
        }
        System.out.print("* ");
        print1(--count );
    }

    static void triangle(int row, int col){
        if(row == 0){
            return;
        }

        if(col < row){
            System.out.print("* ");
            triangle(row, col + 1);
        }else{
            System.out.println();
            triangle(row - 1, 0);
        }
    }
}
