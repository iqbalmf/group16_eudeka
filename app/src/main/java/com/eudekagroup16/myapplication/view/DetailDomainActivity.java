package com.eudekagroup16.myapplication.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MenuItem;
import android.widget.TextView;

import com.eudekagroup16.myapplication.Constants;
import com.eudekagroup16.myapplication.R;
import com.eudekagroup16.myapplication.adapter.DetailDomainAdapter;
import com.eudekagroup16.myapplication.model.DomainDetail;

import java.util.ArrayList;

public class DetailDomainActivity extends AppCompatActivity {

    private RecyclerView rvDetail;

    private TextView tvLabelDetail;

    private DetailDomainAdapter adapter;

    private ArrayList<Pair<String, String>> details;

    private DomainDetail detail;

    public static void start(Context context, DomainDetail domainDetail){
        Intent intent = new Intent(context, DetailDomainActivity.class);
        intent.putExtra(Constants.KEY_DETAIL_DOMAIN, domainDetail);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_domain);

        initIntent();

        initUI();
    }

    private void initIntent() {
        detail = getIntent().getParcelableExtra(Constants.KEY_DETAIL_DOMAIN);
    }

    private void initUI() {
        rvDetail = findViewById(R.id.rv_list_detail);
        tvLabelDetail = findViewById(R.id.tv_label_detail);

        tvLabelDetail.setText(String.format(getString(R.string.label_detail_domain), detail.getDomainName()));
        details = new ArrayList<>();
        details.add(new Pair<>(getString(R.string.label_country), detail.getDomainCountry()));
        details.add(new Pair<>(getString(R.string.label_suffix), detail.getDomainSuffix()));
        details.add(new Pair<>(getString(R.string.label_created_at), detail.getDomainCreate()));
        details.add(new Pair<>(getString(R.string.label_expired_at), detail.getDomainExpiry()));
        details.add(new Pair<>(getString(R.string.label_updated_at), detail.getDomainUpdate()));
        if (!detail.getDomainNS().isEmpty()){
            StringBuilder nsList = new StringBuilder();
            for (String ns : detail.getDomainNS()){
                nsList.append(ns);
                nsList.append(" ");
            }
            details.add(new Pair<>(getString(R.string.label_ns), nsList.toString()));
        }
        adapter = new DetailDomainAdapter(this, details);
        rvDetail.setLayoutManager(new LinearLayoutManager(this));
        rvDetail.setNestedScrollingEnabled(false);
        rvDetail.setAdapter(adapter);
        rvDetail.setHasFixedSize(true);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.title_detail_domain);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
