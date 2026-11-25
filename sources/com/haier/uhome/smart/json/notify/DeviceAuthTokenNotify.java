package com.haier.uhome.smart.json.notify;

import androidx.constraintlayout.core.motion.utils.w;
import com.facebook.appevents.UserDataStore;
import com.haier.uhome.smart.handler.DeviceAuthTokenNotifyHandler;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import com.paytm.pgsdk.d;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceAuthTokenNotify extends BasicNotify {

    @b(name = w.h.f3145c)
    private int from;

    @b(name = UserDataStore.STATE)
    private int st;

    @b(name = d.R)
    private String token;

    public int getFrom() {
        return this.from;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new DeviceAuthTokenNotifyHandler();
    }

    public int getSt() {
        return this.st;
    }

    public String getToken() {
        return this.token;
    }

    public void setFrom(int i7) {
        this.from = i7;
    }

    public void setSt(int i7) {
        this.st = i7;
    }

    public void setToken(String str) {
        this.token = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "DeviceAuthTokenNotify{st=" + this.st + ", token=" + this.token + ", from=" + this.from + '}';
    }
}
