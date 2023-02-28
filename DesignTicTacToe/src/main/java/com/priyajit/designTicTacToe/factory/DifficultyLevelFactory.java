package com.priyajit.designTicTacToe.factory;

import com.priyajit.designTicTacToe.strategy.difficulylevel.DifficultyLevel;
import com.priyajit.designTicTacToe.strategy.difficulylevel.EasyDifficultyLevel;
import com.priyajit.designTicTacToe.strategy.difficulylevel.HardDifficultyLevel;
import com.priyajit.designTicTacToe.strategy.difficulylevel.MediumDifficultyLevel;

public class DifficultyLevelFactory {
    public static DifficultyLevel easyDifficultyLevel(){
        return new EasyDifficultyLevel();
    }
    public static DifficultyLevel mediumDifficultyLevel(){
        return new MediumDifficultyLevel();
    }
    public static DifficultyLevel hardDifficultyLevel(){
        return new HardDifficultyLevel();
    }
    public static DifficultyLevel getDifficultyLevel(String choice){
        return switch(choice){
            case "medium" -> new MediumDifficultyLevel();
            case "hard" -> new HardDifficultyLevel();
            default -> new EasyDifficultyLevel();
        };
    }
}
