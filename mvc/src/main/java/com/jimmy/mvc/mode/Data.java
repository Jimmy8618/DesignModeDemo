package com.jimmy.mvc.mode;

import com.jimmy.mvc.callback.MCallback;

import java.util.Random;

public class Data {

    public static void getAccountData(String accountName, MCallback mCallbacks){
        Random rd = new Random();
        boolean isSuccess = rd.nextBoolean();
        if(isSuccess){
            Account account = new Account();
            account.setName(accountName);
            account.setLevel(100);
            mCallbacks.success(account);

        }else{
            mCallbacks.failed();

        }

    }
}
