package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameOfLifeTest {

    @Test
    public void testBasicGridForOneCellAlive(){
        GameOfLife gameOfLife = new GameOfLife(3);
        Grid deadGrid = new Grid(3,3);
        List<int[]> initialCellAlive = new ArrayList<>();
        initialCellAlive.add(new int[]{1,1});

        gameOfLife.startGame(initialCellAlive);

    }

}