import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            displayMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    convertCurrency(scanner, "SEK", "USD", 0.11);
                    break;
                case 2:
                    convertCurrency(scanner, "USD", "SEK", 9.10);
                    break;
                case 3:
                    convertCurrency(scanner, "SEK", "EUR", 0.095);
                    break;
                case 4:
                    convertCurrency(scanner, "EUR", "SEK", 10.50);
                    break;
                case 5:
                    convertCurrency(scanner, "USD", "EUR", 0.85);
                    break;
                case 6:
                    convertCurrency(scanner, "EUR", "USD", 1.18);
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("Currency Converter Menu:");
        System.out.println("1. Convert SEK to USD");
        System.out.println("2. Convert USD to SEK");
        System.out.println("3. Convert SEK to EUR");
        System.out.println("4. Convert EUR to SEK");
        System.out.println("5. Convert USD to EUR");
        System.out.println("6. Convert EUR to USD");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void convertCurrency(Scanner scanner, String fromCurrency, String toCurrency, double rate) {
        System.out.print("Enter amount in " + fromCurrency + ": ");
        if (scanner.hasNextDouble()) {
            double amount = scanner.nextDouble();
            if (amount < 0) {
                System.out.println("Amount cannot be negative.");
            } else {
                double convertedAmount = amount * rate;
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                System.out.printf("Converted amount: %.2f %s (as of %s)%n", convertedAmount, toCurrency, now.format(formatter));
            }
        } else {
            System.out.println("Invalid input. Please enter a numeric value.");
            scanner.next();
        }
    }
}


//CODE REFS LEXICON-G52-AE:
//https://www.w3schools.com/java/ref_output_printf.asp
//https://www.w3schools.com/java/java_packages.asp
//https://www.w3schools.com/java/java_date.asp
//https://www.scaler.com/topics/currency-converter-java-project/
