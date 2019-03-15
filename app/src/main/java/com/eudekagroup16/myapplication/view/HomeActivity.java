package com.eudekagroup16.myapplication.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.eudekagroup16.myapplication.MyClickListener;
import com.eudekagroup16.myapplication.R;
import com.eudekagroup16.myapplication.databinding.ActivityMainBinding;
import com.eudekagroup16.myapplication.navigator.HomeNavigator;
import com.eudekagroup16.myapplication.viewmodel.HomeViewModel;

public class HomeActivity extends AppCompatActivity implements HomeNavigator {

    private HomeViewModel homeViewModel;
    private MyClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        listener = new MyClickListener(this);
        binding.setMyClickListener(listener);

    }

    @Override
    public void onViewLoaded() {

    }

    @Override
    public void onErrorLoaded() {

    }
}
