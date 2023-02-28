package com.priyajit.designTicTacToe;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ConsoleReader {
    private static ConsoleReader instance;
    private final Scanner scanner;

    private ConsoleReader() {
        scanner = new Scanner(System.in);
    }

    public static ConsoleReader getInstance() {
        if (instance == null) {
            synchronized (ConsoleReader.class) {
                if (instance == null) {
                    instance = new ConsoleReader();
                }
            }
        }
        return instance;
    }

    public int readInt(String inputName, String message, int lowLim, int highLim) {
        if (message != null && message.length() > 0) message = "(" + message + ")";
        System.out.printf("Enter %s %s (%d<=value>=%d):%n", inputName, message, lowLim, highLim);
        int val = scanner.nextInt();
        while (val < lowLim || val > highLim) {
            System.out.println("wrong input, renter correctly");
            val = scanner.nextInt();
        }
        return val;
    }

    public String readString(String inputName, String message, int lenLowLim, int lenHighLim) {
        if (message != null && message.length() > 0) message = "(" + message + ")";
        System.out.printf("Enter %s(%s) (%d<=length>=%d):%n", inputName, message, lenLowLim, lenHighLim);
        String val = scanner.next();
        while (val.length() < lenLowLim && val.length() > lenHighLim) {
            System.out.println("wrong input, renter correctly");
            val = scanner.next();
        }
        return val;
    }

    public String readString(String inputName, String message, List<String> options) {
        if (message != null && message.length() > 0) message = "(" + message + ")";
        Set<String> optionsSet = new HashSet<>(options);
        System.out.printf("Enter %s(%s) (options:%s):%n", inputName, message, options);
        String val = scanner.next();
        while (!optionsSet.contains(val)) {
            System.out.println("wrong input, renter correctly");
            val = scanner.next();
        }
        return val;
    }

    public char readChar(String inputName, String message, Set<Character> forbiddenChars) {
        if (message != null && message.length() > 0) message = "(" + message + ")";
        System.out.printf("Enter %s %s (except:%s):%n", inputName, message, forbiddenChars);
        char val = scanner.next().charAt(0);
        while (forbiddenChars.contains(val)) {
            System.out.println("wrong input, renter correctly");
            val = scanner.next().charAt(0);
        }
        return val;
    }
}
