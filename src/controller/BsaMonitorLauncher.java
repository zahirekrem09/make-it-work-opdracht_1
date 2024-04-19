package controller;

import java.util.Scanner;

import  util.ArrayCalculator;
import util.CheckScanner;

/**
 * @author Zahir Ekrem SARITEKE
 * @project  Student Advisement System
 * @created 18 April Thursday 2024 - 10:13
 */
public class BsaMonitorLauncher {

    private  static  final  String[] SUBJECTS_NAMES = {"Project Fasten Your Seatbelts",
                "Programming", "Databases", "Personal Skills","Project Skills","User Interaction","OOP 1"}; ;
    private  static  final  int[]  CREDITS = {12,3,3,2,2,3,3};
    private static final int CREDITS_SUM = ArrayCalculator.calculateSumInt(CREDITS);
    private  static  final double MAX_SCORE = 10.0;
    private  static  final double MIN_SCORE = 1.0;
    private  static  final double VALID_SCORE = 5.5;
    private  static  final double VALID_CREDITS_RATE = (5.0/6.0);



    public static void main(String[] args) {
        printBsaMonitor();
    }

    public static  void printBsaMonitor() {
        System.out.println("Voer behaalde cijfers in:");
        Scanner sc = new Scanner(System.in);

        // generate scores array with valid scores en valid credits
        double[] scores = generateScores(sc);
        // print scores table
        printScoresTable(scores);
        System.out.println();

        // check total credits
        int totalCredits = ArrayCalculator.calculateSumInt(CREDITS);
        System.out.printf("Totaal behaalde studiepunten: %d/%d%n", totalCredits, CREDITS_SUM);
        if (checkTotalCredits(totalCredits)) System.out.println("Gefeliciteerd: je ligt op schema voor een positief BSA! ");
         else  System.out.println("PAS OP: je ligt niet op schema voor een positief BSA! ");


    }


    /**
     * A method to print the scores table based on the given scores array.
     *
     * @param  scores  array of double values representing scores
     */
    private  static  void  printScoresTable(double[] scores) {
        int[] maxLengthByNames = new int[SUBJECTS_NAMES.length];
        for (int i = 0; i < SUBJECTS_NAMES.length; i++) {
            maxLengthByNames[i] = SUBJECTS_NAMES[i].length();
        }
        int maxLength = ArrayCalculator.calculateMaxInt(maxLengthByNames);

        // generate string format for pretty table
        String[] formatTextString = generateStringFormat(maxLength);
        String formatRow =formatTextString[1] ;
        String formatTitle = formatTextString[0] ;
        System.out.printf(formatTitle, "Vak/project", "Cijfer", "Behaalde punten");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf(formatRow, SUBJECTS_NAMES[i], scores[i], CREDITS[i]);
        }
    }

    /**
     * Generates an array of scores by prompting the user to input scores for each subject.
     *
     * @param  sc  the Scanner object used to read user input
     * @return     an array of scores, with each element corresponding to a subject
     */
    public  static  double[] generateScores(Scanner sc) {
        double[] scores = new double[SUBJECTS_NAMES.length];
        for (int i = 0; i < SUBJECTS_NAMES.length; i++) {
            System.out.printf("%s: ", SUBJECTS_NAMES[i]);
            double score = CheckScanner.getValidDouble(sc);
            if (score > MAX_SCORE || score < MIN_SCORE) {
                System.out.println("Cijfer mag niet hoger dan 10 zijn en minder dan 1 zijn.");
                i--;
                continue;
            }
            scores[i] = score;
            if (score <VALID_SCORE) {
                CREDITS[i] = 0;
            }
        }
        sc.close();
        return scores;

    }

    public static   boolean  checkTotalCredits(int totalCredits) {
        return CREDITS_SUM*VALID_CREDITS_RATE <= totalCredits;
    }

    /**
     * Generates a string format for creating a formatted table.
     *
     * @param  maxLength  the maximum length of the table columns
     * @return            an array containing the format strings for the table title and rows
     */
    public  static  String[] generateStringFormat(int maxLength) {
        String formatLength = "%" + maxLength;
        String formatTextBegin= "%" +"-" + maxLength;
        String formatTextString= formatLength + "s";
        String formatTextStringBegin= formatTextBegin + "s";
        String formatTextNumber= formatLength + "d";
        String formatTextFloat= formatLength + ".1f";
        String formatRow = String.format("%s %s %s %n", formatTextStringBegin, formatTextFloat, formatTextNumber);
        String formatTitle = String.format("%s %s %s %n", formatTextStringBegin, formatTextString, formatTextString);

        return new String[]{formatTitle, formatRow};
    }
}
