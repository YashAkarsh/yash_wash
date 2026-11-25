package com.google.common.util.concurrent;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
final class x1 {
    private x1() {
    }

    static boolean a(Throwable th, Class<? extends Throwable> cls) {
        return cls.isInstance(th);
    }
}
