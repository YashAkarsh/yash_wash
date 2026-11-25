package com.haier.uhome.control.noumenon.b.a;

import androidx.constraintlayout.core.motion.utils.w;
import com.haier.uhome.control.base.json.req.DeviceAttrWriteReq;

/* JADX INFO: loaded from: classes2.dex */
public class b extends DeviceAttrWriteReq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g3.b(name = w.h.f3145c)
    private int f29460a;

    public int getFrom() {
        return this.f29460a;
    }

    @Override // com.haier.uhome.control.base.json.req.DeviceAttrWriteReq, com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return "noumenon_device_attr_write_req";
    }

    public void setFrom(int i7) {
        this.f29460a = i7;
    }

    @Override // com.haier.uhome.control.base.json.req.DeviceAttrWriteReq, com.haier.uhome.control.base.json.req.BasicOpReq, com.haier.uhome.control.base.json.req.BasicDeviceReq, com.haier.uhome.usdk.base.json.BasicReq
    public String toString() {
        return "NoumenonDeviceAttrWriteReq{" + super.toString() + ", from=" + this.f29460a + '}';
    }
}
