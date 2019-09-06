package exercise;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Orders {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String[] line = scanner.nextLine().split("\\s+");

    LinkedHashMap<String, Double> productsAndPrice = new LinkedHashMap<>();
    LinkedHashMap<String, Integer> productsAndQuantity = new LinkedHashMap<>();
    String product;
    double pricePerOneProduct;

    while (!line[0].equals("buy")) {
      product = line[0];
      int quantity = Integer.parseInt(line[2]);
      pricePerOneProduct = Double.parseDouble(line[1]);

      if (!productsAndPrice.containsKey(product)) {
        productsAndPrice.put(product, 0d);
        productsAndPrice.put(product, pricePerOneProduct);
      } else {
        if (pricePerOneProduct != productsAndPrice.get(product)) {
          productsAndPrice.put(product, pricePerOneProduct);
        }
      }
      if (!productsAndQuantity.containsKey(product)) {
        productsAndQuantity.put(product, 0);
        productsAndQuantity.put(product, quantity);
      } else {
        productsAndQuantity.put(product, productsAndQuantity.get(product) + quantity);
      }

      line = scanner.nextLine().split("\\s+");
    }

    LinkedHashMap<String, Double> result = new LinkedHashMap<>();

    for (String key : productsAndPrice.keySet()) {
      if (productsAndQuantity.containsKey(key)) {
        result.put(key, productsAndPrice.get(key) * productsAndQuantity.get(key));
      }
    }

    result.forEach((k, v) -> System.out.println(String.format("%s -> %.2f", k, v)));
  }
}