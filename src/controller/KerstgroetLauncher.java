package controller;

public class KerstgroetLauncher {


    public static void main(String[] args) {
        //8 kerstboom
        for (int i = 0; i < 8; i++) {
            KerstgroetLauncher.printKerstBoom();
        }
    }

    /**
     * Prints a Christmas tree shape with a greeting message.
     */
    public static void printKerstBoom() {
        // Print Merry Christmas greeting
        System.out.println("Merry Christmas!");
        System.out.println();
        // Print the Christmas tree shape
        System.out.println("    *    ");
        System.out.println("  * * *  ");
        System.out.println("   * *   ");
        System.out.println(" * * * * ");
        System.out.println("  * * *  ");
        System.out.println("* * * * *");
        System.out.println("    *    ");
        System.out.println();
    }
}
