package com.starwayne.databinding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ObservableDataBindingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observable);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new ObservableFragment())
                .commit();
    }
}
