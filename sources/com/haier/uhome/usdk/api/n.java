package com.haier.uhome.usdk.api;

import com.haier.uhome.smart.api.BaseSmartRsp;

/* JADX INFO: loaded from: classes2.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BaseSmartRsp f30650a;

    public n(int i7) {
        this.f30650a = new BaseSmartRsp(i7);
    }

    public void a(int i7) {
        this.f30650a.setResult(i7);
    }

    public BaseSmartRsp b() {
        return this.f30650a;
    }

    public String toString() {
        return "UBaseSmartRsp{ReqSn=" + this.f30650a.getReqSn() + ",Result=" + this.f30650a.getResult() + '}';
    }

    public int a() {
        return this.f30650a.getResult();
    }
}
