package org.example;

import org.example.Exceptions.InvalidGridSizeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GridTest {

    @Test
    public void testGridCreationWithProperSize() {
        assertDoesNotThrow(() -> {
            new Grid(3,3,50.0);
        });
    }

    @Test
    public void testInvalidGridSizeException() {
        assertThrows(InvalidGridSizeException.class , () -> {
            new Grid(2,2,50.0);
        });
    }

    @Test
    public void testValidGridWhenPercentageIs20() {
        Grid grid = new Grid(5,5,20.0);
        int expectedAliveCount = 0;
        for(int i = 0;i<5;i++){
            for(int j = 0;j<5;j++){
                if(grid.checkCellStatus(i,j)) expectedAliveCount++;
            }
        }

        assertEquals(expectedAliveCount,5);
    }

    @Test
    public void testValidGridWhenPercentageIs1() {
        Grid grid = new Grid(5,5,1.0);
        int expectedAliveCount = 0;
        for(int i = 0;i<5;i++){
            for(int j = 0;j<5;j++){
                if(grid.checkCellStatus(i,j)) expectedAliveCount++;
            }
        }

        assertEquals(expectedAliveCount,0);
    }

    @Test
    public void testGridInitializationUsingCellStatus() {
        Grid grid = new Grid(3,3,1.0);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertFalse(grid.checkCellStatus(i, j));
            }
        }
    }

    @Test
    public void testDisplayGridWthProperSize() {
        Grid grid = spy(new Grid(3,3,50.0));
        grid.displayGrid();
        verify(grid,times(9)).checkCellStatus(anyInt(), anyInt());
    }

    @Test
    public void testGridStatusCheckingCellStatusWithZeroCellsAlive() {
        Grid grid = spy(new Grid(3,3,0.0));
        grid.checkGridStatus();
        verify(grid,times(9)).checkCellStatus(anyInt(), anyInt());
    }


}