package org.chromium.base.memory;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.chromium.base.ThreadUtils;
import org.chromium.base.metrics.RecordHistogram;
import org.chromium.base.o;

/* JADX INFO: loaded from: classes3.dex */
public class b implements ComponentCallbacks2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b f38823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final /* synthetic */ boolean f38824c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f38825a;

    @Retention(RetentionPolicy.SOURCE)
    private @interface a {

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        public static final int f38826c0 = 0;

        /* JADX INFO: renamed from: d0, reason: collision with root package name */
        public static final int f38827d0 = 1;

        /* JADX INFO: renamed from: e0, reason: collision with root package name */
        public static final int f38828e0 = 2;

        /* JADX INFO: renamed from: f0, reason: collision with root package name */
        public static final int f38829f0 = 3;

        /* JADX INFO: renamed from: g0, reason: collision with root package name */
        public static final int f38830g0 = 4;

        /* JADX INFO: renamed from: h0, reason: collision with root package name */
        public static final int f38831h0 = 5;

        /* JADX INFO: renamed from: i0, reason: collision with root package name */
        public static final int f38832i0 = 6;

        /* JADX INFO: renamed from: j0, reason: collision with root package name */
        public static final int f38833j0 = 7;

        /* JADX INFO: renamed from: k0, reason: collision with root package name */
        public static final int f38834k0 = 8;

        /* JADX INFO: renamed from: l0, reason: collision with root package name */
        public static final int f38835l0 = 9;
    }

    private b(String str) {
        this.f38825a = "Android.MemoryPressureNotification." + str;
    }

    public static void a() {
        c("Browser");
    }

    public static void b() {
        c("ChildService");
    }

    private static void c(String str) {
        ThreadUtils.b();
        f38823b = new b(str);
        o.e().registerComponentCallbacks(f38823b);
    }

    private void d(int i7) {
        RecordHistogram.l(this.f38825a, i7, 9);
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        d(8);
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i7) {
        if (i7 == 5) {
            d(7);
            return;
        }
        if (i7 == 10) {
            d(6);
            return;
        }
        if (i7 == 15) {
            d(5);
            return;
        }
        if (i7 == 20) {
            d(4);
            return;
        }
        if (i7 == 40) {
            d(3);
            return;
        }
        if (i7 == 60) {
            d(2);
        } else if (i7 != 80) {
            d(0);
        } else {
            d(1);
        }
    }
}
