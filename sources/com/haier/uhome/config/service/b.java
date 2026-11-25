package com.haier.uhome.config.service;

import com.haier.uhome.usdk.base.json.BasicReq;

/* JADX INFO: loaded from: classes2.dex */
public class b implements com.haier.uhome.usdk.base.d.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConfigNative f28535a;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static b f28536a = new b();

        private a() {
        }
    }

    public static b a() {
        return a.f28536a;
    }

    @Override // com.haier.uhome.usdk.base.d.e
    public int sendReq(BasicReq basicReq) {
        return 0;
    }

    private b() {
        ConfigNative configNative = new ConfigNative();
        this.f28535a = configNative;
        configNative.setUserPackageReceive(com.haier.uhome.usdk.base.d.f.a());
    }

    public String a(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        return this.f28535a.getDeviceBindInfo(str, str2);
    }
}
