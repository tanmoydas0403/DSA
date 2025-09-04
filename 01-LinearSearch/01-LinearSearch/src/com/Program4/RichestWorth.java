package com.Program4;

public class RichestWorth {
    public static void main(String[] args) {
        int [][] arr={
            {4,2},
            {2,2}
        };

        int[] account = sumOfAccount(arr);
        int ans=richWorth(account);
        if(ans==0){
            System.out.println("Both customer richest");
        }else {
            System.out.println("Customer-"+ans+" is max balance");
        }
    }

    private static int richWorth(int[] accounts) {
        int max=accounts[0];
        int index=0;
        for (int i = 1; i < accounts.length; i++) {
            if(max==accounts[i]){
                return 0;
            }else if(max<accounts[i]){
                max=accounts[i];
                index=i;
            }
        }
        return index+1;
    }

    private static int[] sumOfAccount(int[][] arr) {
        int[] sum= new int[arr.length];
        for (int person = 0; person < arr.length; person++) {
            int rowSum=0;
            for (int account = 0; account < arr[person].length; account++) {
                rowSum+=arr[person][account];
            }
            sum[person]=rowSum;
        }
        return sum;
    }
}
