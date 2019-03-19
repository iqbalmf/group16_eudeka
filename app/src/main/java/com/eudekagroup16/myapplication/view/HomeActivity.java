package com.eudekagroup16.myapplication.view;


import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.eudekagroup16.myapplication.Injection;
import com.eudekagroup16.myapplication.MyClickListener;
import com.eudekagroup16.myapplication.R;
import com.eudekagroup16.myapplication.databinding.ActivityMainBinding;
import com.eudekagroup16.myapplication.model.DomainDetail;
import com.eudekagroup16.myapplication.navigator.HomeNavigator;
import com.eudekagroup16.myapplication.viewmodel.HomeViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements HomeNavigator {

    private HomeViewModel homeViewModel;
    private MyClickListener listener;
    private List<DomainDetail> dataListDomain;
    private EditText inputnamaDomain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        listener = new MyClickListener(this);
        binding.setMyClickListener(listener);
        homeViewModel = new HomeViewModel(Injection.provideDomainRepository(this),this);
        dataListDomain = new ArrayList<>();
        homeViewModel.setHomeNavigator(this);
        //parameter query domain yang di input user
        homeViewModel.getCheckResult("facebook");

    }

    @Override
    public void onViewLoaded(List<DomainDetail> listDomain) {

        dataListDomain.addAll(listDomain);

        //Testing Menampilkan Ambil data Ambil data
        int listsize = listDomain.size();
        for (int i = 0; i<listsize; i++){
            DomainDetail data = listDomain.get(i);
            Log.e("Data Array:" , data.getDomainName());
            }
    }

    @Override
    public void onErrorLoaded(String message) {
        Log.e("ERROR", message);
    }
}
