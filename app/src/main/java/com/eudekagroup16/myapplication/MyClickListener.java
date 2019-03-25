package com.eudekagroup16.myapplication;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.eudekagroup16.myapplication.databinding.ActivityMainBinding;
import com.eudekagroup16.myapplication.model.Domains;
import com.eudekagroup16.myapplication.view.DomainListActivity;
import com.eudekagroup16.myapplication.viewmodel.HomeViewModel;

/**
 * Project MyApplication
 * <p>
 * Created by IqbalMF on 3/15/2019
 */
public class MyClickListener {
    private Context context;
    Domains domains;

    public MyClickListener(Context context) {
        this.context = context;
    }

    public void onClickListener(View view) {
        Intent intent = new Intent(context, DomainListActivity.class);
        context.startActivity(intent);
        Log.i("TAG", "onClickListener: "+domains);
    }

    public void onCheckAvaibility(View.OnClickListener view) {

    }
}
