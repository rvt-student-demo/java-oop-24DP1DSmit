package rvt;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class todo {
    public void add(String task) {
        try {
            FileWriter myWriter = new FileWriter("data/todo.csv", true);
            myWriter.write("Files in Java might be tricky, but it is fun enough!");
            myWriter.close();
        } catch (Exception e) {
           System.out.println("Error " + e.getMessage());
        }
    }

    public void list() {
        try (Scanner reader = new Scanner(new File("data/todo.csv"))) {
            // Skip header line
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    public void remove(int id) {

    }
}