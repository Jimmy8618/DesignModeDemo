package com.jimmy.mvp.presenter;

import com.jimmy.mvp.IMVPView;
import com.jimmy.mvp.callback.MCallback;
import com.jimmy.mvp.mode.Account;
import com.jimmy.mvp.mode.MVPMode;

public class MVPPresenter {
    IMVPView imvpView;
    MVPMode mvpMode;

    public MVPPresenter(IMVPView imvpView) {
        this.imvpView = imvpView;
        mvpMode = new MVPMode();
    }

    public void getData(String accountName) {
        mvpMode.getAccountData(accountName, new MCallback() {
            @Override
            public void success(Account account) {
                imvpView.showSuccessPage(account);
            }

            @Override
            public void failed() {

                imvpView.showFailedPage();
            }
        });
    }
}
