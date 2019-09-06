package exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlaning {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    List<String> lessons = Arrays.stream(scanner.nextLine()
            .split(", "))
            .collect(Collectors.toList());

    String line = scanner.nextLine();

    while (!line.equals("course start")) {

      String[] cmd = line.split(":");

      if ("Add".equals(cmd[0])) {
        if (!lessons.contains(cmd[1])) {
          lessons.add(cmd[1]);
        }

      } else if ("Insert".equals(cmd[0])) {
        int index = Integer.parseInt(cmd[2]);
        if (!lessons.contains(cmd[1])) {
          lessons.add(index, cmd[1]);
        }

      } else if ("Remove".equals(cmd[0])) {
          lessons.remove(cmd[1]);

      } else if ("Exercise".equals(cmd[0])) {
        String lessonTitle = cmd[1];

        if (!lessons.contains(lessonTitle)) {
          lessons.add(lessonTitle);
          lessons.add(lessonTitle + "-Exercise");
        } else {
          int index = lessons.indexOf(lessonTitle);
          lessons.add(index, lessonTitle + "-Exercise");
        }

      } else {
        String firstLesson = cmd[1];
        String secondLesson = cmd[2];

        if (lessons.contains(firstLesson) && lessons.contains(secondLesson)) {
          int indexOfFirstLesson = lessons.indexOf(firstLesson);
          int indexOfSecondLesson = lessons.indexOf(secondLesson);

          if (lessons.get(indexOfFirstLesson + 1).equals(firstLesson + "-Exercise")
                  && lessons.get(indexOfSecondLesson + 1).equals(secondLesson + "-Exercise")
                  && (indexOfFirstLesson < lessons.size() - 1)
                  && (indexOfSecondLesson < lessons.size() - 1)) {

            lessons.set(indexOfSecondLesson, firstLesson);
            lessons.add(indexOfSecondLesson + 1, firstLesson + "-Exercise");
            lessons.set(indexOfFirstLesson, secondLesson);
            lessons.add(indexOfFirstLesson + 1, secondLesson + "-Exercise");
            indexOfFirstLesson = lessons.indexOf(firstLesson);
            indexOfSecondLesson = lessons.indexOf(secondLesson);
            lessons.remove(indexOfFirstLesson + 1);
            lessons.remove(indexOfSecondLesson + 1);

          } else if (indexOfFirstLesson < lessons.size() - 1
                  && lessons.get(indexOfFirstLesson + 1).equals(firstLesson + "-Exercise")) {

            lessons.set(indexOfSecondLesson, firstLesson);
            lessons.add(indexOfSecondLesson + 1, firstLesson + "-Exercise");
            lessons.set(indexOfFirstLesson, secondLesson);
            indexOfFirstLesson = lessons.indexOf(firstLesson);
            indexOfSecondLesson = lessons.indexOf(secondLesson);
            lessons.remove(indexOfSecondLesson + 1);

          } else if (indexOfSecondLesson < lessons.size() - 1
                  && lessons.get(indexOfSecondLesson + 1).equals(secondLesson + "-Exercise")) {

            lessons.add(indexOfFirstLesson, secondLesson);
            lessons.add(indexOfFirstLesson + 1, secondLesson + "-Exercise");
            lessons.add(indexOfSecondLesson, firstLesson);
            indexOfFirstLesson = lessons.indexOf(firstLesson);
            indexOfSecondLesson = lessons.indexOf(secondLesson);
            lessons.remove(indexOfSecondLesson + 2);
            lessons.remove(indexOfSecondLesson + 1);
            lessons.remove(indexOfFirstLesson + 1);

          } else {

            lessons.add(indexOfSecondLesson, firstLesson);
            lessons.add(indexOfFirstLesson, secondLesson);
            lessons.remove(indexOfFirstLesson + 1);
            lessons.remove(indexOfSecondLesson + 1);
          }
        }
      }
      line = scanner.nextLine();
    }
    for (int i = 0; i < lessons.size(); i++) {
      System.out.println(String.format("%d.%s", i + 1, lessons.get(i)));
    }
  }
}

