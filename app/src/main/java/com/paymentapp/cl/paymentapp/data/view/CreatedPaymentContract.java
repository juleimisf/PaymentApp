package com.paymentapp.cl.paymentapp.data.view;

import android.content.Context;

import com.paymentapp.cl.paymentapp.domain.model.CardRequest;

public interface CreatedPaymentContract {
    interface View {
        void showError(String message);
        void successPayment();
        Context getContext();
    }

    interface Presenter {
        void createdPayment(CardRequest request);
    }
}

