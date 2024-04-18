package controller;

import util.CheckScanner;

import java.util.Scanner;

/**
 * @author Zahir Ekrem SARITEKE
 * @project Tafels printen
 * @created 16 April Tuesday 2024 - 21:25
 */
public class TafelsLauncher {

    private static final int AANTAL_GETALLEN_PER_REGEL = 5;


    public static void main(String[] args) {
        printTafels();
    }

    private static void printTafels() {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.print("Welke tafel wilt u afdrukken? (0=stoppen) ");
            int tafelGetal = CheckScanner.getValidIntInput(scanner);
            if (tafelGetal == 0) {
                System.out.println("Tot ziens!");
                break;
            }

            System.out.print("Hoeveel getallen wilt u afdrukken? ");

            int aantal = CheckScanner.getValidInput(scanner);
            System.out.printf("Tafel van %d : \n", tafelGetal);

            // Print the table
            int maxLength = Integer.toString(aantal * tafelGetal).length() + 1;
            String formatLength = String.valueOf(maxLength);
            for (int teller = 1; teller <= aantal; teller++) {
                int product = tafelGetal * teller;
                System.out.printf("%" + formatLength + "d", product);
//              System.out.printf("%5d",  maxLength,product);

                if (teller % AANTAL_GETALLEN_PER_REGEL == 0) {
                    System.out.println();
                }
            }
            System.out.println();
        }
    }
}
