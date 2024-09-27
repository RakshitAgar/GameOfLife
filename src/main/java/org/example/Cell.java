package org.example;

public class Cell {
    private boolean isAlive;

    public Cell(boolean cellState) {
        this.isAlive = cellState;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setCellStatus(boolean cellState) {
        this.isAlive = cellState;
    }

}
