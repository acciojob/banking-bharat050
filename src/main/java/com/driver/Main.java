package com.driver;

public class Main {
    public static void main(String[] args) {
        BankAccount a = new BankAccount("bharat", 5000, 2000);
        a.deposit(352.0);
        try{
            System.out.println(a.generateAccountNumber(12,9));
            a.withdraw(1000);
        }
        catch (Exception e){
            System.out.println(e);
        }


    }
}