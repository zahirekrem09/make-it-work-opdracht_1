package controller;

import util.CheckScanner;
import util.GenerateRandomNumbers;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Zahir Ekrem SARITEKE
 * @project 1 to 10 random numbers generator
 * @created 19 April Friday 2024 - 09:07
 */
public class GetallenRadenLauncher {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 10;
    private static final int COUNT_NUMBER = 3;

    public static void main(String[] args) {
        printGetallenRaden();
    }

    /**
     * Prints the game "Getallen Raden" to the console.
     *
     * @param None
     * @return None
     */
    private static void printGetallenRaden() {
        int counter = 1;
        while (true) {
            int[] randomNumbers = GenerateRandomNumbers.generateRandomNumbers(COUNT_NUMBER, MIN_NUMBER, MAX_NUMBER);

            System.out.print("Geef 3 verschillende getallen tussen 1 en 10, gescheiden door spaties: ");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            int[] inputNumbers = stringToArray(input);
            if (inputNumbers.length != COUNT_NUMBER) {
                System.out.println("Foutieve invoer, probeer opnieuw");
                continue;
            }
            int correctCounter = countCheckInputNumbers(randomNumbers, inputNumbers);
            System.out.printf("Aantal correcte getallen = %d %n ", correctCounter);

            if (correctCounter == COUNT_NUMBER) {
                System.out.println("Gefeliciteerd, u heeft gewonnen");
                System.out.printf("U heeft %d keer geraden. %n", counter);
                System.out.print("De te raden getallen waren: ");
                Arrays.sort(randomNumbers);
                printArray(inputNumbers);
                sc.close();
                break;
            } else {
                counter++;
                // recursive call
                // printGetallenRaden();
            }
        }

    }

    /**
     * Counts the number of input numbers that are found in the given array of
     * random numbers.
     *
     * @param randomNumbers the array of random numbers to search in
     * @param inputNumbers  the array of input numbers to count
     * @return the number of input numbers found in the random numbers array
     */
    private static int countCheckInputNumbers(int[] randomNumbers, int[] inputNumbers) {
        int counter = 0;
        for (int inputNumber : inputNumbers) {
            if (isFoundInArray(inputNumber, randomNumbers)) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * A function to check if a specific number is found in an integer array.
     *
     * @param number the number to check for in the array
     * @param array  the array of integers to search for the number
     * @return true if the number is found in the array, false otherwise
     */
    public static boolean isFoundInArray(int number, int[] array) {
        for (int el : array) {
            if (el == number) {
                return true;
            }
        }
        return false;

    }

    /**
     * A function to print the elements of an integer array.
     *
     * @param array the array of integers to print
     * @return void
     */
    public static void printArray(int[] array) {
        for (int el : array) {
            System.out.print(el + " ");
        }
    }

    /**
     * Converts a string of space-separated integers into an array of integers.
     *
     * @param input the string of integers
     * @return an array of integers
     */
    public static int[] stringToArray(String input) {
        String[] inputArray = input.split(" ");
        int[] inputNumbers = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {

            if (CheckScanner.isInteger((inputArray[i]))) {
                inputNumbers[i] = Integer.parseInt(inputArray[i]);
            } else {
                // System.out.println("Foutieve invoer, probeer opnieuw");
                // continue;
            }
        }
        return inputNumbers;
    }

}
