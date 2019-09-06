package Tech3Exercises.MapsLambdaLINQ.p07_PopulationCounter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\|");
        Map<String, Map<String, Long>> countries = new LinkedHashMap<>();

        while (!input[0].equals("report")) {

            String city = input[0];
            String country = input[1];
            long population = Long.parseLong(input[2]);

            if (!countries.containsKey(country)) {
                Map<String, Long> temp = new LinkedHashMap<>();
                temp.put(city, population);
                countries.put(country, temp);
            } else {
                if (!countries.get(country).containsKey(city)) {
                    countries.get(country).put(city, population);
                }
            }
            input = scanner.nextLine().split("\\|");
        }

        countries.entrySet()
                .stream()
                .sorted((c1, c2) -> c2.getValue().values()
                        .stream()
                        .reduce(0L, Long::sum)
                        .compareTo(
                                c1.getValue().values()
                                        .stream()
                                        .reduce(0L, Long::sum))
                ).forEach(country -> {
            System.out.println(String.format("%s (total population: %d)", country.getKey()
                    , country.getValue().values().stream().reduce(0L, Long::sum)));

            country.getValue().entrySet().stream().sorted((c1, c2) ->
                    c2.getValue().compareTo(c1.getValue()))
                    .forEach(c -> System.out.printf("=>%s: %d%n", c.getKey(), c.getValue()));
        });
    }
}