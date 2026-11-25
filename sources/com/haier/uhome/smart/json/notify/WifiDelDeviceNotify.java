package com.haier.uhome.smart.json.notify;

import androidx.constraintlayout.core.motion.utils.w;
import com.haier.uhome.smart.handler.WifiDelDeviceNotifyHandler;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class WifiDelDeviceNotify extends BasicNotify {

    @b(name = w.h.f3145c)
    private int from;

    @b(name = "wifiMac")
    private String wifiMac;

    public int getFrom() {
        return this.from;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new WifiDelDeviceNotifyHandler();
    }

    public String getWifiMac() {
        return this.wifiMac;
    }

    public void setFrom(int i7) {
        this.from = i7;
    }

    public void setWifiMac(String str) {
        this.wifiMac = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "WifiDelDeviceNotify{wifiMac='" + this.wifiMac + "', from=" + this.from + '}';
    }
}
