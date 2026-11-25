package com.haier.uhome.account.model.uwsmodel;

import com.haier.globalwasher.presenter.o;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceBaseInfo {

    @b(name = "connectionStatus")
    private String connectionStatus;

    @b(name = "devNo")
    private String devNo;

    @b(name = o.f25218y)
    private String deviceId;

    @b(name = "productCode")
    private String productCode;

    @b(name = "productName")
    private String productName;

    @b(name = "softwareVersion")
    private String softwareVersion;

    public String getConnectionStatus() {
        return this.connectionStatus;
    }

    public String getDevNo() {
        return this.devNo;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public String getProductName() {
        return this.productName;
    }

    public String getSoftwareVersion() {
        return this.softwareVersion;
    }

    public void setConnectionStatus(String str) {
        this.connectionStatus = str;
    }

    public void setDevNo(String str) {
        this.devNo = str;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setProductCode(String str) {
        this.productCode = str;
    }

    public void setProductName(String str) {
        this.productName = str;
    }

    public void setSoftwareVersion(String str) {
        this.softwareVersion = str;
    }

    public String toString() {
        return "DeviceBaseInfo{deviceId='" + this.deviceId + "', devNo='" + this.devNo + "', productCode='" + this.productCode + "', productName='" + this.productName + "', softwareVersion='" + this.softwareVersion + "', connectionStatus='" + this.connectionStatus + "'}";
    }
}
