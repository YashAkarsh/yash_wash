package com.haier.globalwasher.modle.bean.pay;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class PayTMParamentBean implements Serializable {
    private String CALLBACK_URL;
    private String CHANNEL_ID;
    private String CHECKSUMHASH;
    private String CUST_ID;
    private String INDUSTRY_TYPE_ID;
    private String MID;
    private String ORDER_ID;
    private String TXN_AMOUNT;
    private String TXN_TOKEN;
    private String WEBSITE;
    private String body;

    public String getBody() {
        return this.body;
    }

    public String getCALLBACK_URL() {
        return this.CALLBACK_URL;
    }

    public String getCHANNEL_ID() {
        return this.CHANNEL_ID;
    }

    public String getCHECKSUMHASH() {
        return this.CHECKSUMHASH;
    }

    public String getCUST_ID() {
        return this.CUST_ID;
    }

    public String getINDUSTRY_TYPE_ID() {
        return this.INDUSTRY_TYPE_ID;
    }

    public String getMID() {
        return this.MID;
    }

    public String getORDER_ID() {
        return this.ORDER_ID;
    }

    public String getTXN_AMOUNT() {
        return this.TXN_AMOUNT;
    }

    public String getTXN_TOKEN() {
        return this.TXN_TOKEN;
    }

    public String getWEBSITE() {
        return this.WEBSITE;
    }

    public void setCALLBACK_URL(String str) {
        this.CALLBACK_URL = str;
    }

    public void setCHANNEL_ID(String str) {
        this.CHANNEL_ID = str;
    }

    public void setCHECKSUMHASH(String str) {
        this.CHECKSUMHASH = str;
    }

    public void setCUST_ID(String str) {
        this.CUST_ID = str;
    }

    public void setINDUSTRY_TYPE_ID(String str) {
        this.INDUSTRY_TYPE_ID = str;
    }

    public void setMID(String str) {
        this.MID = str;
    }

    public void setORDER_ID(String str) {
        this.ORDER_ID = str;
    }

    public void setTXN_AMOUNT(String str) {
        this.TXN_AMOUNT = str;
    }

    public void setTXN_TOKEN(String str) {
        this.TXN_TOKEN = str;
    }

    public void setWEBSITE(String str) {
        this.WEBSITE = str;
    }

    public String toString() {
        return "PayTMParamentBean{CALLBACK_URL='" + this.CALLBACK_URL + "', CHANNEL_ID='" + this.CHANNEL_ID + "', CUST_ID='" + this.CUST_ID + "', INDUSTRY_TYPE_ID='" + this.INDUSTRY_TYPE_ID + "', MID='" + this.MID + "', ORDER_ID='" + this.ORDER_ID + "', TXN_AMOUNT='" + this.TXN_AMOUNT + "', WEBSITE='" + this.WEBSITE + "', CHECKSUMHASH='" + this.CHECKSUMHASH + "', TXN_TOKEN='" + this.TXN_TOKEN + "', body='" + this.body + "'}";
    }
}
