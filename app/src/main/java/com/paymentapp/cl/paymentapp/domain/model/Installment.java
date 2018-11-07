package com.paymentapp.cl.paymentapp.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Installment {
    @SerializedName("payment_method_id")
    @Expose
    public String paymentMethodId;
    @SerializedName("payment_type_id")
    @Expose
    public String paymentTypeId;
    @SerializedName("issuer")
    @Expose
    public Issuer issuer;
    @SerializedName("processing_mode")
    @Expose
    public String processingMode;
    @SerializedName("merchant_account_id")
    @Expose
    public Object merchantAccountId;
    @SerializedName("payer_costs")
    @Expose
    public List<PayerCost> payerCosts = null;

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(String paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public Issuer getIssuer() {
        return issuer;
    }

    public void setIssuer(Issuer issuer) {
        this.issuer = issuer;
    }

    public String getProcessingMode() {
        return processingMode;
    }

    public void setProcessingMode(String processingMode) {
        this.processingMode = processingMode;
    }

    public Object getMerchantAccountId() {
        return merchantAccountId;
    }

    public void setMerchantAccountId(Object merchantAccountId) {
        this.merchantAccountId = merchantAccountId;
    }

    public List<PayerCost> getPayerCosts() {
        return payerCosts;
    }

    public void setPayerCosts(List<PayerCost> payerCosts) {
        this.payerCosts = payerCosts;
    }
}
