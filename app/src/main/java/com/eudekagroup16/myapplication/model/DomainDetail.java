package com.eudekagroup16.myapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DomainDetail implements Parcelable {
    @SerializedName("domain")
    public String domainName;
    @SerializedName("suffix")
    public String domainSuffix;
    @SerializedName("expiry_date")
    public String domainExpiry;
    @SerializedName("create_date")
    public String domainCreate;
    @SerializedName("update_date")
    public String domainUpdate;
    @SerializedName("country")
    public String domainCountry;

    @SerializedName("NS")
    private List<String> domainNS ;


    public DomainDetail(String domainName, String domainCountry) {
        this.domainName = domainName;
        this.domainCountry = domainCountry;
    }

    public DomainDetail(String domainName, String domainSuffix, String domainExpiry, String domainCreate, String domainUpdate, String domainCountry, List domainNS) {
        this.domainName = domainName;
        this.domainSuffix = domainSuffix;
        this.domainExpiry = domainExpiry;
        this.domainCreate = domainCreate;
        this.domainUpdate = domainUpdate;
        this.domainCountry = domainCountry;
        this.domainNS = domainNS;
    }

    protected DomainDetail(Parcel in) {
        domainName = in.readString();
        domainSuffix = in.readString();
        domainExpiry = in.readString();
        domainCreate = in.readString();
        domainUpdate = in.readString();
        domainCountry = in.readString();
        domainNS = in.createStringArrayList();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(domainName);
        dest.writeString(domainSuffix);
        dest.writeString(domainExpiry);
        dest.writeString(domainCreate);
        dest.writeString(domainUpdate);
        dest.writeString(domainCountry);
        dest.writeStringList(domainNS);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DomainDetail> CREATOR = new Creator<DomainDetail>() {
        @Override
        public DomainDetail createFromParcel(Parcel in) {
            return new DomainDetail(in);
        }

        @Override
        public DomainDetail[] newArray(int size) {
            return new DomainDetail[size];
        }
    };

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

    public String getDomainExpiry() {
        return domainExpiry;
    }

    public void setDomainExpiry(String domainExpiry) {
        this.domainExpiry = domainExpiry;
    }

    public String getDomainCreate() {
        return domainCreate;
    }

    public void setDomainCreate(String domainCreate) {
        this.domainCreate = domainCreate;
    }

    public String getDomainUpdate() {
        return domainUpdate;
    }

    public void setDomainUpdate(String domainUpdate) {
        this.domainUpdate = domainUpdate;
    }

    public String getDomainCountry() {
        return domainCountry;
    }

    public void setDomainCountry(String domainCountry) {
        this.domainCountry = domainCountry;
    }

    public List<String> getDomainNS() {
        return domainNS;
    }

    public void setDomainNS(List<String> domainNS) {
        this.domainNS = domainNS;
    }
}
