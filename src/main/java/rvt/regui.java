package rvt;

import java.util.Scanner;

public class regui {
    regprog prog = new regprog();
    Scanner scanner = new Scanner(System.in);

    public void start() {
        String[] comands = { "end", "add", "remove", "list", "help", "change" };
        Boolean end = false;
        System.out.print("available comands: ");
        for (int i = 0; i < comands.length; i++) {
            if (i == comands.length-1) {
                System.out.print(comands[i] + "\n");
            } else {
                System.out.print(comands[i] + " | ");
            }
        }
        while (true) {
            System.out.println("Enter comand : ");
            String caller = scanner.nextLine();
            for (int i = 0; i < comands.length; i++) {
                if (caller.equals(comands[i])) {
                    if (i == 0) {
                        end = true;
                    }
                    prog.end();
                    break;
                }
                if (caller.equals(comands[1])) {
                    prog.add();
                    break;
                }
                if (caller.equals(comands[2])) {
                    prog.remove();
                    break;
                }
                if (caller.equals(comands[3])) {
                    prog.list();
                    break;
                }
                if (caller.equals(comands[4])) {
                    prog.help();
                    break;
                }
                if (caller.equals(comands[5])) {
                    prog.change();
                    break;
                }
            }
            if (end) {
                break;
            }

            System.out.println("Enter command");
        }
    }
}
