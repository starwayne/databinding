package com.starwayne.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.starwayne.databinding.databinding.ExpressionDataBinding;

public class ExpressionDataBindingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ExpressionDataBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_expression_data_binding);
    }
}
