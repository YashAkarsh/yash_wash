package com.haier.uhome.smart.api;

/* JADX INFO: loaded from: classes2.dex */
public class RegisterResult {
    private String mDevId;
    private DeviceRole mDevRole;
    private int mUgwCode;

    public String getDevId() {
        return this.mDevId;
    }

    public DeviceRole getDevRole() {
        return this.mDevRole;
    }

    public int getUgwCode() {
        return this.mUgwCode;
    }

    public void setDevId(String str) {
        this.mDevId = str;
    }

    public void setDevRole(DeviceRole deviceRole) {
        this.mDevRole = deviceRole;
    }

    public void setUgwCode(int i7) {
        this.mUgwCode = i7;
    }

    public String toString() {
        return "RegisterResult{mUgwCode=" + this.mUgwCode + ", mDevId='" + this.mDevId + "', mDevRole=" + this.mDevRole + '}';
    }
}
