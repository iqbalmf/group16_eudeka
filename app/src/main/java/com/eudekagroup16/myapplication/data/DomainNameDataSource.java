package com.eudekagroup16.myapplication.data;

import com.eudekagroup16.myapplication.model.Domains;

public interface DomainNameDataSource {
    void getListDomains(GetDomainsCallback callback, String query);


    interface GetDomainsCallback {
        void onDomainsLoaded(Domains data);
        void onDataAvailable();
        void onDataNotAvailable(String errorMessage);
    }
}
