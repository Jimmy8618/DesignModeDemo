package com.jimmy.designmodedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jimmy.designmodedemo.bean.Account;
import com.jimmy.designmodedemo.callback.MCallback;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etName;
    private Button btSumbit;
    private TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void initView(){
        etName = findViewById(R.id.et_name);
        btSumbit = findViewById(R.id.bt_submit);
        tvContent = findViewById(R.id.tv_content);

        btSumbit.setOnClickListener(this);
    }

    private String getUserInput(){
        return etName.getText().toString();
    }

    private void showSuccessPage(Account account){
        tvContent.setText("用户名："+account.getName()+"|"+"用户等级："+account.getLevel());

    }

    private void showFailedPage(){
        tvContent.setText("查询失败！");

    }

    private void getAccountData(String accountName, MCallback mCallbacks){
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
    @Override
    public void onClick(View v) {
        getAccountData(getUserInput(), new MCallback() {
            @Override
            public void success(Account account) {
                showSuccessPage(account);
            }

            @Override
            public void failed() {

                showFailedPage();
            }
        });
    }
}
