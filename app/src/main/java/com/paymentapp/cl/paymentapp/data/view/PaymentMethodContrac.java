package com.paymentapp.cl.paymentapp.data.view;

import android.content.Context;

import com.paymentapp.cl.paymentapp.domain.model.PaymentMethod;

import java.util.List;

public interface PaymentMethodContrac {
    interface View {
        void showError(String message);
        void showListPaymentMethod(List<PaymentMethod> body);
        Context getContext();
    }

    interface Presenter {
        void getListPaymentMethods();
    }
}

