package com.priyajit.designTicTacToe.game;

import com.priyajit.designTicTacToe.ConsoleReader;
import com.priyajit.designTicTacToe.ConsoleReaderImpl;
import com.priyajit.designTicTacToe.factory.DifficultyLevelFactory;
import com.priyajit.designTicTacToe.player.BotPlayer;
import com.priyajit.designTicTacToe.player.HumanPlayer;
import com.priyajit.designTicTacToe.player.Player;
import com.priyajit.designTicTacToe.strategy.difficulylevel.DifficultyLevel;
import com.priyajit.designTicTacToe.strategy.difficulylevel.EasyDifficultyLevel;
import com.priyajit.designTicTacToe.strategy.winningstrategy.SimpleWinningStrategy;

import java.util.*;
import java.util.stream.Collectors;

/**
 * GameDriver responsible to initiate a game
 * Take inputs from user like dimension, no of players, bots, difficulty level
 */
public class GamerDriver {
    public static void startGame() {
        // Get initial inputs from user with validation to create a Game and start
        // Get dimension of the board
        ConsoleReader consoleReader = ConsoleReaderImpl.getInstance();
        int dimension = consoleReader.readInt("dimension", "", 2, 50);

        // Get total player count
        int playerCount = consoleReader.readInt("total player count", "", 2, dimension * dimension);

        // List to store all type of players
        List<Player> players = new ArrayList<>();

        // Set to store symbols and avoid duplicate symbols
        Set<Character> takenSymbols = new HashSet<>();

        // Get human player count
        int humanPlayerCount = consoleReader.readInt("human player count", "remaining will be bots added automatically", 0, playerCount);

        // Add human players using helper method
        addHumanPlayers(humanPlayerCount, players, takenSymbols);

        // Add remaining as bot players using helper method
        // Get bot difficulty level from user
        int botPlayerCount = playerCount - humanPlayerCount;
        addBotPlayers(botPlayerCount, players, takenSymbols);

        // Get count of blocked cells
        int blockedCellCount = consoleReader.readInt("blocked cell count", "will be placed randomly", 0, dimension * dimension);

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
        ConsoleReader consoleReader = ConsoleReaderImpl.getInstance();
        for (int i = 0; i < humanPlayerCount; i++) {
            String name = consoleReader.readString("player name", "", 3, 10);
            char symbol = consoleReader.readChar("symbol", "", takenSymbols);
            Player player = new HumanPlayer(name, symbol);
            players.add(player);
            takenSymbols.add(symbol);
            System.out.println("Added players: " + players);
        }
    }

    private static void addBotPlayers(int botPlayerCount, List<Player> players, Set<Character> takenSymbols) {
        ConsoleReader consoleReader = ConsoleReaderImpl.getInstance();
        if (botPlayerCount == 0) return;
        List<String> difficultyLevels = Arrays.stream(DifficultyLevel.DIFFICULTY_LEVELS.values())
                .map(Enum::toString)
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        String choice = consoleReader.readString("difficulty level", "", difficultyLevels);

        DifficultyLevel difficultyLevel = DifficultyLevelFactory.getDifficultyLevel(choice);

        char botSymbol = 'A';
        for (int i = 0; i < botPlayerCount; i++) {
            while (takenSymbols.contains(botSymbol)) botSymbol++;
            String botName = "EasyBot" + (i + 1);
            Player player = new BotPlayer(botName, botSymbol, difficultyLevel);
            players.add(player);
            takenSymbols.add(botSymbol++);
        }
    }
}
