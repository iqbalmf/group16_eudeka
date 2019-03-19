package com.eudekagroup16.myapplication.viewmodel;

import android.content.Context;

import com.eudekagroup16.myapplication.data.DomainNameDataSource;
import com.eudekagroup16.myapplication.data.DomainRepository;
import com.eudekagroup16.myapplication.model.Domains;
import com.eudekagroup16.myapplication.navigator.HomeNavigator;

/**
 * Project MyApplication
 * <p>
 * Created by IqbalMF on 3/15/2019
 */
public class HomeViewModel {

    private DomainRepository domainRepository;
    private HomeNavigator homeNavigator;
    private Context context;

    public HomeViewModel(DomainRepository domainRepository, Context context) {
        this.domainRepository = domainRepository;
        this.context = context;
    }

    public void setHomeNavigator(HomeNavigator mHomeNavigator) {
        homeNavigator = mHomeNavigator;
    }

    public void getCheckResult(String query) {
        domainRepository.getListDomains(new DomainNameDataSource.GetDomainsCallback() {
            @Override
            public void onDomainsLoaded(Domains data) {
                homeNavigator.onViewLoaded(data.getDomains());
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {
                homeNavigator.onErrorLoaded(errorMessage);
            }
        }, query);
    }
}
