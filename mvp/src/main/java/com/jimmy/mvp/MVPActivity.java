package com.jimmy.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jimmy.mvp.mode.Account;
import com.jimmy.mvp.presenter.MVPPresenter;

public class MVPActivity extends AppCompatActivity implements View.OnClickListener,IMVPView {

    /**
     * 1.MVPActivity负责提供view层面的功能（采用实现接口的方式）
     * 2.MVPMode负责提供数据方面的功能
     * 3.Model与view不再直接通信，通过Presenter来实现
     */


    private EditText etName;
    private Button btSumbit;
    private TextView tvContent;
    MVPPresenter mvpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        mvpPresenter = new MVPPresenter(this);
        initView();
    }

    public void initView(){
        etName = findViewById(R.id.et_name);
        btSumbit = findViewById(R.id.bt_submit);
        tvContent = findViewById(R.id.tv_content);

        btSumbit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        mvpPresenter.getData(getUserInput());

    }

    @Override
    public String getUserInput() {
        return etName.getText().toString();
    }

    @Override
    public void showSuccessPage(Account account) {
        tvContent.setText("用户名："+account.getName()+" | "+"用户等级："+account.getLevel());

    }

    @Override
    public void showFailedPage() {
        tvContent.setText("查询失败！");
    }
}
