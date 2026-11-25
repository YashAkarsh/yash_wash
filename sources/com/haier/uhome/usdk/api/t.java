package com.haier.uhome.usdk.api;

import com.haier.uhome.smart.api.SmartReadRsp;

/* JADX INFO: loaded from: classes2.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SmartReadRsp f30734a;

    public t(int i7) {
        this.f30734a = new SmartReadRsp(i7);
    }

    public void a(String str) {
        this.f30734a.setValue(str);
    }

    public String toString() {
        return "USmartReadRsp{ReqSn=" + this.f30734a.getReqSn() + ",Value=" + this.f30734a.getValue() + ",Result=" + this.f30734a.getResult() + '}';
    }

    public void a(int i7) {
        this.f30734a.setResult(i7);
    }

    public SmartReadRsp a() {
        return this.f30734a;
    }
}
