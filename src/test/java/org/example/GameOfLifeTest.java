package org.example;

import org.example.Exceptions.InvalidGridSizeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameOfLifeTest {

    @Test
    public void testInValidGridException(){
        assertThrows(InvalidGridSizeException.class, () -> {new GameOfLife(2,2,10.0);});
    }

    @Test
    public void testInValidGridSizeException2rows3cols(){
        assertThrows(InvalidGridSizeException.class, () -> {new GameOfLife(2,3,10.0);});
    }



}