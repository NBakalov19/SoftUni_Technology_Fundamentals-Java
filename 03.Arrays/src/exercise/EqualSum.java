package exercise;

import java.util.Arrays;
import java.util.Scanner;

public class EqualSum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        boolean isEqual = false;

        for (int i = 0; i < numbers.length; i++) {
            int leftSum = 0;
            int rightSum = 0;

            for (int left = i - 1; left > 0; left--) {
                leftSum += numbers[left];
            }
            for (int right = i + 1; right < numbers.length; right++) {
                rightSum += numbers[right];
            }

            if (leftSum == rightSum){
                System.out.println(i);
                isEqual = true;
                break;
            }
        }
        if(!isEqual){
            System.out.println("no");
        }
    }
}