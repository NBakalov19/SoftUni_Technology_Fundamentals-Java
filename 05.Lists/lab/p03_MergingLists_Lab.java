package lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p03_MergingLists_Lab {

    public static List<Integer> getRemainingElements(List<Integer> longerList, List<Integer> shorterList) {

        List<Integer> nums = new ArrayList<>();

        for (int i = shorterList.size(); i < longerList.size(); i++) {
            nums.add(longerList.get(i));
        }

        return nums;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstNumbers =
                Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        List<Integer> secondNumbers =
                Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        List<Integer> resultOfLists = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < Math.min(firstNumbers.size(), secondNumbers.size()); i++) {

            resultOfLists.add(0 + index, firstNumbers.get(i));
            resultOfLists.add(1 + index, secondNumbers.get(i));

            index += 2;
        }

        if (firstNumbers.size() > secondNumbers.size()) {
            resultOfLists.addAll(getRemainingElements(firstNumbers, secondNumbers));
        } else if (secondNumbers.size() > firstNumbers.size()) {
            resultOfLists.addAll(getRemainingElements(secondNumbers, firstNumbers));
        }


        for (int num : resultOfLists
        ) {
            System.out.print(num + " ");
        }
    }
}