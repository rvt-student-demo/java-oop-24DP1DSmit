package rvt.onlineShop;

import java.util.Scanner;

public class onlineShop {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        
        warehouse.addProduct("milk", 2, 10);
        warehouse.addProduct("bread", 3, 8);
        warehouse.addProduct("cheese", 5, 5);
        warehouse.addProduct("eggs", 4, 12);
        
        Scanner scanner = new Scanner(System.in);
        Store store = new Store(warehouse, scanner);
        
        store.shop("John");
        
        scanner.close();
    }
}
