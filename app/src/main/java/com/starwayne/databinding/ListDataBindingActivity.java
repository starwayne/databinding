package com.starwayne.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.starwayne.databinding.bean.Person;
import com.starwayne.databinding.databinding.ActivityListBinding;

import java.util.ArrayList;
import java.util.Random;

public class ListDataBindingActivity extends AppCompatActivity {

    ActivityListBinding mBinding;

    PersonListAdapter mPersonListAdapter;


    public class Presenter {

        private Random mRandom = new Random(System.currentTimeMillis());

        public void onClickAddItem(View view) {
            mPersonListAdapter.add(MyUtils.genNewPerson());
        }

        public void onClickRemoveItem(View view) {
            mPersonListAdapter.remove();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(ListDataBindingActivity.this, R.layout.activity_list);
        mBinding.setPresenter(new Presenter());
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mPersonListAdapter = new PersonListAdapter(this);
        mBinding.recyclerView.setAdapter(mPersonListAdapter);
        mPersonListAdapter.setListener(new PersonListAdapter.OnItemClickListener() {
            @Override
            public void onPersonClick(Person person) {
                Toast.makeText(ListDataBindingActivity.this,
                        person.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        ArrayList<Person> persons = new ArrayList<>();
        for(int i = 0 ; i < 5 ; i++){
            persons.add(MyUtils.genNewPerson());
        }
        mPersonListAdapter.addAll(persons);

    }
}
