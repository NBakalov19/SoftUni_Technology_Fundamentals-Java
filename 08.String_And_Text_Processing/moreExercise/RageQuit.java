package moreExercise;

import java.util.Scanner;

public class RageQuit {

  private static String repStr(StringBuilder str, int count) {
    StringBuilder sb = new StringBuilder();

    sb.append(String.valueOf(str).repeat(Math.max(0, count)));
    return sb.toString();
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String input = scanner.nextLine();

    StringBuilder rageMessage = new StringBuilder();
    StringBuilder pairs = new StringBuilder();
    StringBuilder digits = new StringBuilder();
    int uniqueSymbols = 0;
    int countOfPairs = 0;

    for (int i = 0; i < input.length(); i++) {
      if (!(Character.isDigit(input.charAt(i)))) {
        char symbol = input.charAt(i);
        if (Character.isLetter(symbol)) {
          symbol = Character.toUpperCase(symbol);
          uniqueSymbols++;
          if (pairs.length() > 0) {
            for (int j = 0; j < pairs.length(); j++) {
              if (pairs.charAt(j) == symbol) {
                uniqueSymbols--;
                break;
              }
            }
          }
          if (rageMessage.length() > 0) {
            for (int j = 0; j < rageMessage.length(); j++) {
              if (rageMessage.charAt(j) == symbol) {
                uniqueSymbols--;
                break;
              }
            }
          }
          pairs.append(symbol);
        } else {
          uniqueSymbols++;
          if (pairs.length() > 0) {
            for (int j = 0; j < pairs.length(); j++) {
              if (pairs.charAt(j) == symbol) {
                uniqueSymbols--;
                break;
              }
            }
          }
          if (rageMessage.length() > 0) {
            for (int j = 0; j < rageMessage.length(); j++) {
              if (rageMessage.charAt(j) == symbol) {
                uniqueSymbols--;
                break;
              }
            }
          }
          pairs.append(symbol);
        }
        i++;
        while (!Character.isDigit(input.charAt(i))) {
          symbol = input.charAt(i);
          if (Character.isLetter(symbol)) {
            symbol = Character.toUpperCase(symbol);
            uniqueSymbols++;
            if (pairs.length() > 0) {
              for (int j = 0; j < pairs.length(); j++) {
                if (pairs.charAt(j) == symbol) {
                  uniqueSymbols--;
                  break;
                }
              }
              if (rageMessage.length() > 0) {
                for (int j = 0; j < rageMessage.length(); j++) {
                  if (rageMessage.charAt(j) == symbol) {
                    uniqueSymbols--;
                    break;
                  }
                }
              }
            }
            pairs.append(symbol);
          } else {
            uniqueSymbols++;
            if (pairs.length() > 0) {
              for (int j = 0; j < pairs.length(); j++) {
                if (pairs.charAt(j) == symbol) {
                  uniqueSymbols--;
                  break;
                }
              }
            }
            if (rageMessage.length() > 0) {
              for (int j = 0; j < rageMessage.length(); j++) {
                if (rageMessage.charAt(j) == symbol) {
                  uniqueSymbols--;
                  break;
                }
              }
            }
            pairs.append(symbol);
          }
          i++;
        }
      }
      if (Character.isDigit(input.charAt(i))) {
        digits.append(input.charAt(i));
        if (i < input.length() - 1) {
          if (Character.isDigit(input.charAt(i + 1))) {
            digits.append(input.charAt(i));
          }
        }
        countOfPairs = Integer.parseInt(digits.toString());
      }

      rageMessage.append(repStr(pairs, countOfPairs));
      pairs = new StringBuilder();
      digits = new StringBuilder();
    }
    System.out.println(String.format("Unique symbols used: %d", uniqueSymbols));
    System.out.println(rageMessage);
  }
}