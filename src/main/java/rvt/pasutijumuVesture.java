package rvt;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class pasutijumuVesture {
    public static void main(String[] args) {
        ex2();
    }

    public static void ex1() {
        try(Scanner reader = new Scanner(new File("data/file.csv"))){
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    public static void ex2() {
        try(Scanner reader = new Scanner(new File("data/file.csv"))){
            while (reader.hasNextLine()) {
                // System.out.println(reader.nextLine());
                String row = reader.nextLine();
                String[] parts = row.split(",");
                String name = parts[0];
                int age = Integer.valueOf(parts[1]);
                String email = parts[2];
                String course = parts[3];
                double gpa = Double.valueOf(parts[4]);
                System.out.println("Vārds :"+ name + ", vecums: " + age + ", epasts: " + email + ", kurss: " + course + ", GPA: " + gpa);
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}
