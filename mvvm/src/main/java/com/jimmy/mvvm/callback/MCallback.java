package com.jimmy.mvvm.callback;

import com.jimmy.mvvm.bean.Account;

public interface MCallback {

    public void success(Account account);
    public void failed();
}
