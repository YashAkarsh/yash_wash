package com.haier.uhome.config.json.notify;

import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class ConfigStateNotify extends BasicNotify {

    @b(name = "code")
    private int code;

    @b(name = "uplusID")
    private String uplusId;

    @b(name = "wifiMAC")
    private String wifiMac;

    public int getCode() {
        return this.code;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new com.haier.uhome.config.c.e();
    }

    public String getUplusId() {
        return this.uplusId;
    }

    public String getWifiMac() {
        return this.wifiMac;
    }

    public void setCode(int i7) {
        this.code = i7;
    }

    public void setUplusId(String str) {
        this.uplusId = str;
    }

    public void setWifiMac(String str) {
        this.wifiMac = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "ConfigStateNotify{wifiMac='" + this.wifiMac + "', uplusId='" + this.uplusId + "', code=" + this.code + '}';
    }
}
