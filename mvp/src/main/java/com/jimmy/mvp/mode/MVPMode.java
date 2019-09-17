package com.jimmy.mvp.mode;


import com.jimmy.mvp.callback.MCallback;

import java.util.Random;

public class MVPMode {

    public void getAccountData(String accountName, MCallback mCallbacks){
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
