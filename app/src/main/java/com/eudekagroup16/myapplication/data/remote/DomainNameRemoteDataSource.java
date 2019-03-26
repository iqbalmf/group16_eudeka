package com.eudekagroup16.myapplication.data.remote;


import com.eudekagroup16.myapplication.data.DomainNameDataSource;
import com.eudekagroup16.myapplication.model.Domains;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DomainNameRemoteDataSource implements DomainNameDataSource {

    private ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

    @Override
    public void getListDomains(final GetDomainsCallback callback, String query) {
        Call<Domains> call = apiInterface.getAllDomains(query);
        call.enqueue(new Callback<Domains>() {
            @Override
            public void onResponse(Call<Domains> call, Response<Domains> response) {
                if (response.isSuccessful()) {
                    callback.onDomainsLoaded(response.body());
                } else { /*ketika failed response*/
                    callback.onDataAvailable();
                }
            }

            @Override
            public void onFailure(Call<Domains> call, Throwable t) {
                callback.onDataNotAvailable(t.toString());
            }
        });
    }
}
