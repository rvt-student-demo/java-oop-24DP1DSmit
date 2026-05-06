package rvt;

import javax.swing.JFrame;

public class masivi {
    public static void main() {
        System.out.println("row, column, value");
        int rows = 2;
        int columns = 3;
        int[][] twoDimensionalArray = new int[rows][columns];
        for (int row = 0; row < twoDimensionalArray.length; row++) {
            for (int column = 0; column < twoDimensionalArray[row].length; column++) {
                int value = twoDimensionalArray[row][column];
                System.out.println("" + row + ", " + column + ", " + value);
            }
        }
    }
}
