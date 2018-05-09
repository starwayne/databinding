package com.starwayne.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.starwayne.databinding.bean.User;
import com.starwayne.databinding.databinding.ActivityExpressionDataBindingBinding;

import java.util.Random;

public class ExpressionDataBindingActivity extends AppCompatActivity {

    Random mRandom = new Random(System.currentTimeMillis());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        User user = new User("Xin", "Wang");
        user.setHidden(mRandom.nextBoolean());
        ActivityExpressionDataBindingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_expression_data_binding);

    }

    public class Presenter{
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        public void onClick(View view){
            Toast.makeText(ExpressionDataBindingActivity.this, "Button clicked", Toast.LENGTH_SHORT).show();

        }
    }
}
