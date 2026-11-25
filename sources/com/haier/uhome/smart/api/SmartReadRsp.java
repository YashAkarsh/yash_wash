package com.haier.uhome.smart.api;

/* JADX INFO: loaded from: classes2.dex */
public class SmartReadRsp extends BaseSmartRsp {
    private String mValue;

    public SmartReadRsp(int i7) {
        super(i7);
    }

    public String getValue() {
        return this.mValue;
    }

    public void setValue(String str) {
        this.mValue = str;
    }

    @Override // com.haier.uhome.smart.api.BaseSmartRsp
    public String toString() {
        return "SmartReadRsp{mValue='" + this.mValue + '}';
    }
}
