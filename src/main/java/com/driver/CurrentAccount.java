package com.driver;

public class CurrentAccount extends BankAccount{
    private String tradeLicenseId; //consists of Uppercase English characters only

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name, balance, 5000);
        this.tradeLicenseId = tradeLicenseId;
//        if(balance < 5000) throw new Exception("Insufficient Balance");
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        boolean need = false;
        int len = tradeLicenseId.length();
        for(int i=0;i<len-1;i++){
            char c = tradeLicenseId.charAt(i);
            char d = tradeLicenseId.charAt(i+1);
            if (c == d) {
                need = true;
                break;
            }
        }
        if(need) {
            int[] arr = new int[26];
            for (int i = 0; i < len; i++) {
                char c = tradeLicenseId.charAt(i);
                arr[c - 65]++;
            }
            // System.out.print(Arrays.toString(arr));
            int maxOccurIndex = 0;
            int maxOccurValue = 0;
            for (int i = 0; i < 26; i++) {
                if (arr[i] > maxOccurValue) {
                    maxOccurValue = arr[i];
                    maxOccurIndex = i;
                }
            }
            if (len % 2 == 0 && maxOccurValue > len / 2) throw new Exception("Valid License can not be generated");
            if (len % 2 != 0 && maxOccurValue > (len + 1) / 2)
                throw new Exception("Valid License can not be generated");

            char[] res = new char[len];
            int index = 0;
            while (arr[maxOccurIndex]-- > 0) {
                res[index] = (char) (maxOccurIndex + 65);
                index += 2;
            }
            // System.out.println(arr[maxOccurIndex]);
            for (int i = 0; i < 26; i++) {
                if (arr[i] <= 0) continue;
                while (arr[i]-- > 0) {
                    if (index > len - 1) index = 1;
                    res[index] = (char) (i + 65);
                    index += 2;
                }
            }
            setTradeLicenseId(String.valueOf(res));
            System.out.println(String.valueOf(res));
        }
    }

}
