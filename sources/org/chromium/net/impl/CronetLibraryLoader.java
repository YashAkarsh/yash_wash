package org.chromium.net.impl;

import android.content.Context;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.s0;
import org.chromium.net.NetworkChangeNotifier;

/* JADX INFO: loaded from: classes3.dex */
@x6.c("cronet")
@s0
public class CronetLibraryLoader {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile boolean f39211f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final /* synthetic */ boolean f39213h = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f39206a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f39207b = "cronet." + i.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f39208c = CronetLibraryLoader.class.getSimpleName();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final HandlerThread f39209d = new HandlerThread("CronetInit");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile boolean f39210e = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final ConditionVariable f39212g = new ConditionVariable();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CronetLibraryLoader.b();
        }
    }

    public static void a(Context context, e eVar) {
        synchronized (f39206a) {
            if (!f39211f) {
                org.chromium.base.o.g(context);
                HandlerThread handlerThread = f39209d;
                if (!handlerThread.isAlive()) {
                    handlerThread.start();
                }
                d(new a());
            }
            if (!f39210e) {
                if (eVar.I() != null) {
                    eVar.I().a(f39207b);
                } else {
                    System.loadLibrary(f39207b);
                }
                String strB = i.b();
                if (!strB.equals(nativeGetCronetVersion())) {
                    throw new RuntimeException(String.format("Expected Cronet version number %s, actual version number %s.", strB, nativeGetCronetVersion()));
                }
                org.chromium.base.t.p(f39208c, "Cronet version: %s, arch: %s", strB, System.getProperty("os.arch"));
                f39210e = true;
                f39212g.open();
            }
        }
    }

    static void b() {
        if (f39211f) {
            return;
        }
        NetworkChangeNotifier.init();
        NetworkChangeNotifier.r();
        f39212g.block();
        nativeCronetInitOnInitThread();
        f39211f = true;
    }

    private static boolean c() {
        return f39209d.getLooper() == Looper.myLooper();
    }

    public static void d(Runnable runnable) {
        if (c()) {
            runnable.run();
        } else {
            new Handler(f39209d.getLooper()).post(runnable);
        }
    }

    @CalledByNative
    private static void ensureInitializedFromNative() {
        synchronized (f39206a) {
            f39210e = true;
            f39212g.open();
        }
        a(org.chromium.base.o.e(), null);
    }

    @CalledByNative
    private static String getDefaultUserAgent() {
        return v.b(org.chromium.base.o.e());
    }

    private static native void nativeCronetInitOnInitThread();

    private static native String nativeGetCronetVersion();

    @CalledByNative
    private static void setNetworkThreadPriorityOnNetworkThread(int i7) {
        Process.setThreadPriority(i7);
    }
}
