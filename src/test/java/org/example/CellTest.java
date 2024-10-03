package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {
    @Test
    public void testCellStageByAliveNeighborsOfDeadCellWith3Neighbour() {
        Cell deadCell = new Cell();
        int aliveNeighbors = 3;
        assertTrue(deadCell.determineNextState(aliveNeighbors));
    }

    @Test
    public void testCellStageByAliveNeighborsOfDeadCellWith2Neighbour() {
        Cell deadCell = new Cell();
        int aliveNeighbors = 2;
        assertFalse(deadCell.determineNextState(aliveNeighbors));
    }

    @Test
    public void testCellStageByAliveNeighborsOfDeadCellWith4Neighbour() {
        Cell deadCell = new Cell();
        int aliveNeighbors = 4;
        assertFalse(deadCell.determineNextState(aliveNeighbors));
    }

    @Test
    public void testCellStageByAliveNeighborsWith3AliveNeighbour() {
        Cell aliveCell = new Cell();
        aliveCell.changeCellState(true);

        int aliveNeighbors = 3;
        assertTrue(aliveCell.determineNextState(aliveNeighbors));
    }

    @Test
    public void testCellStageByAliveNeighborsWith2AliveNeighbour() {
        Cell aliveCell = new Cell();
        aliveCell.changeCellState(true);

        int aliveNeighbors = 2;
        assertTrue(aliveCell.determineNextState(aliveNeighbors));
    }

    @Test
    public void testCellStageByAliveNeighborsWith1AliveNeighbour() {
        Cell aliveCell = new Cell();
        aliveCell.changeCellState(true);

        int aliveNeighbors = 1;
        assertFalse(aliveCell.determineNextState(aliveNeighbors));
    }

    @Test
    public void testCellStageByAliveNeighborsWith4AliveNeighbour() {
        Cell aliveCell = new Cell();
        aliveCell.changeCellState(true);

        int aliveNeighbors = 4;
        assertFalse(aliveCell.determineNextState(aliveNeighbors));
    }


}