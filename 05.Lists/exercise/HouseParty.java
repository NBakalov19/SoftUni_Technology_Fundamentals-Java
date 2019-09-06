package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfCommands = Integer.parseInt(scanner.nextLine());

        List<String> names = new ArrayList<>();

        while (countOfCommands > 0) {
            String[] commands = scanner.nextLine().split("\\s+");
            if (commands[2].equals("not")) {
                if (names.contains(commands[0])) {
                    names.remove(commands[0]);
                } else {
                    System.out.println(String.format("%s is not in the list!", commands[0]));
                }
            } else {
                if (!names.contains(commands[0])) {
                    names.add(commands[0]);
                } else {
                    System.out.println(String.format("%s is already in the list!", commands[0]));
                }
            }
            countOfCommands--;
        }
        names.forEach(n -> System.out.println(n + " "));
    }
}