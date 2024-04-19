package controller;

import util.CheckScanner;

import java.util.Arrays;
import java.util.Scanner;


/**
 * @author Zahir Ekrem SARITEKE
 * @project  Het analyseren van tentamenresultaten
 * @created 17 April Wednesday 2024 - 10:18
 */
public class TentamencijfersLauncher {


    private static final int AANTAL_GETALLEN_PER_REGEL = 5;
    private static final int MAX_CIJFERS = 10;

    public static void main(String[] args) {
        printTentamencijfers();
    }

    private static void printTentamencijfers() {

        System.out.print("Hoeveel cijfers wilt u invoeren?");
        Scanner scanner = new Scanner(System.in);
        int aantalCijfers =  CheckScanner.getValidIntInput(scanner);

        // !! check if greater than 0
        if (aantalCijfers==0) {
            System.out.println("Aantal cijfers moet groter zijn dan 0!");
            aantalCijfers =  CheckScanner.getValidIntInput(scanner);
        }

        double[] cijfers = new double[aantalCijfers];
        int totaal = 0;
        int voldoendeAantal = 0;
        for (int i = 0; i < cijfers.length; i++) {
            System.out.printf("Cijfer student %d: ", i + 1);

            cijfers[i] = CheckScanner.getValidDouble(scanner);
            if (cijfers[i] > MAX_CIJFERS) {
                System.out.println("Cijfer moet langer zijn dan 10!");
                System.out.printf("Cijfer student %d: ", i + 1);
                cijfers[i] = CheckScanner.getValidDouble(scanner);
            }
            if (cijfers[i] >= AANTAL_GETALLEN_PER_REGEL) {
                voldoendeAantal++;
            }
            totaal += cijfers[i];
        }

//        double max = cijfers[0];
//        for (int teller = 1; teller < cijfers.length; teller++) {
//            if (cijfers[teller] > max) {
//                max = cijfers[teller];
//            }
//        }
        double maxCijfer = Arrays.stream(cijfers).max().getAsDouble();
        double minCijfer = Arrays.stream(cijfers).min().getAsDouble();
        System.out.printf("Aantal cijfers : %d%n", aantalCijfers);
        System.out.printf("Gemiddelde cijfer: %.2f%n", (double) totaal / aantalCijfers);
        System.out.printf("Hoogste cijfer : %.1f%n", maxCijfer);
        System.out.printf("Laagste cijfer : %.1f%n", minCijfer);
        System.out.printf("Aantal voldoendes: %d%n", voldoendeAantal );

    }
}
