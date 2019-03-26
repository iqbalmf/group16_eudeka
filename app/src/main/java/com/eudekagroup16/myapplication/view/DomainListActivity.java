package com.eudekagroup16.myapplication.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.MenuItem;

import com.eudekagroup16.myapplication.Constants;
import com.eudekagroup16.myapplication.Injection;
import com.eudekagroup16.myapplication.R;
import com.eudekagroup16.myapplication.adapter.DomainAdapter;
import com.eudekagroup16.myapplication.databinding.ActivityDomainListBinding;
import com.eudekagroup16.myapplication.listener.ItemDomainClickListener;
import com.eudekagroup16.myapplication.model.DomainDetail;
import com.eudekagroup16.myapplication.navigator.DomainListNavigator;
import com.eudekagroup16.myapplication.viewmodel.DomainListViewModel;

import java.util.ArrayList;
import java.util.List;

public class DomainListActivity extends AppCompatActivity implements ItemDomainClickListener, DomainListNavigator {

    DomainAdapter adapter;
    RecyclerView domainRv;
    SwipeRefreshLayout refreshLayout;
    DomainListViewModel viewModel;
    ActivityDomainListBinding binding;

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
    public void setLoading(boolean isLoading) {
        refreshLayout.setRefreshing(isLoading);
    }

    @Override
    public void loadDomainList(List<DomainDetail> domains) {
        adapter.setItems(domains);
    }

    @Override
    public void onItemClickListener(DomainDetail domain) {

    }

    private void initUi() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_domain_list);
        viewModel = new DomainListViewModel(Injection.provideDomainRepository(this), this, this);
        binding.setVm(viewModel);
        domainRv = findViewById(R.id.listDomain);
        refreshLayout = findViewById(R.id.refreshLayout);
        refreshLayout.setColorSchemeColors(ContextCompat.getColor(this, R.color.colorPrimary));

        String queryText = getIntent().getStringExtra(Constants.NAMA_DOMAIN);
        binding.setQueryText(queryText);
        viewModel.getDomainList(queryText);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Domain List" + (TextUtils.isEmpty(queryText) ? "" : (" : " + queryText)));
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setupAdapter() {
        adapter = new DomainAdapter(this);
        domainRv.setAdapter(adapter);
        domainRv.setLayoutManager(new LinearLayoutManager(this));
    }
}
