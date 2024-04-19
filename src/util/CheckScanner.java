package util;

import java.util.Scanner;

/**
 * @author Zahir Ekrem SARITEKE
 * @project Check Scanner integer value or double value
 * @created 15 Nisan Pazartesi 2024 - 21:28
 */
public class CheckScanner {

    protected static final String ERR_INPUT_MSG = "Vul een geldig input in alstublieft.";
    public static boolean isDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public  static  boolean isDoubleOrInteger(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            try {
                Integer.parseInt(input);
                return true;
            } catch (NumberFormatException e2) {
                return false;
            }
        }
    }

    public static boolean isIntegerOrDouble(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            try {
                Double.parseDouble(input);
                return true;
            } catch (NumberFormatException e2) {
                return false;
            }
        }
    }

    public static void checkScannerInput(Scanner sc, String input) {

        while (!isIntegerOrDouble(input)) {
            System.out.println(ERR_INPUT_MSG);
            input = sc.nextLine();
        }

    }
    public static int getValidInput(Scanner sc) {
        int userAnswer = 0;
        while (userAnswer <= 0) {
            if (sc.hasNextInt()) {
                userAnswer = sc.nextInt();
            } else {
                System.out.println("Vul een geldig input in alstublieft.");
                sc.nextLine();
            }
        }
        return userAnswer;
    }
    public static int getValidIntInput(Scanner sc) {
        int userAnswer = 0;
        while (true) {
            if (sc.hasNextInt()) {
                userAnswer = sc.nextInt();
                break;
            } else {
                System.out.println("Vul een geldig input in alstublieft.");
                sc.nextLine();
            }
        }

        return userAnswer;


    }


    public static double getValidDouble(Scanner sc) {

        double userAnswer = 0;
        while (userAnswer <= 0) {
            if (sc.hasNextDouble()) {
                userAnswer = sc.nextDouble();
                break;
            } else {
                System.out.println("Vul een geldig input in alstublieft.");
                sc.nextLine();
            }
        }
        return userAnswer;
    }

    public static double getValidExamScore(Scanner sc) {

        double userAnswer = 0;
        while (!(userAnswer <= 0) && !(userAnswer > 10)) {
            if (sc.hasNextDouble()) {
                userAnswer = sc.nextDouble();

            } else {
                System.out.println("Vul een geldig input in alstublieft.");
                sc.nextLine();
            }
        }
        return userAnswer;
    }

}
