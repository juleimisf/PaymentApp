package com.paymentapp.cl.paymentapp.data.injector.module;

import com.paymentapp.cl.paymentapp.data.injector.scope.CustomScope;
import com.paymentapp.cl.paymentapp.data.view.InstallmentContract;

import dagger.Module;
import dagger.Provides;

@Module
public class InstallmentModule {

    private final InstallmentContract.View mView;


    public InstallmentModule(InstallmentContract.View mView) {
        this.mView = mView;
    }

    @Provides
    @CustomScope
    InstallmentContract.View providesMainScreenContractView() {
        return mView;
    }

}
