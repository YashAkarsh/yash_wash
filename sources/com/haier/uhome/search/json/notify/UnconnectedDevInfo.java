package com.haier.uhome.search.json.notify;

import g3.b;
import y2.a;

/* JADX INFO: loaded from: classes2.dex */
public class UnconnectedDevInfo {

    @b(name = "configMode")
    private int configMode;

    @b(name = "configState")
    private int configState;

    @b(name = "devAp")
    private String devAp;

    @b(name = "mac")
    private String mac;

    @b(name = "productCode")
    private String productCode;

    @b(name = "softapSSID")
    private String softApSSID;

    @b(name = a.C)
    private String ssid;

    public int getConfigMode() {
        return this.configMode;
    }

    public int getConfigState() {
        return this.configState;
    }

    public String getDevAp() {
        return this.devAp;
    }

    public String getMac() {
        return this.mac;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public String getSoftApSSID() {
        return this.softApSSID;
    }

    public String getSsid() {
        return this.ssid;
    }

    public void setConfigMode(int i7) {
        this.configMode = i7;
    }

    public void setConfigState(int i7) {
        this.configState = i7;
    }

    public void setDevAp(String str) {
        this.devAp = str;
    }

    public void setMac(String str) {
        this.mac = str;
    }

    public void setProductCode(String str) {
        this.productCode = str;
    }

    public void setSoftApSSID(String str) {
        this.softApSSID = str;
    }

    public void setSsid(String str) {
        this.ssid = str;
    }

    public String toString() {
        return "UnconnectedDevInfo{mac='" + this.mac + "', ssid='" + this.ssid + "', devAp='" + this.devAp + "', configMode=" + this.configMode + ", configState=" + this.configState + ", productCode='" + this.productCode + "', softApSSID='" + this.softApSSID + "'}";
    }
}
