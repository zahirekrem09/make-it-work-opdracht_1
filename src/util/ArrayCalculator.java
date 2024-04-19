package util;

/**
 * @author Zahir Ekrem SARITEKE
 * @project opdracht_1_2
 * @created 18 April Thursday 2024 - 10:37
 */
public class ArrayCalculator {

    public  static  double calculateAverage(double[] numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return sum / numbers.length;
    }

    public  static  double calculateSum(double[] numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return sum ;
    }public  static  int calculateSumInt(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum ;
    }

    public  static  double calculateMax(double[] numbers) {
        double maximum = numbers[0];
        for (double number : numbers) {
            if (number > maximum) {
                maximum = number;
            }
        }
        return maximum;
    }
    public  static  int calculateMaxInt(int[] numbers) {
        int maximum = numbers[0];
        for (int number : numbers) {
            if (number > maximum) {
                maximum = number;
            }
        }
        return maximum;
    }
    public static int geefHoogsteScore(int[] mpScores) {
        int hoogsteScore = -1;
        for (int number : mpScores) {
            hoogsteScore = Math.
                    max(hoogsteScore, number);
        }
        return hoogsteScore;
    }


    public  static  double calculateMin(double[] numbers) {
        double min = numbers[0];
        for (double number : numbers) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }
}
