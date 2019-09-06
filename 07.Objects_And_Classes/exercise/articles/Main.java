package exercise.articles;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String[] data = scanner.nextLine().split(", ");

    Article article = new Article(data[0], data[1], data[2]);

    int n = Integer.parseInt(scanner.nextLine());

    while (n > 0) {
      String[] tokens = scanner.nextLine().split(": ");
      String command = tokens[0];

      switch (command) {
        case "Edit":
          article.edit(tokens[1]);
          break;
        case "ChangeAuthor":
          article.changeAuthor(tokens[1]);
          break;
        default:
          article.rename(tokens[1]);
          break;
      }
      n--;
    }
    System.out.println(article.toString());
  }
}