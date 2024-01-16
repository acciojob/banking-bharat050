package com.driver;

public class Main {
    public static void main(String[] args) throws Exception {
        BankAccount a = new BankAccount("bharat", 5000, 2000);
        a.deposit(352.0);
        CurrentAccount b = new CurrentAccount("HDFC", 5000, "AAAAAAAABBBCCC");
        SavingsAccount savingsAccount = new SavingsAccount("save", 1000.0, 1.0, 5.0);
        try{
            System.out.println(a.generateAccountNumber(1,5));
//            b.withdraw(1000);
            System.out.println(savingsAccount.getCompoundInterest(4, 5));
            System.out.println(savingsAccount.getSimpleInterest(5));
            savingsAccount.withdraw(1000);
            savingsAccount.withdraw(1000);

        }
        catch (Exception e){
            System.out.println(e);
        }


    }
}