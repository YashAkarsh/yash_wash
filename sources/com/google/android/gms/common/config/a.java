package com.google.android.gms.common.config;

import android.os.Binder;
import android.os.StrictMode;
import android.util.Log;
import c.m0;
import c.o0;
import g1.d0;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public abstract class a<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object f15526d = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    protected final String f15527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m0
    protected final T f15528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @o0
    private T f15529c = null;

    protected a(@m0 String str, @m0 T t7) {
        this.f15527a = str;
        this.f15528b = t7;
    }

    @c1.a
    public static boolean c() {
        synchronized (f15526d) {
        }
        return false;
    }

    @c1.a
    @m0
    public static a<Float> f(@m0 String str, @m0 Float f8) {
        return new e(str, f8);
    }

    @c1.a
    @m0
    public static a<Integer> g(@m0 String str, @m0 Integer num) {
        return new d(str, num);
    }

    @c1.a
    @m0
    public static a<Long> h(@m0 String str, @m0 Long l7) {
        return new c(str, l7);
    }

    @c1.a
    @m0
    public static a<String> i(@m0 String str, @m0 String str2) {
        return new f(str, str2);
    }

    @c1.a
    @m0
    public static a<Boolean> j(@m0 String str, boolean z7) {
        return new b(str, Boolean.valueOf(z7));
    }

    @c1.a
    @m0
    public final T a() {
        T t7 = this.f15529c;
        if (t7 != null) {
            return t7;
        }
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        Object obj = f15526d;
        synchronized (obj) {
        }
        synchronized (obj) {
            try {
            } catch (Throwable th) {
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                throw th;
            }
        }
        try {
            T tK = k(this.f15527a);
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            return tK;
        } catch (SecurityException unused) {
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                T tK2 = k(this.f15527a);
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                return tK2;
            } catch (Throwable th2) {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
                throw th2;
            }
        }
    }

    @c1.a
    @m0
    @Deprecated
    public final T b() {
        return a();
    }

    @d0
    @c1.a
    public void d(@m0 T t7) {
        Log.w("GservicesValue", "GservicesValue.override(): test should probably call initForTests() first");
        this.f15529c = t7;
        Object obj = f15526d;
        synchronized (obj) {
            synchronized (obj) {
            }
        }
    }

    @d0
    @c1.a
    public void e() {
        this.f15529c = null;
    }

    @m0
    protected abstract T k(@m0 String str);
}
