package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter grid size (m n):");
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        System.out.println("Enter seed percentage (0-100):");
        double seedPercentage = scanner.nextDouble();

        Game game = new Game(m, n, seedPercentage,scanner);
        game.startGame();

        scanner.close();
    }
}