package lab;

import java.util.Scanner;

public class RefactorVolumeOfPyramid {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Length: ");
    double length = Double.parseDouble(sc.nextLine());
    System.out.print("Width: ");
    double width = Double.parseDouble(sc.nextLine());
    System.out.print("Height: ");
    double height = Double.parseDouble(sc.nextLine());

    double volume = (length * width * height) / 3;

    System.out.printf("Pyramid Volume: %.2f", volume);
  }
}