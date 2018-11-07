package com.paymentapp.cl.paymentapp;

import com.paymentapp.cl.paymentapp.data.injector.module.NetworkModule;
import com.paymentapp.cl.paymentapp.data.view.PaymentMethodContrac;
import com.paymentapp.cl.paymentapp.domain.presenter.PaymentMethodPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */




public class PaymentTest {

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    private NetworkModule networkModule;

    @Mock
    private PaymentMethodContrac.View view;


    @Test
    public void fetchValidDataShouldLoadIntoView() {
    }

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
}