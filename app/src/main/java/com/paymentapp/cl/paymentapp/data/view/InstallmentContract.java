package com.paymentapp.cl.paymentapp.data.view;

import android.content.Context;

import com.paymentapp.cl.paymentapp.domain.model.Installment;

import java.util.List;

public interface InstallmentContract {
    interface View {
        void showError(String message);
        void showListInstallment(List<Installment> body);
        Context getContext();
    }

    interface Presenter {
        void getListInstallment(String amount, String payment_method_id, String issuer_id);
    }
}

