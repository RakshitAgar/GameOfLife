package org.example;

import org.example.Exceptions.InvalidGridSizeException;
import org.example.Grid;

import java.util.Scanner;

public class Game {
    private Grid grid;
    private Scanner scanner;

    public Game(int row, int column, Double seedPercentage, Scanner scanner) throws InvalidGridSizeException {
        this.scanner = scanner;
        this.grid = new Grid(row, column, seedPercentage);
    }

    public void startGame() {
        int generation = 0;
        boolean hasAliveCells = grid.hasAliveCells();

        while (hasAliveCells) {
            System.out.println("Generation #" + generation);
            grid.displayGrid();
            System.out.println("Press Enter to continue or type 'q' to quit:");

            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                break;
            }

            grid.evolve();
            hasAliveCells = grid.hasAliveCells();
            generation++;
        }

        if (!hasAliveCells) {
            System.out.println("All cells are dead.");
        }
    }
}