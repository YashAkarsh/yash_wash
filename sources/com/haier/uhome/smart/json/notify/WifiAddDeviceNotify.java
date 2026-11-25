package com.haier.uhome.smart.json.notify;

import androidx.constraintlayout.core.motion.utils.w;
import com.haier.uhome.smart.handler.WifiAddDeviceNotifyHandler;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class WifiAddDeviceNotify extends BasicNotify {

    @b(name = w.h.f3145c)
    private int from;

    @b(name = "mainType")
    private int mainType;

    @b(name = "middleType")
    private int middleType;

    @b(name = "softApName")
    private String softApName;

    @b(name = "wifiMac")
    private String wifiMac;

    public int getFrom() {
        return this.from;
    }

    public int getMainType() {
        return this.mainType;
    }

    public int getMiddleType() {
        return this.middleType;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new WifiAddDeviceNotifyHandler();
    }

    public String getSoftApName() {
        return this.softApName;
    }

    public String getWifiMac() {
        return this.wifiMac;
    }

    public void setFrom(int i7) {
        this.from = i7;
    }

    public void setMainType(int i7) {
        this.mainType = i7;
    }

    public void setMiddleType(int i7) {
        this.middleType = i7;
    }

    public void setSoftApName(String str) {
        this.softApName = str;
    }

    public void setWifiMac(String str) {
        this.wifiMac = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "WifiAddDeviceNotify{wifiMac='" + this.wifiMac + "', softApName='" + this.softApName + "', mainType=" + this.mainType + ", middleType=" + this.middleType + ", from=" + this.from + '}';
    }
}
