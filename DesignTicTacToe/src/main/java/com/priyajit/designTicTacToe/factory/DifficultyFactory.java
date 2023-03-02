package com.priyajit.designTicTacToe.factory;

import com.priyajit.designTicTacToe.strategy.difficulylevel.*;
public class DifficultyFactory {
    public static Difficulty easyDifficulty() {
        return new EasyDifficulty();
    }

    public static Difficulty mediumDifficulty() {
        return new MediumDifficulty();
    }

    public static Difficulty hardDifficulty() {
        return new HardDifficulty();
    }

    public static Difficulty getDifficulty(String choice) {
        return switch (choice) {
            case "medium" -> new MediumDifficulty();
            case "hard" -> new HardDifficulty();
            default -> new EasyDifficulty();
        };
    }
}
