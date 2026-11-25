package com.haier.uhome.control.noumenon.b.a;

import androidx.constraintlayout.core.motion.utils.w;
import com.haier.uhome.control.base.json.req.DeviceOperReq;

/* JADX INFO: loaded from: classes2.dex */
public class c extends DeviceOperReq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g3.b(name = "len")
    private int f29461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g3.b(name = w.h.f3145c)
    private int f29462b;

    public int getFrom() {
        return this.f29462b;
    }

    public int getLen() {
        return this.f29461a;
    }

    @Override // com.haier.uhome.control.base.json.req.DeviceOperReq, com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return "noumenon_device_oper_req";
    }

    public void setFrom(int i7) {
        this.f29462b = i7;
    }

    public void setLen(int i7) {
        this.f29461a = i7;
    }

    @Override // com.haier.uhome.control.base.json.req.DeviceOperReq, com.haier.uhome.control.base.json.req.BasicOpReq, com.haier.uhome.control.base.json.req.BasicDeviceReq, com.haier.uhome.usdk.base.json.BasicReq
    public String toString() {
        return "NoumenonDeviceOperReq{" + super.toString() + ", len=" + this.f29461a + ", from=" + this.f29462b + '}';
    }
}
