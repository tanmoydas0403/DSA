package com.tanmoy;

import java.io.*;

public class Main {
    public static void main(String[] args) {
//        try(InputStreamReader isr = new InputStreamReader(System.in)){
//            System.out.println("Enter some letters: ");
//            int letters = isr.read();
//            while(isr.ready()){
//                System.out.println((char) letters);
//                letters = isr.read();
//            }
//            System.out.println();
//        }catch (IOException io){
//            io.printStackTrace();
//        }
//
//        try(FileReader fr = new FileReader("input.txt")){
//            System.out.println("Enter some letters: ");
//            int letters;
//            while ((letters = fr.read()) != -1) {
//                System.out.print((char) letters);
//            }
//            System.out.println();
//        }catch (IOException io){
//            io.printStackTrace();
//        }

//        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){
//            System.out.println("You typed: " + br.readLine());
//        }catch (IOException io){
//            io.printStackTrace();
//        }

//        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                // You can process the line here if needed
//                System.out.println(line);
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

//        try(OutputStreamWriter osw = new OutputStreamWriter(System.out)){
//            osw.write("Hello my name is Tanmoy");
//            osw.write("\n");
//            osw.write(97);
//            osw.flush();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        try(FileWriter fw = new FileWriter("output.txt", true)){
//            fw.write("Hello my name is Tanmoy");
//            fw.write("\n");
//            fw.write(97);
//            fw.write("\n");
//            fw.flush();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))){
            bw.write("Jai Shree Ram");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
