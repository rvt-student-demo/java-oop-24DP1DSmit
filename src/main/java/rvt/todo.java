package rvt;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class todo {
    public void add(String task) {
        try (FileWriter writer = new FileWriter("data/todo.csv", true)) {
            writer.write(task + "\n");
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    public void list() {
        try (Scanner reader = new Scanner(new File("data/todo.csv"))) {
            int id = 1;
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                System.out.println(id + ": " + line);
                id++;
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }


    public void remove(int id) {
        ArrayList<String> tasks = new ArrayList<>();
        try (Scanner reader = new Scanner(new File("data/todo.csv"))) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                tasks.add(line);
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
            return;
        }

  
        if (id < 1 || id > tasks.size()) {
            System.out.println("Invalid ID");
            return;
        }

        tasks.remove(id - 1);

        try (FileWriter writer = new FileWriter("data/todo.csv")) {
            for (String task : tasks) {
                writer.write(task + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}