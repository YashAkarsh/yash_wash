package com.haier.uhome.smart.api;

import com.haier.uhome.usdk.base.annotation.Keep;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class SmartDevicePair {
    private String mName;
    private String mValue;

    public SmartDevicePair(String str, String str2) {
        this.mName = str;
        this.mValue = str2;
    }

    public String getName() {
        return this.mName;
    }

    public String getValue() {
        return this.mValue;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setValue(String str) {
        this.mValue = str;
    }

    public String toString() {
        return "SmartDevicePair{mName= " + this.mName + ", mValue=" + this.mValue + '}';
    }
}
