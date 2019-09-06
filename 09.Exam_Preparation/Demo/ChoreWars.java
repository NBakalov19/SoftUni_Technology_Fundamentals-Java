package Demo;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChoreWars {
  private static int getTime(String line, Pattern pattern) {
    int time = 0;

    Matcher matcherForDishes = pattern.matcher(line);
    while (matcherForDishes.find()) {
      String timeCommand = matcherForDishes.group(1);
      for (int i = 0; i < timeCommand.length(); i++) {
        char symbol = timeCommand.charAt(i);
        if (Character.isDigit(symbol)) {
          time += Integer.parseInt(String.valueOf(symbol));
        }
      }
    }
    return time;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String line = scanner.nextLine();

    int timeForDishes = 0;
    int timeForCleaning = 0;
    int timeForLaundry = 0;

    Pattern patternForDishes = Pattern.compile("<([a-z0-9]+)>");
    Pattern patternForCleaning = Pattern.compile("\\[([A-Z0-9]+)]");
    Pattern patternForLaundry = Pattern.compile("\\{(.+)}");

    while (!line.equals("wife is happy")) {

      timeForDishes += getTime(line, patternForDishes);
      timeForCleaning += getTime(line, patternForCleaning);
      timeForLaundry += getTime(line, patternForLaundry);

      line = scanner.nextLine();
    }

    int totalTime = timeForCleaning + timeForDishes + timeForLaundry;

    System.out.println(String.format("Doing the dishes - %d min.", timeForDishes));
    System.out.println(String.format("Cleaning the house - %d min.", timeForCleaning));
    System.out.println(String.format("Doing the laundry - %d min.", timeForLaundry));
    System.out.println(String.format("Total - %d min.", totalTime));
  }
}