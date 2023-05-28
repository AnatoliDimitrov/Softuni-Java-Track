package BankAccount;

public class BankAccount {

    private final static double DEFAULT_INTEREST_RATE = 0.02;
    private static double interestRate = DEFAULT_INTEREST_RATE;
    private static int bankAccount = 1;
    private int id;
    private double balance;

    public BankAccount() {
        this.bankAccount++;
    }

    public Double getInterestRate(int years) {
        return (this.interestRate * years) * this.balance;
    }

    public static void setInterestRate(Double interest) {
        interestRate = interest;
    }

    public void deposit(Double amount){
        this.balance += amount;
    }

}