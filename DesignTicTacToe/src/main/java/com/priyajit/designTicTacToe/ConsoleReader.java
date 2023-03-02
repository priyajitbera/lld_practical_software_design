package com.priyajit.designTicTacToe;

import java.util.List;
import java.util.Set;

public interface ConsoleReader {
    public int readInt(String inputName, String message, int lowLim, int highLim);

    public String readString(String inputName, String message, int lenLowLim, int lenHighLim);

    public String readString(String inputName, String message, Set<String> options);

    public char readCharExcludingForbiddens(String inputName, String message, Set<Character> forbiddenChars);

    public char readChar(String inputName, String message, Set<Character> options);
}
