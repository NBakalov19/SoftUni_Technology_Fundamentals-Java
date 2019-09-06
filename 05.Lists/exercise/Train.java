package exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {

    private static void filteredTrain(List<Integer> train, int maxCapacity, int passengers){



        for (int i = 0; i < train.size() ; i++) {

            int emptySpaces = maxCapacity - train.get(i);

            if (train.get(i) < maxCapacity && emptySpaces >= passengers){
                train.set(i,train.get(i) + passengers );
                break;
            }
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> train =
                Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        int maxCapacity = Integer.parseInt(scanner.nextLine());

        while (true) {
            String line = scanner.nextLine();

            if (line.equals("end")) {
                for (int wagon : train) {
                    System.out.print(wagon + " ");
                }
                break;
            }

            String[] command = line.split(" ");

            if ("Add".equals(command[0])) {
                int passengers = Integer.parseInt(command[1]);
                train.add(passengers);
            }else {
                int passengers = Integer.parseInt(command[0]);
                filteredTrain(train,maxCapacity,passengers);
            }
        }
    }
}
