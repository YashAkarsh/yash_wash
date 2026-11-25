package com.haier.uhome.config.json.resp;

import com.haier.uhome.usdk.base.json.BasicResp;
import g3.b;
import y2.a;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceGetWifiInfoResp extends BasicResp {

    @b(name = "bssid")
    private String bssid;

    @b(name = "devId")
    private String devId;

    @b(name = "password")
    private String password;

    @b(name = a.C)
    private String ssid;

    public String getBssid() {
        return this.bssid;
    }

    public String getDevId() {
        return this.devId;
    }

    public String getPassword() {
        return this.password;
    }

    public String getSsid() {
        return this.ssid;
    }

    public void setBssid(String str) {
        this.bssid = str;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setSsid(String str) {
        this.ssid = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicResp
    public String toString() {
        return "DeviceGetWifiInfoResp{ssid='" + this.ssid + "', bssid='" + this.bssid + "', password='" + this.password + "'}";
    }
}
