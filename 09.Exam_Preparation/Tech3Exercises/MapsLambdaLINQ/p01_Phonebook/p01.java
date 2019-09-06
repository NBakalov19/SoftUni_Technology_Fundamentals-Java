package Tech3Exercises.MapsLambdaLINQ.p01_Phonebook;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phoneBook = new LinkedHashMap<>();

        String[] line = scanner.nextLine().split("\\s+");

        while (!line[0].equals("END")) {

            String command = line[0];
            String name = line[1];

            if (command.equals("A")) {
                String number = line[2];
                if (!phoneBook.containsKey(name)) {
                    phoneBook.put(name, number);
                } else {
                    phoneBook.put(name,number);
                }

            } else {

                if (phoneBook.containsKey(name)) {
                    System.out.println(String.format("%s -> %s", name, phoneBook.get(name)));
                } else {
                    System.out.println(String.format("Contact %s does not exist.", name));
                }
            }
            line = scanner.nextLine().split("\\s+");
        }
    }
}