package org.example;

import org.example.Exceptions.InvalidGridSizeException;
import java.util.Scanner;

public class GameOfLife {
    private Grid grid;
    private int row;
    private int column;
    private Scanner scanner;

    public GameOfLife(int row, int column, Double seedPercentage, Scanner scanner) throws InvalidGridSizeException {
        this.row = row;
        this.column = column;
        this.scanner = scanner;
        this.grid = new Grid(this.row, this.column, seedPercentage);
    }

    public void startGame() {
        int generation = 0;
        boolean hasAliveCells = grid.checkGridStatus();

        while (hasAliveCells) {
            hasAliveCells = grid.checkGridStatus();
            System.out.println("Generation #" + generation);
            grid.displayGrid();
            System.out.println("Press Enter to continue or type 'q' to quit:");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                break;
            }
            evolve();
            generation++;
        }
        if (!hasAliveCells) {
            System.out.println("All cells are dead.");
        }
    }

    public void evolve() {
        int rows = this.row;
        int cols = this.column;
        boolean[][] nextGeneration = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int aliveNeighbors = countAliveNeighbors(row, col);
                boolean currentState = grid.checkCellStatus(row, col);

                if (currentState && (aliveNeighbors == 2 || aliveNeighbors == 3)) {
                    nextGeneration[row][col] = true;
                } else if (!currentState && aliveNeighbors == 3) {
                    nextGeneration[row][col] = true;
                } else {
                    nextGeneration[row][col] = false;
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                grid.setCellStatus(row, col, nextGeneration[row][col]);
            }
        }
    }

    private int countAliveNeighbors(int row, int col) {
        int count = 0;
        int rows = this.row;
        int cols = this.column;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int newRow = (row + i + rows) % rows;
                int newCol = (col + j + cols) % cols;
                if (grid.checkCellStatus(newRow, newCol)) {
                    count++;
                }
            }
        }
        return count;
    }
}
