package com.eudekagroup16.myapplication.data.remote;

import java.util.concurrent.TimeUnit;

import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkhttpClientFactory {
    private static final int DEFAULT_MAX_REQUEST = 30;

    private static final int TIMEOUT = 20;

    private OkhttpClientFactory() {

    }

    public static OkHttpClient create() {

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true);


            HttpLoggingInterceptor interceptor =
                    new HttpLoggingInterceptor();
            interceptor
                    .setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(interceptor).build();

        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequests(DEFAULT_MAX_REQUEST);
        builder.dispatcher(dispatcher);

        return builder.build();
    }
}
