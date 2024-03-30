import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        int prenciples = 0;
        float monthlyInterest = 0;
        int numbersOfPayments = 0;
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.print("Principal: ");
            if(scanner.hasNextInt()) {
                prenciples = scanner.nextInt();
                if (prenciples >= 1000 && prenciples <= 1_000_000)
                    break;
                System.out.print("Enter a value between 1K and 1M \n");
            } else {
                System.out.print("Prenciple must be in numbers\n");
                scanner.next();
            }
        }

        while (true){
            System.out.print("Annual Interest Rate: ");
            if(scanner.hasNextFloat()) {
                float annualInterest = scanner.nextFloat();
                if (annualInterest >= 1 && annualInterest <= 30) {
                    monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
                    break;
                }
                System.out.print("Enter a value between 1 and 30\n");
            } else {
                System.out.print("Annual Interest Rate must be in numbers\n");
                scanner.next();
            }
        }


        while (true){
            System.out.print("Period (Years): ");
            if(scanner.hasNextByte()) {
                byte years = scanner.nextByte();
                if (years >= 1 && years <= 30){
                    numbersOfPayments = years * MONTHS_IN_YEAR;
                    break;
                }
                System.out.print("Enter a value between 1 and 30\n");
            } else {
                System.out.print("Period must be in Numbers \n");
                scanner.next();
            }
        }

        double mortage = prenciples * (monthlyInterest * Math.pow(1 + monthlyInterest, numbersOfPayments)) / (Math.pow( 1 + monthlyInterest, numbersOfPayments));
        String mortageFormated = NumberFormat.getCurrencyInstance().format(mortage);
        System.out.print("Mortgate " + mortageFormated);
    }
}