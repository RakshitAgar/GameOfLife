package org.example;

import org.example.Exceptions.InvalidGridSizeException;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GameTest {

    @Test
    public void testGameCreationWithValidParameters() {
        Scanner scanner = new Scanner(System.in);
        assertDoesNotThrow(() -> {
            new Game(3, 3, 50.0, scanner);
        });
    }


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
    public void testGameWithQuitInputAfterOneEvolve() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextLine()).thenReturn("q");

        Game game = new Game(3, 3, 50.0, mockScanner);
        game.startGame();

        // Verify that "Generation #0" was printed
        assertTrue(outContent.toString().contains("Generation #0"));
        assertTrue(outContent.toString().contains("Press Enter to continue or type 'q' to quit:"));
    }






}