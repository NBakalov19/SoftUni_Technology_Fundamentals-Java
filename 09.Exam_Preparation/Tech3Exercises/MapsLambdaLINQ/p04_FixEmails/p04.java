package Tech3Exercises.MapsLambdaLINQ.p04_FixEmails;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Map<String,String> emails = new LinkedHashMap<>();
        int counter = 0;
        String name = "";
        while (!line.equals("stop")){
            counter++;
            if (counter % 2 == 1){
                emails.putIfAbsent(line,"");
            } else {
                String[] email = line.split("\\.");
                String domain = email[1];
                if (!(domain.equals("us") || domain.equals("uk"))){
                    emails.put(name,line);
                }
            }
            name = line;
            line = scanner.nextLine();
        }
        emails.entrySet()
                .stream()
                .filter(es -> es.getValue().length() > 0)
                .forEach(entry ->
                        System.out.println(String.format("%s -> %s",entry.getKey(),entry.getValue()))
                );
    }
}