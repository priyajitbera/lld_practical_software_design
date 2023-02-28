package com.priyajit.designTicTacToe.game;

import com.priyajit.designTicTacToe.ConsoleReader;
import com.priyajit.designTicTacToe.player.BotPlayer;
import com.priyajit.designTicTacToe.player.HumanPlayer;
import com.priyajit.designTicTacToe.player.Player;
import com.priyajit.designTicTacToe.strategy.difficulylevel.EasyDifficultyLevel;
import com.priyajit.designTicTacToe.strategy.winningstrategy.SimpleWinningStrategy;

import java.util.*;

/**
 * GameDriver responsible to initiate a game
 * Take inputs from user like dimension, no of players, bots, difficulty level
 */
public class GamerDriver {
    public static void startGame() {
        // Get initial inputs from user with validation to create a Game and start
        // Get dimension of the board
        System.out.println("Enter dimension of the Board(>=1):");
        int dimension = ConsoleReader.scanner.nextInt();
        while (!isValidDimension(dimension)) {
            System.out.println("wrong input, enter correctly:");
            dimension = ConsoleReader.scanner.nextInt();
        }

        // Get total player count
        System.out.println("Enter total number of players(>=2):");
        int playerCount = ConsoleReader.scanner.nextInt();
        while (!isValidPlayerCount(playerCount)) {
            System.out.println("wrong input, enter correctly:");
            playerCount = ConsoleReader.scanner.nextInt();
        }

        // List to store all type of players
        List<Player> players = new ArrayList<>();

        // Set to store symbols and avoid duplicate symbols
        Set<Character> takenSymbols = new HashSet<>();

        // Get human player count
        System.out.println("Enter number of human player(>=0)(remaining will be automatically added bots):");
        int humanPlayerCount = ConsoleReader.scanner.nextInt();
        while (!isValidHumanPlayerCount(humanPlayerCount)) {
            System.out.println("wrong input, enter correctly:");
            humanPlayerCount = ConsoleReader.scanner.nextInt();
        }

        // Add human players using helper method
        addHumanPlayers(humanPlayerCount, players, takenSymbols);

        // Add remaining as bot players using helper method
        // Get bot difficulty level from user
        int botPlayerCount = playerCount - humanPlayerCount;
        addBotPlayers(botPlayerCount, players, takenSymbols);

        // Get count of blocked cells
        System.out.printf("Enter the number of blocked cells(will be placed randomly)(>=0 && <=%d) : ", dimension * dimension);
        int blockedCellCount = ConsoleReader.scanner.nextInt();

        // Create game and start
        Game game = new Game(dimension, players, blockedCellCount, new SimpleWinningStrategy());
        game.start();
        if (game.currentGameStatus == GameStatus.FINISHED) {
            System.out.println("Winner is: " + game.getWinner());
        } else if (game.currentGameStatus == GameStatus.DRAW) {
            System.out.println("Game is Draw");
        }
    }

    /**
     * Helper method to add human players
     * Take input name and symbol from console
     *
     * @param humanPlayerCount
     * @param players
     * @param takenSymbols
     */
    private static void addHumanPlayers(int humanPlayerCount, List<Player> players, Set<Character> takenSymbols) {
        for (int i = 0; i < humanPlayerCount; i++) {
            System.out.println("Enter player name(length >= 2): ");
            String name = ConsoleReader.scanner.next();
            while (!isValidPlayerName(name)) {
                System.out.println("wrong input, enter correctly:");
                name = ConsoleReader.scanner.next();
            }
            System.out.println("Enter symbol(one char)(except already taken: " + takenSymbols + "):");
            char symbol = ConsoleReader.scanner.next().charAt(0);
            while (!isValidChosenSymbol(symbol, takenSymbols)) {
                System.out.println(symbol + " already taken, choose any other symbol:");
                symbol = ConsoleReader.scanner.next().charAt(0);
            }
            Player player = new HumanPlayer(name, symbol);
            players.add(player);
            takenSymbols.add(symbol);
            System.out.println("Added players: " + players);
        }
    }

    private static void addBotPlayers(int botPlayerCount, List<Player> players, Set<Character> takenSymbols) {
        if (botPlayerCount == 0) return;
        System.out.println("Enter the bot difficulty level(easy):");
        String difficultyLevel = ConsoleReader.scanner.next();
        while (!isValidDifficultyLevel(difficultyLevel)) {
            difficultyLevel = ConsoleReader.scanner.next();
        }
        char botSymbol = 'A';
        for (int i = 0; i < botPlayerCount; i++) {
            while (takenSymbols.contains(botSymbol)) botSymbol++;
            String botName = "EasyBot" + (i + 1);
            Player player = new BotPlayer(botName, botSymbol, new EasyDifficultyLevel());
            players.add(player);
            takenSymbols.add(botSymbol++);
        }
    }

    // User Input Validators
    private static boolean isValidDimension(int dimension) {
        return dimension >= 1;
    }

    private static boolean isValidPlayerCount(int playerCount) {
        return playerCount >= 2;
    }

    private static boolean isValidHumanPlayerCount(int humanPlayerCount) {
        return humanPlayerCount >= 0;
    }

    private static boolean isValidPlayerName(String name) {
        return name.length() >= 2;
    }

    private static boolean isValidChosenSymbol(char symbol, Set<Character> takenSymbols) {
        return !takenSymbols.contains(symbol);
    }

    private static boolean isValidDifficultyLevel(String difficultyLevel) {
        difficultyLevel = difficultyLevel.toLowerCase();
        return difficultyLevel.equals("easy");
    }
}
