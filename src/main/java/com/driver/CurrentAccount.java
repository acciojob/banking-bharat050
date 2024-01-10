package com.driver;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name, balance, 5000);
        this.tradeLicenseId = tradeLicenseId;
        if(balance < 5000) throw new Exception("Insufficient Balance");
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        int[] arr = new int[26];
        int size = tradeLicenseId.length();
        for(int i=0; i< size; i++){
            char c = tradeLicenseId.charAt(i);
            arr[65-c]++;
        }
        for(int a: arr){
            if(size%2 ==0 && a > size/2) throw new Exception("Valid License can not be generated");
            else if(size%2 !=0 && a > size/2 + 1) throw new Exception("Valid License can not be generated");
        }
    }

}
