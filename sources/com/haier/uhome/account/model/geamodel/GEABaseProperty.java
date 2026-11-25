package com.haier.uhome.account.model.geamodel;

import com.haier.uhome.trace.api.TraceProtocolConst;
import g3.b;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class GEABaseProperty {

    @b(name = "brand")
    private String brand;

    @b(name = TraceProtocolConst.PRO_MODEL)
    private String model;

    @b(name = "others")
    private Map<String, String> others;

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public Map<String, String> getOthers() {
        return this.others;
    }

    public void setBrand(String str) {
        this.brand = str;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public void setOthers(Map<String, String> map) {
        this.others = map;
    }
}
