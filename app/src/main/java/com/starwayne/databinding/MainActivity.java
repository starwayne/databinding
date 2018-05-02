package com.starwayne.databinding;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.starwayne.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding bindings = DataBindingUtil.setContentView(this, R.layout.activity_main);
        String[] nameArray = getResources().getStringArray(R.array.main_activity_button_names);
        bindings.setButtonNameArray(nameArray);

    }

    public void onDemo1Click(View view){
        Intent intent = new Intent();
        intent.setClassName("com.starwayne.databinding" , "com.starwayne.databinding.ActivityDemo1");
        startActivity(intent);
    }

    public void onDemo2Click(View view){

    }
}
