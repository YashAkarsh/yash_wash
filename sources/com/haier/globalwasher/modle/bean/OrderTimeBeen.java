package com.haier.globalwasher.modle.bean;

/* JADX INFO: loaded from: classes2.dex */
public class OrderTimeBeen {
    private String remainingTime;
    private String status;

    public OrderTimeBeen(String str, String str2) {
        this.status = str;
        this.remainingTime = str2;
    }

    public String getRemainingTime() {
        return this.remainingTime;
    }

    public String getStatus() {
        return this.status;
    }

    public void setRemainingTime(String str) {
        this.remainingTime = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
