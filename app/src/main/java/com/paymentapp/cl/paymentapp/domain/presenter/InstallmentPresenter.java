package com.paymentapp.cl.paymentapp.domain.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.paymentapp.cl.paymentapp.data.rest.PaymentAppApi;
import com.paymentapp.cl.paymentapp.data.view.InstallmentContract;
import com.paymentapp.cl.paymentapp.domain.model.Installment;
import com.paymentapp.cl.paymentapp.utils.Constants;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class InstallmentPresenter implements InstallmentContract.Presenter {
    private static final String TAG = InstallmentPresenter.class.getSimpleName();
    private InstallmentContract.View mView;
    private Retrofit retrofit;


    @Inject
    public InstallmentPresenter(Retrofit retrofit, InstallmentContract.View mView) {
        this.mView = mView;
        this.retrofit = retrofit;
    }

    @Override
    public void getListInstallment(String amount, String payment_method_id, String issuer_id) {

        retrofit.create(PaymentAppApi.class).getInstallments(Constants.PUBLIC_KEY, amount, payment_method_id, issuer_id ).enqueue(new Callback<List<Installment>>() {
            @Override
            public void onResponse(@NonNull Call<List<Installment>> call, @NonNull Response<List<Installment>> response) {

                if(response.code()==200){
                    mView.showListInstallment(response.body());
                }
                else{
                    mView.showError(response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Installment>> call, @NonNull Throwable t) {
                Log.e(TAG, "onFailure: "+ t.getMessage());
                mView.showError(t.getMessage());

            }
        });
    }
}
