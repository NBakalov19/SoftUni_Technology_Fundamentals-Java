package exercise;

import java.util.Scanner;

public class TrainArray {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int sizeOfTrain = Integer.parseInt(scanner.nextLine());

        int[] train = new int[sizeOfTrain];

        int sum = 0;

        for (int i = 0; i < sizeOfTrain ; i++) {
            train[i] = Integer.parseInt(scanner.nextLine());
            sum+= train[i];
        }

        for (int i = 0; i < sizeOfTrain ; i++) {
            System.out.print(String.format("%d ",train[i]));
        }
        System.out.printf("\n%d",sum);
    }
}