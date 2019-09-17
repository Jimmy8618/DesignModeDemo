package com.jimmy.designmodedemo.callback;

import com.jimmy.designmodedemo.bean.Account;

public interface MCallback {

    public void success(Account account);
    public void failed();
}
