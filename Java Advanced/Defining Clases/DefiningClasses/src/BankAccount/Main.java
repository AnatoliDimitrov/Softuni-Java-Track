package BankAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<BankAccount> accounts = new ArrayList<>();

        var input = scanner.nextLine();

        while (!input.equals("End")) {
            if (input.equals("Create")) {
                accounts.add(new BankAccount());
                System.out.printf("Account ID%d created%n", accounts.size());
                input = scanner.nextLine();
                continue;
            }

            var info = input.split("\\s+");
            var command = info[0];
            if (command.equals("Deposit")) {
                var id = Integer.parseInt(info[1]);
                if (id > accounts.size()) {
                    System.out.println("Account does not exist");
                } else {
                    accounts.get(id - 1).deposit(Double.parseDouble(info[2]));
                    System.out.printf("Deposited %s to ID%d%n", info[2], id);
                }
            } else if (command.equals("SetInterest")) {
                BankAccount.setInterestRate(Double.parseDouble(info[1]));
            } else if (command.equals("GetInterest")) {
                var id = Integer.parseInt(info[1]);
                if(id > accounts.size()){
                    System.out.println("Account does not exist");
                } else {
                    var years = Integer.parseInt(info[2]);
                    System.out.printf("%.2f%n", accounts.get(id - 1).getInterestRate(years));
                }
            }

            input = scanner.nextLine();
        }
    }
}