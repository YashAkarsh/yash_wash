package com.haier.globalwasher.modle.bean;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceListBeen implements Serializable {
    private BluetoothInfoBean blueToolthInfo;
    private String currentRunModeId;
    private String deviceId;
    private String name;
    private String serialNumber;
    private String status;
    private String timeRemaining;

    public BluetoothInfoBean getBlueToolthInfo() {
        return this.blueToolthInfo;
    }

    public String getCurrentRunModeId() {
        return this.currentRunModeId;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getName() {
        return this.name;
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }

    public String getStatus() {
        return this.status;
    }

    public String getTimeRemaining() {
        return this.timeRemaining;
    }

    public void setCurrentRunModeId(String str) {
        this.currentRunModeId = str;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSerialNumber(String str) {
        this.serialNumber = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setTimeRemaining(String str) {
        this.timeRemaining = str;
    }

    public String toString() {
        return "DeviceListBeen{name='" + this.name + "', deviceId='" + this.deviceId + "', serialNumber='" + this.serialNumber + "', status='" + this.status + "', timeRemaining='" + this.timeRemaining + "', currentRunModeId='" + this.currentRunModeId + "'}";
    }
}
