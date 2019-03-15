package com.eudekagroup16.myapplication.viewmodel;

import android.content.Context;

import com.eudekagroup16.myapplication.navigator.HomeNavigator;

/**
 * Project MyApplication
 * <p>
 * Created by IqbalMF on 3/15/2019
 */
public class HomeViewModel {
    private HomeNavigator homeNavigator;
    private Context context;

    public HomeViewModel(Context context) {
        this.context = context;
    }

    public void setHomeNavigator(HomeNavigator mHomeNavigator) {
        homeNavigator = mHomeNavigator;
    }

    public void getCheckResult() {

    }
}
