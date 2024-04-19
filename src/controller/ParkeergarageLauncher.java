package controller;

import util.ArrayCalculator;
import util.CheckScanner;
import java.util.Scanner;

/**
 * @author Zahir Ekrem SARITEKE
 * @project Het doel van deze opdracht is om een applicatie te schrijven die de
 *          parkeerkosten berekent in een
 *          parkeergarage. Na het invoeren van auto’s die geparkeerd hebben,
 *          bepaalt de applicatie de
 *          parkeerkosten voor elke auto en de totale parkeerkosten voor alle
 *          auto’s die hebben geparkeerd.
 * @created 19 April Friday 2024 - 13:08
 */
public class ParkeergarageLauncher {

    protected static final Scanner scanner = new Scanner(System.in);

    private static final int MAX_PARKEER_UREN = 24;
    private static final int MAX_KENTEKEN_LENGTE = 5;
    private static final double MAX_PARKEER_KOSTEN = 25.0;
    private static final double PARKEER_KOSTEN_PER_URE = 2.75;
    private static final double PARKEER_KOSTEN_EERSTE_DRIE_PER_URE = 3.75;
    private static final int COUNT_NUMBER = 3;

    public static void main(String[] args) {
        printParkeergarage();
    }

    /**
     * Prints the parking garage and prompts the user for the number of cars that
     * have parked.
     * Then, for each car, prompts the user for the license plate and the number of
     * hours parked.
     * Validates the license plate length and the number of parked hours.
     * Finally, calls the printLastMessage method with the number of cars, their
     * license plates, and the parked hours.
     */
    private static void printParkeergarage() {
        System.out.printf("Hoeveel auto's hebben geparkeerd? ");

        // get the number of cars that have parked
        int aantalAuto = CheckScanner.getValidIntInput(scanner);
        // get the license plates and the number of hours parked for each car
        String[] autoKentekens = new String[aantalAuto];
        int[] parkeerkUren = new int[aantalAuto];

        // get the license plates and the number of hours parked for each car
        for (int i = 0; i < aantalAuto; i++) {
            System.out.printf("Auto %d: %n", i + 1);
            // get the license plate
            System.out.print("Kenteken: ");
            scanner.nextLine();
            String autoKenteken = scanner.next();
            // validate the license plate length
            if (autoKenteken.length() != MAX_KENTEKEN_LENGTE) {
                System.out.println("Auto kenteken moet 8 karakters bevatten.");
                i--;
                continue;
                // autoKenteken = scanner.next();
            }
            // get the number of hours parked
            System.out.printf("Geparkeerde uren (max. 24): ");
            int parkeerUren = CheckScanner.getValidIntInput(scanner);
            // validate the number of hours parked
            if (parkeerUren > MAX_PARKEER_UREN) {
                System.out.println("De parkeerduur kan maximaal 24 uur zijn.");
                System.out.printf("Geparkeerde uren (max. 24): ");
                parkeerUren = CheckScanner.getValidIntInput(scanner);
            }
            parkeerkUren[i] = parkeerUren;
            autoKentekens[i] = autoKenteken;

        }
        // print the last message with the number of cars, their license plates, and the parked hours
        printLastMessage(aantalAuto, autoKentekens, parkeerkUren);

    }

    /**
     * Calculates the parking costs for each given parking duration.
     *
     * @param parkeerUren an array of integers representing the parking durations
     * @return an array of doubles representing the parking costs for each duration
     */
    public static double[] getParkeerKosten(int[] parkeerUren) {
        double[] parkeerKosten = new double[parkeerUren.length];
        for (int i = 0; i < parkeerUren.length; i++) {
            parkeerKosten[i] = calculateParkAmount(parkeerUren[i]);
        }
        return parkeerKosten;
    }

    /**
     * Calculates the parking cost based on the number of parking hours.
     *
     * @param parkeerUren the number of parking hours
     * @return the calculated parking cost
     */
    public static double calculateParkAmount(int parkeerUren) {
        double parkeerKost = 0;
        if (parkeerUren <= COUNT_NUMBER) {
            parkeerKost = parkeerUren * PARKEER_KOSTEN_EERSTE_DRIE_PER_URE;
        } else {
            parkeerKost = COUNT_NUMBER * PARKEER_KOSTEN_EERSTE_DRIE_PER_URE
                    + (parkeerUren - COUNT_NUMBER) * PARKEER_KOSTEN_PER_URE;
        }
        if (parkeerKost > MAX_PARKEER_KOSTEN) {
            parkeerKost = MAX_PARKEER_KOSTEN;
        }
        return parkeerKost;

    }

    /**
     * Prints the last message summarizing the parking details for each car.
     *
     * @param aantalAuto    the number of cars parked
     * @param autoKentekens an array of strings representing the license plates of
     *                      parked cars
     * @param parkeerkUren  an array of integers representing the parking hours for
     *                      each car
     */
    public static void printLastMessage(int aantalAuto, String[] autoKentekens, int[] parkeerkUren) {
        double[] parkeerKosten = getParkeerKosten(parkeerkUren);
        System.out.println();
        System.out.println("Parkeeroverzicht");
        System.out.printf("%-10s  %5s  %7s %n", "Kenteken", "Uren", "Bedrag");
        for (int i = 0; i < aantalAuto; i++) {
            System.out.printf("%-10s  %5d  %7.2f %n", autoKentekens[i], parkeerkUren[i], parkeerKosten[i]);
        }
        System.out.printf("Totaal van alle parkeergelden: %.1f euro.", ArrayCalculator.calculateSum(parkeerKosten));
    }

}
