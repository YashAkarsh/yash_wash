package com.haier.uhome.qrcode.bind.api;

/* JADX INFO: loaded from: classes2.dex */
public enum l {
    STATE_WAIT(0),
    STATE_SCAN(1),
    STATE_CONFIRM(2),
    STATE_QRCODE_INVALID(3),
    STATE_REFRESH_TOKEN_INVALID(4);


    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f29652f;

    l(int i7) {
        this.f29652f = i7;
    }

    public int a() {
        return this.f29652f;
    }

    public static l a(int i7) {
        try {
            return values()[i7];
        } catch (Exception unused) {
            return STATE_WAIT;
        }
    }
}
