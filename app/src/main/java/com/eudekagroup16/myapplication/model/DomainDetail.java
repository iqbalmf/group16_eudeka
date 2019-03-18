package com.eudekagroup16.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class DomainDetail {
    @SerializedName("domain")
    public String domainName;
    @SerializedName("suffix")
    public String domainSuffix;

    public DomainDetail(String domainName, String domainSuffix) {
        this.domainName = domainName;
        this.domainSuffix = domainSuffix;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getDomainSuffix() {
        return domainSuffix;
    }

    public void setDomainSuffix(String domainSuffix) {
        this.domainSuffix = domainSuffix;
    }
}
