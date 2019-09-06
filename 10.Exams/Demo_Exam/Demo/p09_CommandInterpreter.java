package Demo;

import java.util.*;
import java.util.stream.Collectors;

public class p09_CommandInterpreter {

  private static List<String> reversedSubList(List<String> text, int startIndex, int count) {
    List<String> subList = text.subList(startIndex, startIndex + count);

    List<String> reversed = new ArrayList<>();

    for (int i = subList.size() - 1; i >= 0; i--) {
      reversed.add(subList.get(i));
    }
    return reversed;
  }

  private static List<String> sortSubList(List<String> text, int startIndex, int count) {
    List<String> subList = text.subList(startIndex, (startIndex + count) + 1);

    subList.sort(Comparator.naturalOrder());

    return subList;
  }

  private static void leftRotatedList(List<String> text, int rotations) {

    rotations = rotations % text.size();

    for (int i = 0; i < rotations; i++) {
      String temp = text.get(0);
      for (int j = 0; j < text.size() - 1; j++) {
        text.set(j, text.get(j + 1));
      }
      text.set(text.size() - 1, temp);
    }

  }

  private static void rightRotatedList(List<String> text, int rotations) {

    rotations = rotations % text.size();

    for (int i = 0; i < rotations; i++) {
      String temp = text.get(text.size() - 1);
      for (int j = text.size() - 1; j > 0; j--) {
        text.set(j, text.get(j - 1));
      }
      text.set(0, temp);
    }

  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    List<String> text = Arrays
            .stream(scanner.nextLine().split("\\s+"))
            .collect(Collectors.toList());

    String line = scanner.nextLine();

    while (!line.equals("end")) {

      String[] cmd = line.split(" ");
      String command = cmd[0];
      int firstElement = text.indexOf(text.get(0));
      int lastElement = text.size() - 1;

      if ("reverse".equals(command)) {
        int startIndex = Integer.parseInt(cmd[2]);
        int count = Integer.parseInt(cmd[4]);
        if (startIndex >= firstElement && startIndex < lastElement
                && startIndex + count <= lastElement && count >= 0) {

          text.addAll(startIndex + count, reversedSubList(text, startIndex, count));
          text.subList(startIndex, startIndex + count).clear();

        } else {
          System.out.println("Invalid input parameters.");
        }
      } else if ("sort".equals(command)) {
        int startIndex = Integer.parseInt(cmd[2]);
        int count = Integer.parseInt(cmd[4]);
        if (startIndex >= firstElement && startIndex < lastElement
                && startIndex + count <= lastElement && count >= 0) {

          text.addAll(startIndex + count, sortSubList(text, startIndex, count));
          text.subList(startIndex, startIndex + count).clear();
        } else {
          System.out.println("Invalid input parameters.");
        }
      } else if ("rollLeft".equals(command)) {
        int rotations = Integer.parseInt(cmd[1]);
        if (rotations > 0) {
          leftRotatedList(text, rotations);
        } else {
          System.out.println("Invalid input parameters.");
        }
      } else {
        int rotations = Integer.parseInt(cmd[1]);
        if (rotations > 0) {
          rightRotatedList(text, rotations);
        } else {
          System.out.println("Invalid input parameters.");
        }
      }

      line = scanner.nextLine();
    }
    String output = String.join(", ", text);
    System.out.println(String.format("[%s]", output));
  }
}