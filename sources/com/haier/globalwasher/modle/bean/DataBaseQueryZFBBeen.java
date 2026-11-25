package com.haier.globalwasher.modle.bean;

/* JADX INFO: loaded from: classes2.dex */
public class DataBaseQueryZFBBeen {
    private String code;
    private String out_trade_no;
    private String payType;

    public DataBaseQueryZFBBeen(String str, String str2, String str3) {
        this.code = str;
        this.payType = str2;
        this.out_trade_no = str3;
    }

    public String getCode() {
        return this.code;
    }

    public String getOut_trade_no() {
        return this.out_trade_no;
    }

    public String getPayType() {
        return this.payType;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setOut_trade_no(String str) {
        this.out_trade_no = str;
    }

    public void setPayType(String str) {
        this.payType = str;
    }
}
