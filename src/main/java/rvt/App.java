package rvt;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        todo todoList = new todo();
        Scanner scanner = new Scanner(System.in);
        
        todoInterface ui = new todoInterface(todoList, scanner);
        ui.start();
        
        scanner.close();
    }
}
