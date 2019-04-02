package com.eudekagroup16.myapplication.view;


import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.eudekagroup16.myapplication.Constants;
import com.eudekagroup16.myapplication.Injection;
import com.eudekagroup16.myapplication.MyClickListener;
import com.eudekagroup16.myapplication.R;
import com.eudekagroup16.myapplication.customview.ProgressDialogFragment;
import com.eudekagroup16.myapplication.customview.UIDialog;
import com.eudekagroup16.myapplication.databinding.ActivityMainBinding;
import com.eudekagroup16.myapplication.listener.ClickListenerModel;
import com.eudekagroup16.myapplication.model.DomainDetail;
import com.eudekagroup16.myapplication.navigator.HomeNavigator;
import com.eudekagroup16.myapplication.viewmodel.HomeViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements HomeNavigator {

    private HomeViewModel homeViewModel;
    private MyClickListener listener;
    private List<DomainDetail> dataListDomain;
    private EditText etDomain;
    private TextInputLayout tilDomain;
    private Button butCekDomain, butCekListDomain;
    ProgressDialogFragment progressDialog;
    ActivityMainBinding binding;

    public static void start(Context context) {
        Intent intent = new Intent(context, HomeActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeUI();
        initViewEvent();
        initViewModel();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (progressDialog != null && progressDialog.isVisible()) {
            progressDialog.dismiss();
        }
    }

    private void initViewModel() {
        homeViewModel.getConnected(this);
    }

    private void initViewEvent() {
        butCekDomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(etDomain.getText().toString())) {
                    tilDomain.setError(getString(R.string.text_domain_empty));
                    return;
                }
                homeViewModel.getCheckResult(etDomain.getText().toString());
            }
        });
        butCekListDomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(etDomain.getText().toString())) {
                    tilDomain.setError(getString(R.string.text_domain_empty));
                    return;
                }
                Intent intent = new Intent(HomeActivity.this, DomainListActivity.class);
                intent.putExtra(Constants.NAMA_DOMAIN, etDomain.getText().toString());
                startActivity(intent);
            }
        });
        etDomain.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (etDomain.getText().length() > 0) {
                    tilDomain.setError(null);
                }
            }
        });
    }

    private void initializeUI() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        homeViewModel = new HomeViewModel(Injection.provideDomainRepository(this));
        dataListDomain = new ArrayList<>();
        homeViewModel.setHomeNavigator(this);
        listener = new MyClickListener(this);
        binding.setMyClickListener(listener);
        etDomain = findViewById(R.id.etInputText);
        tilDomain = findViewById(R.id.tilInputText);
        progressDialog = new ProgressDialogFragment();
        progressDialog.setCancelable(false);
        butCekDomain = findViewById(R.id.butCekDomain);
        butCekListDomain = findViewById(R.id.butCekListDomain);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(getResources().getString(R.string.text_label_titlebar));
        }
    }

    @Override
    public void onViewLoaded(List<DomainDetail> listDomain) {
        UIDialog.showDialogChecker(this,
                "Hasil Check Domain\n" + etDomain.getText().toString(),
                this.getResources().getString(R.string.text_domain_unavailable),
                new ClickListenerModel(this.getResources().getString(R.string.text_label_positive), null)).show();
    }

    @Override
    public void onDataNotFound() {
        UIDialog.showDialogChecker(this,
                "Hasil Check Domain\n" + etDomain.getText().toString(),
                this.getResources().getString(R.string.text_domain_available),
                new ClickListenerModel(this.getResources().getString(R.string.text_label_positive), null)).show();
    }

    @Override
    public void onErrorLoaded(String message) {
        UIDialog.showDialogChecker(this,
                "Hasil Check Domain\n" + etDomain.getText().toString(),
                message,
                new ClickListenerModel(this.getResources().getString(R.string.text_label_positive), null)).show();
    }

    @Override
    public void setLoading(boolean isLoading) {
        if (isLoading) {
            progressDialog.show(getSupportFragmentManager(), "ProgressDialog");
        } else {
            progressDialog.dismiss();
        }
    }

}
