package com.starwayne.databinding.bean;


import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.starwayne.databinding.BR;

public class Country extends BaseObservable{
    private String name;

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }
}
