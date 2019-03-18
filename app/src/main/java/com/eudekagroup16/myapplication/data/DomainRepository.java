package com.eudekagroup16.myapplication.data;

import android.support.annotation.Nullable;

import com.eudekagroup16.myapplication.data.remote.*;
import com.eudekagroup16.myapplication.model.Domains;

public class DomainRepository implements DomainNameDataSource {
    private DomainNameRemoteDataSource domainemoteDataSource;

    public DomainRepository(DomainNameRemoteDataSource domainNameRemoteDataSource) {
        this.domainemoteDataSource = domainNameRemoteDataSource;
    }


    @Override
    public void getListDomains(final GetDomainsCallback callback, String query) {
        domainemoteDataSource.getListDomains(new GetDomainsCallback() {
            @Override
            public void onDomainsLoaded(Domains data) {
                callback.onDomainsLoaded(data);
            }
            @Override
            public void onDataNotAvailable(String errorMessage) {
                callback.onDataNotAvailable(errorMessage);
            }
        }, query);
    }


}
