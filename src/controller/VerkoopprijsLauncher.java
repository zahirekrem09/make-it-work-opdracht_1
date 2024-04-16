package controller;

import java.util.Scanner;

/**
 * @author Zahir Ekrem SARITEKE
 * @project Calculator for Verkoopprijs
 * @created 15 Nisan Pazartesi 2024 - 22:23
 */

/*inkoopprijs x winstmarge x btw percentage,  €500,- x 15% x 21%
oftewel
€ 500 x 1,15 x 1,21 = € 695,75*/

public class VerkoopprijsLauncher {
    protected static final double BTW_HOOG = 0.21;
    protected static final double BTW_LAAG = 0.06;

    public static void main(String[] args) {
        printVerkoopprijs();
    }

    private static void printVerkoopprijs() {

        Scanner sc = new Scanner(System.in);
        double inkoopprijs = getValidInkoopprijs(sc);
        double btwPercentage = getValidBtwPercentage(sc);
        double winstMarge = getValidWinstMarge(sc);
        double verkoopprijsMetBTW = calculateVerkoopprijs(inkoopprijs, btwPercentage, winstMarge, true);
        double verkoopprijsZonderBTW = calculateVerkoopprijs(inkoopprijs, btwPercentage, winstMarge, false);
        System.out.printf("Verkoopprijs exclusief BTW: %.5f", verkoopprijsZonderBTW);
        System.out.println();
        System.out.printf("Verkoopprijs inclusief %s%d BTW:: %.5f", "%", (int) (btwPercentage * 100), verkoopprijsMetBTW);
    }

    private static double calculateVerkoopprijs(double inkoopprijs, double btwPercentage, double winstMarge, boolean isBtw) {
        double verkoopprijs = isBtw ? inkoopprijs * (1 + winstMarge / 100) : inkoopprijs * (1 + winstMarge / 100) * (1 + btwPercentage);
        return verkoopprijs;
    }

    private static double getValidWinstMarge(Scanner sc) {

        double winstMarge = 0;
        while (winstMarge <= 0) {
            System.out.print("Geef je winstmarge in: ");
            if (sc.hasNextDouble()) {
                winstMarge = sc.nextDouble();
                if (winstMarge <= 0 || winstMarge > 100) {
                    System.out.println("Vul een geldig winstmarge in alstublieft.");
                }
            } else {
                System.out.println("Vul een geldig winstmarge in alstublieft.");
                sc.nextLine();
            }
        }
        return winstMarge;
    }

    private static double getValidBtwPercentage(Scanner sc) {
        int percentageType = 0;

        while (percentageType != 1 && percentageType != 2) {
            var btwPercentageMsg = String.format("""
                    Wat is de btwPercentage?
                    1. %s %d
                    2. %s %d""", "%", (int) (BTW_HOOG * 100), "%", (int) (BTW_LAAG * 100));
            System.out.println(
                    btwPercentageMsg
            );
            System.out.print("Geef de btwPercentage in: ");
            if (sc.hasNextInt()) {
                percentageType = sc.nextInt();
                if (percentageType != 1 && percentageType != 2) {
                    System.out.println("Vul een geldig btwPercentage in alstublieft.");
                }
            } else {
                System.out.println("Vul een geldig btwPercentage in alstublieft.");
                sc.nextLine();
            }
        }
        return percentageType == 1 ? BTW_HOOG : BTW_LAAG;

    }

    private static double getValidInkoopprijs(Scanner sc) {

        double inkoopprijs = 0.0;
        while (inkoopprijs <= 0) {
            System.out.print("Geef de inkoopprijs in: ");
            if (sc.hasNextDouble()) {
                inkoopprijs = sc.nextDouble();
                if (inkoopprijs <= 0) {
                    System.out.println("Vul een geldig inkoopprijs in alstublieft.");
                }
            } else {
                System.out.println("Vul een geldig inkoopprijs in alstublieft.");
                sc.nextLine();
            }
        }


        return inkoopprijs;
    }
}
