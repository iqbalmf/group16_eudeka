package com.eudekagroup16.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.eudekagroup16.myapplication.view.DomainListActivity;
import com.eudekagroup16.myapplication.viewmodel.HomeViewModel;

/**
 * Project MyApplication
 * <p>
 * Created by IqbalMF on 3/15/2019
 */
public class MyClickListener {
    private Context context;
    private HomeViewModel homeViewModel;

    public MyClickListener(Context context) {
        this.context = context;
    }
    public void onClickListener(View view){

    }

    public void onCheckAvaibility(View view){
        Intent intent = new Intent(context, DomainListActivity.class);
        context.startActivity(intent);
    }
}
