package com.haier.uhome.control.local.b;

/* JADX INFO: loaded from: classes2.dex */
public enum d {
    AES_256("aes256", 1);


    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f29360b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f29361c;

    d(String str, int i7) {
        this.f29360b = str;
        this.f29361c = i7;
    }

    public String a() {
        return this.f29360b;
    }

    public int b() {
        return this.f29361c;
    }

    public static d a(String str) {
        for (d dVar : values()) {
            if (com.haier.library.common.util.c.c(dVar.a(), str)) {
                return dVar;
            }
        }
        return AES_256;
    }
}
