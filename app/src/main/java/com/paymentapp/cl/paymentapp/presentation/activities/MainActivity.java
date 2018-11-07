package com.paymentapp.cl.paymentapp.presentation.activities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.paymentapp.cl.paymentapp.PaymentApp;
import com.paymentapp.cl.paymentapp.R;
import com.paymentapp.cl.paymentapp.data.injector.component.DaggerCreatedPaymentComponent;
import com.paymentapp.cl.paymentapp.data.injector.module.CreatedPaymentModule;
import com.paymentapp.cl.paymentapp.domain.model.CardRequest;
import com.paymentapp.cl.paymentapp.data.view.CreatedPaymentContract;
import com.paymentapp.cl.paymentapp.domain.presenter.CreatedPaymentPresenter;
import com.paymentapp.cl.paymentapp.presentation.DialogFragment.SuccessDialogoFragment;
import com.paymentapp.cl.paymentapp.presentation.fragment.AmountFragment;
import com.paymentapp.cl.paymentapp.presentation.fragment.InstallmentFragment;
import com.paymentapp.cl.paymentapp.presentation.fragment.PaymentMethodFragment;
import com.paymentapp.cl.paymentapp.presentation.fragment.BankFragment;
import com.paymentapp.cl.paymentapp.presentation.listener.OnFragmentInteractionListener;
import com.paymentapp.cl.paymentapp.presentation.listener.SuccessPayment;
import com.paymentapp.cl.paymentapp.utils.Constants;
import com.paymentapp.cl.paymentapp.utils.Utils;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener, OnFragmentInteractionListener, CreatedPaymentContract.View, SuccessPayment {
    @BindView(R.id.nav_view)
    NavigationView nav_view;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer_layout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Inject
    CreatedPaymentPresenter createdPaymentPresenter;

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onCreateView(Bundle savedInstanceState) {
        initComponet();
        initView();
    }


    public void initComponet() {

        DaggerCreatedPaymentComponent.builder()
                .networkComponent(((PaymentApp) getApplication()).getNetComponent())
                .createdPaymentModule(new CreatedPaymentModule(this))
                .build().inject(this);

    }

    public void initView() {
        setSupportActionBar(toolbar);
        toolbar.setVisibility(View.VISIBLE);
        drawer_layout.setDrawerElevation(0);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer_layout.addDrawerListener(toggle);
        toggle.syncState();
        nav_view.setNavigationItemSelectedListener(this);
        nav_view.setItemIconTintList(null);

        //Calls fragment default
        callDefaultFrag();
    }

    public void callDefaultFrag() {

        Fragment fragment = new AmountFragment();
        FragmentTransaction fragTansaction = getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.contenedorPrincipalFragmento, fragment);
        fragTansaction.commit();

    }

    @Override
    public void onFragmentInteraction(String id, int type) {
        switch (type) {
            case 0:
                Fragment paymentFragment = new PaymentMethodFragment();
                pushFragment(paymentFragment, "PaymentFragment");
                Utils.hideKeyboard(this);
                break;

            case 1:
                Fragment typeBankFragment = BankFragment.newInstance(id);
                pushFragment(typeBankFragment, "BankFragment");
                Utils.hideKeyboard(this);
                break;

            case 2:
                Fragment installment = new InstallmentFragment();
                pushFragment(installment, "InstallmentFragment");
                Utils.hideKeyboard(this);
                break;

            case 3:
                CardRequest request = new CardRequest(Constants.PUBLIC_KEY);
                createdPaymentPresenter.createdPayment(request);
                break;
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public void showError(String message) {
        Utils.showSnackBar(this, message, toolbar);
    }

    @Override
    public void successPayment() {

        SuccessDialogoFragment newFragment = new SuccessDialogoFragment();
        newFragment.show(getSupportFragmentManager(), "dialog");

    }

    @Override
    public Context getContext() {
        return this.getApplicationContext();
    }

    @Override
    public void success() {
        callDefaultFrag();
    }
}
