package com.paymentapp.cl.paymentapp.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PaymentMethodBuilder {

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

    public String getName() {
        return name;
    }

    public PaymentMethodBuilder setName(String name) {
       this.name = name;
       return this;
    }

    public PaymentMethod build(){
        return new PaymentMethod(this.id, this.name, this.paymentTypeId, this.status, this.secureThumbnail, this.thumbnail, this.deferredCapture, this.settings, this.additionalInfoNeeded, this.minAllowedAmount, this.maxAllowedAmount,this.accreditationTime, this.financialInstitutions, this.processingModes);
    }

}
