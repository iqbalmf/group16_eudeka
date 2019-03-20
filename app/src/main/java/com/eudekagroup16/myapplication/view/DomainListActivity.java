package com.eudekagroup16.myapplication.view;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.eudekagroup16.myapplication.R;
import com.eudekagroup16.myapplication.adapter.DomainAdapter;
import com.eudekagroup16.myapplication.listener.ItemDomainClickListener;
import com.eudekagroup16.myapplication.model.DomainDetail;

import java.util.ArrayList;
import java.util.List;

public class DomainListActivity extends AppCompatActivity implements ItemDomainClickListener, SwipeRefreshLayout.OnRefreshListener {

    DomainAdapter adapter;
    RecyclerView domainRv;
    SwipeRefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_domain_list);
        initUi();
        setupAdapter();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRefresh() {
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void onItemClickListener(DomainDetail domain) {

    }

    private void initUi() {
        domainRv = findViewById(R.id.listDomain);
        refreshLayout = findViewById(R.id.refreshLayout);
        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setColorSchemeColors(ContextCompat.getColor(this, R.color.colorPrimary));

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Domain List");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setupAdapter() {
        adapter = new DomainAdapter(this);
        domainRv.setAdapter(adapter);
        domainRv.setLayoutManager(new LinearLayoutManager(this));
        adapter.setItems(dummyData());
    }

    public List<DomainDetail> dummyData() {
        List<DomainDetail> dummyList = new ArrayList<>();
        dummyList.add(new DomainDetail("facebook.com", "SG"));
        dummyList.add(new DomainDetail("facebook.com", "SG"));
        dummyList.add(new DomainDetail("facebook.com", "SG"));
        dummyList.add(new DomainDetail("facebook.com", "SG"));
        dummyList.add(new DomainDetail("facebook.com", "SG"));
        dummyList.add(new DomainDetail("facebook.com", "SG"));
        dummyList.add(new DomainDetail("facebook.com", "SG"));
        dummyList.add(new DomainDetail("facebook.com", "SG"));
        return dummyList;
    }
}
