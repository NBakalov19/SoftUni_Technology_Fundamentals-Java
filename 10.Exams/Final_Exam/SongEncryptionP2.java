package FinalExam;

import java.util.Scanner;

public class SongEncryptionP2 {
    private static boolean validateArtist(String artist) {
        boolean isValid = true;
        char firstLetter = artist.charAt(0);
        if (Character.isUpperCase(firstLetter)) {
            for (int i = 1; i < artist.length(); i++) {
                char letter = artist.charAt(i);
                if (((!Character.isLowerCase(letter) || !Character.isLetter(letter))
                        && letter != '\'' && letter != ' ')) {
                    isValid = false;
                    break;
                }
            }
        } else {
            isValid = false;
        }
        return isValid;
    }

    private static boolean validateSong(String song) {
        boolean isValid = true;

        for (int i = 0; i < song.length(); i++) {
            char symbol = song.charAt(i);
            if (Character.isLowerCase(symbol) || !Character.isLetter(symbol)) {
                if (symbol != ' ') {
                    isValid = false;
                    break;
                }
            }
        }
        return isValid;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] tokens = input.split(":");
            String artist = tokens[0];
            String song = tokens[1];

            if (!validateArtist(artist) || !validateSong(song)) {
                System.out.println("Invalid input!");
            } else {
                int key = artist.length();
                StringBuilder sb = new StringBuilder();
                char[] charArray = input.toCharArray();

                for (char symbol : charArray) {

                    if (Character.isUpperCase(symbol)) {
                        int nextValue = (int) symbol + key;
                        int tempSymbol = nextValue;
                        char newSymbol;
                        if (tempSymbol > 90) {
                            int diff = tempSymbol - 91;
                            nextValue = 65 + diff;
                            newSymbol = (char) nextValue;
                            sb.append(newSymbol);
                        } else {
                            newSymbol = (char) nextValue;
                            sb.append(newSymbol);
                        }
                    } else if (Character.isLowerCase(symbol)) {
                        int nextValue = (int) symbol + key;
                        int tempSymbol = nextValue;
                        char newSymbol;
                        if (tempSymbol > 122) {
                            int diff = tempSymbol - 123;
                            nextValue = 97 + diff;
                            newSymbol = (char) nextValue;
                            sb.append(newSymbol);
                        } else {
                            newSymbol = (char) nextValue;
                            sb.append(newSymbol);
                        }
                    } else if (symbol == ':') {
                        sb.append('@');
                    } else {
                        sb.append(symbol);
                    }

                }
                System.out.println(String.format("Successful encryption: %s", sb.toString()));
            }
            input = scanner.nextLine();
        }
    }
}