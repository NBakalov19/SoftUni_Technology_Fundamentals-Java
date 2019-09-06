package exercise;

import java.util.Scanner;

public class NxNMatrix {
    
    private static void printNxNMatrix(int number){
        for (int i = 0; i < number ; i++) {
            for (int j = 0; j < number ; j++) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        printNxNMatrix(number);
    }
}