package com.paymentapp.cl.paymentapp.presentation.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.paymentapp.cl.paymentapp.PaymentApp;
import com.paymentapp.cl.paymentapp.R;
import com.paymentapp.cl.paymentapp.data.injector.component.DaggerBankComponent;
import com.paymentapp.cl.paymentapp.data.injector.module.BankModule;
import com.paymentapp.cl.paymentapp.domain.model.Bank;
import com.paymentapp.cl.paymentapp.data.view.BankContract;
import com.paymentapp.cl.paymentapp.domain.presenter.BankPresenter;
import com.paymentapp.cl.paymentapp.presentation.adapter.BankAdapter;
import com.paymentapp.cl.paymentapp.presentation.listener.OnFragmentInteractionListener;
import com.paymentapp.cl.paymentapp.presentation.listener.TypePaymentListener;
import com.paymentapp.cl.paymentapp.utils.Utils;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BankFragment extends BaseFragment implements BankContract.View {

    @BindView(R.id.tv_no_data)
    TextView tv_no_data;
    @BindView(R.id.iv_no_data)
    ImageView iv_no_data;
    @BindView(R.id.app_bar_layout)
    AppBarLayout app_bar_layout;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsing_toolbar;
    @BindView(R.id.rv_type_bank)
    RecyclerView rv_type_bank;
    @BindView(R.id.swipe_container)
    SwipeRefreshLayout swipe_container;
    private OnFragmentInteractionListener mListener;
    String id;

    @Inject
    BankPresenter bankPresenter;

    public BankFragment() {
        // Required empty public constructor
    }


    public static BankFragment newInstance(String id) {
        BankFragment fragment = new BankFragment();
        Bundle args = new Bundle();
        args.putString("id", id);
        fragment.setArguments(args);
        return fragment;
    }


    public void initComponet(){

        DaggerBankComponent.builder()
                .networkComponent(((PaymentApp) getActivity().getApplication()).getNetComponent())
                .bankModule(new BankModule(this))
                .build().inject(this);

    }

    @Override
    public int getFragmentLayout() {
        return R.layout.fragment_type_bank;
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
        id = getArguments().getString("id");
        rv_type_bank.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        rv_type_bank.setLayoutManager(layoutManager);

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
                    collapsing_toolbar.setTitle(getResources().getString(R.string.tv_bank));
                    isShow = true;

                } else if(isShow) {
                    collapsing_toolbar.setTitle(" ");//carefull there should a space between double quote otherwise it wont work
                    isShow = false;
                }
            }
        });

        bankPresenter.getListBanks(id);
        //Your toolbar is now an action bar and you can use it like you always do, for example:
        collapsing_toolbar.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
    }

    //Call our calendar
    TypePaymentListener teamListener = new TypePaymentListener() {
        @Override
        public void selectTypePayment(String id) {
            mListener.onFragmentInteraction(id, 2);
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
    public void showListBanks(List<Bank> body) {
        if(body.size()>0){
            BankAdapter bankAdapter = new BankAdapter(getContext(), body, teamListener);
            rv_type_bank.setAdapter(bankAdapter);
        }
        else{
            iv_no_data.setVisibility(View.VISIBLE);
            tv_no_data.setVisibility(View.VISIBLE);
            swipe_container.setVisibility(View.GONE);
        }
        dismissDialog();
    }
}
