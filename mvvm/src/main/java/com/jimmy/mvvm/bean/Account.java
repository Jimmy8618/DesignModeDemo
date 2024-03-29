package com.jimmy.mvvm.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.jimmy.mvvm.BR;

public class Account extends BaseObservable {

    private String name;
    private int level;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Bindable
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
        notifyPropertyChanged(BR.level);
    }
}
