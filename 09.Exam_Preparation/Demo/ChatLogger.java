package Demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ChatLogger {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String line = scanner.nextLine();

    ArrayList<String> chatLogger = new ArrayList<>();

    while (!line.equals("end")) {
      String[] tokens = line.split("\\s+");
      String commands = tokens[0];
      String message = tokens[1];
      if ("Chat".equals(commands)) {
        chatLogger.add(message);
      } else if ("Delete".equals(commands)) {
        if (chatLogger.contains(message)) {
          chatLogger.remove(message);
        } else {
          continue;
        }
      } else if ("Edit".equals(commands)) {
        String editedMessage = tokens[2];
        int indexOfMsg = chatLogger.indexOf(message);
        chatLogger.set(indexOfMsg, editedMessage);
      } else if ("Pin".equals(commands)) {
        chatLogger.remove(message);
        chatLogger.add(message);
      } else if ("Spam".equals(commands)) {
        chatLogger.addAll(Arrays.asList(tokens).subList(1, tokens.length));
      }
      line = scanner.nextLine();
    }

    for (String message : chatLogger) {
      System.out.println(message);
    }
  }
}