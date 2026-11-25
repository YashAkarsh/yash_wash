package com.haier.uhome.config.json.req;

import com.alipay.sdk.data.a;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class WithWifi {

    @b(name = "BSSID")
    private String bssid;

    @b(name = "password")
    private String password;

    @b(name = "SSID")
    private String ssid;

    @b(name = a.f13674p)
    private int timeout;

    public String getBssid() {
        return this.bssid;
    }

    public String getPassword() {
        return this.password;
    }

    public String getSsid() {
        return this.ssid;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public void setBssid(String str) {
        this.bssid = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setSsid(String str) {
        this.ssid = str;
    }

    public void setTimeout(int i7) {
        this.timeout = i7;
    }

    public String toString() {
        return "WithWifi{ssid='" + this.ssid + "', bssid='" + this.bssid + "', password='" + this.password + "', timeout=" + this.timeout + '}';
    }
}
