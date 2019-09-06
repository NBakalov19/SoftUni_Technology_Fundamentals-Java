package Tech3Exercises.MapsLambdaLINQ.p05_HandOfCards;

import java.util.*;

import java.util.stream.Collectors;

public class p05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Map<String, List<String>> playersAndCard = new LinkedHashMap<>();
        List<String> cards;
        while (!line.equals("JOKER")) {
            String[] tokens = line.split(": ");
            String player = tokens[0];
            playersAndCard.putIfAbsent(player, new ArrayList<>());
            String[] pulledOutCards = tokens[1].split(", ");
            cards = Arrays.stream(pulledOutCards).distinct().collect(Collectors.toList());
            for (String card : cards) {
                playersAndCard.get(player).add(card);
            }
            List<String> collect = playersAndCard.get(player).stream().distinct().collect(Collectors.toList());
            playersAndCard.put(player, collect);
            line = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> player : playersAndCard.entrySet()) {

            int multiplauyer = 0;
            int sum = 0;

            for (String card : player.getValue()) {
                char cardType = card.charAt(card.length() - 1);
                switch (cardType) {
                    case 'S':
                        multiplauyer = 4;
                        break;
                    case 'H':
                        multiplauyer = 3;
                        break;
                    case 'D':
                        multiplauyer = 2;
                        break;
                    case 'C':
                        multiplauyer = 1;
                        break;
                    default:
                        break;
                }
                int mainValue;
                String symbol = card.substring(0, card.length() - 1);
                switch (symbol) {

                    case "J":
                        mainValue = 11;
                        break;
                    case "Q":
                        mainValue = 12;
                        break;
                    case "K":
                        mainValue = 13;
                        break;
                    case "A":
                        mainValue = 14;
                        break;
                    default:
                        mainValue = Integer.parseInt(symbol);
                        break;
                }
                sum += multiplauyer * mainValue;
            }
            System.out.println(String.format("%s: %d", player.getKey(), sum));
        }
    }
}