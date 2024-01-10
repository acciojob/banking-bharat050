package com.driver;

import java.util.Random;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        Random rand = new Random();
        StringBuilder number = new StringBuilder();
        int max =9;
        for(int i=0;i<digits; i++){
            int rNo = rand.nextInt(max);
//            System.out.print(rNo+",");
            number.append(rNo);
            sum -= rNo;
            if(sum<max){
                max = sum;
            }
        }
        if(sum<10 && sum!=0) number.setCharAt(digits-1, Integer.toString(sum).charAt(0));
        if(sum>9){
            throw new Exception("Account Number can not be generated");
        }
        return number.toString();
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if(balance - minBalance < amount){
            throw new Exception("Insufficient Balance");
        }
        balance -= amount;
    }

}