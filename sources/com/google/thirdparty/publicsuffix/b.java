package com.google.thirdparty.publicsuffix;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.b
public enum b {
    PRIVATE(':', ','),
    REGISTRY('!', '?');


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final char f23320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final char f23321b;

    b(char c8, char c9) {
        this.f23320a = c8;
        this.f23321b = c9;
    }

    static b a(char c8) {
        for (b bVar : values()) {
            if (bVar.c() == c8 || bVar.d() == c8) {
                return bVar;
            }
        }
        throw new IllegalArgumentException("No enum corresponding to given code: " + c8);
    }

    static b b(boolean z7) {
        return z7 ? PRIVATE : REGISTRY;
    }

    char c() {
        return this.f23320a;
    }

    char d() {
        return this.f23321b;
    }
}
