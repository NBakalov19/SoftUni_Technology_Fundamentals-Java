package Tech3Exercises.MapsLambdaLINQ.p08_LogsAggregator;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.String.*;

public class p08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfLogs = Integer.parseInt(scanner.nextLine());

        Map<String, List<String>> userAndIp = new TreeMap<>();
        Map<String, Integer> userAndTime = new TreeMap<>();

        for (int i = 0; i < countOfLogs; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String user = tokens[1];
            String ip = tokens[0];
            int time = Integer.parseInt(tokens[2]);

            userAndIp.putIfAbsent(user, new ArrayList<>());
            userAndIp.get(user).add(ip);
            List<String> sorted = userAndIp.get(user).stream().sorted().collect(Collectors.toList());
            userAndIp.put(user, sorted);
            userAndTime.putIfAbsent(user, 0);
            userAndTime.put(user, userAndTime.get(user) + time);
        }


        for (Map.Entry<String, List<String>> entry : userAndIp.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            System.out.println(
                    format("%s: %d %s", key,
                            userAndTime.get(key)
                            , value.stream().distinct().collect(Collectors.toList())
                    ));
        }
    }
}