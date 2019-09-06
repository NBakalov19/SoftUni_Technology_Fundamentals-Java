package exercise;

import java.util.Arrays;
import java.util.Scanner;

public class TopInteger {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();


        for (int i = 0; i < numbers.length - 1; i++) {
            boolean topInt = false;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] >= numbers[j]) {
                    topInt = true;
                }else {
                    topInt = false;
                    break;
                }
            }
            if(topInt){
                System.out.print(numbers[i] + " ");
            }
        }
        System.out.println(numbers[numbers.length -1]);
    }
}
