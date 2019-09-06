package exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);


    List<Integer> numbers =
            Arrays.stream(scanner.nextLine().split("\\s+"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

    String line = scanner.nextLine();

    while (!line.equals("end")) {

      String[] command = line.split("\\s+");

      if (command[0].equals("Delete")) {
        int element = Integer.parseInt(command[1]);

        while (numbers.contains(element)) {
          numbers.remove(Integer.valueOf(element));
        }

      } else if (command[0].equals("Insert")) {
        int element = Integer.parseInt(command[1]);
        int index = Integer.parseInt(command[2]);

        if (index < numbers.size()) {
          numbers.add(index, element);
        }
      }

      line = scanner.nextLine();
    }

    for (int numb : numbers) {
      System.out.print(numb + " ");
    }
  }
}