package com.haier.uhome.smart.json.notify;

import androidx.constraintlayout.core.motion.utils.w;
import com.facebook.internal.ServerProtocol;
import com.haier.uhome.smart.handler.DeviceCloudNotifyHandler;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceCloudStateNotify extends BasicNotify {

    @b(name = w.h.f3145c)
    private int from;

    @b(name = ServerProtocol.DIALOG_PARAM_STATE)
    private int state;

    public int getFrom() {
        return this.from;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new DeviceCloudNotifyHandler();
    }

    public int getState() {
        return this.state;
    }

    public void setFrom(int i7) {
        this.from = i7;
    }

    public void setState(int i7) {
        this.state = i7;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "DeviceCloudStateNotify{state=" + this.state + ", from=" + this.from + '}';
    }
}
