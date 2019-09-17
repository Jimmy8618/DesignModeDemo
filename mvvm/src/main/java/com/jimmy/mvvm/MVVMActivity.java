package com.jimmy.mvvm;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.jimmy.mvvm.bean.Account;
import com.jimmy.mvvm.databinding.ActivityMvvmBinding;
import com.jimmy.mvvm.viewmodel.VModel;

public class MVVMActivity extends AppCompatActivity {

    Account account;
    ActivityMvvmBinding binding;

    /**
     * 1.提供View，ViewModel以及model三层
     * 2.将布局改为DataBinding布局
     * 3.View与ViewModel通过DataBinding进行通信
     * 4.获取数据并展示在界面上
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_mvvm);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_mvvm);
//        account = new Account();
//        account.setName("test");
//        account.setLevel(100);
//        binding.setAccount(account);
//        binding.setActivity(this);
        VModel vm = new VModel(getApplication());
        binding.setViewModle(vm);
    }

    public void onClick(View view){
//        Toast.makeText(this,"agann",Toast.LENGTH_LONG).show();
        int level = account.getLevel();
        account.setLevel(level + 1);
//        binding.setAccount(account);

    }
}
