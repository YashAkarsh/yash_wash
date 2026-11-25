package com.haier.globalwasher.modle.bean.pay;

/* JADX INFO: loaded from: classes2.dex */
public class PrePayBean {
    private String TAG = "PrePayBean";
    private String isPayZero;
    private String payType;
    private PayTMParamentBean prepayInfo;

    public String getIsPayZero() {
        return this.isPayZero;
    }

    public String getPayType() {
        return this.payType;
    }

    public PayTMParamentBean getPrepayInfo() {
        return this.prepayInfo;
    }

    public void setIsPayZero(String str) {
        this.isPayZero = str;
    }

    public void setPayType(String str) {
        this.payType = str;
    }
}
