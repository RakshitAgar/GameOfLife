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
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j] = new Cell(random.nextDouble() < seedPercentage);
            }
        }
    }

    public boolean checkCellStatus(int row, int col){
        return cells[row][col].isAlive();
    }

    private void setCellStatus(int row, int col, boolean status){
        cells[row][col].setCellStatus(status);
    }

    public void evolve() {
        boolean[][] nextGeneration = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int aliveNeighbors = countAliveNeighbors(row, col);
                boolean currentState = checkCellStatus(row, col);

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
                setCellStatus(row, col, nextGeneration[row][col]);
            }
        }
    }

    private int countAliveNeighbors(int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int newRow = (row + i + rows) % rows;
                int newCol = (col + j + cols) % cols;
                if (checkCellStatus(newRow, newCol)) {
                    count++;
                }
            }
        }
        return count;
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

    public boolean checkGridStatus(){
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(checkCellStatus(i,j)){
                    return true;
                }
            }
        }
        return false;
    }


}
