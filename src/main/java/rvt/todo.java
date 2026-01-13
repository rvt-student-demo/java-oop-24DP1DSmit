package rvt;

import java.util.Scanner;
import java.io.File;

public class todo {
    public static void main(String[] args) {
        ex1();
    }

    public static void ex1() {
        System.out.println("Helpa izveide : help");
        System.out.println("Faila izvade : list");
        System.out.println("Pievienot pinktu: add");
        System.out.println("Pabegt programmas izpildi: stop");
        Scanner scanner = new Scanner(System.in);
        
        while(true){
        System.out.println("Ievadi komandu: ");
        String comand = String.valueOf(scanner.nextLine());
        scanner.close();

        if(comand.equals("help")){
            System.out.println("Helpa izveide : help");
            System.out.println("Faila izvade : list");
            System.out.println("Pievienot pinktu: add");
            System.out.println("Pabegt programmas izpildi: stop");
        } else if (comand.equals("add")){
            System.out.println("Ievadi jauno piezīmi: ");
            String newNote = String.valueOf(scanner.nextLine());
            try(java.io.FileWriter writer = new java.io.FileWriter("data/todo.csv", true)){
                writer.write(newNote + "\n");
            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
            }
           
        }else if (comand.equals("list")){
            try(Scanner reader = new Scanner(new File("data/file.csv"))){
                while (reader.hasNextLine()) {
                    System.out.println(reader.nextLine());
                }
            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
            }
        } else if (comand.equals("stop")){
            System.out.println("Programmas izpilde pabeigta.");
            break;
        }
        }


        // try(Scanner reader = new Scanner(new File("data/file.csv"))){
        //     while (reader.hasNextLine()) {
        //         System.out.println(reader.nextLine());
        //     }
        // } catch (Exception e) {
        //     System.out.println("Error " + e.getMessage());
        // }
    }

}
