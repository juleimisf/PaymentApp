package com.paymentapp.cl.paymentapp.domain.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.paymentapp.cl.paymentapp.data.rest.PaymentAppApi;
import com.paymentapp.cl.paymentapp.data.view.PaymentMethodContrac;
import com.paymentapp.cl.paymentapp.domain.model.PaymentMethod;
import com.paymentapp.cl.paymentapp.utils.Constants;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PaymentMethodPresenter implements PaymentMethodContrac.Presenter {
    private static final String TAG = PaymentMethodPresenter.class.getSimpleName();
    private PaymentMethodContrac.View mView;
    private Retrofit retrofit;



    @Inject
    public PaymentMethodPresenter(Retrofit retrofit, PaymentMethodContrac.View mView) {
        this.mView = mView;
        this.retrofit = retrofit;

    }


    @Override
    public void getListPaymentMethods() {

        retrofit.create(PaymentAppApi.class).getPaymentsMethods(Constants.PUBLIC_KEY).enqueue(new Callback<List<PaymentMethod>>() {
            @Override
            public void onResponse(@NonNull Call<List<PaymentMethod>> call, @NonNull Response<List<PaymentMethod>> response) {
                if(response.code()==200){
                    mView.showListPaymentMethod(response.body());
                }
                else {
                    mView.showError(response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<PaymentMethod>> call, @NonNull Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage() );
                mView.showError(t.getMessage());
            }
        });

    }
}
