package rvt.studentRegistration;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class regprog {
    Scanner scanner = new Scanner(System.in);

    public void end() {
        System.out.println("Ending ...");
    }

    public void add() {
        System.out.println("Enter text : ");
        String[] mass = { "vards", "uzvards", "personas kods", "epasts", "registracijas laiks" };
        String line = "";
        for (int index = 0; index < mass.length - 1; index++) {
            System.out.print("Tagat jāievada - " + mass[index] + " :");
            String text = scanner.nextLine();
            line = line + text + ",";
        }
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        line = line + formattedDate;

        System.out.println("Jūs ievadījāt: " + line);
        addwriter(line);
    }

    public void addwriter(String line) {
        try (FileWriter writer = new FileWriter("data/reg.csv", true)) {
            writer.write("\n" + line);
            System.out.println("Successfully appended to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void list() {
        File myFile = new File("data/reg.csv");
        System.out.println("");
        System.out.println("");
        try (Scanner reader = new Scanner(myFile)) {
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println();
        System.out.println();
    }

    public void help() {
        System.out.println();
        System.out.println();
        String[] comands = { "end", "add", "remove", "list", "help", "change" };
        System.out.print("available comands: ");
        for (int i = 0; i < comands.length; i++) {
            if (i == comands.length - 1) {
                System.out.print(comands[i] + "\n");
            } else {
                System.out.print(comands[i] + " | ");
            }
        }
        System.out.println();
        System.out.println();
    }

    public void remove() {
        System.out.println("removing");
        String persCodes = scanner.nextLine();
        ArrayList<String> stringi = new ArrayList<String>();
        File file = new File("data/reg.csv");
        try (Scanner myReader = new Scanner(file)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                stringi.add(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        String fileLine;
        String linePerCode;
        for (int index = 0; index < stringi.size(); index++) {
            fileLine = stringi.get(index);
            linePerCode = fileLine.split(",")[2];
            if (linePerCode.equals(persCodes)) {
                stringi.remove(index);
                break;
            }
        }
        try (FileWriter writer = new FileWriter("data/reg.csv", false)) {
            for (int index = 0; index < stringi.size(); index++) {
                if (index != stringi.size() - 1) {
                    writer.write(stringi.get(index) + "\n");

                } else {
                    writer.write(stringi.get(index));
                }
            }
            System.out.println("Successfully removed from the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void change() {
        System.out.println("changeing");
        String persCodes = scanner.nextLine();
        ArrayList<String> stringi = new ArrayList<String>();
        File file = new File("data/reg.csv");
        try (Scanner myReader = new Scanner(file)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                stringi.add(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        String fileLine;
        String linePerCode;
        for (int index = 0; index < stringi.size(); index++) {
            fileLine = stringi.get(index);
            linePerCode = fileLine.split(",")[2];
            if (linePerCode.equals(persCodes)) {
                stringi.remove(index);
                break;
            }
        }
        try (FileWriter writer = new FileWriter("data/reg.csv", false)) {
            for (int index = 0; index < stringi.size(); index++) {
                if (index != stringi.size() - 1) {
                    writer.write(stringi.get(index) + "\n");

                } else {
                    writer.write(stringi.get(index));
                }
            }
            System.out.println("Successfully removed from the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        add();
    }

}