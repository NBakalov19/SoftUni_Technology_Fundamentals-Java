package lab;

import java.util.Scanner;

public class TriplesOfLatinLetters {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int countOfLetters = Integer.parseInt(sc.nextLine());

    for (char i = 0; i < countOfLetters; i++) {
      for (char j = 0; j < countOfLetters; j++) {
        for (char k = 0; k < countOfLetters; k++) {
          char firstLetter = (char) ('a' + i);
          char secondLetter = (char) ('a' + j);
          char thirdLetter = (char) ('a' + k);

          System.out.println(String.format("%c%c%c", firstLetter, secondLetter, thirdLetter));
        }
      }
    }
  }
}