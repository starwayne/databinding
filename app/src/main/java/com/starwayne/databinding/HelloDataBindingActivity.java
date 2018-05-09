package com.starwayne.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.starwayne.databinding.bean.Person;
import com.starwayne.databinding.databinding.ActivityHelloDataBindingBinding;

public class HelloDataBindingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityHelloDataBindingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_hello_data_binding);
        Person person = new Person("xiaoming", "36", "China");
        binding.setPerson(person);
        binding.textView1.setVisibility(View.VISIBLE);
    }
}
