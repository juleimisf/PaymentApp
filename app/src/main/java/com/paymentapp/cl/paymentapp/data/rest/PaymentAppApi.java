package com.paymentapp.cl.paymentapp.data.rest;

import com.paymentapp.cl.paymentapp.domain.model.Bank;
import com.paymentapp.cl.paymentapp.domain.model.Card;
import com.paymentapp.cl.paymentapp.domain.model.Installment;
import com.paymentapp.cl.paymentapp.domain.model.Payment;
import com.paymentapp.cl.paymentapp.domain.model.PaymentMethod;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface PaymentAppApi {

    @GET("payment_methods")
    Call<List<PaymentMethod>> getPaymentsMethods(@Query("public_key") String public_key);

    @GET("payment_methods/card_issuers")
    Call<List<Bank>> getBanks(@Query("public_key") String public_key,
                              @Query("payment_method_id") String payment_method_id);

    @GET("payment_methods/installments")
    Call<List<Installment>>getInstallments(@Query("public_key") String public_key,
                                            @Query("amount") String amount,
                                            @Query("payment_method_id") String payment_method_id,
                                            @Query("issuer.id") String issuer);

    @POST("payments")
    @FormUrlEncoded
    Call<Payment> setRegisterPayment(@Field("transaction_amount") float transaction_amount,
                                  @Field("token") String token,
                                  @Field("installments") String installments,
                                  @Field("payment_method_id") String payment_method_id,
                                  @Field("issuer_id") String issuer_id);

    /**
     * GET CARD TOKEN FOR REGISTER PAYMENT IN API MERCADOPAGO
     * @param public_key
     * @return public_key
     */
    @POST("card_tokens")
    @FormUrlEncoded
    Call<Card>getCardToken(@Field("public_key") String public_key );

}
