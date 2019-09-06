package Tech3Exercises.MapsLambdaLINQ.SrabskoUnleashed;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Map<String, Integer>> venues = new LinkedHashMap<>();

        Pattern pattern = Pattern.compile("(([a-zA-Z]+\\s){1,3})@(([a-zA-Z]+\\s){1,3})(\\d+)\\s(\\d+)");
        while (!input.equals("End")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {

                String venue;
                String singer;
                int pricePerTicket;
                int ticketsCount;

                singer = matcher.group(1);
                venue = matcher.group(3);
                pricePerTicket = Integer.parseInt(matcher.group(5));
                ticketsCount = Integer.parseInt(matcher.group(6));
                int profit = pricePerTicket * ticketsCount;

                if (!venues.containsKey(venue)) {
                    Map<String, Integer> singerProfit = new LinkedHashMap<>();
                    singerProfit.put(singer, profit);
                    venues.put(venue, singerProfit);
                } else {
                    if (!venues.get(venue).containsKey(singer)) {
                        venues.get(venue).put(singer, profit);
                    } else {
                        venues.get(venue).put(singer, venues.get(venue).get(singer) + profit);
                    }
                }

            }
            input = scanner.nextLine();
        }

        venues.entrySet().stream()
                .sorted((v1, v2) -> v2.getValue().values()
                        .stream()
                        .reduce(0, Integer::sum)
                        .compareTo(
                                v1.getValue().values()
                                        .stream()
                                        .reduce(0, Integer::sum)))
                .forEach(venue -> {
                    System.out.println(String.format("%s", venue.getKey()));

                    venue.getValue().entrySet()
                            .stream()
                            .sorted((s1, s2) ->
                                    s2.getValue().compareTo(s1.getValue()))
                            .forEach(
                                    singer -> System.out.println(String.format("#  %s-> %d",
                                            singer.getKey(), singer.getValue())));
                });
    }
}