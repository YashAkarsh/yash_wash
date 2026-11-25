package com.haier.uhome.control.noumenon.b.a;

import androidx.constraintlayout.core.motion.utils.w;
import com.haier.uhome.control.base.json.req.DeviceAttrReadReq;

/* JADX INFO: loaded from: classes2.dex */
public class a extends DeviceAttrReadReq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g3.b(name = w.h.f3145c)
    private int f29459a;

    public int getFrom() {
        return this.f29459a;
    }

    @Override // com.haier.uhome.control.base.json.req.DeviceAttrReadReq, com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return "noumenon_device_attr_read_req";
    }

    public void setFrom(int i7) {
        this.f29459a = i7;
    }

    @Override // com.haier.uhome.control.base.json.req.DeviceAttrReadReq, com.haier.uhome.control.base.json.req.BasicOpReq, com.haier.uhome.control.base.json.req.BasicDeviceReq, com.haier.uhome.usdk.base.json.BasicReq
    public String toString() {
        return "NoumenonDeviceAttrReadReq{" + super.toString() + ", from=" + this.f29459a + '}';
    }
}
