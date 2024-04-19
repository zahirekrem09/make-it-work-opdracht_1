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
     * Prints the occurrences of numbers in a given array.
     *
     * @param array the array of integers to check for occurrences
     */
    public static void printOccurrences(int[] array) {
        System.out.println("Overzicht van voorkomens van getallen in rij: ");
        // 0 olanlarida gosteriyor
        /*int max = maxElementArr(array);
        int min = minElementArr(array);
        System.out.println("De maximum waarde is: " + max);
        System.out.println("De minimum waarde is: " + min);
        int[] numberOccurrences = countOccurrencesInRowPerNumber(array, max);
        for (int i = 0; i < numberOccurrences.length; i++) {
            System.out.printf("Getal %d komt %d keer. %n", i + 1,  numberOccurrences[i]);
        }*/


        // get unique elements from an integer array(sadece var olanlari gosteriyor)
        ArrayList<Integer> uniqueList = getUnique(array);
        int[] uniqueArray = convertToIntArray(uniqueList);
        Arrays.sort(uniqueArray);
        for (int num : uniqueArray) {
            System.out.printf("Getal %d komt %d keer. %n", num, countOccurrencesInRow(array, num));
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

    /**
     * A function to find the minimum value in an integer array.
     *
     * @param  arr  the input array of integers
     * @return        the minimum value in the input array
     */
    public static int minElementArr(int[] arr) {
        int minimum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minimum) {
                minimum = arr[i];
            }
        }
        return minimum;
    }

    /**
     * A function to find the maximum value in an integer array.
     *
     * @param  arr  the input array of integers
     * @return        the maximum value in the input array
     */
    public static int maxElementArr(int[] arr) {
        int maximum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maximum) {
                maximum = arr[i];
            }
        }
        return maximum;
    }

    /**
     * A function to count the occurrences of each number in a row of random numbers.
     *
     * @param  ranndomNumbers  the array of random numbers
     * @param  maxNumber       the maximum number to count occurrences for
     * @return                 an array containing the number of occurrences for each number
     */
    public static int[] countOccurrencesInRowPerNumber(int[] ranndomNumbers, int maxNumber) {
        int[] numberOccurrences = new int[maxNumber];
        for (int i = 0; i < maxNumber; i++) {
            numberOccurrences[i] = countOccurrencesInRow(ranndomNumbers, i + 1);
        }
        return numberOccurrences;
    }

    /**
     * A function to count the occurrences of a specific number in an integer array.
     *
     * @param array  the array of integers to check for occurrences
     * @param number the number to count occurrences for
     * @return the number of occurrences of the specified number in the array
     */
    public static int countOccurrencesInRow(int[] array, int number) {
        int occurrences = 0;
        for (int num : array) {
            if (num == number) {
                occurrences++;
            }
        }
        return occurrences;
    }
}
