package controller;

import util.CheckScanner;

import java.util.Scanner;

/**
 * @author Zahir Ekrem SARITEKE
 * @project Schrijf een applicatie die van een cirkel, een rechthoek, een
 *          vierkant en een driehoek de oppervlakte
 *          uit kan rekenen.
 * @created 19 April Friday 2024 - 11:21
 */
public class OppervlakteberekeningWithMethodsLauncher {

    protected static final Scanner sc = new Scanner(System.in);
    protected static final String LAST_MESSAGE = "De oppervlakte van jouw %s is %.1f vierkante centimeter. %n";

    ;

    public static void main(String[] args) {
        printOppervlakteBerekening();
        // printOppervlakteBerekeningWithRecursion();
    }

    /**
     * Recursive function to calculate the area of different geometric figures based
     * on user input.
     *
     */
    private static void printOppervlakteBerekeningWithRecursion() {
        System.out.print("Van welke figuur wil je de oppervlakte uit laten rekenen?\n" +
                "(cirkel = 1; rechthoek = 2; vierkant = 3; driehoek = 4;\n" +
                "stoppen = 0):");

        int input = sc.nextInt();
        switch (input) {
            case 1:
                printCircle();
                printOppervlakteBerekeningWithRecursion();
                break;
            case 2:
                printRechthoek();
                printOppervlakteBerekeningWithRecursion();
                break;
            case 3:
                printVierkant();
                printOppervlakteBerekeningWithRecursion();
                break;
            case 4:
                printDriehoek();
                printOppervlakteBerekeningWithRecursion();
                break;
            case 0:
                System.out.println("Het programma wordt nu gestopt.");
                break;
            default:
                System.out.println("Vul een geldig getal in");
                break;
        }
    }

    /**
     * Prints the area of different geometric figures based on user input.
     *
     * This function prompts the user to input a number representing the figure
     * they want to calculate the area of. It then uses a switch statement to
     * determine which function to call based on the input. The functions called
     * are `printCircle()`, `printRechthoek()`, `printVierkant()`, and
     * `printDriehoek()`. If the input is 0, the program stops. If the input is
     * not a valid number, the user is prompted to enter a valid number.
     *
     * @return void
     */
    private static void printOppervlakteBerekening() {

        boolean isRepeat = true;
        while (isRepeat) {
            System.out.print("Van welke figuur wil je de oppervlakte uit laten rekenen?\n" +
                    "(cirkel = 1; rechthoek = 2; vierkant = 3; driehoek = 4;\n" +
                    "stoppen = 0):");

            int input = sc.nextInt();
            switch (input) {
                case 1:
                    printCircle();

                    break;
                case 2:
                    printRechthoek();

                    break;
                case 3:
                    printVierkant();

                    break;
                case 4:
                    printDriehoek();

                    break;
                case 0:
                    System.out.println("Het programma wordt nu gestopt.");
                    isRepeat = false;
                    break;
                default:
                    System.out.println("Vul een geldig getal in");
                    break;
            }
        }

    }

    /**
     * Prints the area of a triangle based on the inputted base and height.
     *
     */
    private static void printDriehoek() {
        System.out.print("Vul de breedte van de driehoek in: ");
        int basis = sc.nextInt();
        System.out.print("Vul de hoogte van de driehoek in: ");
        int hoogte = sc.nextInt();
        double area = calculateAreaTriangle(basis, hoogte);
        System.out.printf(LAST_MESSAGE, "driehoek", area);
    }
    /**
     * Prints the area of a square based on the length entered by the user.
     *
     */
    private static void printVierkant() {
        System.out.print("Wat is de lengte in centimeter?: ");
        int lengte = sc.nextInt();
        double area = calculateAreaSquare(lengte);
        System.out.printf(LAST_MESSAGE, "vierkant", area);
    }

    /**
     * Prints the area of a rectangle based on the length entered by the user.
     *
     */
    private static void printRechthoek() {

        System.out.print("Wat is de hoogte in centimeter?: ");
        // int hoogte = sc.nextInt();
        double hoogte = CheckScanner.getValidDouble(sc);
        System.out.print("Wat is de breedte in centimeter?: ");
        double breedte = CheckScanner.getValidDouble(sc);
        // int breedte = sc.nextInt();
        double area = calculateAreaRectangle(breedte, hoogte);
        System.out.printf(LAST_MESSAGE, "rechthoek", area);

    }
    /**
     * Prints the area of a circle based on the length entered by the user.
     */
    private static void printCircle() {
        System.out.print("Wat is de zijde in centimeter?: ");
        // int radius = sc.nextInt();
        double radius = CheckScanner.getValidDouble(sc);
        double area = calculateAreaCircle(radius);
        System.out.printf(LAST_MESSAGE, "cirkel", area);
    }

    private static double calculateAreaTriangle(double mpBasis, double mpHoogte) {
        return (mpBasis * mpHoogte) / 2.0;
    }

    private static double calculateAreaSquare(double mpBasis) {
        return Math.pow(mpBasis, 2);
    }

    private static double calculateAreaRectangle(double mpBasis, double mpHoogte) {
        return (mpBasis * mpHoogte);
    }

    private static double calculateAreaCircle(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }



}
