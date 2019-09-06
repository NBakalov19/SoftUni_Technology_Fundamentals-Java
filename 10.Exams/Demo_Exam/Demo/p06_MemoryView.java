package Demo;

import java.util.ArrayList;
import java.util.Scanner;

public class p06_MemoryView {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String line = scanner.nextLine();

    while (!line.equals("Visual Studio crash")) {

      String[] sequence = line.split(" ");

      ArrayList<String> code = new ArrayList<>();

      for (int i = 0; i < sequence.length; i++) {
        code.add(i, sequence[i]);
      }

      code.removeIf(s -> s.equals("0"));

      int[] codeInInteger = code.stream().mapToInt(Integer::parseInt).toArray();

      StringBuilder word = new StringBuilder();

      int beginOfLoop = code.indexOf(code.get(4));

      for (int i = beginOfLoop; i < code.size(); i++) {
        word.append((char) codeInInteger[i]);
      }

      System.out.println(word);
      line = scanner.nextLine();

    }
  }
  //70/100
}