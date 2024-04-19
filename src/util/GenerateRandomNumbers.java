package util;

/**
 * @author Zahir Ekrem SARITEKE
 * @project opdracht_1_2
 * @created 19 April Friday 2024 - 09:10
 */
public class GenerateRandomNumbers {

    /**
     * Generates an array of random integers within the specified range.
     *
     * @param  count  the number of random integers to generate
     * @param  min    the minimum value of the range (inclusive)
     * @param  max    the maximum value of the range (inclusive)
     * @return        an array of random integers within the specified range
     */
    public static int[] generateRandomNumbers(int count, int min, int max) {
        int[] randomNumbers = new int[count];
        //Random rand = new Random();
        for (int i = 0; i < count; i++) {
            //randomNumbers[i] = rand.nextInt(max - min + 1) + min;
            randomNumbers[i] = (int) (Math.random() * (max - min + 1)) + min;


        }
        return randomNumbers;
    }
}
