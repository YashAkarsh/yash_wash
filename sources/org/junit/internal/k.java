package org.junit.internal;

/* JADX INFO: loaded from: classes3.dex */
public final class k {
    private k() {
    }

    private static <T extends Throwable> void a(Throwable th) throws Throwable {
        throw th;
    }

    public static Exception b(Throwable th) throws Exception {
        a(th);
        return null;
    }
}
