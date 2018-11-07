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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.paymentapp.cl.paymentapp.PaymentApp;
import com.paymentapp.cl.paymentapp.R;
import com.paymentapp.cl.paymentapp.data.injector.component.DaggerInstallmentComponent;
import com.paymentapp.cl.paymentapp.data.injector.module.InstallmentModule;
import com.paymentapp.cl.paymentapp.domain.model.InfPayment;
import com.paymentapp.cl.paymentapp.domain.model.Installment;
import com.paymentapp.cl.paymentapp.data.view.InstallmentContract;
import com.paymentapp.cl.paymentapp.domain.presenter.InstallmentPresenter;
import com.paymentapp.cl.paymentapp.presentation.adapter.InstanllmentAdapter;
import com.paymentapp.cl.paymentapp.presentation.listener.OnFragmentInteractionListener;
import com.paymentapp.cl.paymentapp.presentation.listener.TypePaymentListener;
import com.paymentapp.cl.paymentapp.utils.Utils;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class InstallmentFragment extends BaseFragment implements InstallmentContract.View {
    public static final String TAG = InstallmentFragment.class.getSimpleName();

    @BindView(R.id.app_bar_layout)
    AppBarLayout app_bar_layout;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsing_toolbar;
    @BindView(R.id.rv_type_installment)
    RecyclerView rv_type_installment;
    @BindView(R.id.swipe_container)
    SwipeRefreshLayout swipe_container;
    @BindView(R.id.iv_profile)
    ImageView iv_profile;
    private OnFragmentInteractionListener mListener;
    private InfPayment infPayment;

    @Inject
    InstallmentPresenter installmentPresenter;


    public InstallmentFragment() {
        // Required empty public constructor
    }


    public void initComponet(){

        DaggerInstallmentComponent.builder()
                .networkComponent(((PaymentApp) getActivity().getApplication()).getNetComponent())
                .installmentModule(new InstallmentModule(this))
                .build().inject(this);

    }


    @Override
    public int getFragmentLayout() {
        return R.layout.fragment_installment;
    }

    @Override
    public void onViewReady(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState, View view) {

        initComponet();
        initViews();

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
    }

    private void initViews() {
        showProgressDialog(getContext());
        infPayment = InfPayment.getInstance();
        rv_type_installment.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        rv_type_installment.setLayoutManager(layoutManager);

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
                    collapsing_toolbar.setTitle(getResources().getString(R.string.tv_installment));
                    isShow = true;

                } else if(isShow) {
                    collapsing_toolbar.setTitle(" ");//carefull there should a space between double quote otherwise it wont work
                    isShow = false;
                }
            }
        });

        installmentPresenter.getListInstallment(infPayment.getAmount(), infPayment.payment_method_id, infPayment.getIssuer_id());
        //Your toolbar is now an action bar and you can use it like you always do, for example:
        collapsing_toolbar.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
    }


    TypePaymentListener teamListener = new TypePaymentListener() {
        @Override
        public void selectTypePayment(String id) {
            mListener.onFragmentInteraction(id, 3);
        }

        @Override
        public void showError(String message) {
            Utils.showSnackBar(getContext(), message,app_bar_layout );

        }
    };

    @Override
    public void showError(String message) {
        Utils.showSnackBar(getContext(), message, collapsing_toolbar);
    }

    @Override
    public void showListInstallment(List<Installment> body) {

        Glide.with(this)
                .load(infPayment.getImagen_method())
                .apply(new RequestOptions()
                        .placeholder(R.mipmap.ic_launcher_round))
                .into(iv_profile);

        if(body.size()>0){
            InstanllmentAdapter instanllmentAdapter = new InstanllmentAdapter(getContext(), body.get(0).getPayerCosts(), teamListener);
            rv_type_installment.setAdapter(instanllmentAdapter);
        }

        dismissDialog();

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
