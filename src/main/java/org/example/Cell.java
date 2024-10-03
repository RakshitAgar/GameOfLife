package org.example;

public class Cell {
    private boolean isAlive;

    public Cell() {
        this.isAlive = false;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void changeCellState(boolean cellState) {
        this.isAlive = cellState;
    }

    public boolean determineNextState(int aliveNeighbors) {
        if (isAlive) {
            // Survival rules
            return aliveNeighbors == 2 || aliveNeighbors == 3;
        } else {
            // Birth rule
            return aliveNeighbors == 3;
        }
    }
}