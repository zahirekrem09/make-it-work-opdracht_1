package controller;

import java.time.Year;
import java.util.Scanner;

public class LeeftijdBerekeningLauncher {

    protected static final String USER_NAME_MSG = "Hoe heet je? ";
    protected static final String USER_BIRTH_YEAR_MSG = "Wat is je geboortejaar? ";
    protected static final String ERR_BIRTH_MSG = "Vul een geldig jaar in alstublieft.";
    protected static final String ERR_NAME_MSG = "Vul een geldig name in alstublieft.";
    protected static final String LAST_MSG = "Beste %s, eind %d zal je leeftijd %d zijn.";
    protected static final int CURRENT_YEAR = Year.now().getValue();

    public static void main(String[] args) {
        printLeeftijd();
    }


    /**
     * Prints the age of the person based on their birth year.
     */
    public static void printLeeftijd() {
        Scanner sc = new Scanner(System.in);
        System.out.print(USER_NAME_MSG);
        String name = sc.nextLine();

        while (true) {
            if (name.isEmpty()) {
                System.out.println(ERR_NAME_MSG);
                name = sc.nextLine();
            } else {
                break;
            }
        }
        System.out.print(USER_BIRTH_YEAR_MSG);
        int birth;

        while (true) {
            if (sc.hasNextInt()) {
                birth = sc.nextInt();

                if (birth < 1900 || birth > CURRENT_YEAR) {
                    System.out.println(ERR_BIRTH_MSG);
                    continue;
                }
                int age = CURRENT_YEAR - birth;
                String message = String.format(LAST_MSG, name, CURRENT_YEAR, age);
                System.out.println(message);
                sc.close();
                break;
            } else {
                System.out.println(ERR_BIRTH_MSG);
                sc.nextLine();
            }


        }


    }

}

