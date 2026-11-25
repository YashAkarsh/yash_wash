package com.haier.uhome.account.model.uacmodel;

import com.haier.uhome.trace.api.TraceProtocolConst;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class UacDeviceAttribute {

    @b(name = "brand")
    private String brand;

    @b(name = TraceProtocolConst.PRO_MODEL)
    private String model;

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public void setBrand(String str) {
        this.brand = str;
    }

    public void setModel(String str) {
        this.model = str;
    }
}
