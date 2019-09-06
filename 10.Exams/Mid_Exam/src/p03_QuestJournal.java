import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p03_QuestJournal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> questsJournal = Arrays.stream(scanner.nextLine()
                .split(", "))
                .collect(Collectors.toList());

        String line = scanner.nextLine();


        while (!line.equals("Retire!")) {
            String[] command = line.split(" - ");

            if (command[0].equals("Start")) {
                if (!questsJournal.contains(command[1])) {
                    questsJournal.add(command[1]);
                }
            } else if (command[0].equals("Complete")) {
                questsJournal.remove(command[1]);
            } else if (command[0].equals("Side Quest")) {
                String[] sideQuest = command[1].split(":");

                if (questsJournal.contains(sideQuest[0])) {
                    if (!questsJournal.contains(sideQuest[1])) {
                        int questIndex = questsJournal.indexOf(sideQuest[0]);
                        if (questIndex == questsJournal.size() - 1) {
                            questsJournal.add(sideQuest[1]);
                        } else {
                            questsJournal.add(questIndex + 1, sideQuest[1]);
                        }
                    }
                }
            } else if (command[0].equals("Renew")) {
                if (questsJournal.contains(command[1])) {

                    questsJournal.remove(command[1]);
                    questsJournal.add(command[1]);
                }
            }
            line = scanner.nextLine();
        }

        System.out.println(String.join(", ", questsJournal));
    }

}