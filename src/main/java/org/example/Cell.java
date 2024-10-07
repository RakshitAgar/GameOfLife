package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private boolean isAlive;
    private List<Cell> neighbors; // Store neighbors

    public Cell() {
        this.isAlive = false;
        this.neighbors = new ArrayList<>();
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void changeCellState(boolean cellState) {
        this.isAlive = cellState;
    }

    public boolean determineNextState() {
        int aliveNeighbors = countAliveNeighbors();

        if (isAlive) {
            // Survival rules
            return aliveNeighbors == 2 || aliveNeighbors == 3;
        } else {
            // Birth rule
            return aliveNeighbors == 3;
        }
    }

    private int countAliveNeighbors() {
        int count = 0;
        for (Cell neighbor : neighbors) {
            if (neighbor.isAlive()) {
                count++;
            }
        }
        return count;
    }

    public void addNeighbor(Cell neighbor) {
        this.neighbors.add(neighbor);
    }
}
