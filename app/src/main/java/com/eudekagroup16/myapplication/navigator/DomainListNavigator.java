package com.eudekagroup16.myapplication.navigator;

import com.eudekagroup16.myapplication.model.DomainDetail;

import java.util.List;

public interface DomainListNavigator {
    void loadDomainList(List<DomainDetail> domains);

    void setLoading(boolean isLoading);
}
