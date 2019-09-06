package Demo;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Deciphering {

  private static String getDecrementStr(String msgToDecrement) {

    StringBuilder sb = new StringBuilder();
    for (char value : msgToDecrement.toCharArray()) {
      int nextValue = (int) value - 3;
      char symbol = (char) nextValue;
      sb.append(symbol);
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String msgToDecrement = scanner.nextLine();
    String[] replacements = scanner.nextLine().split(" ");

    char symbol;
    boolean isValid = true;
    String message;

    for (int i = 0; i < msgToDecrement.length(); i++) {
      symbol = msgToDecrement.charAt(i);
      if (symbol < 'c' || symbol > '}') {
        if (symbol != '#') {
          isValid = false;
          break;
        }
      }
    }

    if (isValid) {
      message = getDecrementStr(msgToDecrement);
      Pattern pattern = Pattern.compile(replacements[0]);
      Matcher matcher = pattern.matcher(message);
      message = matcher.replaceAll(replacements[1]);
      System.out.println(message);
    } else {
      System.out.println("This is not the book you are looking for.");
    }
  }
}