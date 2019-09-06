package Demo;

import java.util.Scanner;

public class GoogleSearches {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    int days = Integer.parseInt(scanner.nextLine());
    int users = Integer.parseInt(scanner.nextLine());
    double moneyPerSearch = Double.parseDouble(scanner.nextLine());
    int counter = 1;
    double totalMoney = 0d;

    while (users > 0) {

      int words = Integer.parseInt(scanner.nextLine());
      double money = 0d;


      if (words == 1) {
        money += moneyPerSearch * 2;
      } else if (words > 5) {
        money += 0;
      } else {
        money += moneyPerSearch;
      }

      if (counter % 3 == 0) {
        money *= 3;
      }

      totalMoney += money;
      users--;
      counter++;
    }

    totalMoney *= days;

    System.out.println(String.format("Total money earned for %d days: %.2f", days, totalMoney));
  }
}