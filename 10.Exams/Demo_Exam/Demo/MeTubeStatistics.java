package Demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MeTubeStatistics {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String line = scanner.nextLine();

    Map<String, Integer> videosWithViews = new HashMap<>();
    Map<String, Integer> videosWithLikes = new HashMap<>();

    while (!line.equals("stats time")) {

      String[] command = line.split("[ :]");

      if (command[0].equals("like") || command[0].equals("dislike")) {
        String[] tokens = line.split(":");
        String title = tokens[1];
        if (videosWithLikes.containsKey(title)) {
          if (command[0].equals("like")) {
            videosWithLikes.put(title, videosWithLikes.get(title) + 1);
          } else {
            videosWithLikes.put(title, videosWithLikes.get(title) - 1);
          }
        }
      } else {
        String[] tokens = line.split("-");
        String title = tokens[0];
        int views = Integer.parseInt(tokens[1]);

        if (!videosWithViews.containsKey(title)) {
          videosWithViews.put(title, views);
        } else {
          videosWithViews.put(title, videosWithViews.get(title) + views);
        }

        if (!videosWithLikes.containsKey(title)) {
          videosWithLikes.put(title, 0);
        }

      }

      line = scanner.nextLine();
    }

    String sortCommand = scanner.nextLine();

    if (sortCommand.equals("by likes")) {
      videosWithLikes.entrySet()
              .stream()
              .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
              .forEach(entry -> System.out.println(
                      String.format("%s - %d views - %d likes",
                              entry.getKey(), videosWithViews.get(entry.getKey()), entry.getValue())
              ));
    } else {
      videosWithViews.entrySet()
              .stream()
              .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
              .forEach(entry -> System.out.println(
                      String.format("%s - %d views - %d likes",
                              entry.getKey(), entry.getValue(), videosWithLikes.get(entry.getKey()))
              ));
    }
  }
}