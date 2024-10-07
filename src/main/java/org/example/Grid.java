package org.example;

import org.example.Exceptions.InvalidGridSizeException;
import org.example.Exceptions.InvalidPercentageException;
import java.util.Random;

public class Grid {
    private Cell[][] cells;
    private int rows;
    private int cols;

    public Grid(int rows, int cols, Double seedPercentage) throws InvalidGridSizeException {
        if (rows < 3 || cols < 3) {
            throw new InvalidGridSizeException("Grid size must be at least 3x3");
        }
        if(seedPercentage < 0 || seedPercentage > 100) {
            throw new InvalidPercentageException("Seed percentage must be between 0 and 100");
        }
        this.rows = rows;
        this.cols = cols;
        cells = new Cell[rows][cols];
        initializeGrid(seedPercentage);
        assignNeighbors();
    }

    private void initializeGrid(double seedPercentage) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j] = new Cell();
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
                cells[randomRow][randomCol].changeCellState(true);
                aliveCells++;
            }
        }
    }

    public void evolve() {
        Cell[][] nextGeneration = new Cell[rows][cols];

        // Initialize new cells
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                nextGeneration[i][j] = new Cell();
            }
        }

        // Calculate next generation
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                boolean nextState = cells[row][col].determineNextState();
                nextGeneration[row][col].changeCellState(nextState);
            }
        }

        // Update cells
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                cells[row][col].changeCellState(nextGeneration[row][col].isAlive());
            }
        }
    }

    public boolean hasAliveCells() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (cells[i][j].isAlive()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void displayGrid() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(cells[row][col].isAlive() ? "■ " : "□ ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void assignNeighbors() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Cell cell = cells[row][col];

                // Assign all 8 neighbors (account for edges with modulo operator)
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (i == 0 && j == 0) continue; // Skip the current cell

                        int neighborRow = (row + i + rows) % rows;
                        int neighborCol = (col + j + cols) % cols;
                        cell.addNeighbor(cells[neighborRow][neighborCol]);
                    }
                }
            }
        }
    }

}