package com.haier.uhome.smart.api;

import android.text.TextUtils;
import com.haier.uhome.smart.api.interfaces.ISmartDeviceListener;
import com.haier.uhome.smart.service.SmartDeviceService;
import com.haier.uhome.usdk.base.api.o;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SmartDevice {
    private boolean isOldDevIdRule;
    private String mDevId;
    private ISmartDeviceListener mDeviceListener;
    private String mHwType;
    private String mHwVersion;
    private String mKey;
    private SmartDeviceService mSmartDeviceService;
    private String mSwType;
    private String mSwVersion;
    private String mUplusId;

    private SmartDevice() {
        this.mSmartDeviceService = SmartDeviceService.getInstance();
    }

    public void bindWindow(int i7, o oVar) {
        this.mSmartDeviceService.bindWindow(this.mDevId, i7, oVar);
    }

    public void businessUp(String str, byte[] bArr, o oVar) {
        this.mSmartDeviceService.businessUp(this.mDevId, str, bArr, oVar);
    }

    public String getDevId() {
        return this.mDevId;
    }

    public String getHwType() {
        return this.mHwType;
    }

    public String getHwVersion() {
        return this.mHwVersion;
    }

    public String getKey() {
        return this.mKey;
    }

    public ISmartDeviceListener getListener() {
        return this.mDeviceListener;
    }

    public String getSwType() {
        return this.mSwType;
    }

    public String getSwVersion() {
        return this.mSwVersion;
    }

    public String getUplusId() {
        return this.mUplusId;
    }

    public void reportAlarm(List<SmartDevicePair> list, o oVar) {
        this.mSmartDeviceService.reportAlarm(this.mDevId, list, oVar);
    }

    public void reportBigData(String str, String str2, o oVar) {
        this.mSmartDeviceService.reportBigData(this.mDevId, str, str2, oVar);
    }

    public void reportStatus(List<SmartDevicePair> list, o oVar) {
        this.mSmartDeviceService.reportStatus(this.mDevId, list, oVar);
    }

    public void setDevId(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = str.toUpperCase();
        }
        this.mDevId = str;
    }

    public void setHwType(String str) {
        this.mHwType = str;
    }

    public void setHwVersion(String str) {
        this.mHwVersion = str;
    }

    public void setKey(String str) {
        this.mKey = str;
    }

    public void setListener(ISmartDeviceListener iSmartDeviceListener) {
        this.mDeviceListener = iSmartDeviceListener;
    }

    public void setSwType(String str) {
        this.mSwType = str;
    }

    public void setSwVersion(String str) {
        this.mSwVersion = str;
    }

    public void setUplusId(String str) {
        this.mUplusId = str;
    }

    public String toString() {
        return "SmartDevice{mDevId='" + this.mDevId + "', mUplusId='" + this.mUplusId + "', mSwVersion='" + this.mSwVersion + "', mHwVersion='" + this.mHwVersion + "', mSwType='" + this.mSwType + "', mHwType='" + this.mHwType + "', mKey='" + this.mKey + "'}";
    }

    public SmartDevice(String str, String str2, String str3, String str4, String str5) {
        this();
        setDevId(str);
        this.mUplusId = str2;
        this.mSwVersion = str3;
        this.mHwVersion = str4;
        this.mKey = str5;
    }

    public SmartDevice(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this();
        setDevId(str);
        this.mUplusId = str2;
        this.mSwVersion = str3;
        this.mHwVersion = str4;
        this.mSwType = str5;
        this.mHwType = str6;
        this.mKey = str7;
    }
}
