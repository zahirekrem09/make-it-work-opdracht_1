package controller;

import java.util.Scanner;


/**
 * @author Zahir Ekrem SARITEKE
 * @project Calculator for the average of two or more numbers
 * @created 16 April Tuesday 2024 - 14:34
 */
public class GemiddeldeLauncher {

    protected static final String YES = "ja";
    protected static final String NO = "nee";

    public static void main(String[] args) {
        printGemiddelde();
    }

    private static void printGemiddelde() {
        double sum = 0;
        int count = 2;
        Scanner sc = new Scanner(System.in);

        System.out.println("Dit programma berekent het gemiddelde van twee of meer getallen");

        System.out.print("Geef het eerste getal:");

        int userAnswer1 = getValidInput(sc);

//        sum += sc.nextInt();
        sum += userAnswer1;
        System.out.print("Geef het tweede getal:");
        int userAnswer2 = getValidInput(sc);
        sum += userAnswer2;
        boolean isOnRepeat = getValidAntwoordType(sc);

        while (isOnRepeat) {
            System.out.print("Geef het volgende getal:");
            int input = getValidInput(sc);
//            sum += sc.nextInt();
            sum += input;
            count++;

            isOnRepeat = getValidAntwoordType(sc);
        }

        double average = sum / count;

        String formattedAverageMsg = String.format("Het gemiddelde van jouw %d getallen is %.2f", count, average);
        System.out.println(formattedAverageMsg);


    }




    private static int getValidInput(Scanner sc) {
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

    private static boolean getValidAntwoordType(Scanner sc) {
        String antwoordType = "";
        System.out.println("Wil je van meer getallen het gemiddelde bepalen (ja/nee)?");

        while (!antwoordType.equals(YES) && !antwoordType.equals(NO)) {

            antwoordType = sc.nextLine();
            if (!antwoordType.isEmpty()) {
                if (!antwoordType.equals(YES) && !antwoordType.equals(NO)) {
                    System.out.println("Vul een geldige antwoord in alstublieft.");
                }

            }

        }

        return antwoordType.equals(YES);


    }

}
