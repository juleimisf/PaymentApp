package com.paymentapp.cl.paymentapp.data.injector.module;

import com.paymentapp.cl.paymentapp.data.injector.scope.CustomScope;
import com.paymentapp.cl.paymentapp.data.view.PaymentMethodContrac;

import dagger.Module;
import dagger.Provides;

@Module
public class PaymentMethodModule {

    private final PaymentMethodContrac.View mView;
    public PaymentMethodModule(PaymentMethodContrac.View mView) {
        this.mView = mView;
    }

    @Provides
    @CustomScope
    PaymentMethodContrac.View providesMainScreenContractView() {
        return mView;
    }

}
