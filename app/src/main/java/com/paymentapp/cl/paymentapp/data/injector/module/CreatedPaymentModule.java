package com.paymentapp.cl.paymentapp.data.injector.module;

import com.paymentapp.cl.paymentapp.data.injector.scope.CustomScope;
import com.paymentapp.cl.paymentapp.data.view.CreatedPaymentContract;

import dagger.Module;
import dagger.Provides;

@Module
public class CreatedPaymentModule {

    private final CreatedPaymentContract.View mView;


    public CreatedPaymentModule(CreatedPaymentContract.View mView) {
        this.mView = mView;
    }

    @Provides
    @CustomScope
    CreatedPaymentContract.View providesMainScreenContractView() {
        return mView;
    }

}
