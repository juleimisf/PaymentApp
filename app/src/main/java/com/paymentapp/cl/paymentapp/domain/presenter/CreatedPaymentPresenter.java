package com.paymentapp.cl.paymentapp.domain.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.paymentapp.cl.paymentapp.data.rest.PaymentAppApi;
import com.paymentapp.cl.paymentapp.data.view.CreatedPaymentContract;
import com.paymentapp.cl.paymentapp.domain.model.Card;
import com.paymentapp.cl.paymentapp.domain.model.CardRequest;
import com.paymentapp.cl.paymentapp.domain.model.InfPayment;
import com.paymentapp.cl.paymentapp.domain.model.Payment;
import com.paymentapp.cl.paymentapp.utils.Constants;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CreatedPaymentPresenter implements CreatedPaymentContract.Presenter {
    private static final String TAG = CreatedPaymentPresenter.class.getSimpleName();
    private CreatedPaymentContract.View mView;
    private Retrofit retrofit;
    private InfPayment infPayment;

    @Inject
    public CreatedPaymentPresenter(Retrofit retrofit, CreatedPaymentContract.View mView) {
        this.mView = mView;
        this.retrofit = retrofit;
        infPayment = InfPayment.getInstance();
    }

    /**
     * generate CardToken for payment
     * @param dataRequest
     */
    @Override
    public void createdPayment(CardRequest dataRequest) {
        retrofit.create(PaymentAppApi.class).getCardToken(Constants.PUBLIC_KEY).enqueue(new Callback<Card>() {
            @Override
            public void onResponse(@NonNull Call<Card> call, @NonNull Response<Card> response) {
                assert response.body() != null;
                generatedPayment(response.body().getId());
            }

            @Override
            public void onFailure(@NonNull Call<Card> call, @NonNull Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
                mView.showError(t.getMessage());
            }
        });
    }

    private void generatedPayment(String token) {
        retrofit.create(PaymentAppApi.class).setRegisterPayment(
                Float.valueOf(infPayment.getAmount()),
                token,
                infPayment.getIssuer_id(),
                infPayment.getPayment_method_id(),
                infPayment.getIssuer_id()).enqueue(new Callback<Payment>() {
            @Override
            public void onResponse(@NonNull Call<Payment> call, @NonNull Response<Payment> response) {
                Log.i(TAG, "onResponse: " + response.code() + response.message());
                mView.successPayment();
            }

            @Override
            public void onFailure(@NonNull Call<Payment> call, @NonNull Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
                mView.showError(t.getMessage());
            }
        });

    }
}
