package rvt;

public class App {
    public static void main(String[] args) {
        todo myObj = new todo();
        myObj.add("Task ex1");
        myObj.add("Task ex2");
        myObj.add("Task ex3");

        myObj.list();

        myObj.remove(2);

        myObj.list();
    }
}
