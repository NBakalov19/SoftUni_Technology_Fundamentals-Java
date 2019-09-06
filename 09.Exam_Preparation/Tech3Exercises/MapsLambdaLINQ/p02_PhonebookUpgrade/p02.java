package Tech3Exercises.MapsLambdaLINQ.p02_PhonebookUpgrade;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class p02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, String> phonebook = new TreeMap<>();

        String[] line = scanner.nextLine().split("\\s+");

        while (!line[0].equals("END")) {

            String command = line[0];

            switch (command) {
                case "A": {
                    String name = line[1];
                    String number = line[2];
                    if (!phonebook.containsKey(name)) {
                        phonebook.put(name, number);
                    } else {
                        phonebook.put(name, number);
                    }

                    break;
                }
                case "ListAll":
                    phonebook.forEach((k, v) -> System.out.println(String.format("%s -> %s", k, v)));
                    break;
                default: {
                    String name = line[1];
                    if (phonebook.containsKey(name)) {
                        System.out.println(String.format("%s -> %s", name, phonebook.get(name)));
                    } else {
                        System.out.println(String.format("Contact %s does not exist.", name));
                    }
                    break;
                }
            }
            line = scanner.nextLine().split("\\s+");
        }
    }
}