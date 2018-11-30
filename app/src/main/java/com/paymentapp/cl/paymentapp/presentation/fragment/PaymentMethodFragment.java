package com.paymentapp.cl.paymentapp.presentation.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.paymentapp.cl.paymentapp.PaymentApp;
import com.paymentapp.cl.paymentapp.R;
import com.paymentapp.cl.paymentapp.data.injector.component.DaggerPaymetMethodComponent;
import com.paymentapp.cl.paymentapp.data.injector.module.PaymentMethodModule;
import com.paymentapp.cl.paymentapp.domain.model.PaymentMethod;
import com.paymentapp.cl.paymentapp.data.view.PaymentMethodContrac;
import com.paymentapp.cl.paymentapp.domain.presenter.PaymentMethodPresenter;
import com.paymentapp.cl.paymentapp.presentation.listener.OnFragmentInteractionListener;
import com.paymentapp.cl.paymentapp.presentation.listener.TypePaymentListener;
import com.paymentapp.cl.paymentapp.presentation.adapter.TypePaymentAdapter;
import com.paymentapp.cl.paymentapp.utils.Utils;

import java.security.SecureRandom;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class PaymentMethodFragment extends BaseFragment implements PaymentMethodContrac.View {


    @BindView(R.id.app_bar_layout)
    AppBarLayout app_bar_layout;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsing_toolbar;
    @BindView(R.id.rv_type_payment)
    RecyclerView rv_type_payment;
    @BindView(R.id.swipe_container)
    SwipeRefreshLayout swipe_container;
    private OnFragmentInteractionListener mListener;
    @Inject
    PaymentMethodPresenter paymentMethodPresenter;


    public PaymentMethodFragment() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    public static PaymentMethodFragment newInstance(String id) {
        PaymentMethodFragment fragment = new PaymentMethodFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getFragmentLayout() {
        return R.layout.fragment_type_payment;
    }


    @Override
    public void onViewReady(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState, View view) {

        // toolbar
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (((AppCompatActivity)getActivity()).getSupportActionBar() != null) {
            ((AppCompatActivity)getActivity()). getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getFragmentManager() != null) {
                    getFragmentManager().popBackStack();
                }

            }
        });

        initComponet();
        initViews();

    }

    public void initComponet(){

        DaggerPaymetMethodComponent.builder()
                .networkComponent(((PaymentApp) getActivity().getApplication()).getNetComponent())
                .paymentMethodModule(new PaymentMethodModule(this))
                .build().inject(this);
    }

    private void initViews() {

        showProgressDialog(getContext());
        rv_type_payment.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        rv_type_payment.setLayoutManager(layoutManager);

        app_bar_layout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = true;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsing_toolbar.setCollapsedTitleTextColor(getResources().getColor(R.color.icons));
                    collapsing_toolbar.setTitle(getResources().getString(R.string.tv_type));
                    isShow = true;

                } else if (isShow) {
                    collapsing_toolbar.setTitle(" ");//carefull there should a space between double quote otherwise it wont work
                    isShow = false;
                }
            }
        });

        //Your toolbar is now an action bar and you can use it like you always do, for example:
        collapsing_toolbar.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));

        paymentMethodPresenter.getListPaymentMethods();
    }

    //Call our calendar
    TypePaymentListener teamListener = new TypePaymentListener() {
        @Override
        public void selectTypePayment(String id) {
            mListener.onFragmentInteraction(id, 1);

        }

        @Override
        public void showError(String message) {
            Utils.showSnackBar(getContext(), message,app_bar_layout );
        }
    };


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

    @Override
    public void showError(String message) {

    }

    @Override
    public void showListPaymentMethod(List<PaymentMethod> body) {
        dismissDialog();
        TypePaymentAdapter typePaymentAdapter = new TypePaymentAdapter(getContext(), body, teamListener);
        rv_type_payment.setAdapter(typePaymentAdapter);
    }

    @Override
    public void showProgress() {
        showProgress();

    }

    @Override
    public void hideProgress() {
        hideProgress();

    }
}
