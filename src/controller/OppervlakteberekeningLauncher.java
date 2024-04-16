package controller;

import java.util.Scanner;

/**
 * @author Zahir Ekrem SARITEKE
 * @project Calculator for the area of en rectangle
 * @created 16 April Tuesday 2024 - 13:08
 */
public class OppervlakteberekeningLauncher {

    protected static final double LONGEST = 10;
    protected static final double SHORT = 2;
    protected static final String YES = "j";
    protected static final String NO = "n";
    ;

    public static void main(String[] args) {
        printOppervlakte();
    }

    private static void printOppervlakte() {


        Scanner sc = new Scanner(System.in);
        boolean isOnRepeat = getValidAntwoordType(sc);

        while (isOnRepeat) {
            showResult(sc);
            isOnRepeat = getValidAntwoordType(sc);
        }

    }

    private static double getValidAntwoord(Scanner sc) {

        double userAnswer = 0;
        while (userAnswer <= 0) {

            if (sc.hasNextDouble()) {
                userAnswer = sc.nextDouble();

            } else {
                System.out.println("Vul een geldig input in alstublieft.");
                sc.nextLine();
            }
        }
        return userAnswer;
    }

    private static double calculateArea(double mpBasis, double mpHoogte) {
        return (mpBasis * mpHoogte) / 2.0;
    }


    private static int generateRandomNumber() {
        return (int) ((int) (Math.random() * (LONGEST - SHORT)) + SHORT);
    }

    private static void showResult(Scanner sc) {

        double mpBasis = generateRandomNumber();
        double mpHoogte = generateRandomNumber();
        float oppervlakte = (float) calculateArea(mpBasis, mpHoogte);
        float formatOppervlakte = (float) Math.round(oppervlakte * 100) / 100;

        String formatMsg = "Bereken de oppervlakte van\n" +
                "een driehoek met basis %.2f en hoogte %.2f:";
        System.out.printf(formatMsg, mpBasis, mpHoogte);

        double userAnswer = getValidAntwoord(sc);


        if (userAnswer == formatOppervlakte) {
            System.out.println("Jouw antwoord is goed!\n");
        } else {
            System.out.println("Jouw antwoord is fout!\n" +
                    "Het juiste antwoord is " + formatOppervlakte);
        }

    }

    private static boolean getValidAntwoordType(Scanner sc) {
        String antwoordType = "";
        System.out.println("Wil je de oppervlakte van een driehoek uitrekenen");
        System.out.println("Doorgaan (jaa/nee)?:");
        while (!antwoordType.equals(YES) && !antwoordType.equals(NO)) {

            antwoordType = sc.nextLine();
            if (!antwoordType.isEmpty()) {
                if (!antwoordType.equals(YES) && !antwoordType.equals(NO)) {
                    System.out.println("Vul een geldige --------antwoord in alstublieft.");
                }
                if (antwoordType.equals(NO)) {
                    sc.close();
                    System.exit(0);
                }
            }


        }

        return antwoordType.equals(YES);


    }


}
