package exercise.articlesV2;

import exercise.articles.Article;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ArticlesV2 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int countOfArticles = Integer.parseInt(scanner.nextLine());

    ArrayList<Article> articlesArrList = new ArrayList<>();

    for (int i = 0; i < countOfArticles; i++) {
      String[] line = scanner.nextLine().split(", ");

      String title = line[0];
      String content = line[1];
      String author = line[2];

      Article article = new Article(title, content, author);

      articlesArrList.add(article);
    }

    String command = scanner.nextLine();

    switch (command) {
      case "title":
        articlesArrList.stream()
                .sorted(Comparator.comparing(Article::getTitle))
                .forEach(article -> System.out.println(article.toString()));
        break;
      case "content":
        articlesArrList.stream()
                .sorted(Comparator.comparing(Article::getContent))
                .forEach(article -> System.out.println(article.toString()));
        break;
      case "author":
        articlesArrList.stream()
                .sorted(Comparator.comparing(Article::getAuthor))
                .forEach(article -> System.out.println(article.toString()));
        break;
      default:
        break;

    }
  }
}