package com.paymentapp.cl.paymentapp.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bin {
    @SerializedName("pattern")
    @Expose
    public String pattern;
    @SerializedName("installments_pattern")
    @Expose
    public String installmentsPattern;
    @SerializedName("exclusion_pattern")
    @Expose
    public Object exclusionPattern;

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getInstallmentsPattern() {
        return installmentsPattern;
    }

    public void setInstallmentsPattern(String installmentsPattern) {
        this.installmentsPattern = installmentsPattern;
    }

    public Object getExclusionPattern() {
        return exclusionPattern;
    }

    public void setExclusionPattern(Object exclusionPattern) {
        this.exclusionPattern = exclusionPattern;
    }
}
