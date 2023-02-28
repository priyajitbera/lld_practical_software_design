package com.priyajit.designTicTacToe;

import java.util.*;

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
        int val = -1;
        try {
            val = scanner.nextInt();
        } catch (InputMismatchException ignored) {
        }
        while (val < lowLim || val > highLim) {
            System.out.println("wrong input, enter correctly");
            try {
                val = scanner.nextInt();
            } catch (InputMismatchException ignored) {
            }
        }
        return val;
    }

    public String readString(String inputName, String message, int lenLowLim, int lenHighLim) {
        if (message != null && message.length() > 0) message = "(" + message + ")";
        System.out.printf("Enter %s(%s) (%d<=length>=%d):%n", inputName, message, lenLowLim, lenHighLim);
        String val = "";
        try {
            val = scanner.next();
        } catch (InputMismatchException e) {
        }
        while (val.length() < lenLowLim && val.length() > lenHighLim) {
            System.out.println("wrong input, enter correctly");
            try {
                val = scanner.next();
            } catch (InputMismatchException ignored) {
            }
        }
        return val;
    }

    public String readString(String inputName, String message, List<String> options) {
        if (message != null && message.length() > 0) message = "(" + message + ")";
        Set<String> optionsSet = new HashSet<>(options);
        System.out.printf("Enter %s(%s) (options:%s):%n", inputName, message, options);
        String val = "";
        try {
            val = scanner.next();
        } catch (InputMismatchException ignored) {
        }
        while (!optionsSet.contains(val)) {
            System.out.println("wrong input, enter correctly");
            try {
                val = scanner.next();
            } catch (InputMismatchException ignored) {
            }
        }
        return val;
    }

    public char readChar(String inputName, String message, Set<Character> forbiddenChars) {
        if (message != null && message.length() > 0) message = "(" + message + ")";
        System.out.printf("Enter %s %s (except:%s):%n", inputName, message, forbiddenChars);
        char val = '.';
        try {
            String str = scanner.next();
            val = str.length() > 0 ? str.charAt(0) : '.';
        } catch (InputMismatchException ignored) {
        }
        while (forbiddenChars.contains(val)) {
            System.out.println("wrong input, enter correctly");
            try {
                String str = scanner.next();
                val = str.length() > 0 ? str.charAt(0) : '.';
            } catch (InputMismatchException ignored) {
            }
        }
        return val;
    }

    public char readChar(String inputName, String message, List<Character> options) {
        Set<Character> optionsSet = new HashSet<>(options);
        if (message != null && message.length() > 0) message = "(" + message + ")";
        System.out.printf("Enter %s %s (options:%s):%n", inputName, message, options);
        char val = '.';
        try {
            String str = scanner.next();
            val = str.length() > 0 ? str.charAt(0) : '.';
        } catch (InputMismatchException ignored) {
        }
        while (!optionsSet.contains(val)) {
            System.out.println("wrong input, enter correctly");
            try {
                String str = scanner.next();
                val = str.length() > 0 ? str.charAt(0) : '.';
            } catch (InputMismatchException ignored) {
            }
        }
        return val;
    }
}
