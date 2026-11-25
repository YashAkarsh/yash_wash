package com.haier.uhome.config.json.notify;

import com.haier.uhome.config.c.d;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class ConfigProcessNotify extends BasicNotify {

    @b(name = "progress")
    private String progress;

    @b(name = "sn")
    private int sn;

    @b(name = "uplusID")
    private String uplusId;

    @b(name = "wifiMAC")
    private String wifiMac;

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new d();
    }

    public String getProgress() {
        return this.progress;
    }

    public int getSn() {
        return this.sn;
    }

    public String getUplusId() {
        return this.uplusId;
    }

    public String getWifiMac() {
        return this.wifiMac;
    }

    public void setProgress(String str) {
        this.progress = str;
    }

    public void setSn(int i7) {
        this.sn = i7;
    }

    public void setUplusId(String str) {
        this.uplusId = str;
    }

    public void setWifiMac(String str) {
        this.wifiMac = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "BleConfigProcessNotify{sn=" + this.sn + ", wifiMac='" + this.wifiMac + "', uplusId='" + this.uplusId + "', progress='" + this.progress + "'}";
    }
}
