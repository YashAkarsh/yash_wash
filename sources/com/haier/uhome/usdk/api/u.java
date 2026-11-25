package com.haier.uhome.usdk.api;

/* JADX INFO: loaded from: classes2.dex */
public enum u {
    APP_PROT_STD(com.haier.uhome.usdk.base.api.a.APP_PROT_STD),
    APP_PROT_SIXID(com.haier.uhome.usdk.base.api.a.APP_PROT_SIXID);


    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.haier.uhome.usdk.base.api.a f30745c;

    u(com.haier.uhome.usdk.base.api.a aVar) {
        this.f30745c = aVar;
    }

    public static u a(String str) {
        try {
            return valueOf(str);
        } catch (Exception unused) {
            return APP_PROT_SIXID;
        }
    }

    public static u a(int i7) {
        try {
            return values()[i7];
        } catch (Exception unused) {
            return APP_PROT_SIXID;
        }
    }
}
