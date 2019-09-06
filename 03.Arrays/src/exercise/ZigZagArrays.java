package exercise;

import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int linesCount = Integer.parseInt(scanner.nextLine());

        int[] firstArr = new int[linesCount];
        int[] secondArr = new int[linesCount];

        for (int i = 0; i < linesCount ; i++) {
            String[] numbers = scanner.nextLine().split(" ");

            if (i % 2 == 0){
                firstArr[i] = Integer.parseInt(numbers[0]);
                secondArr[i] = Integer.parseInt(numbers[1]);
            }else{
                firstArr[i] = Integer.parseInt(numbers[1]);
                secondArr[i] = Integer.parseInt(numbers[0]);
            }

        }

        for (int number : firstArr) {
            System.out.print(number + " ");
        }
        System.out.println();
        for (int number : secondArr) {
            System.out.print(number + " ");
        }

    }
}
