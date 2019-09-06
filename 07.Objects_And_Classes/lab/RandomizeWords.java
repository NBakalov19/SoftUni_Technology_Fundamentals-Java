package lab;

import java.util.Random;
import java.util.Scanner;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] text = scanner.nextLine().split("\\s+");

        Random rnd = new Random();

        for (int i = 0; i < text.length; i++) {
            int firstWord = rnd.nextInt(text.length);
            int secondWord = rnd.nextInt(text.length);

            String swap = text[firstWord];
            text[firstWord] = text[secondWord];
            text[secondWord] = swap;
        }

        for (String s : text) {
            System.out.println(s);
        }
    }
}