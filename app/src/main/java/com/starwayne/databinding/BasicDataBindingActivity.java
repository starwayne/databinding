package com.starwayne.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.starwayne.databinding.databinding.ActivityBasicDataBindingBinding;

import java.util.ArrayList;
import java.util.HashMap;

public class BasicDataBindingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityBasicDataBindingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_basic_data_binding);
        binding.setNum(999);
        binding.setStr("Str");

        String[] array = new String[2];
        array[0] = "array 0";
        array[1] = "array 1";
        binding.setStringArray(array);
        binding.setArrayIndex(1);

        ArrayList aList = new ArrayList<String>();
        aList.add("list item 0");
        aList.add("list item 1");
        aList.add("list item 2");
        binding.setArrayList(aList);
        binding.setListIndex(2);

        HashMap aMap = new HashMap<String, String>();
        aMap.put("name", "xiaoming");
        binding.setHashMap(aMap);
        binding.setMapKey("name");

        //binding.setBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.ic_cloud_black_24dp));
    }
}
