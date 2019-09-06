package moreExercise;

import java.util.Scanner;

public class ExtractPersonInformation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int countOfStrings = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < countOfStrings; i++) {
            String line = scanner.nextLine();
            StringBuilder name = new StringBuilder();
            StringBuilder age = new StringBuilder();
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == '@') {
                    j++;
                    while (!(line.charAt(j) == '|')) {
                        char symbol = line.charAt(j);
                        name.append(symbol);
                        j++;
                    }
                }

                if (line.charAt(j) == '#') {
                    j++;
                    while (!(line.charAt(j) == '*')) {
                        char symbol = line.charAt(j);
                        age.append(symbol);
                        j++;
                    }
                }
            }
            if (name.length() > 0) {
                System.out.println(String.format("%s is %s years old.", name, age));
            }
        }
    }
}