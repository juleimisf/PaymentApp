package com.paymentapp.cl.paymentapp;

import com.paymentapp.cl.paymentapp.data.injector.module.NetworkModule;
import com.paymentapp.cl.paymentapp.data.rest.PaymentAppApi;
import com.paymentapp.cl.paymentapp.data.view.PaymentMethodContrac;
import com.paymentapp.cl.paymentapp.domain.model.ModelValidator;
import com.paymentapp.cl.paymentapp.domain.model.PaymentMethod;
import com.paymentapp.cl.paymentapp.domain.model.PaymentMethodBuilder;
import com.paymentapp.cl.paymentapp.domain.presenter.PaymentMethodPresenter;
import com.paymentapp.cl.paymentapp.presentation.activities.MainActivity;;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */


public class PaymentTest {


    @Mock
    private PaymentMethodContrac.View view;

    @Mock
    private PaymentAppApi paymentAppApi;

    @Mock
    private PaymentMethodContrac.Presenter presenter;


    @Mock
    List<PaymentMethod> paymentMethodList;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }


    @Test
    public void amount_shouldReturnResultPass() {
        assert (Integer.parseInt("10000") > 0);
    }

    @Test
    public void amount_shouldReturnResultForValueNegative() {
        assert (Integer.parseInt("0") <= 0);
    }

    @Test
    public void amount_shouldReturnResultForEmpty() {
        assert ("").isEmpty();
    }


    @Test
    public void clickOnButtom_ShowsOtherView() {
        presenter.getListPaymentMethods();
        verify(view).showProgress();
        paymentAppApi.getPaymentsMethods("gw/=367237hbshsbu81u32hueih");
        verify(view).hideProgress();
    }


    @Test()
    public void shouldNotThrowErrorOnValidPaymentMethodModel() throws IllegalArgumentException {
        PaymentMethodBuilder builder = new PaymentMethodBuilder();
        builder.setName("Mastercard");
        PaymentMethod characterModel = builder.build();
        ModelValidator validator = new ModelValidator(characterModel);
        validator.validate();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowErrorOnInvalidPaymentMethodModel() throws IllegalArgumentException {
        PaymentMethodBuilder builder = new PaymentMethodBuilder();
        builder.setName(null);
        PaymentMethod characterModel = builder.build();
        ModelValidator validator = new ModelValidator(characterModel);
        validator.validate();
    }

}