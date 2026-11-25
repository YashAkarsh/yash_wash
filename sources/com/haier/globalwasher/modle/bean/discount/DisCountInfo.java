package com.haier.globalwasher.modle.bean.discount;

/* JADX INFO: loaded from: classes2.dex */
public class DisCountInfo {
    private String preferType;
    private String preferValueId;

    public DisCountInfo(String str, String str2) {
        this.preferType = str;
        this.preferValueId = str2;
    }

    public String getPreferType() {
        return this.preferType;
    }

    public String getPreferValueId() {
        return this.preferValueId;
    }

    public void setPreferType(String str) {
        this.preferType = str;
    }

    public void setPreferValueId(String str) {
        this.preferValueId = str;
    }
}
