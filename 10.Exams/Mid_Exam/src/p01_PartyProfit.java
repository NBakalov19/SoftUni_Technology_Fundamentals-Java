import java.text.DecimalFormat;
import java.util.Scanner;

public class p01_PartyProfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int companions = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());

        int coins = 0;

        for (int i = 1; i <= days; i++) {
            if (i % 10 == 0) {
                companions -= 2;
            }
            if (i % 15 == 0) {
                companions += 5;
            }

            int earningPerDay = 50 - (2 * companions);
            int motivationPartySpending = (companions * 3);
            int bossMonster = companions * 20;

            if (i % 3 == 0) {
                coins += earningPerDay - motivationPartySpending;

            }
            if (i % 5 == 0) {
                if (i % 3 == 0) {
                    coins += (bossMonster - (2 * companions));
                } else {
                    coins += earningPerDay + bossMonster;
                }
            }
            if (i % 3 != 0 && i % 5 != 0){
                coins += earningPerDay;
            }
        }

        double coinsPerCompanion = Math.floor(coins / companions);
        DecimalFormat df = new DecimalFormat("#");

        System.out.printf("%d companions received %s coins each.%n", companions, df.format(coinsPerCompanion));
    }
}