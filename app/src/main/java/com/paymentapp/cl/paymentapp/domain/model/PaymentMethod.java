package com.paymentapp.cl.paymentapp.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PaymentMethod {
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("payment_type_id")
    @Expose
    public String paymentTypeId;
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("secure_thumbnail")
    @Expose
    public String secureThumbnail;
    @SerializedName("thumbnail")
    @Expose
    public String thumbnail;
    @SerializedName("deferred_capture")
    @Expose
    public String deferredCapture;
    @SerializedName("settings")
    @Expose
    public List<Setting> settings = null;
    @SerializedName("additional_info_needed")
    @Expose
    public List<String> additionalInfoNeeded = null;
    @SerializedName("min_allowed_amount")
    @Expose
    public float  minAllowedAmount;
    @SerializedName("max_allowed_amount")
    @Expose
    public Integer maxAllowedAmount;
    @SerializedName("accreditation_time")
    @Expose
    public Integer accreditationTime;
    @SerializedName("financial_institutions")
    @Expose
    public List<FinancialInstitution> financialInstitutions = null;
    @SerializedName("processing_modes")
    @Expose
    public List<String> processingModes = null;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(String paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSecureThumbnail() {
        return secureThumbnail;
    }

    public void setSecureThumbnail(String secureThumbnail) {
        this.secureThumbnail = secureThumbnail;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDeferredCapture() {
        return deferredCapture;
    }

    public void setDeferredCapture(String deferredCapture) {
        this.deferredCapture = deferredCapture;
    }

    public List<Setting> getSettings() {
        return settings;
    }

    public void setSettings(List<Setting> settings) {
        this.settings = settings;
    }

    public List<String> getAdditionalInfoNeeded() {
        return additionalInfoNeeded;
    }

    public void setAdditionalInfoNeeded(List<String> additionalInfoNeeded) {
        this.additionalInfoNeeded = additionalInfoNeeded;
    }

    public float  getMinAllowedAmount() {
        return minAllowedAmount;
    }

    public void setMinAllowedAmount(float  minAllowedAmount) {
        this.minAllowedAmount = minAllowedAmount;
    }

    public Integer getMaxAllowedAmount() {
        return maxAllowedAmount;
    }

    public void setMaxAllowedAmount(Integer maxAllowedAmount) {
        this.maxAllowedAmount = maxAllowedAmount;
    }

    public Integer getAccreditationTime() {
        return accreditationTime;
    }

    public void setAccreditationTime(Integer accreditationTime) {
        this.accreditationTime = accreditationTime;
    }

    public List<FinancialInstitution> getFinancialInstitutions() {
        return financialInstitutions;
    }

    public void setFinancialInstitutions(List<FinancialInstitution> financialInstitutions) {
        this.financialInstitutions = financialInstitutions;
    }

    public List<String> getProcessingModes() {
        return processingModes;
    }

    public void setProcessingModes(List<String> processingModes) {
        this.processingModes = processingModes;
    }
}
