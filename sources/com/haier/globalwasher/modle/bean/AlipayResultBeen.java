package com.haier.globalwasher.modle.bean;

/* JADX INFO: loaded from: classes2.dex */
public class AlipayResultBeen {
    private String total_amount;
    private String trade_no;
    private String trade_status;

    public AlipayResultBeen(String str, String str2, String str3) {
        this.trade_status = str;
        this.total_amount = str2;
        this.trade_no = str3;
    }

    public String getTotal_amount() {
        return this.total_amount;
    }

    public String getTrade_no() {
        return this.trade_no;
    }

    public String getTrade_status() {
        return this.trade_status;
    }

    public void setTotal_amount(String str) {
        this.total_amount = str;
    }

    public void setTrade_no(String str) {
        this.trade_no = str;
    }

    public void setTrade_status(String str) {
        this.trade_status = str;
    }
}
