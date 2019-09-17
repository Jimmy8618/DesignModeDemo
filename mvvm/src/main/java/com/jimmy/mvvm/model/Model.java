package com.jimmy.mvvm.model;

import com.jimmy.mvvm.bean.Account;
import com.jimmy.mvvm.callback.MCallback;

import java.util.Random;

public class Model {
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
