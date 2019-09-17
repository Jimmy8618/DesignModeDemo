package com.jimmy.mvvm.viewmodel;

import android.app.Application;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.jimmy.mvvm.BR;
import com.jimmy.mvvm.bean.Account;
import com.jimmy.mvvm.callback.MCallback;
import com.jimmy.mvvm.databinding.ActivityMvvmBinding;
import com.jimmy.mvvm.model.Model;

public class VModel extends BaseObservable {

    private String mResult;
    private Model model;
    private String mUserInput;
    private ActivityMvvmBinding binding;

    public VModel(Application application) {

        model = new Model();
//        binding =bindings;

    }

    public VModel(Application application, ActivityMvvmBinding bindings) {

        model = new Model();
        binding =bindings;

    }

    @Bindable
    public String getUserInput() {
        return mUserInput;
    }

    public void setUserInput(String userInput) {
        this.mUserInput = userInput;
        notifyPropertyChanged(BR.userInput);
    }



    @Bindable
    public String getResult() {
        return mResult;
    }

    public void setResult(String result) {
        mResult = result;
        notifyPropertyChanged(BR.result);
    }

    public void getData(View view){
//        String userInput = binding.etName.getText().toString();
        model.getAccountData(mUserInput, new MCallback() {
            @Override
            public void success(Account account) {
                String info = account.getName() + " | " +account.getLevel();
                Log.d("jimmy","info= "+info);
                setResult(info);

            }

            @Override
            public void failed() {
                setResult("获取失败");

            }
        });
    }
}
