package com.haier.uhome.qrcode.bind.api;

/* JADX INFO: loaded from: classes2.dex */
public enum c {
    QRCODE_LOGIN(0),
    QRCODE_BIND(1),
    QRCODE_LOGIN_BIND(2),
    POLL_LOGIN(3),
    POLL_BIND(4),
    POLL_LOGIN_BIND(5);


    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f29584g;

    c(int i7) {
        this.f29584g = i7;
    }

    public int a() {
        return this.f29584g;
    }

    public static c a(int i7) {
        try {
            return values()[i7];
        } catch (Exception unused) {
            return QRCODE_LOGIN;
        }
    }
}
