package controller;

import java.util.Scanner;

/**
 * @author Zahir Ekrem SARITEKE
 * @project Currency Exchange Calculator
 * @created 16 Nisan Salı 2024 - 09:32
 */
public class CurrencyExchangeLauncher {

    protected static final double MAX_TRANSACTION_AMOUNT = 15;
    protected static final double MIN_TRANSACTION_AMOUNT = 2;
    protected static final double TRANSACTION_FEE = 0.015;
    protected static final double USD_EXCHANGE_RATE = 1.06;
    protected static final double GBP_EXCHANGE_RATE = 0.85;
    protected static final double YEN_EXCHANGE_RATE = 163.96;


    public static void main(String[] args) {
        printCurrencyExchange();
    }

    public static void printCurrencyExchange() {
        Scanner sc = new Scanner(System.in);
        int amount = getValidAmount(sc);

        printTransactionAmount(amount);
       /* double exchangeUsd = calculateExchangeRate(amount, USD_EXCHANGE_RATE);
        double exchangeGbp = calculateExchangeRate(amount, GBP_EXCHANGE_RATE);
        double exchangeYen = calculateExchangeRate(amount, YEN_EXCHANGE_RATE);*/

//        var bodyMassIndexReturnType = calculateExchangeRateWithRecord(amount);
//        double exchangeUsd = bodyMassIndexReturnType.getUSD();
//        double exchangeGbp = bodyMassIndexReturnType.getGBP();
//        double exchangeYen = bodyMassIndexReturnType.getYEN();

        var bodyMassIndexReturnType = calculateExchangeRateWithRecord2(amount);
        double exchangeUsd = bodyMassIndexReturnType.USD();
        double exchangeGbp = bodyMassIndexReturnType.GBP();
        double exchangeYen = bodyMassIndexReturnType.YEN();
        printExchangeResult(exchangeUsd, "USD(Dollar)", USD_EXCHANGE_RATE);
        printExchangeResult(exchangeGbp, "GBP(Pound)", GBP_EXCHANGE_RATE);
        printExchangeResult(exchangeYen, "JPY(Yen)", YEN_EXCHANGE_RATE);



    }

    private static void printExchangeResult(double exchangeAmount, String currencyType, double exchangeRate) {
        String formattedAmountMsg = String.format("U krijgt hiervoor %.4f %s. (Koers is %.4f)", exchangeAmount, currencyType, exchangeRate);
        System.out.println(formattedAmountMsg);

    }

    private static double calculateExchangeRate(int amount, double exchangeRate) {
        double transactionAmount = calculateTransactionAmount(amount);
        double amountWithoutFee = amount - transactionAmount;
        return amountWithoutFee * exchangeRate;

    }

    private  static  BodyMassIndexReturnType calculateExchangeRateWithRecord(int amount) {

        double transactionAmount = calculateTransactionAmount(amount);
        double amountWithoutFee = amount - transactionAmount;

        BodyMassIndexReturnType bodyMassIndexReturnType = new BodyMassIndexReturnType();
        bodyMassIndexReturnType.setUSD(amountWithoutFee * USD_EXCHANGE_RATE);;
        bodyMassIndexReturnType.setGBP(amountWithoutFee * GBP_EXCHANGE_RATE);
        bodyMassIndexReturnType.setYEN(amountWithoutFee * YEN_EXCHANGE_RATE);
        return bodyMassIndexReturnType;

    }

    private  static  ReturnType calculateExchangeRateWithRecord2(int amount) {

        double transactionAmount = calculateTransactionAmount(amount);
        double amountWithoutFee = amount - transactionAmount;

        ReturnType bodyMassIndexReturnType = new ReturnType(amountWithoutFee * USD_EXCHANGE_RATE,
                amountWithoutFee * GBP_EXCHANGE_RATE,
                amountWithoutFee * YEN_EXCHANGE_RATE);
        return bodyMassIndexReturnType;

    }


    private static void printTransactionAmount(int amount) {

        double transactionAmount = calculateTransactionAmount(amount);
        String formattedAmount = String.format("De transactiekosten bedragen %.2f Euro.", transactionAmount);
        System.out.println(formattedAmount);
        String lastMessage = String.format("We rekenen daarom %.2f Euro voor u om.", amount - transactionAmount);
        System.out.println(lastMessage);

    }


    private static double calculateTransactionAmount(int amount) {
        var doubleAmount = (double) amount;
        var transactionAmount = doubleAmount * TRANSACTION_FEE;
        if (transactionAmount < MIN_TRANSACTION_AMOUNT) {
            transactionAmount = MIN_TRANSACTION_AMOUNT;
        } else if (transactionAmount > MAX_TRANSACTION_AMOUNT) {
            transactionAmount = MAX_TRANSACTION_AMOUNT;
        }
        return transactionAmount;
    }

    private static int getValidAmount(Scanner sc) {

        int amount = 0;
        while (amount <= 0) {
            System.out.print("In te wisselen bedrag (alleen gehele getallen en EURO) ");
            if (sc.hasNextInt()) {
                amount = sc.nextInt();
                if (amount <= 0) {
                    System.out.println("Vul een geldig amount in alstublieft.");
                }
            } else {
                System.out.println("Vul een geldig amount in alstublieft.");
                sc.nextLine();
            }
        }

        return amount;
    }
}

class BodyMassIndexReturnType {
    private  double USD;
    private double GBP;
    private double YEN;

    public BodyMassIndexReturnType() {
    }

    public double getUSD() {
        return USD;
    }

    public double getGBP() {
        return GBP;
    }

    public double getYEN() {
        return YEN;
    }

    public void setUSD(double USD) {
        this.USD = USD;
    }

    public void setGBP(double GBP) {
        this.GBP = GBP;
    }

    public void setYEN(double YEN) {
        this.YEN = YEN;
    }
}

record  ReturnType (double USD, double GBP, double YEN) {
}