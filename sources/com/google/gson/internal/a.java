package com.google.gson.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private a() {
        throw new UnsupportedOperationException();
    }

    public static void a(boolean z7) {
        if (!z7) {
            throw new IllegalArgumentException();
        }
    }

    public static <T> T b(T t7) {
        t7.getClass();
        return t7;
    }
}
