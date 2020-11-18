package algorithms.other;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
    Copy paste the following solution,
    or any other valid or invalid solution to the console after running the program
    to see how the program works
    
2 1 4 7 8 9 3 6 5
3 7 8 1 6 5 2 4 9
6 5 9 2 3 4 1 7 8
7 2 1 3 4 8 5 9 6
4 3 6 9 5 1 7 8 2
8 9 5 6 2 7 4 1 3
1 4 2 5 9 6 8 3 7
9 8 3 4 7 2 6 5 1
5 6 7 8 1 3 9 2 4

 */

public class SudokuValidator {
    public static void main(String[] args) {
        // Read a Sudoku solution
        int[][] grid = readSolutionFromInput();
        
        if (isCorrectSolution(grid))
            System.out.println("Congratulations, the solution is correct.");
    }
    
    /**
     * Reads the solution supplied by the user from console
     */
    public static int[][] readSolutionFromInput() {
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Sudoku solution checking program.");
        System.out.println("Grid will be populated left to right, top to bottom");
        System.out.println("Please enter a complete sudoku grid that you want to check:");
        int[][] grid = new int[9][9];
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++)
                grid[row][column] = input.nextInt();
        }
        
        System.out.println("Grid to be checked: ");
        printGrid(grid);
        
        return grid;
    }
    
    public static void printGrid(int[][] grid) {
        for (int row = 0; row < 9; row++) {
            System.out.print("\n" + (((row + 1) % 3 == 0) ? "_" : " "));
            for (int column = 0; column < 9; column++) {
                System.out.printf("%2d", grid[row][column]);
                if ((column + 1) % 3 == 0)
                    System.out.print("|");
            }
        }
        System.out.println();
    }
    
    public static boolean isCorrectSolution(int[][] grid) {
        return checkRows(grid) && checkColumns(grid) && checkMatrix(grid);
    }
    
    public static boolean checkRows(int[][] grid) {
        for (int row = 0; row < 9; row++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int column = 0; column < 9; column++) {
                
                int currentNum = grid[row][column];
                if (!checkRange(currentNum)) return false;
                if (rowSet.contains(currentNum)) {
                    System.out.printf("Error in row %d, duplicate number %d found.", row, currentNum);
                    return false;
                }
                rowSet.add(currentNum);
                
            }
        }
        return true;
    }
    
    public static boolean checkColumns(int[][] grid) {
        for (int column = 0; column < 9; column++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int row = 0; row < 9; row++) {
                
                int currentNum = grid[row][column];
                if (rowSet.contains(currentNum)) {
                    System.out.printf("Error in column %d, duplicate number %d found.", column, currentNum);
                    return false;
                }
                rowSet.add(currentNum);
            }
            
        }
        return true;
    }
    
    public static boolean checkMatrix(int[][] grid) {
        for (int matrixRow = 0; matrixRow < 3; matrixRow++) {
            for (int matrixColumn = 0; matrixColumn < 3; matrixColumn++) {
                
                Set<Integer> matrix = new HashSet<>();
                for (int row = matrixRow * 3; row < matrixRow * 3 + 3; row++) {
                    for (int column = matrixColumn * 3; column < matrixColumn * 3 + 3; column++) {
                        
                        int currentNum = grid[row][column];
                        if (matrix.contains(currentNum)) {
                            System.out.printf("Error in matrix, duplicate number %d found in row %d, column %d.", currentNum, row, column);
                            return false;
                        }
                        matrix.add(currentNum);
                        
                    }
                }
                
            }
        }
        return true;
    }
    
    public static boolean checkRange(int num) {
        if (num < 1 || num > 9) {
            System.out.println("Invalid grid, only numbers 1-9 are accepted");
            return false;
        }
        return true;
    }
}
