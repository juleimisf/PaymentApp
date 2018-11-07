package com.paymentapp.cl.paymentapp.presentation.dialogFragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.paymentapp.cl.paymentapp.R;
import com.paymentapp.cl.paymentapp.domain.model.InfPayment;
import com.paymentapp.cl.paymentapp.presentation.listener.SuccessPayment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SuccessDialogoFragment extends DialogFragment {
    InfPayment infPayment;
    @BindView(R.id.tv_total)
    TextView tv_total;
    @BindView(R.id.tv_installment)
    TextView tv_installment;
    @BindView(R.id.iv_method)
    ImageView iv_method;
    @BindView(R.id.iv_bank)
    ImageView iv_bank;
    SuccessPayment listener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Dialog dialogo = super.onCreateDialog(savedInstanceState);
        dialogo.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialogo.setContentView(R.layout.dialog_success);
        dialogo.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ButterKnife.bind(this, dialogo);
        dialogo.setCancelable(false);
        infPayment = InfPayment.getInstance();

        tv_total.setText(" Monto total: $" + infPayment.getAmount());
        tv_installment.setText("$" + infPayment.getInstallment());

        Glide.with(this)
                .load(infPayment.getImagen_method())
                .apply(new RequestOptions()
                        .placeholder(R.mipmap.ic_launcher_round))
                .into(iv_method);

        Glide.with(this)
                .load(infPayment.getImagen_bank())
                .apply(new RequestOptions()
                        .placeholder(R.mipmap.ic_launcher_round))
                .into(iv_bank);


        return dialogo;
    }

    @OnClick({R.id.btn_accept})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_accept:
                listener.success();
                dismiss();
                break;
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (SuccessPayment) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(
                    context.toString() +
                            " no implementó OkDialogListener");
        }
    }
}
