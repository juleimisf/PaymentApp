package com.paymentapp.cl.paymentapp;


import android.app.Application;

import com.paymentapp.cl.paymentapp.data.injector.module.AppModule;
import com.paymentapp.cl.paymentapp.data.injector.component.DaggerNetworkComponent;
import com.paymentapp.cl.paymentapp.data.injector.component.NetworkComponent;
import com.paymentapp.cl.paymentapp.data.injector.module.NetworkModule;

public class PaymentApp extends Application {

    private NetworkComponent mNetComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        //Dagger
        mNetComponent = DaggerNetworkComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .build();
    }

    public NetworkComponent getNetComponent() {
        return mNetComponent;
    }

}