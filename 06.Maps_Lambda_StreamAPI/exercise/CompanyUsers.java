package exercise;

import java.util.*;

public class CompanyUsers {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String[] registrations = scanner.nextLine().split(" -> ");

    TreeMap<String, ArrayList<String>> employeesRegister = new TreeMap<>();


    while (!registrations[0].equalsIgnoreCase("End")) {
      String companyName = registrations[0];
      String employeeID = registrations[1];

      employeesRegister.putIfAbsent(companyName, new ArrayList<>());

      if (!employeesRegister.get(companyName).contains(employeeID)) {

        employeesRegister.get(companyName).add(employeeID);

      }

      registrations = scanner.nextLine().split(" -> ");

    }


    for (Map.Entry<String, ArrayList<String>> eachCompany : employeesRegister.entrySet()) {
      String eachCompanyName = eachCompany.getKey();

      System.out.printf("%s%n", eachCompanyName);

      ArrayList<String> everyEmployeeID = eachCompany.getValue();

      for (String employeeNames : everyEmployeeID) {
        System.out.printf("-- %s%n", employeeNames);
      }

    }

  }
}