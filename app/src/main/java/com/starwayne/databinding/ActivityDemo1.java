package com.starwayne.databinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.starwayne.databinding.bean.Person;
import com.starwayne.databinding.databinding.ActivityDemo1Binding;

public class ActivityDemo1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDemo1Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_demo_1);
        Person person = new Person("xiaoming", "36", "China");
        binding.setPerson(person);
    }
}
