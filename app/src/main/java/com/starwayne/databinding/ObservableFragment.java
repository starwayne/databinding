package com.starwayne.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.starwayne.databinding.bean.Company;
import com.starwayne.databinding.bean.Country;
import com.starwayne.databinding.databinding.FragmentObservableBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class ObservableFragment extends Fragment {

    private Random mRandom = new Random(System.currentTimeMillis());
    FragmentObservableBinding mDataBinding;
    private ArrayList<String> mCountrieDatas;
    private ArrayList<String> mCompanyDatas;
    private HashMap<String, ArrayList<String> > mProductDatas;

    private Country mCountry = new Country();
    private Company mCompany = new Company();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDatas();
    }

    private void initDatas() {
        mCountrieDatas = new ArrayList<>();
        mCountrieDatas.add("China");
        mCountrieDatas.add("USA");
        mCountrieDatas.add("Japan");

        mCompanyDatas = new ArrayList<>();
        mCompanyDatas.add("ZTE");
        mCompanyDatas.add("SONY");
        mCompanyDatas.add("APPLE");

        mProductDatas = new HashMap<>();

        ArrayList<String> aList = new ArrayList<>();
        aList.add("Multy");
        aList.add("Blade");
        aList.add("Axon");
        mProductDatas.put("ZTE", aList);

        ArrayList<String> bList = new ArrayList<>();
        bList.add("sony 1");
        bList.add("sony 2");
        bList.add("sony 3");
        mProductDatas.put("SONY", bList);

        ArrayList<String> cList = new ArrayList<>();
        cList.add("iphone 4");
        cList.add("iphone 6");
        cList.add("iphone 8");
        mProductDatas.put("APPLE", cList);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_observable, container, false);
        mCountry.setName(mCountrieDatas.get(0));
        mDataBinding.setCountry(mCountry);
        fillCompanyAndProductsData(0);
        mDataBinding.setCompany(mCompany);
        showCurrentProductInfo();
        mDataBinding.setPresenter(new Presenter());
        return mDataBinding.getRoot();
    }

    private void fillCompanyAndProductsData(int index){
        String companyName = mCompanyDatas.get(index);
        mCompany.name.set(companyName);
        ArrayList<String> products = mProductDatas.get(companyName);
        int size = products.size();
        mCompany.products.clear();
        for(int i = 0 ; i < size ; i++){
            mCompany.products.add(products.get(i));
        }
    }

    private void showCurrentProductInfo(){
        mDataBinding.tvProducts.setText(getCurrentProductsInfo());
    }

    private String getCurrentProductsInfo(){
        StringBuilder ret = new StringBuilder();
        for(String product : mCompany.products){
            ret.append(product).append("\n");
        }
        return ret.toString();
    }

    public class Presenter{

        private int mIndex = 0;

        public void onClick(View view){
            Log.d("CHECK", "Presenter onClick");
            while(true){
                int index = (mRandom.nextInt() % mCompanyDatas.size() );
                if( mIndex != index){
                    mIndex = index;
                    break;
                }
            }
            showInfo(mIndex);
        }
    }

    private void showInfo(int index) {
        mCountry.setName(mCountrieDatas.get(index));
        fillCompanyAndProductsData(index);
        showCurrentProductInfo();
    }
}
