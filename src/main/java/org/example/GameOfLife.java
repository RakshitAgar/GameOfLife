package org.example;

import org.example.Exceptions.InvalidGridSizeException;

import java.util.Scanner;

public class GameOfLife {
    private Grid grid;
    private int row;
    private int column;
    private Scanner scanner;

    public GameOfLife(int row, int column, Double seedPercentage) throws InvalidGridSizeException {
        this.row = row;
        this.column = column;
        this.scanner = new Scanner(System.in);
        this.grid = new Grid(this.row, this.column, seedPercentage);
    }


    public void startGame() {
        int generation = 0;
        boolean hasAliveCells = true;

        while(hasAliveCells) {
            hasAliveCells = grid.checkGridStatus();
            System.out.println("Generation #" + generation);
            grid.displayGrid();
            System.out.println("Press Enter to continue or type 'q' to quit:");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                break;
            }
            grid.evolve();
            generation++;
        }
        if(!hasAliveCells) {
            System.out.println("All cells are dead.");
        }
    }




}
