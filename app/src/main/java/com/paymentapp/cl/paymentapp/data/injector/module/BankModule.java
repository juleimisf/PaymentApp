package com.paymentapp.cl.paymentapp.data.injector.module;

import com.paymentapp.cl.paymentapp.data.injector.scope.CustomScope;
import com.paymentapp.cl.paymentapp.data.view.BankContract;

import dagger.Module;
import dagger.Provides;

@Module
public class BankModule {

    private final BankContract.View mView;


    public BankModule(BankContract.View mView) {
        this.mView = mView;
    }

    @Provides
    @CustomScope
    BankContract.View providesMainScreenContractView() {
        return mView;
    }

}
