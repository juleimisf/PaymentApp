package com.paymentapp.cl.paymentapp.data.injector.component;

import com.paymentapp.cl.paymentapp.data.injector.module.BankModule;
import com.paymentapp.cl.paymentapp.data.injector.scope.CustomScope;
import com.paymentapp.cl.paymentapp.presentation.fragment.BankFragment;

import dagger.Component;

@CustomScope
@Component(dependencies = NetworkComponent.class, modules = BankModule.class)
public interface BankComponent {
    void inject(BankFragment fragment);
}

