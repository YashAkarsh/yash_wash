package org.chromium.base.task;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import org.chromium.base.annotations.CalledByNative;

/* JADX INFO: loaded from: classes3.dex */
@x6.c("base")
public class PostTask {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Executor f38881d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final /* synthetic */ boolean f38883f = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f38878a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Set<r> f38879b = Collections.newSetFromMap(new WeakHashMap());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Executor f38880c = new g();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final p[] f38882e = d();

    public static j a(u uVar) {
        j jVarC;
        synchronized (f38878a) {
            jVarC = f(uVar).c(uVar);
        }
        return jVarC;
    }

    public static n b(u uVar) {
        n nVarB;
        synchronized (f38878a) {
            nVarB = f(uVar).b(uVar);
        }
        return nVarB;
    }

    public static r c(u uVar) {
        r rVarE;
        synchronized (f38878a) {
            rVarE = f(uVar).e(uVar);
        }
        return rVarE;
    }

    private static p[] d() {
        p[] pVarArr = new p[5];
        pVarArr[0] = new i();
        return pVarArr;
    }

    static Executor e() {
        synchronized (f38878a) {
            Executor executor = f38881d;
            if (executor != null) {
                return executor;
            }
            return f38880c;
        }
    }

    private static p f(u uVar) {
        return f38882e[uVar.f38967e];
    }

    public static void g(u uVar, Runnable runnable, long j7) {
        synchronized (f38878a) {
            if (f38879b != null) {
                f(uVar).d(uVar, runnable, j7);
            } else {
                nativePostDelayedTask(uVar.f38963a, uVar.f38964b, uVar.f38965c, uVar.f38966d, uVar.f38967e, uVar.f38968f, runnable, j7);
            }
        }
    }

    public static void h(u uVar, Runnable runnable) {
        g(uVar, runnable, 0L);
    }

    static boolean i(r rVar) {
        Set<r> set = f38879b;
        if (set == null) {
            return false;
        }
        set.add(rVar);
        return true;
    }

    public static void j(int i7, p pVar) {
        synchronized (f38878a) {
            f38882e[i7] = pVar;
        }
    }

    public static void k() {
        synchronized (f38878a) {
            f38881d = null;
        }
    }

    public static void l(u uVar, Runnable runnable) {
        if (f(uVar).a(uVar)) {
            runnable.run();
        } else {
            h(uVar, runnable);
        }
    }

    @Deprecated
    public static <T> T m(u uVar, Callable<T> callable) {
        return (T) o(uVar, new FutureTask(callable));
    }

    @Deprecated
    public static void n(u uVar, Runnable runnable) {
        o(uVar, new FutureTask(runnable, null));
    }

    private static native void nativePostDelayedTask(boolean z7, int i7, boolean z8, boolean z9, byte b8, byte[] bArr, Runnable runnable, long j7);

    private static <T> T o(u uVar, FutureTask<T> futureTask) {
        l(uVar, futureTask);
        try {
            return futureTask.get();
        } catch (Exception e8) {
            throw new RuntimeException(e8);
        }
    }

    @CalledByNative
    private static void onNativeSchedulerReady() {
        synchronized (f38878a) {
            Iterator<r> it = f38879b.iterator();
            while (it.hasNext()) {
                it.next().d();
            }
            f38879b = null;
        }
    }

    @CalledByNative
    private static void onNativeSchedulerShutdown() {
        synchronized (f38878a) {
            f38879b = Collections.newSetFromMap(new WeakHashMap());
        }
    }

    public static void p(Executor executor) {
        synchronized (f38878a) {
            f38881d = executor;
        }
    }
}
