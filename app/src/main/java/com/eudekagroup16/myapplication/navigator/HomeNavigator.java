package com.eudekagroup16.myapplication.navigator;

import android.content.Context;

import com.eudekagroup16.myapplication.model.DomainDetail;

import java.util.List;

/**
 * Project MyApplication
 * <p>
 * Created by IqbalMF on 3/15/2019
 */
public interface HomeNavigator {
    void onViewLoaded(List<DomainDetail> listDomain);

    void onDataNotFound();

    void onErrorLoaded(String message);
}
