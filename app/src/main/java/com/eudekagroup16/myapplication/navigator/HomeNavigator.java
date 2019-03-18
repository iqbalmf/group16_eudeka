package com.eudekagroup16.myapplication.navigator;

import com.eudekagroup16.myapplication.model.DomainDetail;

import java.util.List;

/**
 * Project MyApplication
 * <p>
 * Created by IqbalMF on 3/15/2019
 */
public interface HomeNavigator {
    void onViewLoaded(List<DomainDetail> listDomain);

    void onErrorLoaded(String message);
}
