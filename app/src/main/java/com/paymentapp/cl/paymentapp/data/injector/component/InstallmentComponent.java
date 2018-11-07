package com.paymentapp.cl.paymentapp.data.injector.component;

import com.paymentapp.cl.paymentapp.data.injector.module.InstallmentModule;
import com.paymentapp.cl.paymentapp.data.injector.scope.CustomScope;
import com.paymentapp.cl.paymentapp.presentation.fragment.InstallmentFragment;

import dagger.Component;

@CustomScope
@Component(dependencies = NetworkComponent.class, modules = InstallmentModule.class)
public interface InstallmentComponent {
    void inject(InstallmentFragment fragment);
}

