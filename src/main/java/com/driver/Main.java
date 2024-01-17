package com.driver;

public class Main {
    public static void main(String[] args) throws Exception {
        BankAccount a = new BankAccount("bharat", 5000, 2000);
        a.deposit(352.0);
        CurrentAccount b = new CurrentAccount("HDFC", 5000, "ABAZAZAYAXAMAPAM");
        SavingsAccount savingsAccount = new SavingsAccount("save", 0.0, 5.0, 50.0);
        try{
            System.out.println(a.generateAccountNumber(1,5));
            b.validateLicenseId();
            savingsAccount.deposit(500.0);
            savingsAccount.withdraw(1.0);
            System.out.println(savingsAccount.getBalance());
            savingsAccount.withdraw(5.0);
            System.out.println(savingsAccount.getBalance());
//            savingsAccount.withdraw(6.0);
//            System.out.println(savingsAccount.getBalance());
            savingsAccount.withdraw(1000.0);
            System.out.println(savingsAccount.getBalance());
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            System.out.println(savingsAccount.getBalance());
        }

    }
}