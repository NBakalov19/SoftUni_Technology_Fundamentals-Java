package Demo;

import java.util.*;


public class Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> contestsWithPass = new HashMap<>();
        Map<String, Map<String, Integer>> submissions = new TreeMap<>();
        String input = scanner.nextLine();

        String contest;
        String password;

        while (!input.equals("end of contests")) {
            String[] contestInput = input.split(":");
            contest = contestInput[0];
            password = contestInput[1];
            contestsWithPass.put(contest, password);
            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("end of submissions")) {
            String[] submissionsInput = input.split("=>");

            contest = submissionsInput[0];
            password = submissionsInput[1];
            String candidate = submissionsInput[2];
            int points = Integer.parseInt(submissionsInput[3]);

            if (contestsWithPass.containsKey(contest)
                    && contestsWithPass.get(contest).equals(password)) {
                if (!submissions.containsKey(candidate)) {
                    Map<String, Integer> contestsWithPoints = new HashMap<>();
                    contestsWithPoints.put(contest, points);
                    submissions.put(candidate, contestsWithPoints);

                } else {
                    if (!submissions.get(candidate).containsKey(contest)) {
                        submissions.get(candidate).put(contest, points);
                    } else if (submissions.get(candidate).get(contest) < points) {
                        submissions.get(candidate).put(candidate, points);
                    }
                }
            }

            input = scanner.nextLine();
        }

        Map<String, Integer> candidateTotalPoints = new HashMap<>();

        for (Map.Entry<String, Map<String, Integer>> entry : submissions.entrySet()) {
            int totalPoints = entry.getValue().values().stream().reduce(0, Integer::sum);
            candidateTotalPoints.put(entry.getKey(), totalPoints);
        }

        String bestCandidate = Collections.max(candidateTotalPoints.entrySet(),
                Comparator.comparingInt(Map.Entry::getValue)).getKey();

        int bestTotalPoints = candidateTotalPoints.get(bestCandidate);

        System.out.println(
                String.format("Best candidate is %s with total %d points.", bestCandidate, bestTotalPoints));
        System.out.println("Ranking:");
        submissions.forEach((key, value) -> {
            System.out.printf("%s%n", key);

            value.entrySet()
                    .stream()
                    .sorted((c1, c2) ->
                            c2.getValue().compareTo(c1.getValue())
                    )
                    .forEach(
                            c -> System.out.println(
                                    String.format("#  %s -> %d", c.getKey(), c.getValue()))
                    );
        });
    }
}