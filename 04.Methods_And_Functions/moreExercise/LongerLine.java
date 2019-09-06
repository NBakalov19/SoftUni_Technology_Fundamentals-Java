package moreExercise;

import java.text.DecimalFormat;
import java.util.Scanner;

public class LongerLine {
  private static String GetLongerLine(double x1, double y1, double x2, double y2,
                                      double x3, double y3, double x4, double y4) {
    double distanceOfFirstLine = DistanceOfFirstLine(x1, y1, x2, y2);
    double distanceOfSecondLine = DistanceOfSecondLine(x3, y3, x4, y4);

    if (distanceOfFirstLine <= distanceOfSecondLine) {
      return "first";
    } else {
      return "second";
    }

  }

  private static double DistanceOfFirstLine(double x1, double y1, double x2, double y2) {
    double diffOfXPowers = Math.abs(Math.pow(x2, 2) - Math.pow(x1, 2));
    double diffOfYPowers = Math.abs(Math.pow(y2, 2) - Math.pow(y1, 2));
    return Math.sqrt(diffOfXPowers + diffOfYPowers);
  }

  private static double DistanceOfSecondLine(double x3, double y3, double x4, double y4) {
    double diffOfXPowers = Math.abs(Math.pow(x4, 2) - Math.pow(x3, 2));
    double diffOfYPowers = Math.abs(Math.pow(y4, 2) - Math.pow(y3, 2));

    return Math.sqrt(diffOfXPowers + diffOfYPowers);
  }


  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    double x1 = Double.parseDouble(scanner.nextLine());
    double y1 = Double.parseDouble(scanner.nextLine());
    double x2 = Double.parseDouble(scanner.nextLine());
    double y2 = Double.parseDouble(scanner.nextLine());
    double x3 = Double.parseDouble(scanner.nextLine());
    double y3 = Double.parseDouble(scanner.nextLine());
    double x4 = Double.parseDouble(scanner.nextLine());
    double y4 = Double.parseDouble(scanner.nextLine());

    String getLongerLine = GetLongerLine(x1, y1, x2, y2, x3, y3, x4, y4);


    String decX1 = new DecimalFormat("0.####").format(x1);
    String decY1 = new DecimalFormat("0.####").format(y1);
    String decX2 = new DecimalFormat("0.####").format(x2);
    String decY2 = new DecimalFormat("0.####").format(y2);
    String decX3 = new DecimalFormat("0.####").format(x3);
    String decY3 = new DecimalFormat("0.####").format(y3);
    String decX4 = new DecimalFormat("0.####").format(x4);
    String decY4 = new DecimalFormat("0.####").format(y4);

    if (getLongerLine.equals("first")) {
      double distanceX1Y1 = Math.sqrt(Math.pow(x1, 2) + Math.pow(y1, 2));
      double distanceX2Y2 = Math.sqrt(Math.pow(x2, 2) + Math.pow(y2, 2));

      if (distanceX1Y1 <= distanceX2Y2) {
        System.out.printf("(%s, %s)(%s, %s)", decX1, decY1, decX2, decY2);
      } else {
        System.out.printf("(%s, %s)(%s, %s)", decX2, decY2, decX1, decY1);
      }
    } else {
      double distanceX3Y3 = Math.sqrt(Math.pow(x3, 2) + Math.pow(y3, 2));
      double distanceX4Y4 = Math.sqrt(Math.pow(x4, 2) + Math.pow(y4, 2));

      if (distanceX3Y3 <= distanceX4Y4) {
        System.out.printf("(%s, %s)(%s, %s)", decX3, decY3, decX4, decY4);
      } else {
        System.out.printf("(%s, %s)(%s, %S)", decX4, decY4, decX3, decY3);
      }
    }
  }
}