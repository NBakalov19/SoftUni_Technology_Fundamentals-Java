package FinalExam;

import java.util.*;

public class ConcertP1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, List<String>> bandWithMembers = new TreeMap<>();
        Map<String, Long> bandPlayTime = new HashMap<>();

        while (!input.equals("start of concert")) {

            String[] tokens = input.split("; ");

            String command = tokens[0];
            String bandName = tokens[1];

            if (command.equals("Add")) {
                String[] members = tokens[2].split(", ");
                if (!bandWithMembers.containsKey(bandName)) {
                    List<String> bandMembers = new ArrayList<>();
                    for (int i = 0; i < members.length; i++) {
                        bandMembers.add(members[i]);
                    }
                    bandWithMembers.put(bandName, bandMembers);
                } else {
                    for (int i = 0; i < members.length; i++) {
                        if (!bandWithMembers.get(bandName).contains(members[i])) {
                            bandWithMembers.get(bandName).add(members[i]);
                        }
                    }
                }
            } else {
                long playTime = Long.parseLong(tokens[2]);
                if (!bandPlayTime.containsKey(bandName)) {
                    bandPlayTime.put(bandName, playTime);
                } else {
                    bandPlayTime.put(bandName, bandPlayTime.get(bandName) + playTime);
                }
            }
            input = scanner.nextLine();
        }
        String band = scanner.nextLine();
        long totalTime = bandPlayTime.values().stream().reduce(0L,Long::sum);
        System.out.println(String.format("Total time: %d",totalTime));
        bandPlayTime.entrySet()
                .stream()
                .sorted((b1,b2) -> b2.getValue().compareTo(b1.getValue()))
                .forEach(b ->
                        System.out.println(String.format("%s -> %d",b.getKey(),b.getValue())));
        System.out.println(band);
         bandWithMembers.get(band)
                 .forEach(m -> System.out.println(
                         String.format("=> %s",m)));
    }
}