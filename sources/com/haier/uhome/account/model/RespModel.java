package com.haier.uhome.account.model;

import com.haier.uhome.account.model.geamodel.GEADeviceInfo;
import com.haier.uhome.account.okhttp.uAccountRequest;
import g3.b;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class RespModel {

    @b(name = "accessToken")
    private String accessToken;

    @b(name = "deviceinfos")
    private GEADeviceInfo[] deviceinfos;

    @b(name = "devices")
    private com.haier.uhome.account.model.uacmodel.UacDevice[] devices;

    @b(name = "failedIds")
    private String[] failedIds;

    @b(name = "openId")
    private String openId;

    @b(name = uAccountRequest.KEY_RET_CODE)
    private String retCode;

    @b(name = uAccountRequest.KEY_RET_INFO)
    private String retInfo;

    @b(name = "userBase")
    private com.haier.uhome.account.model.uacmodel.UacUserBase userBase;

    @b(name = "userId")
    private String userId;

    public String getAccessToken() {
        return this.accessToken;
    }

    public GEADeviceInfo[] getDeviceinfos() {
        return this.deviceinfos;
    }

    public com.haier.uhome.account.model.uacmodel.UacDevice[] getDevices() {
        return this.devices;
    }

    public String[] getFailedIds() {
        return this.failedIds;
    }

    public String getOpenId() {
        return this.openId;
    }

    public String getRetCode() {
        return this.retCode;
    }

    public String getRetInfo() {
        return this.retInfo;
    }

    public com.haier.uhome.account.model.uacmodel.UacUserBase getUserBase() {
        return this.userBase;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public void setDeviceinfos(GEADeviceInfo[] gEADeviceInfoArr) {
        this.deviceinfos = gEADeviceInfoArr;
    }

    public void setDevices(com.haier.uhome.account.model.uacmodel.UacDevice[] uacDeviceArr) {
        this.devices = uacDeviceArr;
    }

    public void setFailedIds(String[] strArr) {
        this.failedIds = strArr;
    }

    public void setOpenId(String str) {
        this.openId = str;
    }

    public void setRetCode(String str) {
        this.retCode = str;
    }

    public void setRetInfo(String str) {
        this.retInfo = str;
    }

    public void setUserBase(com.haier.uhome.account.model.uacmodel.UacUserBase uacUserBase) {
        this.userBase = uacUserBase;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String toString() {
        return "RespModel{retCode='" + this.retCode + ", retInfo='" + this.retInfo + ", userBase=" + this.userBase + ", devices=" + Arrays.toString(this.devices) + ", accessToken='" + this.accessToken + ", openId='" + this.openId + ", userId='" + this.userId + ", deviceinfos=" + Arrays.toString(this.deviceinfos) + ", failedIds=" + Arrays.toString(this.failedIds) + '}';
    }
}
