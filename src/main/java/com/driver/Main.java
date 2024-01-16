package com.driver;

public class Main {
    public static void main(String[] args) throws Exception {
        BankAccount a = new BankAccount("bharat", 5000, 2000);
        a.deposit(352.0);
        CurrentAccount b = new CurrentAccount("HDFC", 5000, "AACA");
        try{
//            System.out.println(a.generateAccountNumber(3,28));
            b.withdraw(1000);
            b.validateLicenseId();
        }
        catch (Exception e){
            System.out.println(e);
        }


    }
}