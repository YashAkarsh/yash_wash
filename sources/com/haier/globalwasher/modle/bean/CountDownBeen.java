package com.haier.globalwasher.modle.bean;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class CountDownBeen implements Serializable {
    private String WashOrderId;
    private long clearbucketCountDownTime;
    private long overTime;
    private int statuId;

    public CountDownBeen(String str, long j7, int i7, long j8) {
        this.WashOrderId = str;
        this.overTime = j7;
        this.statuId = i7;
        this.clearbucketCountDownTime = j8;
    }

    public boolean equals(Object obj) {
        if (obj != null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CountDownBeen) {
                return ((CountDownBeen) obj).getWashOrderId().equals(getWashOrderId());
            }
        }
        return false;
    }

    public long getClearbucketCountDownTime() {
        return this.clearbucketCountDownTime;
    }

    public long getOverTime() {
        return this.overTime;
    }

    public int getStatuId() {
        return this.statuId;
    }

    public String getWashOrderId() {
        return this.WashOrderId;
    }

    public void setClearbucketCountDownTime(long j7) {
        this.clearbucketCountDownTime = j7;
    }

    public void setOverTime(long j7) {
        this.overTime = j7;
    }

    public void setStatuId(int i7) {
        this.statuId = i7;
    }

    public void setWashOrderId(String str) {
        this.WashOrderId = str;
    }

    public CountDownBeen() {
        this.WashOrderId = "0";
        this.clearbucketCountDownTime = 0L;
    }
}
