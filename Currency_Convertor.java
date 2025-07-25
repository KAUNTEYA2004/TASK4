package PROJECTS;
import java.util.Scanner;
class CurrencyConverter {
    public static double usdToInr = 83.10;
    public static double usdToEur = 0.92;
    public static double usdToGbp = 0.78;
    public static double usdToJpy = 156.12;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("------ Currency Converter ------");
        System.out.println("Supported currencies: USD, INR, EUR, GBP, JPY");
        System.out.print("Enter source currency (e.g., USD): ");
        String fromCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter target currency (e.g., INR): ");
        String toCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();

        double result = convertCurrency(fromCurrency, toCurrency, amount);

        if (result != -1) {
            System.out.printf("Converted amount: %.2f %s\n", result, toCurrency);
        } else {
            System.out.println("Invalid currency code entered.");
        }

        scanner.close();
    }

    public static double convertCurrency(String from, String to, double amount) {
        double amountInUsd;

        // Convert source currency to USD
        switch (from) {
            case "USD":
                amountInUsd = amount;
                break;
            case "INR":
                amountInUsd = amount / usdToInr;
                break;
            case "EUR":
                amountInUsd = amount / usdToEur;
                break;
            case "GBP":
                amountInUsd = amount / usdToGbp;
                break;
            case "JPY":
                amountInUsd = amount / usdToJpy;
                break;
            default:
                return -1;
        }

        // Convert USD to target currency
        switch (to) {
            case "USD":
                return amountInUsd;
            case "INR":
                return amountInUsd * usdToInr;
            case "EUR":
                return amountInUsd * usdToEur;
            case "GBP":
                return amountInUsd * usdToGbp;
            case "JPY":
                return amountInUsd * usdToJpy;
            default:
                return -1;
        }
    }
}
