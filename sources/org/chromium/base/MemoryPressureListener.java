package org.chromium.base;

import android.app.Activity;
import java.util.Iterator;
import org.chromium.base.annotations.CalledByNative;

/* JADX INFO: loaded from: classes3.dex */
@x6.e
public class MemoryPressureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f38691a = "org.chromium.base.ACTION_LOW_MEMORY";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f38692b = "org.chromium.base.ACTION_TRIM_MEMORY";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f38693c = "org.chromium.base.ACTION_TRIM_MEMORY_RUNNING_CRITICAL";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f38694d = "org.chromium.base.ACTION_TRIM_MEMORY_MODERATE";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final a0<org.chromium.base.memory.a> f38695e = new a0<>();

    @CalledByNative
    private static void addNativeCallback() {
        b(new org.chromium.base.memory.a() { // from class: org.chromium.base.v
            @Override // org.chromium.base.memory.a
            public final void a(int i7) {
                MemoryPressureListener.nativeOnMemoryPressure(i7);
            }
        });
    }

    public static void b(org.chromium.base.memory.a aVar) {
        f38695e.g(aVar);
    }

    public static boolean c(Activity activity, String str) {
        if (f38691a.equals(str)) {
            f(activity);
            return true;
        }
        if (f38692b.equals(str)) {
            g(activity, 80);
            return true;
        }
        if (f38693c.equals(str)) {
            g(activity, 15);
            return true;
        }
        if (!f38694d.equals(str)) {
            return false;
        }
        g(activity, 60);
        return true;
    }

    public static void d(int i7) {
        Iterator<org.chromium.base.memory.a> it = f38695e.iterator();
        while (it.hasNext()) {
            it.next().a(i7);
        }
    }

    public static void e(org.chromium.base.memory.a aVar) {
        f38695e.o(aVar);
    }

    private static void f(Activity activity) {
        activity.getApplication().onLowMemory();
        activity.onLowMemory();
    }

    private static void g(Activity activity, int i7) {
        activity.getApplication().onTrimMemory(i7);
        activity.onTrimMemory(i7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnMemoryPressure(int i7);
}
