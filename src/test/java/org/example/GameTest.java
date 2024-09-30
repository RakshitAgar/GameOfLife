package org.example;

import org.example.Exceptions.InvalidGridSizeException;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GameTest {

    @Test
    public void testInValidGridException(){
        Scanner scanner = new Scanner(System.in);
        assertThrows(InvalidGridSizeException.class, () -> {new Game(2,2,10.0,scanner);});
    }

    @Test
    public void testInValidGridSizeException2rows3cols(){
        Scanner scanner = new Scanner(System.in);
        assertThrows(InvalidGridSizeException.class, () -> {new Game(2,3,10.0,scanner);});
    }

    @Test
    public void testWhenGridHasZeroCellAlive() {
        Scanner scanner = new Scanner(System.in);
        Game game = spy(new Game(4,4,1.0,scanner));
        game.startGame();
        verify(game,times(0)).evolve();
    }

    @Test
    public void testGameGridAfterOneEvolveOnly() {
        Scanner mockedScanner = mock(Scanner.class);
        when(mockedScanner.nextLine())
                .thenReturn("")
                .thenReturn("q");
        // Going to two generation then stopping
        Game game = spy(new Game(4,4,25.0,mockedScanner));
        game.startGame();
        verify(game,times(1)).evolve();
    }

    @Test
    public void testGameGridWithQuitOnFirstChance() {
        Scanner mockedScanner = mock(Scanner.class);
        when(mockedScanner.nextLine())
        .thenReturn("q");
        Game game = spy(new Game(4,4,30.0,mockedScanner));
        game.startGame();

        //evolve is not called once
        verify(game,times(0)).evolve();
    }





}