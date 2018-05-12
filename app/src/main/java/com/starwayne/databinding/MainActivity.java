package com.starwayne.databinding;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.starwayne.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding bindings = DataBindingUtil.setContentView(this, R.layout.activity_main);
        String[] nameArray = getResources().getStringArray(R.array.main_activity_button_names);
        bindings.setButtonNameArray(nameArray);
        bindings.setHandlers(new EventHandlers());

    }


    public class EventHandlers{
        public void handleClick(View view) {
            int viewId = view.getId();
            Intent intent = new Intent();
            if(viewId == R.id.hello_data_binding_id){
                intent.setClass(MainActivity.this, HelloDataBindingActivity.class);
            } else if(viewId == R.id.basic_data_binding_id){
                intent.setClass(MainActivity.this, BasicDataBindingActivity.class);
            } else if(viewId == R.id.expression_data_binding_id){
                intent.setClass(MainActivity.this, ExpressionDataBindingActivity.class);
            } else if(viewId == R.id.observable_data_binding_id){
                intent.setClass(MainActivity.this, ObservableDataBindingActivity.class);
            } else if(viewId == R.id.list_data_binding_id){
                intent.setClass(MainActivity.this, ListDataBindingActivity.class);
            } else {
                intent = null;
            }
            Log.d("MainActivity", "handleClick intent:" + intent);
            if(intent != null){
                startActivity(intent);
            }
        }
    }
}
