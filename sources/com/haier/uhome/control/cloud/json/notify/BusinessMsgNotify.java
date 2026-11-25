package com.haier.uhome.control.cloud.json.notify;

import com.haier.uhome.control.cloud.a.d;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class BusinessMsgNotify extends BasicNotify {

    @b(name = "info")
    private SlaveDeviceBindInfo info;

    public SlaveDeviceBindInfo getInfo() {
        return this.info;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new d();
    }

    public void setInfo(SlaveDeviceBindInfo slaveDeviceBindInfo) {
        this.info = slaveDeviceBindInfo;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "BusinessMsgNotify{info=" + this.info + '}';
    }
}
