package Lecture6_DefiningClasses.BankAccount;

public class BankAccount {
    private static double interestRate = 0.02;
    private static int idCounter = 1;

    private int id;

    public int getId() {
        return id;
    }

    private double balance;

    public BankAccount() {
        this.id = idCounter;
        idCounter++;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }
    public double getInterest(int years) {
        return interestRate * years * balance;
    }
    public void deposit(int amount) {
        balance += amount;
    }

}
