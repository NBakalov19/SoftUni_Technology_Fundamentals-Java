package moreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortPrintArray {
  private static boolean isVowel(char symbol) {
    String vowels = "aeiouAEIOU";

    return vowels.contains(symbol + "");
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int countOfWords = Integer.parseInt(scanner.nextLine());
    int[] sums = new int[countOfWords];

    for (int i = 0; i < countOfWords; i++) {

      String word = scanner.nextLine();
      int sum = 0;
      for (int j = 0; j < word.length(); j++) {
        char symbol = word.charAt(j);

        if (isVowel(symbol)) {
          sum += symbol * word.length();
        } else {
          sum += symbol / word.length();
        }
      }
      sums[i] = sum;
    }

    Arrays.sort(sums);

    for (int element : sums) {
      System.out.println(element);
    }
  }
}