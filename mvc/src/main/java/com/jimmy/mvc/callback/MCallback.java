package com.jimmy.mvc.callback;

import com.jimmy.mvc.mode.Account;

public interface MCallback {

    public void success(Account account);
    public void failed();
}
