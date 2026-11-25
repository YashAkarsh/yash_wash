package com.haier.uhome.smart.json.notify;

import androidx.constraintlayout.core.motion.utils.w;
import com.haier.uhome.smart.handler.DevicePairingNotifyHandler;
import com.haier.uhome.usdk.base.c.e;
import com.haier.uhome.usdk.base.json.BasicNotify;
import g3.b;

/* JADX INFO: loaded from: classes2.dex */
public class DevicePairingNotify extends BasicNotify {

    @b(name = "bindSn")
    private String bindSn;

    @b(name = w.h.f3145c)
    private int from;

    @b(name = "sn")
    private int sn;

    @b(name = "traceId")
    private String traceId;

    @b(name = "upCode")
    private String upCode;

    @b(name = "uplusId")
    private String uplusId;

    public String getBindSn() {
        return this.bindSn;
    }

    public int getFrom() {
        return this.from;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    protected e getNotifyHandler() {
        return new DevicePairingNotifyHandler();
    }

    public int getSn() {
        return this.sn;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public String getUpCode() {
        return this.upCode;
    }

    public String getUplusId() {
        return this.uplusId;
    }

    public void setBindSn(String str) {
        this.bindSn = str;
    }

    public void setFrom(int i7) {
        this.from = i7;
    }

    public void setSn(int i7) {
        this.sn = i7;
    }

    public void setTraceId(String str) {
        this.traceId = str;
    }

    public void setUpCode(String str) {
        this.upCode = str;
    }

    public void setUplusId(String str) {
        this.uplusId = str;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicNotify
    public String toString() {
        return "DevicePairingNotify{traceId='" + this.traceId + "', sn=" + this.sn + ", uplusId='" + this.uplusId + "', upCode='" + this.upCode + "', bindSn='" + this.bindSn + "', from=" + this.from + '}';
    }
}
