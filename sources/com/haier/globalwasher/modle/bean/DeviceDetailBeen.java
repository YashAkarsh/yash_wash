package com.haier.globalwasher.modle.bean;

import com.haier.globalwasher.modle.utils.d0;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceDetailBeen implements Serializable {
    private String blueMac;
    private BluetoothInfoBean blueToolthInfo;
    private String capacity;
    private String currencySymbol;
    private String currentRunModeId;
    private String deviceId;
    private String deviceQRCode;
    private String directive;
    private String funcIntroduction;
    private int isBle;
    private Integer isSpecial;
    private LaundryInfo laundryInfo;
    private String location;
    private String model;
    private String name;
    private ArrayList<String> picture;
    private ArrayList<RunModeBeen> runMode;
    private String serialNumber;
    private String status;
    private String supportsCleaning;
    private String timeRemaining;
    private String type;
    private String typeName;

    public String getBlueMac() {
        return this.blueMac;
    }

    public BluetoothInfoBean getBlueToolthInfo() {
        return this.blueToolthInfo;
    }

    public String getCapacity() {
        return this.capacity;
    }

    public String getCurrencySymbol() {
        return d0.a(this.currencySymbol);
    }

    public String getCurrentRunModeId() {
        return this.currentRunModeId;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getDeviceQRCode() {
        return this.deviceQRCode;
    }

    public String getDirective() {
        return this.directive;
    }

    public String getFuncIntroduction() {
        return this.funcIntroduction;
    }

    public int getIsBle() {
        return this.isBle;
    }

    public Integer getIsSpecial() {
        return this.isSpecial;
    }

    public LaundryInfo getLaundryInfo() {
        return this.laundryInfo;
    }

    public String getLocation() {
        return this.location;
    }

    public String getModel() {
        return this.model;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<String> getPicture() {
        return this.picture;
    }

    public ArrayList<RunModeBeen> getRunMode() {
        return this.runMode;
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }

    public String getStatus() {
        return this.status;
    }

    public String getSupportsCleaning() {
        return this.supportsCleaning;
    }

    public String getTimeRemaining() {
        String str = this.timeRemaining;
        return (str == null || "".equals(str)) ? "0" : this.timeRemaining;
    }

    public String getType() {
        return this.type;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public void setBlueMac(String str) {
        this.blueMac = str;
    }

    public void setCapacity(String str) {
        this.capacity = str;
    }

    public void setCurrencySymbol(String str) {
        this.currencySymbol = str;
    }

    public void setCurrentRunModeId(String str) {
        this.currentRunModeId = str;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setDeviceQRCode(String str) {
        this.deviceQRCode = str;
    }

    public void setFuncIntroduction(String str) {
        this.funcIntroduction = str;
    }

    public void setIsBle(int i7) {
        this.isBle = i7;
    }

    public void setIsSpecial(Integer num) {
        this.isSpecial = num;
    }

    public void setLaundryInfo(LaundryInfo laundryInfo) {
        this.laundryInfo = laundryInfo;
    }

    public void setLocation(String str) {
        this.location = str;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPicture(ArrayList<String> arrayList) {
        this.picture = arrayList;
    }

    public void setRunMode(ArrayList<RunModeBeen> arrayList) {
        this.runMode = arrayList;
    }

    public void setSerialNumber(String str) {
        this.serialNumber = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setSupportsCleaning(String str) {
        this.supportsCleaning = str;
    }

    public void setTimeRemaining(String str) {
        this.timeRemaining = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setTypeName(String str) {
        this.typeName = str;
    }

    public String toString() {
        return "DeviceDetailBeen{name='" + this.name + "', deviceId='" + this.deviceId + "', serialNumber='" + this.serialNumber + "', picture=" + this.picture + ", location='" + this.location + "', type='" + this.type + "', typeName='" + this.typeName + "', isSpecial=" + this.isSpecial + ", model='" + this.model + "', status='" + this.status + "', funcIntroduction='" + this.funcIntroduction + "', runMode=" + this.runMode + ", timeRemaining='" + this.timeRemaining + "', capacity='" + this.capacity + "', laundryInfo=" + this.laundryInfo + ", currentRunModeId='" + this.currentRunModeId + "', deviceQRCode='" + this.deviceQRCode + "', supportsCleaning='" + this.supportsCleaning + "', blueMac='" + this.blueMac + "', currencySymbol='" + this.currencySymbol + "'}";
    }
}
