package controller;

import util.CheckScanner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Zahir Ekrem SARITEKE
 * @project Voorkomen van alle getallen tellen
 * @created 17 April Wednesday 2024 - 11:48
 */
public class VoorkomensInRijLauncher {


    private static final int MIN_NUMBER = 1;
    private static final String HOEVEEL_MSG = "Hoeveel getallen wil je genereren? ";
    private static final String MAX_NUMBER_MSG = "Wat is het grootste getal dat mag voorkomen? ";




    public static void main(String[] args) {
        printVoorkomensInRij();
    }

    private static void printVoorkomensInRij() {
        Scanner sc = new Scanner(System.in);
        System.out.print(HOEVEEL_MSG);
        int mpRij = CheckScanner.getValidIntInput(sc);
        if (mpRij == 0) {
            System.out.println("Aantal getallen moet groter zijn dan 0!");
            mpRij = CheckScanner.getValidIntInput(sc);
        }
        System.out.print(MAX_NUMBER_MSG);
        int mpGetal = CheckScanner.getValidIntInput(sc);
        int[] randomRijGetallen = generateRandomNumbers(mpRij, MIN_NUMBER, mpGetal);
        printArrayElements(randomRijGetallen);
        printOccurrences(randomRijGetallen);

    }

    /**
     * A function to print the elements of an integer array.
     *
     * @param array the array of integers to print
     */
    public static void printArrayElements(int[] array) {
        System.out.print("Dit zijn de getallen: ");
        for (int el : array) {
            System.out.print(el + " ");
        }
    }

    /**
     * A function to count the occurrences of a specific number in an integer array.
     *
     * @param array  the array of integers to check for occurrences
     * @param number the number to count occurrences for
     * @return the number of occurrences of the specified number in the array
     */
    public static int telVoorkomensInRij(int[] array, int number) {
        int occurrences = 0;
        for (int num : array) {
            if (num == number) {
                occurrences++;
            }
        }
        return occurrences;
    }

    /**
     * Prints the occurrences of numbers in a given array.
     *
     * @param array the array of integers to check for occurrences
     */
    public static void printOccurrences(int[] array) {
        System.out.println("Overzicht van voorkomens van getallen in rij: ");
        ArrayList<Integer> uniqueList = getUnique(array);
        int[] uniqueArray = convertToIntArray(uniqueList);
        Arrays.sort(uniqueArray);
        for (int num : uniqueArray) {
            System.out.printf("Getal %d komt %d keer. %n", num, telVoorkomensInRij(array, num));
        }

    }

    /**
     * Converts an ArrayList of Integers to an integer array.
     *
     * @param arrayList the ArrayList of Integers to convert
     * @return the integer array converted from the ArrayList
     */
    public static int[] convertToIntArray(ArrayList<Integer> arrayList) {

        int[] intArray = new int[arrayList.size()];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = arrayList.get(i);
        }
        return intArray;

    }

    /**
     * A function to get unique elements from an integer array.
     *
     * @param arr the input integer array
     * @return an ArrayList of unique integers
     */
    static ArrayList<Integer> getUnique(int arr[]) {
        ArrayList<Integer> uniqueList = new ArrayList<Integer>(); // Create an empty List
        for (int i = 0; i < arr.length; i++) {
            int j;
            for (j = 0; j < i; j++)
                if (arr[i] == arr[j])
                    break;
            if (i == j) {
                uniqueList.add(arr[i]);
            }
        }
        return uniqueList;
    }

    /**
     * Generates an array of random integers within the specified range.
     *
     * @param  count  the number of random integers to generate
     * @param  min    the minimum value of the range (inclusive)
     * @param  max    the maximum value of the range (inclusive)
     * @return        an array of random integers within the specified range
     */
    public static int[] generateRandomNumbers(int count, int min, int max) {
        int[] randomNumbers = new int[count];
        //Random rand = new Random();
        for (int i = 0; i < count; i++) {
            //randomNumbers[i] = rand.nextInt(max - min + 1) + min;
            randomNumbers[i] = (int) (Math.random() * (max - min + 1)) + min;
        }
        return randomNumbers;
    }
}
