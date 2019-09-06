package Demo;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String line = scan.nextLine();
        Double sum = 0d;

//customer, product, count and a price

        while (!line.equals("end of shift")) {
            String regex = "%(?<customer>[A-Z][a-z]+)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*" +
                    "\\|(?<count>\\d+)\\|[^|$%.]*?(?<price>\\d+([.]\\d+)?)\\$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(line);

            if (matcher.find()) {
                String customer = matcher.group("customer");
                String product = matcher.group("product");
                Double count = Double.parseDouble(matcher.group("count"));
                Double price = Double.parseDouble(matcher.group("price"));
                Double allPrice = count * price;
                sum += allPrice;

                System.out.println(String.format("%s: %s - %.2f", customer, product, allPrice));

            }
            line = scan.nextLine();
        }
        System.out.println(String.format("Total income: %.2f", sum));
    }
}