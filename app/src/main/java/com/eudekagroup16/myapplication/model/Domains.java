package com.eudekagroup16.myapplication.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Project MyApplication
 * <p>
 * Created by IqbalMF on 3/15/2019
 */
public class Domains {
    @SerializedName("domains")
    List<DomainDetail> domains;


    public Domains(List<DomainDetail> domains) {
        this.domains = domains;
    }

    public List<DomainDetail> getDomains() {
        return domains;
    }
}
