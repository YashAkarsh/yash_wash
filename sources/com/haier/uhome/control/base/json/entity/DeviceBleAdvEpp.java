package com.haier.uhome.control.base.json.entity;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceBleAdvEpp {
    public static final int EPP_TYPE_ALARM = 2;
    public static final int EPP_TYPE_ATTR = 1;
    private String mBleDevId;
    private String mDevId;
    private int mEppType;
    private List<NameAndValue> mEppValue;
    private String mLongProduceCode;
    private String mProtocol;
    private long mUniqueId;
    private String mUplusId;

    public String getBleDevId() {
        return this.mBleDevId;
    }

    public String getDevId() {
        return this.mDevId;
    }

    public int getEppType() {
        return this.mEppType;
    }

    public List<NameAndValue> getEppValue() {
        return this.mEppValue;
    }

    public String getLongProduceCode() {
        return this.mLongProduceCode;
    }

    public String getProtocol() {
        return this.mProtocol;
    }

    public long getUniqueId() {
        return this.mUniqueId;
    }

    public String getUplusId() {
        return this.mUplusId;
    }

    public void setBleDevId(String str) {
        this.mBleDevId = str;
    }

    public void setDevId(String str) {
        this.mDevId = str;
    }

    public void setEppType(int i7) {
        this.mEppType = i7;
    }

    public void setEppValue(List<NameAndValue> list) {
        this.mEppValue = list;
    }

    public void setLongProduceCode(String str) {
        this.mLongProduceCode = str;
    }

    public void setProtocol(String str) {
        this.mProtocol = str;
    }

    public void setUniqueId(long j7) {
        this.mUniqueId = j7;
    }

    public void setUplusId(String str) {
        this.mUplusId = str;
    }

    public String toString() {
        return "DeviceBleAdvEpp{mDevId=" + this.mDevId + ", mUplusId=" + this.mUplusId + ", mUniqueId=" + this.mUniqueId + ", mEppType=" + this.mEppType + ", mEppValue=" + this.mEppValue + '}';
    }
}
