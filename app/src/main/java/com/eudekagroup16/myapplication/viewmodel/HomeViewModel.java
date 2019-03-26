package com.eudekagroup16.myapplication.viewmodel;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.eudekagroup16.myapplication.R;
import com.eudekagroup16.myapplication.customview.UIDialog;
import com.eudekagroup16.myapplication.data.DomainNameDataSource;
import com.eudekagroup16.myapplication.data.DomainRepository;
import com.eudekagroup16.myapplication.listener.ClickListenerModel;
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

    public HomeViewModel(DomainRepository domainRepository) {
        this.domainRepository = domainRepository;
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
            public void onDataAvailable() {
                homeNavigator.onDataNotFound();
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {
                homeNavigator.onErrorLoaded(errorMessage);
            }
        }, query);
    }

    public void getConnected(Context context) {
        if (!isConnected(context)) {
            UIDialog.showDialogChecker(context,
                    "",
                    context.getResources().getString(R.string.text_message_noconnection),
                    new ClickListenerModel(context.getResources().getString(R.string.text_label_positive), null))
                    .show();
        }
    }

    private static boolean isConnected(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
