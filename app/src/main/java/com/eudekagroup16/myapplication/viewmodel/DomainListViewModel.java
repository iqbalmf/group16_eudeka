package com.eudekagroup16.myapplication.viewmodel;

import android.content.Context;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.view.View;

import com.eudekagroup16.myapplication.data.DomainNameDataSource;
import com.eudekagroup16.myapplication.data.DomainRepository;
import com.eudekagroup16.myapplication.model.Domains;
import com.eudekagroup16.myapplication.navigator.DomainListNavigator;

public class DomainListViewModel {

    private final DomainRepository repository;
    private final DomainListNavigator navigator;
    private final Context context;

    public ObservableInt progressBarVisibility;
    public ObservableInt domainListVisibility;
    public ObservableInt errorMessageVisibility;
    public ObservableBoolean isLoading = new ObservableBoolean();

    public ObservableField<String> errorMessageValue;

    public DomainListViewModel(DomainRepository repository, DomainListNavigator navigator, Context context) {
        this.repository = repository;
        this.navigator = navigator;
        this.context = context;

        progressBarVisibility = new ObservableInt(View.VISIBLE);
        domainListVisibility = new ObservableInt(View.GONE);
        errorMessageVisibility = new ObservableInt(View.GONE);
        errorMessageValue = new ObservableField<>("");
    }

    public void getDomainList(String queryText) {
        progressBarVisibility.set(View.VISIBLE);
        domainListVisibility.set(View.GONE);
        errorMessageVisibility.set(View.GONE);
        repository.getListDomains(new DomainNameDataSource.GetDomainsCallback() {
            @Override
            public void onDomainsLoaded(Domains data) {
                navigator.setLoading(false);
                errorMessageVisibility.set(View.GONE);
                domainListVisibility.set(View.VISIBLE);
                progressBarVisibility.set(View.GONE);
                navigator.loadDomainList(data.getDomains());
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {
                navigator.setLoading(false);
                errorMessageVisibility.set(View.VISIBLE);
                domainListVisibility.set(View.GONE);
                progressBarVisibility.set(View.GONE);
                errorMessageValue.set(errorMessage);
            }

            @Override
            public void onDataAvailable() {
                navigator.setLoading(false);
                errorMessageVisibility.set(View.VISIBLE);
                domainListVisibility.set(View.GONE);
                progressBarVisibility.set(View.GONE);
                errorMessageValue.set("Data tidak tersedia");
            }
        }, queryText);
    }
}
