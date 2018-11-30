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
import rx.Observer;
import rx.Scheduler;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class PaymentMethodPresenter implements PaymentMethodContrac.Presenter {
    private static final String TAG = PaymentMethodPresenter.class.getSimpleName();
    private PaymentMethodContrac.View mView;
    private Retrofit retrofit;

    @NonNull
    private Scheduler backgroundScheduler;

    @NonNull
    private Scheduler mainScheduler;

    @NonNull
    private CompositeSubscription subscriptions;

    @Inject
    public PaymentMethodPresenter(Retrofit retrofit, PaymentMethodContrac.View mView) {
        this.mView = mView;
        this.retrofit = retrofit;
        subscriptions = new CompositeSubscription();
    }


    @Override
    public void getListPaymentMethods() {
//        subscriptions.clear();
//
//        Subscription subscription = retrofit.create(PaymentAppApi.class).getPaymentsMethods(Constants.PUBLIC_KEY)
//                .subscribeOn(backgroundScheduler)
//                .observeOn(mainScheduler)
//                .subscribe(new Observer<PaymentMethod>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e("TAG",e.getMessage());
//
//                    }
//
//                    @Override
//                    public void onNext(PaymentMethod paymentMethods) {
////                        mView.showListPaymentMethod(paymentMethods);
//
//
//                    }
//                });
//        subscriptions.add(subscription);
        mView.showProgress();
//
//        retrofit.create(PaymentAppApi.class).getPaymentsMethods(Constants.PUBLIC_KEY).enqueue(new Callback<List<PaymentMethod>>() {
//            @Override
//            public void onResponse(@NonNull Call<List<PaymentMethod>> call, @NonNull Response<List<PaymentMethod>> response) {
//                if(response.code()==200){
//                    mView.showListPaymentMethod(response.body());
//                }
//                else {
//                    mView.showError(response.message());
//                }
//                mView.hideProgress();
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<List<PaymentMethod>> call, @NonNull Throwable t) {
//                Log.e(TAG, "onFailure: " + t.getMessage() );
//                mView.showError(t.getMessage());
//                mView.hideProgress();
//
//            }
//        });

    }
}
