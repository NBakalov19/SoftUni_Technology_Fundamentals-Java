package exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int counter = 1;
        int counterMax = 0;
        int numberMax = 0;
        for (int i = 0; i < numbers.length - 1; i++) {

            if (numbers[i] == numbers[i + 1]) {
                counter++;
            }else{
                if (counter > counterMax){
                 counterMax = counter;
                 numberMax = numbers[i];
                }
                counter = 1;
            }

            if(i + 1 == numbers.length - 1){

                if (counter > counterMax){
                    counterMax = counter;
                    numberMax = numbers[i];
                }
                counter = 1;
            }
        }
        for (int i = 0; i < counterMax ; i++) {
            System.out.print(numberMax + " ");
        }
    }
}
