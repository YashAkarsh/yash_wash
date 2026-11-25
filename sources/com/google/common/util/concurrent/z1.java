package com.google.common.util.concurrent;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.b
public final class z1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Runnable f22945a = new a();

    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    private z1() {
    }

    public static Runnable a() {
        return f22945a;
    }
}
