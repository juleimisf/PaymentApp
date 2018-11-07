package com.paymentapp.cl.paymentapp.data.view;

import android.content.Context;

import com.paymentapp.cl.paymentapp.domain.model.Bank;
import java.util.List;

public interface BankContract {
    interface View {
        void showError(String message);
        void showListBanks(List<Bank> body);
        Context getContext();
    }

    interface Presenter {
        void getListBanks(String idPayment);
    }
}

