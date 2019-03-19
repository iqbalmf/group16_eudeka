package com.eudekagroup16.myapplication;

import android.content.Context;

import com.eudekagroup16.myapplication.data.DomainRepository;
import com.eudekagroup16.myapplication.data.remote.DomainNameRemoteDataSource;

public class Injection {
    public static DomainRepository provideDomainRepository(Context context) {
        return new DomainRepository(new DomainNameRemoteDataSource());
    }
}
