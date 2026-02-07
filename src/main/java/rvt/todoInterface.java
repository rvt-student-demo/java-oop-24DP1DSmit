package rvt;

import java.util.Scanner;

public class todoInterface {
    private todo todoList;
    private Scanner scanner;

    public todoInterface(todo todoList, Scanner scanner) {
        this.todoList = todoList;
        this.scanner = scanner;
    }

    public void start() {
        while (true) {
            System.out.println("\nEnter a command (add/list/remove/stop): ");
            String command = scanner.nextLine();

            if (command.equals("stop")) {
                System.out.println("Exiting the program.");
                break;
            } else if (command.equals("add")) {
                System.out.println("Enter the task to be added: ");
                String task = scanner.nextLine();
                todoList.add(task);
                System.out.println("Task added successfully.");
            } else if (command.equals("list")) {
                System.out.println("Tasks on the to-do list:");
                todoList.list();
            } else if (command.equals("remove")) {
                System.out.println("Enter the id of the task to be removed: ");
                try {
                    int id = Integer.parseInt(scanner.nextLine());
                    todoList.remove(id);
                    System.out.println("Task removed successfully.");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid ID. Please enter a number.");
                }
            } else {
                System.out.println("Unknown command. Please enter add, list, remove, or stop.");
            }
        }
    }
}