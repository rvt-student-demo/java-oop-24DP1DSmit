package rvt;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class regprog {
     Scanner scanner = new Scanner(System.in);
    // File text = new File("reg.csv");
    public void end() {
        System.out.println("Ending ...");
    }
    

    public void add() {
        System.out.println("Enter text : ");
        String text = scanner.nextLine();
        System.out.println("adding ...");
        addwriter(text);
    }
    public void addwriter(String text){
        try (FileWriter writer = new FileWriter("reg.csv", true)) {
            writer.write("\n" + text);
            System.out.println("Successfully appended to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    public void list() {
        System.out.println("listing");
        for (int i = 0; i < 8; i++) {
            System.out.println(i);
             String text = scanner.nextLine();
             if (text.equals("c")) {
                break;
             }
        }
    }

    public void help() {
        System.out.println("helping");
    }

    public void remove() {
        System.out.println("removing");
    }

    public void change() {
        System.out.println("changeing");
    }

}
