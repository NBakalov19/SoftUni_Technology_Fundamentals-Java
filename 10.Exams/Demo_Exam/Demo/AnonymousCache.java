package Demo;

import java.util.*;

public class AnonymousCache {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String input = scanner.nextLine();

    Map<String, Map<String, Long>> data = new HashMap<>();
    Map<String, Map<String, Long>> cache = new HashMap<>();

    while (!input.equals("thetinggoesskrra")) {
      String[] tokens = input.split(" \\| ");

      if (tokens.length == 1) {

        String dataSet = tokens[0];

        if (cache.containsKey(dataSet)) {
          Map<String, Long> temp = cache.get(dataSet);
          data.putIfAbsent(dataSet, temp);
          cache.remove(dataSet);
        } else {
          data.put(dataSet, new HashMap<>());
        }
      } else {
        String dataSet = tokens[1];
        String[] dataKeysAndSize = tokens[0].split(" -> ");
        String dataKeys = dataKeysAndSize[0];
        long dataSize = Integer.parseInt(dataKeysAndSize[1]);

        if (!data.containsKey(dataSet)) {
          if (!cache.containsKey(dataSet)) {
            cache.put(dataSet, new HashMap<>());
          }
          cache.get(dataSet).put(dataKeys, dataSize);
        } else {
          data.get(dataSet).put(dataKeys, dataSize);
        }

      }
      input = scanner.nextLine();
    }
    if (data.size() > 0) {
      Map<String, Long> temp = new HashMap<>();

      for (Map.Entry<String, Map<String, Long>> entry : data.entrySet()) {
        long totalPoints = entry.getValue().values().stream().reduce(0L, Long::sum);
        for (Map.Entry<String, Long> ignored : entry.getValue().entrySet()) {

          temp.put(entry.getKey(), totalPoints);
        }
      }

      String bestData = Collections.max(temp.entrySet(),
              Comparator.comparingLong(Map.Entry::getValue)).getKey();

      long bestDataSize = temp.get(bestData);


      System.out.println(String.format("Data Set: %s, Total Size: %d", bestData, bestDataSize));

      data.get(bestData).forEach((key, value) -> System.out.println(
              String.format("$.%s", key)));
    }
  }
}