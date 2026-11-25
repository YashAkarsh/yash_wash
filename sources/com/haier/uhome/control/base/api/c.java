package com.haier.uhome.control.base.api;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    private String mName;
    private String mValue;

    protected c() {
    }

    public String getName() {
        return this.mName;
    }

    public String getValue() {
        return this.mValue;
    }

    protected void setName(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("DeviceArgument name must not be empty!");
        }
        this.mName = str;
    }

    protected void setValue(String str) {
        if (str == null) {
            throw new IllegalArgumentException("DeviceArgument value must not be null!");
        }
        this.mValue = str;
    }

    public String toString() {
        return "DeviceArgument{mName=" + this.mName + ", mValue=" + this.mValue + '}';
    }

    public c(String str, String str2) {
        setName(str);
        setValue(str2);
    }
}
