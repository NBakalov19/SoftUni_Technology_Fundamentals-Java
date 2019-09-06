package exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {

  private static int sumOfCards(List<Integer> deck) {
    int sum = 0;

    for (Integer card : deck) {
      sum += card;
    }
    return sum;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    List<Integer> firstDeck =
            Arrays.stream(scanner.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

    List<Integer> secondDeck =
            Arrays.stream(scanner.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

    int sum = 0;

    int size = Math.max(firstDeck.size(), secondDeck.size());

    for (int i = 0; i < size; i++) {

      if (firstDeck.get(i).equals(secondDeck.get(i))) {
        firstDeck.remove(i);
        secondDeck.remove(i);
        i = -1;
        if (firstDeck.isEmpty()) {
          sum = sumOfCards(secondDeck);
          System.out.printf("Second player wins! Sum: %d", sum);
          break;
        } else if (secondDeck.isEmpty()) {
          sum = sumOfCards(firstDeck);
          System.out.printf("First player wins! Sum: %d", sum);
          break;
        }
      } else if (firstDeck.get(i) > secondDeck.get(i)) {
        firstDeck.add(firstDeck.get(i));
        firstDeck.add(secondDeck.get(i));
        firstDeck.remove(i);
        secondDeck.remove(i);
        i = -1;
        if (firstDeck.isEmpty()) {
          sum = sumOfCards(secondDeck);
          System.out.printf("Second player wins! Sum: %d", sum);
          break;
        } else if (secondDeck.isEmpty()) {
          sum = sumOfCards(firstDeck);
          System.out.printf("First player wins! Sum: %d", sum);
          break;
        }
      } else if (secondDeck.get(i) > firstDeck.get(i)) {
        secondDeck.add(secondDeck.get(i));
        secondDeck.add(firstDeck.get(i));
        secondDeck.remove(i);
        firstDeck.remove(i);
        i = -1;
        if (firstDeck.isEmpty()) {
          sum = sumOfCards(secondDeck);
          System.out.printf("Second player wins! Sum: %d", sum);
          break;
        } else if (secondDeck.isEmpty()) {
          sum = sumOfCards(firstDeck);
          System.out.printf("First player wins! Sum: %d", sum);
          break;
        }
      }
    }
  }
}
