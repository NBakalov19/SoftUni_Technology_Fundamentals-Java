import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

            int source = Integer.parseInt(sc.nextLine());

            int totalAmount = 0;
            int days = 0;
            int consumption = 26;

            while (source >= 100) {
                totalAmount += source;
                days++;
                totalAmount -= consumption;
                source -= 10;

                if (source < 100) {
                    totalAmount -= consumption;
                }
            }
        System.out.println(days);
        System.out.println(totalAmount);
    }
}
