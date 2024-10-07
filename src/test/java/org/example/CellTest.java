package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {
    @Test
    public void testCellChangeState() {
        Cell deadCell = new Cell();

        assertFalse(deadCell.isAlive());
        deadCell.changeCellState(true);
        assertTrue(deadCell.isAlive());
    }

    @Test
    public void testCellStageByAliveNeighborsOfDeadCellWith3Neighbour() {
        Cell deadCell = new Cell();
        Cell firstAliveCell = new Cell();
        Cell secondAliveCell = new Cell();
        Cell thirdAliveCell = new Cell();
        firstAliveCell.changeCellState(true);
        secondAliveCell.changeCellState(true);
        thirdAliveCell.changeCellState(true);

        deadCell.addNeighbor(firstAliveCell);
        deadCell.addNeighbor(secondAliveCell);
        deadCell.addNeighbor(thirdAliveCell);

        assertTrue(deadCell.determineNextState());
    }

    @Test
    public void testCellStageByAliveNeighborsOfDeadCellWith2Neighbour() {
        Cell deadCell = new Cell();
        Cell firstAliveCell = new Cell();
        Cell secondAliveCell = new Cell();
        firstAliveCell.changeCellState(true);
        secondAliveCell.changeCellState(true);

        deadCell.addNeighbor(firstAliveCell);
        deadCell.addNeighbor(secondAliveCell);

        assertFalse(deadCell.determineNextState());
    }

    @Test
    public void testCellStageByAliveNeighborsOfDeadCellWith4Neighbour() {
        Cell deadCell = new Cell();
        int aliveNeighbors = 4;
        assertFalse(deadCell.determineNextState());
    }

    @Test
    public void testCellStageByAliveNeighborsWith3AliveNeighbour() {
        Cell aliveCell = new Cell();
        aliveCell.changeCellState(true);
        Cell firstAliveCell = new Cell();
        Cell secondAliveCell = new Cell();
        Cell thirdAliveCell = new Cell();
        firstAliveCell.changeCellState(true);
        secondAliveCell.changeCellState(true);
        thirdAliveCell.changeCellState(true);

        aliveCell.addNeighbor(firstAliveCell);
        aliveCell.addNeighbor(secondAliveCell);
        aliveCell.addNeighbor(thirdAliveCell);

        assertTrue(aliveCell.determineNextState());
    }

    @Test
    public void testCellStageByAliveNeighborsWith2AliveNeighbour() {
        Cell aliveCell = new Cell();
        aliveCell.changeCellState(true);
        Cell firstAliveCell = new Cell();
        Cell secondAliveCell = new Cell();
        firstAliveCell.changeCellState(true);
        secondAliveCell.changeCellState(true);

        aliveCell.addNeighbor(firstAliveCell);
        aliveCell.addNeighbor(secondAliveCell);

        assertTrue(aliveCell.determineNextState());
    }

    @Test
    public void testCellStageByAliveNeighborsWith1AliveNeighbour() {
        Cell aliveCell = new Cell();
        aliveCell.changeCellState(true);

        assertFalse(aliveCell.determineNextState());
    }



}