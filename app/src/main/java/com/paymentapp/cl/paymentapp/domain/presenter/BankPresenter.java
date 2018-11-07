package com.paymentapp.cl.paymentapp.domain.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.paymentapp.cl.paymentapp.data.rest.PaymentAppApi;
import com.paymentapp.cl.paymentapp.data.view.BankContract;
import com.paymentapp.cl.paymentapp.domain.model.Bank;
import com.paymentapp.cl.paymentapp.utils.Constants;


import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class BankPresenter implements BankContract.Presenter {
    private static final String TAG = BankPresenter.class.getSimpleName();
    private BankContract.View mView;
    private Retrofit retrofit;

    @Inject
    public BankPresenter(Retrofit retrofit, BankContract.View mView) {
        this.mView = mView;
        this.retrofit = retrofit;
    }

    @Override
    public void getListBanks(String idPayment) {
        retrofit.create(PaymentAppApi.class).getBanks(Constants.PUBLIC_KEY, idPayment).enqueue(new Callback<List<Bank>>() {
            @Override
            public void onResponse(@NonNull Call<List<Bank>> call, @NonNull Response<List<Bank>> response) {
                if (response.code() == 200) {
                    mView.showListBanks(response.body());
                } else {
                    mView.showError(response.message());
                }
            }
            @Override
            public void onFailure(@NonNull Call<List<Bank>> call, @NonNull Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());

            }
        });
    }
}
