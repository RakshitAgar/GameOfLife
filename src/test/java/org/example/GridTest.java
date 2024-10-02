package org.example;

import org.example.Exceptions.InvalidGridSizeException;
import org.example.Exceptions.InvalidPercentageException;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {

    @Test
    public void testGridCreationWithProperSize() {
        assertDoesNotThrow(() -> {
            new Grid(3,3,50.0);
        });
    }

    @Test
    public void testLargeGridCreationWithProperSize() {
        Grid grid = new Grid(100, 100, 50.0);
        assertTrue(grid.hasAliveCells());
    }

    @Test
    public void testAsymmetricGridCreation() {
        Grid grid = new Grid(3, 5, 50.0);
        assertTrue(grid.hasAliveCells());
    }

    @Test
    public void testInvalidGridSizeException() {
        assertThrows(InvalidGridSizeException.class , () -> {
            new Grid(2,2,50.0);
        });
    }

    @Test
    public void testPercentageLessThanZeroException() {
        assertThrows(InvalidPercentageException.class , () -> {
            new Grid(10,20,-50.0);
        });
    }

    @Test
    public void testPercentageGreaterThan100Exception() {
        assertThrows(InvalidPercentageException.class , () -> {
            new Grid(10,20,150.0);
        });
    }

    @Test
    public void testValidGridWhenPercentageIs20() {
        Grid grid = new Grid(5,5,20.0);
        assertTrue(grid.hasAliveCells());
    }

    @Test
    public void testValidGridWhenPercentageIs1() {
        Grid grid = new Grid(5,5,1.0);
        assertFalse(grid.hasAliveCells());
    }


    @Test
    public void testGridDisplay() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Grid grid = new Grid(3,3,0.0);
        grid.displayGrid();

        String expectedOutput = "□ □ □ \n□ □ □ \n□ □ □ \n\n";
        assertEquals(expectedOutput,outContent.toString());

        System.setOut(System.out);
    }

    @Test
    public void testMultipleEvolveWithAliveCells() {
        Grid grid = new Grid(4,4,50.0);
        grid.evolve();
        grid.evolve();
        assertTrue(grid.hasAliveCells());
    }

    @Test
    public void testGridEvolveWithCellsAlive() {
        Grid grid = new Grid(4,4,50.0);
        grid.evolve();
        assertTrue(grid.hasAliveCells());
    }

    @Test
    public void testGridEvolveWithZeroCellAlive() {
        Grid grid = new Grid(4,4,0.0);
        grid.evolve();
        assertFalse(grid.hasAliveCells());
    }

    @Test
    public void testGridEvolveFunctionWithZeroAliveCellsAfterMultipleEvolve(){
        Grid grid = new Grid(4, 4, 0.0);
        assertFalse(grid.hasAliveCells());

        grid.evolve();
        assertFalse(grid.hasAliveCells());

        for (int i = 0; i < 5; i++) {
            grid.evolve();
            assertFalse(grid.hasAliveCells());
        }
    }


}