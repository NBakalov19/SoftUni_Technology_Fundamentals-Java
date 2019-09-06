package Demo;

import java.util.Scanner;

public class p04_Hogswatch {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int initialHomesToVisit = Integer.parseInt(scanner.nextLine());
    int initialPresents = Integer.parseInt(scanner.nextLine());
    int totalAdditionalPresentsTaken = 0;
    int visitedHomes = 0;
    int returnInWorkshop = 0;
    int presents = initialPresents;
    int homesToVisit = initialHomesToVisit;

    while (homesToVisit > 0) {

      int presentPerHome = Integer.parseInt(scanner.nextLine());

      visitedHomes++;

      if (presents - presentPerHome >= 0) {

        presents -= presentPerHome;

      } else {
        int notEnoughPresets = presentPerHome - presents;
        int additionalPresentsTaken = (initialPresents / visitedHomes)
                * (initialHomesToVisit - visitedHomes) + notEnoughPresets;

        totalAdditionalPresentsTaken += additionalPresentsTaken;
        presents += additionalPresentsTaken;
        returnInWorkshop++;

        presents -= presentPerHome;
      }

      homesToVisit--;
    }

    if (returnInWorkshop > 0) {
      System.out.println(returnInWorkshop);
      System.out.println(totalAdditionalPresentsTaken);
    } else {
      System.out.println(presents);
    }
  }
}