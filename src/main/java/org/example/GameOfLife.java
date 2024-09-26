package org.example;

import org.example.Exceptions.EmptyInputException;
import org.example.Exceptions.InvalidGridSizeException;

import java.util.List;

public class GameOfLife {
    private Grid grid;

    public GameOfLife(int gridSize) throws InvalidGridSizeException {
        if(gridSize <= 2) {
            throw new InvalidGridSizeException("Grid size must be greater than 2");
        }
        this.grid = new Grid(gridSize, gridSize);
    }

    private void setupInitialStage(List<int[]> aliveCells) throws EmptyInputException {
        if(aliveCells.isEmpty()) {
            throw new EmptyInputException("No cells are alive initially Game Stop");
        }
        for (int[] coordinates : aliveCells) {
            if (coordinates.length == 2) {
                int row = coordinates[0];
                int col = coordinates[1];
                grid.setCellAlive(row, col);
            } else {
                System.out.println("Invalid coordinates");
            }
        }
    }

    public void startGame(List<int[]> aliveCells) {
        // getting input from the user for the initial alive cells
        setupInitialStage(aliveCells);
    }


}
