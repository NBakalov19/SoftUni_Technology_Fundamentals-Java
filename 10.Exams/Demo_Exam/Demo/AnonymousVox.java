package Demo;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class AnonymousVox {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String text = scanner.nextLine();

    List<String> placeholders = Arrays
            .stream(scanner.nextLine().split("[{}]+"))
            .collect(Collectors.toList());

    placeholders.removeIf(s -> s.length() == 0);

    Pattern pattern = Pattern.compile("([a-zA-Z]+)(.+)\\1");
    Matcher matcher = pattern.matcher(text);

    int placeholderIndex = 0;

    while (matcher.find()) {
      text = text.replace(matcher.group(2), placeholders.get(placeholderIndex++));
    }

    System.out.println(text);
  }
}