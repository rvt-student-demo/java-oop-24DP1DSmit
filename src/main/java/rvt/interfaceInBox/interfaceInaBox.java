package rvt.interfaceInBox;

import java.util.ArrayList;

public class interfaceInaBox {
    public interface Packable {
        double weight();
    }

    public class Book implements Packable {
        private String author;
        private String name;
        private double weight;

        public Book(String author, String name, double weight) {
            this.author = author;
            this.name = name;
            this.weight = weight;
        }

        @Override
        public double weight() {
            return this.weight;
        }

        @Override
        public String toString() {
            return this.author + ": " + this.name;
        }
    }

    public class CD implements Packable {
        private String artist;
        private String name;
        private int year;

        public CD(String artist, String name, int year) {
            this.artist = artist;
            this.name = name;
            this.year = year;
        }

        @Override
        public double weight() {
            return 0.1;
        }

        @Override
        public String toString() {
            return this.artist + ": " + this.name + " (" + this.year + ")";
        }
    }

    public class Box implements Packable {
        private double maxCapacity;
        private ArrayList<Packable> items;

        public Box(double maxCapacity) {
            this.maxCapacity = maxCapacity;
            this.items = new ArrayList<>();
        }

        // Aprēķina kopējo svaru katru reizi, kad tas nepieciešams
        @Override
        public double weight() {
            double totalWeight = 0;
            for (Packable item : items) {
                totalWeight += item.weight();
            }
            return totalWeight;
        }

        public void add(Packable item) {
            // Pārbaude: vai jaunais objekts nepārsniegs ietilpību?
            if (this.weight() + item.weight() <= this.maxCapacity) {
                this.items.add(item);
            }
        }

        @Override
        public String toString() {
            return "Box: " + this.items.size() + " items, total weight " + this.weight() + " kg";
        }
    }

    public static void main(String[] args) {
        interfaceInaBox program = new interfaceInaBox();
        
        Box box = program.new Box(10);
        Book book1 = program.new Book("J.K. Rowling", "Harry Potter", 0.8);
        Book book2 = program.new Book("George R.R. Martin", "A Song of Ice and Fire", 1.5);
        CD cd1 = program.new CD("Metallica", "Master of Puppets", 1986);
        
        box.add(book1);
        box.add(book2);
        box.add(cd1);
        
        System.out.println(book1);
        System.out.println(book2);
        System.out.println(cd1);
        System.out.println(box);
    }
}
