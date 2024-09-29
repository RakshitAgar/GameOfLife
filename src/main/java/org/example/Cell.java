package org.example;

public class Cell {
    private boolean isAlive;

    public Cell() {
        this.isAlive = false;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void changeCellStatus(boolean cellState) {
        this.isAlive = cellState;
    }

}
