package moreExercise;

import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double currentBalance = Double.parseDouble(scanner.nextLine());
        double totalSpent = 0;

        String command = scanner.nextLine();

        while (true){

            if (command.equals("OutFall 4")){
                if (currentBalance >= 39.99) {
                    currentBalance -= 39.99;
                    totalSpent += 39.99;
                    System.out.println("Bought OutFall 4");
                }else{
                    System.out.println("Too Expencive");
                }
            }else if (command.equals("CS: OG")){
                if (currentBalance >=15.99) {
                    currentBalance -= 15.99;
                    totalSpent += 15.99;
                    System.out.println("Bought CS: OG");
                }else{
                    System.out.println("Too Expencive");
                }
            }else if (command.equals("Zplinter Zell")){
                if (currentBalance >= 19.99) {
                    currentBalance -= 19.99;
                    totalSpent += 19.99;
                    System.out.println("Bought Zplinter Zell");
                }else {
                    System.out.println("Too Expencive");
                }
            }else if (command.equals("Honored 2")){
                if (currentBalance >= 59.99) {
                    currentBalance -= 59.99;
                    totalSpent += 59.99;
                    System.out.println("Bought Honored 2");
                }else{
                    System.out.println("Too Expencive");
                }
            }else if (command.equals("RoverWatch")){
                if (currentBalance >= 29.99) {
                    currentBalance -= 29.99;
                    totalSpent += 29.99;
                    System.out.println("Bought RoverWatch");
                }else{
                    System.out.println("Too Expencive");
                }
            }else if (command.equals("RoverWatch Origins Edition")){
                if (currentBalance >=39.99) {
                    currentBalance -= 39.99;
                    totalSpent += 39.99;
                    System.out.println("Bought RoverWatch Origins Edition");
                }else{
                    System.out.println("Too Expencive");
                }
            }else if(command.equals("Game Time")){
                System.out.printf("Total spent: $%.2f. Remaining: $%.2f",totalSpent,currentBalance);
            }else {
                System.out.println("Not Found");
            }

            if (currentBalance == 0){
                System.out.println("Out of money!");
                break;
            }
            command = scanner.nextLine();
        }
    }
}