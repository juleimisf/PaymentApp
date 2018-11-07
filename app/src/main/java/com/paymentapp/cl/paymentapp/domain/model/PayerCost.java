package com.paymentapp.cl.paymentapp.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PayerCost {
    @SerializedName("installments")
    @Expose
    public Integer installments;
    @SerializedName("installment_rate")
    @Expose
    public Integer installmentRate;
    @SerializedName("discount_rate")
    @Expose
    public Integer discountRate;
    @SerializedName("labels")
    @Expose
    public List<String> labels = null;
    @SerializedName("installment_rate_collector")
    @Expose
    public List<String> installmentRateCollector = null;
    @SerializedName("min_allowed_amount")
    @Expose
    public Integer minAllowedAmount;
    @SerializedName("max_allowed_amount")
    @Expose
    public Integer maxAllowedAmount;
    @SerializedName("recommended_message")
    @Expose
    public String recommendedMessage;
    @SerializedName("installment_amount")
    @Expose
    public Float installmentAmount;
    @SerializedName("total_amount")
    @Expose
    public Integer totalAmount;

    public Integer getInstallments() {
        return installments;
    }

    public void setInstallments(Integer installments) {
        this.installments = installments;
    }

    public Integer getInstallmentRate() {
        return installmentRate;
    }

    public void setInstallmentRate(Integer installmentRate) {
        this.installmentRate = installmentRate;
    }

    public Integer getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Integer discountRate) {
        this.discountRate = discountRate;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<String> getInstallmentRateCollector() {
        return installmentRateCollector;
    }

    public void setInstallmentRateCollector(List<String> installmentRateCollector) {
        this.installmentRateCollector = installmentRateCollector;
    }

    public Integer getMinAllowedAmount() {
        return minAllowedAmount;
    }

    public void setMinAllowedAmount(Integer minAllowedAmount) {
        this.minAllowedAmount = minAllowedAmount;
    }

    public Integer getMaxAllowedAmount() {
        return maxAllowedAmount;
    }

    public void setMaxAllowedAmount(Integer maxAllowedAmount) {
        this.maxAllowedAmount = maxAllowedAmount;
    }

    public String getRecommendedMessage() {
        return recommendedMessage;
    }

    public void setRecommendedMessage(String recommendedMessage) {
        this.recommendedMessage = recommendedMessage;
    }

    public Float getInstallmentAmount() {
        return installmentAmount;
    }

    public void setInstallmentAmount(Float installmentAmount) {
        this.installmentAmount = installmentAmount;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }
}
