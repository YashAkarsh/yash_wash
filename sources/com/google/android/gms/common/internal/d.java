package com.google.android.gms.common.internal;

import android.os.Looper;
import android.util.Log;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public final class d {
    private d() {
        throw new AssertionError("Uninstantiable");
    }

    @c1.a
    public static void a(@c.m0 String str) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return;
        }
        String strValueOf = String.valueOf(Thread.currentThread());
        String strValueOf2 = String.valueOf(Looper.getMainLooper().getThread());
        StringBuilder sb = new StringBuilder(strValueOf.length() + 57 + strValueOf2.length());
        sb.append("checkMainThread: current thread ");
        sb.append(strValueOf);
        sb.append(" IS NOT the main thread ");
        sb.append(strValueOf2);
        sb.append("!");
        Log.e("Asserts", sb.toString());
        throw new IllegalStateException(str);
    }

    @c1.a
    public static void b(@c.m0 String str) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            return;
        }
        String strValueOf = String.valueOf(Thread.currentThread());
        String strValueOf2 = String.valueOf(Looper.getMainLooper().getThread());
        StringBuilder sb = new StringBuilder(strValueOf.length() + 56 + strValueOf2.length());
        sb.append("checkNotMainThread: current thread ");
        sb.append(strValueOf);
        sb.append(" IS the main thread ");
        sb.append(strValueOf2);
        sb.append("!");
        Log.e("Asserts", sb.toString());
        throw new IllegalStateException(str);
    }

    @g6.b({"#1"})
    @c1.a
    public static void c(@Nullable Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("null reference");
        }
    }

    @g6.b({"#1"})
    @c1.a
    public static void d(@Nullable Object obj, @c.m0 Object obj2) {
        if (obj == null) {
            throw new IllegalArgumentException(String.valueOf(obj2));
        }
    }

    @c1.a
    public static void e(@c.m0 Object obj) {
        if (obj != null) {
            throw new IllegalArgumentException("non-null reference");
        }
    }

    @c1.a
    public static void f(boolean z7) {
        if (!z7) {
            throw new IllegalStateException();
        }
    }

    @c1.a
    public static void g(boolean z7, @c.m0 Object obj) {
        if (!z7) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }
}
