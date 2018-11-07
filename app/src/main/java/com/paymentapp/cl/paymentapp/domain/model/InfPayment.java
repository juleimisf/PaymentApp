package com.paymentapp.cl.paymentapp.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InfPayment {

    @SerializedName("amount")
    @Expose
    public String amount;
    @SerializedName("payment_method_id")
    @Expose
    public String payment_method_id;
    @SerializedName("payment_type_id")
    @Expose
    public String payment_type_id;
    @SerializedName("bank")
    @Expose
    public String bank;
    @SerializedName("installment")
    @Expose
    public String installment;
    @SerializedName("issuer_id")
    @Expose
    public String issuer_id;
    @SerializedName("imagen_method")
    @Expose
    public String imagen_method;
    @SerializedName("imagen_bank")
    @Expose
    public String imagen_bank;

    private static InfPayment mInstance = null;

    private InfPayment() {
    }

    public static InfPayment getInstance(){
        if(mInstance == null)
        {
            mInstance = new InfPayment();
        }
        return mInstance;
    }

    public InfPayment(String amount, String payment_method_id, String payment_type_id, String bank, String installment, String issuer_id, String imagen_method, String imagen_bank) {
        this.amount = amount;
        this.payment_method_id = payment_method_id;
        this.payment_type_id = payment_type_id;
        this.bank = bank;
        this.installment = installment;
        this.issuer_id = issuer_id;
        this.imagen_method = imagen_method;
        this.imagen_bank = imagen_bank;
    }

    public String getImagen_bank() {
        return imagen_bank;
    }

    public void setImagen_bank(String imagen_bank) {
        this.imagen_bank = imagen_bank;
    }

    public String getImagen_method() {
        return imagen_method;
    }

    public void setImagen_method(String imagen_method) {
        this.imagen_method = imagen_method;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPayment_method_id() {
        return payment_method_id;
    }

    public void setPayment_method_id(String payment_method_id) {
        this.payment_method_id = payment_method_id;
    }

    public String getPayment_type_id() {
        return payment_type_id;
    }

    public void setPayment_type_id(String payment_type_id) {
        this.payment_type_id = payment_type_id;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getInstallment() {
        return installment;
    }

    public void setInstallment(String installment) {
        this.installment = installment;
    }

    public String getIssuer_id() {
        return issuer_id;
    }

    public void setIssuer_id(String issuer_id) {
        this.issuer_id = issuer_id;
    }
}
