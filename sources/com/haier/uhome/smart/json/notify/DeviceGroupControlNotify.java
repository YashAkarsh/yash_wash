package com.haier.uhome.smart.json.notify;

import androidx.constraintlayout.core.motion.utils.w;
import com.haier.uhome.smart.handler.DeviceGroupControlNotifyHandler;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceGroupControlNotify extends BasicNotify {

    @b(name = "devId")
    private String devId;

    @b(name = w.h.f3145c)
    private int from;

    @b(name = "groupId")
    private String groupId;

    @b(name = "sn")
    private int sn;

    @b(name = "type")
    private int type;

    public String getDevId() {
        return this.devId;
    }

    public int getFrom() {
        return this.from;
    }

    public String getGroupId() {
        return this.groupId;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new DeviceGroupControlNotifyHandler();
    }

    public int getSn() {
        return this.sn;
    }

    public int getType() {
        return this.type;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setFrom(int i7) {
        this.from = i7;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public void setSn(int i7) {
        this.sn = i7;
    }

    public void setType(int i7) {
        this.type = i7;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "DeviceGroupControlNotify{devId='" + this.devId + "', groupId='" + this.groupId + "', sn=" + this.sn + ", type=" + this.type + ", from=" + this.from + '}';
    }
}
