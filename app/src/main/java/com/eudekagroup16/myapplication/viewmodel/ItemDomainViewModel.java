package com.eudekagroup16.myapplication.viewmodel;

import android.databinding.ObservableField;
import android.text.TextUtils;

import com.eudekagroup16.myapplication.model.DomainDetail;

public class ItemDomainViewModel {

    public ObservableField<String> domainNameValue;
    public ObservableField<String> domainCountryValue;

    public ItemDomainViewModel(DomainDetail domainDetail) {
        domainNameValue = new ObservableField<>(domainDetail.getDomainName());
        domainCountryValue = new ObservableField<>("");
        if (TextUtils.isEmpty(domainDetail.domainCountry)) {
            domainCountryValue.set("-");
        }else{
            domainCountryValue.set(domainDetail.getDomainCountry());
        }
    }

}
