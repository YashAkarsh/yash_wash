package com.haier.uhome.config.json;

import g3.b;
import y2.a;

/* JADX INFO: loaded from: classes2.dex */
public class ApInfo {

    @b(name = "encryptionType")
    private int encryptionType;

    @b(name = "power")
    private int power;

    @b(name = a.C)
    private String ssid;

    public int getEncryptionType() {
        return this.encryptionType;
    }

    public int getPower() {
        return this.power;
    }

    public String getSsid() {
        return this.ssid;
    }

    public void setEncryptionType(int i7) {
        this.encryptionType = i7;
    }

    public void setPower(int i7) {
        this.power = i7;
    }

    public void setSsid(String str) {
        this.ssid = str;
    }

    public String toString() {
        return "ApInfo{ssid=" + this.ssid + ", power=" + this.power + ", encryptionType=" + this.encryptionType + '}';
    }
}
