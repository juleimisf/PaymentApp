package com.paymentapp.cl.paymentapp.data.injector.component;

import com.paymentapp.cl.paymentapp.data.injector.module.CreatedPaymentModule;
import com.paymentapp.cl.paymentapp.data.injector.scope.CustomScope;
import com.paymentapp.cl.paymentapp.presentation.activities.MainActivity;

import dagger.Component;

@CustomScope
@Component(dependencies = NetworkComponent.class, modules = CreatedPaymentModule.class)
public interface CreatedPaymentComponent {
    void inject(MainActivity activity);
}

