package com.paymentapp.cl.paymentapp.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CardRequest {
    @SerializedName("public_key")
    @Expose
    public String public_key;

    public CardRequest(String public_key) {
        this.public_key = public_key;
    }

    public String getPublic_key() {
        return public_key;
    }

    public void setPublic_key(String public_key) {
        this.public_key = public_key;
    }

    @Override
    public String toString() {
        return "CardRequest{" +
                "public_key='" + public_key + '\'' +
                '}';
    }
}
