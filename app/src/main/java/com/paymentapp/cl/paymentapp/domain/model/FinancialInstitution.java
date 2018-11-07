package com.paymentapp.cl.paymentapp.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FinancialInstitution {

    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("id")
    @Expose
    public String id;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
