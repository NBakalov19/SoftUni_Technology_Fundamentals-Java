package Tech3Exercises.MapsLambdaLINQ.p06_UserLogs;

import java.util.*;

public class p06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Map<String, Map<String, Integer>> server = new TreeMap<>();

        while (!line.equals("end")) {

            String[] tokens = line.split("\\s+");

            String[] ipInfo = tokens[0].split("=");
            String[] userInfo = tokens[2].split("=");

            String ip = ipInfo[1];
            String username = userInfo[1];

            if (!server.containsKey(username)) {
                LinkedHashMap<String, Integer> tempMap = new LinkedHashMap<>();
                tempMap.put(ip, 1);
                server.put(username, tempMap);
            } else {
                if (!server.get(username).containsKey(ip)) {
                    server.get(username).put(ip, 1);
                } else {
                    server.get(username).put(ip, server.get(username).get(ip) + 1);
                }
            }

            line = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Integer>> entry : server.entrySet()) {
            System.out.println(String.format("%s: ", entry.getKey()));
            List<String> temp = new ArrayList<>();
            for (Map.Entry<String, Integer> ipPair : entry.getValue().entrySet()) {
                temp.add(String.format("%s => %d", ipPair.getKey(), ipPair.getValue()));
            }
            System.out.println(String.join(", ", temp) + ".");
        }
    }
}