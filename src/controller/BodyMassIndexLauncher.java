/**
 * @author Zahir Ekrem SARITEKE
 * @project BodyMassIndex  Calculator
 * @created 15 Nisan Pazartesi 2024 - 20:55
 */

package controller;

import java.util.Scanner;

public class BodyMassIndexLauncher {

    protected static final String LENGTH_MSG = "Geef je lengte in centimeters:";
    protected static final String WEIGHT_MSG = "Geef je gewicht in kilogram:";
    protected static final String ERR_LENGTH_MSG = "Vul een geldig lenght in alstublieft.";
    protected static final String ERR_WEIGHT_MSG = "Vul een geldig gewicht in alstublieft.";
    protected static final String LAST_MSG = "Jouw BMI is: %.1f (%s)";

    public static void main(String[] args) {
        printBodyMassIndex();
    }

    /**
     * Retrieves a valid weight input from the user using the provided Scanner object.
     *
     * @param scanner the Scanner object used to retrieve user input
     * @return the valid weight input provided by the user
     */
    public static double getValidWeight(Scanner scanner) {
        double weight = 0;
        while (weight <= 0) {
            System.out.print(WEIGHT_MSG);
            if (scanner.hasNextDouble()) {
                weight = scanner.nextDouble();
                if (weight <= 0) {
                    System.out.println(ERR_WEIGHT_MSG);
                }
            } else {
                System.out.println(ERR_WEIGHT_MSG);
                scanner.nextLine();
            }
        }
        return weight;
    }

    /**
     * Retrieves a valid height value from the user through the provided scanner.
     *
     * @param scanner the scanner object used to read user input
     * @return the valid height value entered by the user
     */
    public static int getValidHeight(Scanner scanner) {
        int height = 0;
        while (height <= 0) {
            System.out.print(LENGTH_MSG);
            if (scanner.hasNextInt()) {
                height = scanner.nextInt();
                if (height <= 0) {
                    System.out.println(ERR_LENGTH_MSG);
                }
            } else {
                System.out.println(ERR_LENGTH_MSG);
                scanner.nextLine();
            }
        }
        return height;
    }


    /**
     * Calculates the Body Mass Index (BMI) based on the given weight and height.
     *
     * @param weight the weight of the person in kilograms
     * @param height the height of the person in meters
     * @return the calculated BMI value
     */
    public static double calculateBMI(double weight, double height) {
        return weight / (Math.pow(height, 2));
    }

    /**
     * Determines the body mass index category based on the given body mass index.
     *
     * @param bodyMassIndex the body mass index to be evaluated
     * @return   the body mass index category
     *
     * tot 18,5 Ondergewicht
     * 18,5 – 25,0 Gezond gewicht
     *  25,0 – 30,0 Overgewicht
     *  meer dan 30,0 Obesitas
     */
    public static String controllerBodyMassCategory(double bodyMassIndex) {

        if (bodyMassIndex < 18.5) {
            return "Ondergewicht";

        } else if (bodyMassIndex >= 18.5 && bodyMassIndex < 25.0) {
            return "Gezond gewicht";
        } else if (bodyMassIndex >= 25.0 && bodyMassIndex < 30.0) {
            return "Overgewicht";
        }
        return "Obesitas";
    }


    /**
     * Prompts the user to enter their weight and length,
     * calculates their body mass index, and prints the result.
     */
    public static void printBodyMassIndex() {
        Scanner sc = new Scanner(System.in);
        int length = getValidHeight(sc);
        double weight = getValidWeight(sc);
        double bodyMassIndex = calculateBMI(weight, length / 100.0);
        System.out.printf((LAST_MSG) + "%n", bodyMassIndex, controllerBodyMassCategory(bodyMassIndex));
        sc.close();
    }
}



