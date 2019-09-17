package com.jimmy.mvp.callback;

import com.jimmy.mvp.mode.Account;

public interface MCallback {

    public void success(Account account);
    public void failed();
}
