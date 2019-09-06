package Demo;

import java.util.ArrayList;
import java.util.Scanner;

public class p03_BakingFactory {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String line = scanner.nextLine();

    int highestQualityBatch = 0;
    double bestAverage = 0d;
    ArrayList<String> bestBatch = new ArrayList<>();
    int bestBatchLength = 0;
    int counter = 0;

    while (!line.equals("Bake It!")) {

      counter++;

      String batches = line.replaceAll("#", " ");

      String[] batchesArr = batches.split(" ");

      int sumOfBreads = 0;

      for (String s : batchesArr) {
        sumOfBreads += Integer.parseInt(s);
      }

      int localHighestQualityBread = sumOfBreads;

      double localBestAverage = sumOfBreads * 1.0 / batchesArr.length;

      String[] localBestBatch = new String[batchesArr.length];

      System.arraycopy(batchesArr, 0, localBestBatch, 0, batchesArr.length);

      int localBestLength = localBestBatch.length;

      if (localHighestQualityBread > highestQualityBatch) {
        highestQualityBatch = localHighestQualityBread;
        bestAverage = localBestAverage;
        if (bestBatch.size() == 0) {
          for (int i = 0; i < localBestBatch.length; i++) {
            bestBatch.add(i, localBestBatch[i]);
          }
        } else {
          bestBatch.clear();
          for (int i = 0; i < localBestBatch.length; i++) {
            bestBatch.add(i, localBestBatch[i]);
          }
        }
        bestBatchLength = localBestLength;
      } else if (localHighestQualityBread == highestQualityBatch && localBestAverage > bestAverage) {
        bestAverage = localBestAverage;
        bestBatch.clear();
        for (int i = 0; i < localBestBatch.length; i++) {
          bestBatch.add(i, localBestBatch[i]);
        }
        bestBatchLength = localBestLength;
      } else if (localHighestQualityBread == highestQualityBatch
              && localBestAverage == bestAverage && localBestLength < bestBatchLength) {
        bestBatch.clear();
        for (int i = 0; i < localBestBatch.length; i++) {
          bestBatch.add(i, localBestBatch[i]);
        }
        bestBatchLength = localBestLength;
      } else if (counter == 1) {
        highestQualityBatch = localHighestQualityBread;
        bestAverage = localBestAverage;
        bestBatch.clear();
        for (int i = 0; i < localBestBatch.length; i++) {
          bestBatch.add(i, localBestBatch[i]);
        }
        bestBatchLength = localBestLength;
      }

      line = scanner.nextLine();
    }
    System.out.println(String.format("Best Batch quality: %d", highestQualityBatch));
    for (String batch : bestBatch) {
      System.out.print(batch + " ");
    }
  }
}