package Demo;

import java.util.Scanner;

public class p01_BakingMasterclass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double priceForFlour = Double.parseDouble(scanner.nextLine());
        double priceForEgg = Double.parseDouble(scanner.nextLine());
        double priceForApron = Double.parseDouble(scanner.nextLine());

        double totalAprons = Math.ceil((students * 0.2) + students);
        double totalPriceAprons = priceForApron * totalAprons;

        double totalPriceEggs = (priceForEgg * 10) * students;

        int freeFlour = students / 5;
        double totalPriceFlour = priceForFlour * (students - freeFlour);

        double moneySpend = totalPriceAprons + totalPriceEggs + totalPriceFlour;

        double diff = budget - moneySpend;

        if (budget >= moneySpend) {
            System.out.printf("Items purchased for %.2f$.", moneySpend);
        } else {
            System.out.printf("%.2f$ more needed.", Math.abs(diff));
        }
    }
}