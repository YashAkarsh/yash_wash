package com.haier.uhome.usdk.base.service;

import com.haier.uhome.usdk.base.json.BasicReq;

/* JADX INFO: loaded from: classes2.dex */
public class c implements com.haier.uhome.usdk.base.d.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SDKBaseNative f31344a;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static c f31345a = new c();

        private a() {
        }
    }

    public static c a() {
        return a.f31345a;
    }

    public int b() {
        return this.f31344a.init();
    }

    public int c() {
        return this.f31344a.unInit();
    }

    public long d() {
        return this.f31344a.getProfileHandle();
    }

    @Override // com.haier.uhome.usdk.base.d.e
    public int sendReq(BasicReq basicReq) {
        String strBuildJson = basicReq.buildJson();
        e3.a.e("SDKBaseNativeService send json<%d> : %s", Integer.valueOf(basicReq.getSn()), strBuildJson);
        return this.f31344a.sendRequest(strBuildJson);
    }

    private c() {
        SDKBaseNative sDKBaseNative = new SDKBaseNative();
        this.f31344a = sDKBaseNative;
        sDKBaseNative.setUserPackageReceive(com.haier.uhome.usdk.base.d.f.a());
    }
}
