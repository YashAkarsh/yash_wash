package com.haier.globalwasher.modle.bean.discount;

/* JADX INFO: loaded from: classes2.dex */
public class CounponSelectReturnBean {
    private String payAmount;

    public CounponSelectReturnBean(String str) {
        this.payAmount = str;
    }

    public String getPayAmount() {
        return this.payAmount;
    }

    public void setPayAmount(String str) {
        this.payAmount = str;
    }

    public String toString() {
        return "CounponSelectReturnBean{payAmount='" + this.payAmount + "'}";
    }
}
