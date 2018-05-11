package com.starwayne.databinding.bean;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;


public class Company {
    public ObservableField<String> name = new ObservableField<>();
    public ObservableArrayList<String> products = new ObservableArrayList<>();
}
