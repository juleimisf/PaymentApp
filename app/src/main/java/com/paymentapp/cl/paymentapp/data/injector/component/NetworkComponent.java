package com.paymentapp.cl.paymentapp.data.injector.component;

import com.paymentapp.cl.paymentapp.data.injector.module.AppModule;
import com.paymentapp.cl.paymentapp.data.injector.module.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface NetworkComponent {
    Retrofit retrofit();
}