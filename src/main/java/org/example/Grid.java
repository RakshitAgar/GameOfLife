package org.example;

import org.example.Exceptions.InvalidGridSizeException;
import java.util.Random;

public class Grid {
    private Cell[][] cells;
    private int rows;
    private int cols;

    public Grid(int rows, int cols, Double seedPercentage) throws InvalidGridSizeException {
        if (rows < 3 || cols < 3) {
            throw new InvalidGridSizeException("Grid size must be at least 3x3");
        }
        this.rows = rows;
        this.cols = cols;
        cells = new Cell[rows][cols];
        initializeGrid(seedPercentage);
    }

    private void initializeGrid(double seedPercentage) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j] = new Cell();  // Initialize each cell
            }
        }

        int totalCells = rows * cols;
        int aliveCellsCount = (int) (totalCells * (seedPercentage / 100));
        Random random = new Random();
        int aliveCells = 0;

        while (aliveCells < aliveCellsCount) {
            int randomRow = random.nextInt(rows);
            int randomCol = random.nextInt(cols);

            if (!cells[randomRow][randomCol].isAlive()) {
                cells[randomRow][randomCol].setCellStatus(true);
                aliveCells++;
            }
        }
    }

    public boolean checkCellStatus(int row, int col) {
        return cells[row][col].isAlive();
    }

    public void setCellStatus(int row, int col, boolean status) {
        cells[row][col].setCellStatus(status);
    }

    public boolean checkGridStatus() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (checkCellStatus(i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void displayGrid() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(checkCellStatus(row, col) ? "■ " : "□ ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
