package com.haier.uhome.control.noumenon.b.a;

import androidx.constraintlayout.core.motion.utils.w;
import com.haier.uhome.control.base.json.req.BasicDeviceReq;

/* JADX INFO: loaded from: classes2.dex */
public class d extends BasicDeviceReq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g3.b(name = "type")
    private int f29463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g3.b(name = w.h.f3145c)
    private int f29464b;

    public int getFrom() {
        return this.f29464b;
    }

    public int getType() {
        return this.f29463a;
    }

    @Override // com.haier.uhome.usdk.base.json.BasicReq
    protected String protocol() {
        return "noumenon_device_req";
    }

    public void setFrom(int i7) {
        this.f29464b = i7;
    }

    public void setType(int i7) {
        this.f29463a = i7;
    }

    @Override // com.haier.uhome.control.base.json.req.BasicDeviceReq, com.haier.uhome.usdk.base.json.BasicReq
    public String toString() {
        return "NoumenonDeviceReq{" + super.toString() + ", type=" + this.f29463a + ", from=" + this.f29464b + '}';
    }
}
