package com.jimmy.mvp;

import com.jimmy.mvp.mode.Account;

public interface IMVPView {
    String getUserInput();
    void showSuccessPage(Account account);
    void showFailedPage();
}
