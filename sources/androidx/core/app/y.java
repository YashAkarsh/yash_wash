package androidx.core.app;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import android.view.FrameMetrics;
import android.view.Window;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f5540b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f5541c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f5542d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f5543e = 3;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f5544f = 4;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f5545g = 5;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f5546h = 6;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f5547i = 7;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f5548j = 8;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f5549k = 8;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f5550l = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f5551m = 2;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f5552n = 4;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f5553o = 8;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f5554p = 16;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f5555q = 32;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f5556r = 64;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f5557s = 128;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f5558t = 256;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f5559u = 511;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f5560a;

    @c.t0(24)
    private static class a extends b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final int f5561e = 1000000;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final int f5562f = 500000;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static HandlerThread f5563g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static Handler f5564h;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f5565a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        SparseIntArray[] f5566b = new SparseIntArray[9];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ArrayList<WeakReference<Activity>> f5567c = new ArrayList<>();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Window.OnFrameMetricsAvailableListener f5568d = new WindowOnFrameMetricsAvailableListenerC0057a();

        /* JADX INFO: renamed from: androidx.core.app.y$a$a, reason: collision with other inner class name */
        class WindowOnFrameMetricsAvailableListenerC0057a implements Window.OnFrameMetricsAvailableListener {
            WindowOnFrameMetricsAvailableListenerC0057a() {
            }

            @Override // android.view.Window.OnFrameMetricsAvailableListener
            public void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i7) {
                a aVar = a.this;
                if ((aVar.f5565a & 1) != 0) {
                    aVar.f(aVar.f5566b[0], frameMetrics.getMetric(8));
                }
                a aVar2 = a.this;
                if ((aVar2.f5565a & 2) != 0) {
                    aVar2.f(aVar2.f5566b[1], frameMetrics.getMetric(1));
                }
                a aVar3 = a.this;
                if ((aVar3.f5565a & 4) != 0) {
                    aVar3.f(aVar3.f5566b[2], frameMetrics.getMetric(3));
                }
                a aVar4 = a.this;
                if ((aVar4.f5565a & 8) != 0) {
                    aVar4.f(aVar4.f5566b[3], frameMetrics.getMetric(4));
                }
                a aVar5 = a.this;
                if ((aVar5.f5565a & 16) != 0) {
                    aVar5.f(aVar5.f5566b[4], frameMetrics.getMetric(5));
                }
                a aVar6 = a.this;
                if ((aVar6.f5565a & 64) != 0) {
                    aVar6.f(aVar6.f5566b[6], frameMetrics.getMetric(7));
                }
                a aVar7 = a.this;
                if ((aVar7.f5565a & 32) != 0) {
                    aVar7.f(aVar7.f5566b[5], frameMetrics.getMetric(6));
                }
                a aVar8 = a.this;
                if ((aVar8.f5565a & 128) != 0) {
                    aVar8.f(aVar8.f5566b[7], frameMetrics.getMetric(0));
                }
                a aVar9 = a.this;
                if ((aVar9.f5565a & 256) != 0) {
                    aVar9.f(aVar9.f5566b[8], frameMetrics.getMetric(2));
                }
            }
        }

        a(int i7) {
            this.f5565a = i7;
        }

        @Override // androidx.core.app.y.b
        public void a(Activity activity) {
            if (f5563g == null) {
                HandlerThread handlerThread = new HandlerThread("FrameMetricsAggregator");
                f5563g = handlerThread;
                handlerThread.start();
                f5564h = new Handler(f5563g.getLooper());
            }
            for (int i7 = 0; i7 <= 8; i7++) {
                SparseIntArray[] sparseIntArrayArr = this.f5566b;
                if (sparseIntArrayArr[i7] == null && (this.f5565a & (1 << i7)) != 0) {
                    sparseIntArrayArr[i7] = new SparseIntArray();
                }
            }
            activity.getWindow().addOnFrameMetricsAvailableListener(this.f5568d, f5564h);
            this.f5567c.add(new WeakReference<>(activity));
        }

        @Override // androidx.core.app.y.b
        public SparseIntArray[] b() {
            return this.f5566b;
        }

        @Override // androidx.core.app.y.b
        public SparseIntArray[] c(Activity activity) {
            for (WeakReference<Activity> weakReference : this.f5567c) {
                if (weakReference.get() == activity) {
                    this.f5567c.remove(weakReference);
                    break;
                }
            }
            activity.getWindow().removeOnFrameMetricsAvailableListener(this.f5568d);
            return this.f5566b;
        }

        @Override // androidx.core.app.y.b
        public SparseIntArray[] d() {
            SparseIntArray[] sparseIntArrayArr = this.f5566b;
            this.f5566b = new SparseIntArray[9];
            return sparseIntArrayArr;
        }

        @Override // androidx.core.app.y.b
        public SparseIntArray[] e() {
            for (int size = this.f5567c.size() - 1; size >= 0; size--) {
                WeakReference<Activity> weakReference = this.f5567c.get(size);
                Activity activity = weakReference.get();
                if (weakReference.get() != null) {
                    activity.getWindow().removeOnFrameMetricsAvailableListener(this.f5568d);
                    this.f5567c.remove(size);
                }
            }
            return this.f5566b;
        }

        void f(SparseIntArray sparseIntArray, long j7) {
            if (sparseIntArray != null) {
                int i7 = (int) ((500000 + j7) / 1000000);
                if (j7 >= 0) {
                    sparseIntArray.put(i7, sparseIntArray.get(i7) + 1);
                }
            }
        }
    }

    private static class b {
        b() {
        }

        public void a(Activity activity) {
        }

        public SparseIntArray[] b() {
            return null;
        }

        public SparseIntArray[] c(Activity activity) {
            return null;
        }

        public SparseIntArray[] d() {
            return null;
        }

        public SparseIntArray[] e() {
            return null;
        }
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface c {
    }

    public y() {
        this(1);
    }

    public void a(@c.m0 Activity activity) {
        this.f5560a.a(activity);
    }

    @c.o0
    public SparseIntArray[] b() {
        return this.f5560a.b();
    }

    @c.o0
    public SparseIntArray[] c(@c.m0 Activity activity) {
        return this.f5560a.c(activity);
    }

    @c.o0
    public SparseIntArray[] d() {
        return this.f5560a.d();
    }

    @c.o0
    public SparseIntArray[] e() {
        return this.f5560a.e();
    }

    public y(int i7) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f5560a = new a(i7);
        } else {
            this.f5560a = new b();
        }
    }
}
