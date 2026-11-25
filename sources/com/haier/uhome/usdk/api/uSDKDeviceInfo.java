package com.haier.uhome.usdk.api;

import android.text.TextUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class uSDKDeviceInfo implements Serializable {
    private boolean isModuleNeedOTA;
    private String mDeviceId;
    private boolean mOnline;
    protected String mProductCode;
    private String mSoftwareType;
    private String mUplusId;
    protected String machineId;
    private String moduleOTATargetFile;
    private String moduleOTATargetVersion;

    public uSDKDeviceInfo() {
    }

    private void setSoftwareType(String str) {
        this.mSoftwareType = str;
    }

    public String getDeviceId() {
        return this.mDeviceId;
    }

    public String getMachineId() {
        return this.machineId;
    }

    String getModuleOTATargetFile() {
        return this.moduleOTATargetFile;
    }

    String getModuleOTATargetVersion() {
        return this.moduleOTATargetVersion;
    }

    public String getProductCode() {
        if (!TextUtils.isEmpty(this.mProductCode)) {
            return this.mProductCode;
        }
        com.haier.uhome.usdk.base.api.f fVarA = com.haier.uhome.usdk.base.api.g.a().a(getDeviceId());
        return fVarA == null ? "" : fVarA.i();
    }

    public String getSoftwareType() {
        return this.mSoftwareType;
    }

    public String getUplusId() {
        return this.mUplusId;
    }

    public boolean isModuleNeedOTA() {
        return this.isModuleNeedOTA;
    }

    public boolean isOnline() {
        return this.mOnline;
    }

    protected void setDeviceId(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = str.toUpperCase();
        }
        this.mDeviceId = str;
    }

    public void setMachineId(String str) {
        this.machineId = str;
    }

    void setModuleNeedOTA(boolean z7) {
        this.isModuleNeedOTA = false;
        this.moduleOTATargetVersion = null;
    }

    void setModuleOTATargetFile(String str) {
        this.moduleOTATargetFile = str;
    }

    void setModuleOTATargetVersion(String str) {
        this.moduleOTATargetVersion = str;
    }

    public void setOnline(boolean z7) {
        this.mOnline = z7;
    }

    public void setProductCode(String str) {
        this.mProductCode = str;
    }

    protected void setUplusId(String str) {
        this.mUplusId = str;
    }

    public String toString() {
        return "uSDKDeviceInfo{mDeviceId='" + this.mDeviceId + "', mUplusId='" + this.mUplusId + "', mOnline=" + this.mOnline + ", mSoftwareType='" + this.mSoftwareType + "', machineId='" + this.machineId + "', mProductCode='" + this.mProductCode + "', isModuleNeedOTA=" + this.isModuleNeedOTA + ", moduleOTATargetVersion='" + this.moduleOTATargetVersion + "', moduleOTATargetFile='" + this.moduleOTATargetFile + "'}";
    }

    public uSDKDeviceInfo(String str, String str2, boolean z7) {
        setDeviceId(str);
        setUplusId(str2);
        this.mOnline = z7;
    }

    public uSDKDeviceInfo(String str, String str2, String str3, boolean z7) {
        this(str, str2, z7);
        setSoftwareType(str3);
    }
}
