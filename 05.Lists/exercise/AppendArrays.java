package exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppendArrays {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    List<String> numberList = Arrays.stream(scanner.nextLine()
            .split("\\|"))
            .collect(Collectors.toList());

    Collections.reverse(numberList);

    for (String text : numberList) {

      String[] numbersArr = text.split("\\s+");

      for (String number : numbersArr) {
        if (!number.equals("")) {
          System.out.print(number + " ");
        }
      }
    }
  }
}