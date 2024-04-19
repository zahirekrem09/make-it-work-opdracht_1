package controller;

import util.CheckScanner;
import util.GenerateRandomNumbers;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Zahir Ekrem SARITEKE
 * @project 1 to 10  random numbers generator
 * @created 19 April Friday 2024 - 09:07
 */
public class GetallenRadenLauncher {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 10;
    private static final int COUNT_NUMBER =3;

    public static void main(String[] args) {
        printGetallenRaden();
    }


    private static void printGetallenRaden() {
        int counter = 1;
        while (true) {
            int[] randomNumbers = GenerateRandomNumbers.generateRandomNumbers(COUNT_NUMBER, MIN_NUMBER, MAX_NUMBER);

            System.out.print("Geef 3 verschillende getallen tussen 1 en 10, gescheiden door spaties: ");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            String[] inputArray = input.split(" ");
            int[] inputNumbers = new int[inputArray.length];
            for (int i = 0; i < inputArray.length; i++) {

                if (CheckScanner.isInteger((inputArray[i]))) {
                    inputNumbers[i] = Integer.parseInt(inputArray[i]);
                }
                else {
//                    System.out.println("Foutieve invoer, probeer opnieuw");
//                    continue;
                }

            }
            if (inputNumbers.length != COUNT_NUMBER) {
                System.out.println("Foutieve invoer, probeer opnieuw");
                continue;
            }
            int correctCounter =  countCheckInputNumbers(randomNumbers, inputNumbers);
            System.out.printf("Aantal correcte getallen = %d %n " , correctCounter);

            if (correctCounter == COUNT_NUMBER) {
                System.out.println("Gefeliciteerd, u heeft gewonnen");
                System.out.printf("U heeft %d keer geraden. %n" , counter);
                System.out.print("De te raden getallen waren: " );
                Arrays.sort(randomNumbers);
                for (int el : randomNumbers) {
                    System.out.print(el + " ");
                }
                sc.close();
                break;
            } else {
                counter++;
                // recursive call
//                printGetallenRaden();
            }
        }


    }

    private static int countCheckInputNumbers(int[] randomNumbers, int[] inputNumbers) {
        int counter = 0;
        for (int inputNumber : inputNumbers) {
            if (isFoundInArray(inputNumber, randomNumbers)) {
                counter++;
            }
        }
        return  counter;
    }

    /**
     * A function to check if a specific number is found in an integer array.
     *
     * @param  num    the number to check for in the array
     * @param  array  the array of integers to search for the number
     * @return        true if the number is found in the array, false otherwise
     */
    public static boolean isFoundInArray(int num, int[] array) {
        for (int el : array) {
            if (el == num) {
                return true;
            }
        }
        return false;

    }

    public static  void printArray(int[] array) {
        for (int el : array) {
            System.out.print(el + " ");
        }
    }




}
