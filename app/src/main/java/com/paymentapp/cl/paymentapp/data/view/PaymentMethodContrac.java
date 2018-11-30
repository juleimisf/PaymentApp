package com.paymentapp.cl.paymentapp.data.view;

import android.content.Context;

import com.paymentapp.cl.paymentapp.domain.model.PaymentMethod;

import java.util.List;

public interface PaymentMethodContrac {
    interface View {
        void showError(String message);
        void showListPaymentMethod(List<PaymentMethod> body);
        Context getContext();
        void showProgress();
        void hideProgress();
    }

    interface Presenter {
        void getListPaymentMethods();
    }
}

