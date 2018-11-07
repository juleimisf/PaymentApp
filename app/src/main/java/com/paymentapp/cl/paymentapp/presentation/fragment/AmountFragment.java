package com.paymentapp.cl.paymentapp.presentation.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.paymentapp.cl.paymentapp.R;
import com.paymentapp.cl.paymentapp.domain.model.InfPayment;
import com.paymentapp.cl.paymentapp.presentation.listener.OnFragmentInteractionListener;

import butterknife.BindView;
import butterknife.OnClick;


public class AmountFragment extends BaseFragment {
    @BindView(R.id.input_amount)
    TextInputEditText input_amount;
    InfPayment infPayment;

    private OnFragmentInteractionListener mListener;

    public AmountFragment() {
        // Required empty public constructor
    }


    @Override
    public int getFragmentLayout() {
        return R.layout.fragment_amount;
    }

    @Override
    public void onViewReady(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState, View view) {


        infPayment = InfPayment.getInstance();
        input_amount.setText("$");
        Selection.setSelection(input_amount.getText(), input_amount.getText().length());
        input_amount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if (!s.toString().startsWith("$")) {
                    input_amount.setText("$");
                    Selection.setSelection(input_amount.getText(), input_amount
                            .getText().length());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @OnClick({R.id.btn_accept})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_accept:
                isValidate();
                break;
        }
    }

    public void isValidate() {
        if (input_amount.getText().length() < 2 || Integer.parseInt(input_amount.getText().toString().replace("$","")) <= 0) {
            input_amount.setError(getResources().getText(R.string.alert_error_amount));
        } else {
            if (mListener != null) {
                String amount = input_amount.getText().toString().replace("$","");
                infPayment.setAmount(amount);
                mListener.onFragmentInteraction(String.valueOf(amount), 0);
            }
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
