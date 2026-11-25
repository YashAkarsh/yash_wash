package com.haier.uhome.trace.api;

import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class DITraceNode {
    private String mBusinessId;
    private String mBusinessName;
    private String mCode;
    private String mDeviceId;
    private HashMap<String, String> mExtendInfo = new HashMap<>();
    private String mTraceId;
    private String mVersion;

    public DITraceNode(String str, String str2, String str3, String str4, String str5) {
        this.mBusinessId = str;
        this.mBusinessName = str2;
        this.mDeviceId = str3;
        this.mCode = str4;
        this.mVersion = str5;
    }

    public void add(String str, String str2) {
        if (str == null || TextUtils.isEmpty(str2)) {
            e3.a.f("DITraceNode add error: key = %s, value = %s", str, str2, new Object[0]);
        } else {
            this.mExtendInfo.put(str, str2);
        }
    }

    public String getBusinessId() {
        return this.mBusinessId;
    }

    public String getBusinessName() {
        return this.mBusinessName;
    }

    public String getCode() {
        return this.mCode;
    }

    public String getDeviceId() {
        return this.mDeviceId;
    }

    public HashMap<String, String> getExtendInfo() {
        return new HashMap<>(this.mExtendInfo);
    }

    public String getTraceId() {
        return this.mTraceId;
    }

    public String getVersion() {
        return this.mVersion;
    }

    public void setBusinessName(String str) {
        this.mBusinessName = str;
    }

    public void setCode(String str) {
        this.mCode = str;
    }

    void setTraceId(String str) {
        this.mTraceId = str;
    }

    public String toString() {
        return "DITraceNode{mTraceId=" + this.mTraceId + ", mBusinessId=" + this.mBusinessId + ", mCode=" + this.mCode + ", mDeviceId=" + this.mDeviceId + ", mBusinessName=" + this.mBusinessName + ", mVersion=" + this.mVersion + ", mExtendInfo=" + this.mExtendInfo + '}';
    }
}
