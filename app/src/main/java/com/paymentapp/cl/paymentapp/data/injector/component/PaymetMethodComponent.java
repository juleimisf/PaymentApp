package com.paymentapp.cl.paymentapp.data.injector.component;

import com.paymentapp.cl.paymentapp.data.injector.module.PaymentMethodModule;
import com.paymentapp.cl.paymentapp.data.injector.scope.CustomScope;
import com.paymentapp.cl.paymentapp.presentation.fragment.PaymentMethodFragment;

import dagger.Component;
    @CustomScope
    @Component(dependencies = NetworkComponent.class, modules = PaymentMethodModule.class)
    public interface PaymetMethodComponent {
        void inject(PaymentMethodFragment fragment);
    }

