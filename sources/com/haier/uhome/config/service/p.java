package com.haier.uhome.config.service;

import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.json.BasicReq;

/* JADX INFO: loaded from: classes2.dex */
public class p implements com.haier.uhome.usdk.base.d.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConfigNative f28675a;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static p f28676a = new p();

        private a() {
        }
    }

    public static p a() {
        return a.f28676a;
    }

    public int b() {
        int errorId = ErrorConst.RET_USDK_OK.getErrorId();
        try {
            this.f28675a.softAPInit();
            return errorId;
        } catch (com.haier.uhome.config.b.a e8) {
            e8.a();
            return e8.b();
        }
    }

    public int c() {
        return this.f28675a.softAPUninit();
    }

    @Override // com.haier.uhome.usdk.base.d.e
    public int sendReq(BasicReq basicReq) {
        try {
            return this.f28675a.softAPConfig(basicReq.buildJson());
        } catch (com.haier.uhome.config.b.a e8) {
            e8.a();
            return e8.b();
        }
    }

    private p() {
        ConfigNative configNative = new ConfigNative();
        this.f28675a = configNative;
        configNative.setUserPackageReceive(com.haier.uhome.usdk.base.d.f.a());
    }
}
