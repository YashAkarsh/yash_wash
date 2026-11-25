package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.view.n2;
import c.m0;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements View.OnTouchListener {
    private static final int A = 315;
    private static final int B = 1575;
    private static final float C = Float.MAX_VALUE;
    private static final float D = 0.2f;
    private static final float E = 1.0f;
    private static final int F = ViewConfiguration.getTapTimeout();
    private static final int G = 500;
    private static final int H = 500;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final float f6986r = 0.0f;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final float f6987s = Float.MAX_VALUE;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final float f6988t = 0.0f;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f6989u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f6990v = 1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f6991w = 2;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final int f6992x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final int f6993y = 1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final int f6994z = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final View f6997c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Runnable f6998d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f7001g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f7002h;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f7006l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    boolean f7007m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    boolean f7008n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    boolean f7009o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f7010p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f7011q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final C0082a f6995a = new C0082a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Interpolator f6996b = new AccelerateInterpolator();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float[] f6999e = {0.0f, 0.0f};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float[] f7000f = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float[] f7003i = {0.0f, 0.0f};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float[] f7004j = {0.0f, 0.0f};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float[] f7005k = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* JADX INFO: renamed from: androidx.core.widget.a$a, reason: collision with other inner class name */
    private static class C0082a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f7012a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f7013b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f7014c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f7015d;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private float f7021j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f7022k;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f7016e = Long.MIN_VALUE;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private long f7020i = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f7017f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f7018g = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f7019h = 0;

        C0082a() {
        }

        private float e(long j7) {
            long j8 = this.f7016e;
            if (j7 < j8) {
                return 0.0f;
            }
            long j9 = this.f7020i;
            if (j9 < 0 || j7 < j9) {
                return a.e((j7 - j8) / this.f7012a, 0.0f, 1.0f) * 0.5f;
            }
            float f8 = this.f7021j;
            return (1.0f - f8) + (f8 * a.e((j7 - j9) / this.f7022k, 0.0f, 1.0f));
        }

        private float g(float f8) {
            return ((-4.0f) * f8 * f8) + (f8 * 4.0f);
        }

        public void a() {
            if (this.f7017f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float fG = g(e(jCurrentAnimationTimeMillis));
            long j7 = jCurrentAnimationTimeMillis - this.f7017f;
            this.f7017f = jCurrentAnimationTimeMillis;
            float f8 = j7 * fG;
            this.f7018g = (int) (this.f7014c * f8);
            this.f7019h = (int) (f8 * this.f7015d);
        }

        public int b() {
            return this.f7018g;
        }

        public int c() {
            return this.f7019h;
        }

        public int d() {
            float f8 = this.f7014c;
            return (int) (f8 / Math.abs(f8));
        }

        public int f() {
            float f8 = this.f7015d;
            return (int) (f8 / Math.abs(f8));
        }

        public boolean h() {
            return this.f7020i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f7020i + ((long) this.f7022k);
        }

        public void i() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f7022k = a.f((int) (jCurrentAnimationTimeMillis - this.f7016e), 0, this.f7013b);
            this.f7021j = e(jCurrentAnimationTimeMillis);
            this.f7020i = jCurrentAnimationTimeMillis;
        }

        public void j(int i7) {
            this.f7013b = i7;
        }

        public void k(int i7) {
            this.f7012a = i7;
        }

        public void l(float f8, float f9) {
            this.f7014c = f8;
            this.f7015d = f9;
        }

        public void m() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f7016e = jCurrentAnimationTimeMillis;
            this.f7020i = -1L;
            this.f7017f = jCurrentAnimationTimeMillis;
            this.f7021j = 0.5f;
            this.f7018g = 0;
            this.f7019h = 0;
        }
    }

    private class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            if (aVar.f7009o) {
                if (aVar.f7007m) {
                    aVar.f7007m = false;
                    aVar.f6995a.m();
                }
                C0082a c0082a = a.this.f6995a;
                if (c0082a.h() || !a.this.x()) {
                    a.this.f7009o = false;
                    return;
                }
                a aVar2 = a.this;
                if (aVar2.f7008n) {
                    aVar2.f7008n = false;
                    aVar2.c();
                }
                c0082a.a();
                a.this.l(c0082a.b(), c0082a.c());
                n2.p1(a.this.f6997c, this);
            }
        }
    }

    public a(@m0 View view) {
        this.f6997c = view;
        float f8 = Resources.getSystem().getDisplayMetrics().density;
        float f9 = (int) ((1575.0f * f8) + 0.5f);
        r(f9, f9);
        float f10 = (int) ((f8 * 315.0f) + 0.5f);
        s(f10, f10);
        n(1);
        q(Float.MAX_VALUE, Float.MAX_VALUE);
        v(0.2f, 0.2f);
        w(1.0f, 1.0f);
        m(F);
        u(500);
        t(500);
    }

    private float d(int i7, float f8, float f9, float f10) {
        float fH = h(this.f6999e[i7], f9, this.f7000f[i7], f8);
        if (fH == 0.0f) {
            return 0.0f;
        }
        float f11 = this.f7003i[i7];
        float f12 = this.f7004j[i7];
        float f13 = this.f7005k[i7];
        float f14 = f11 * f10;
        return fH > 0.0f ? e(fH * f14, f12, f13) : -e((-fH) * f14, f12, f13);
    }

    static float e(float f8, float f9, float f10) {
        if (f8 > f10) {
            return f10;
        }
        return f8 < f9 ? f9 : f8;
    }

    static int f(int i7, int i8, int i9) {
        if (i7 > i9) {
            return i9;
        }
        return i7 < i8 ? i8 : i7;
    }

    private float g(float f8, float f9) {
        if (f9 == 0.0f) {
            return 0.0f;
        }
        int i7 = this.f7001g;
        if (i7 == 0 || i7 == 1) {
            if (f8 < f9) {
                if (f8 >= 0.0f) {
                    return 1.0f - (f8 / f9);
                }
                if (this.f7009o && i7 == 1) {
                    return 1.0f;
                }
            }
        } else if (i7 == 2 && f8 < 0.0f) {
            return f8 / (-f9);
        }
        return 0.0f;
    }

    private float h(float f8, float f9, float f10, float f11) {
        float interpolation;
        float fE = e(f8 * f9, 0.0f, f10);
        float fG = g(f9 - f11, fE) - g(f11, fE);
        if (fG < 0.0f) {
            interpolation = -this.f6996b.getInterpolation(-fG);
        } else {
            if (fG <= 0.0f) {
                return 0.0f;
            }
            interpolation = this.f6996b.getInterpolation(fG);
        }
        return e(interpolation, -1.0f, 1.0f);
    }

    private void k() {
        if (this.f7007m) {
            this.f7009o = false;
        } else {
            this.f6995a.i();
        }
    }

    private void y() {
        int i7;
        if (this.f6998d == null) {
            this.f6998d = new b();
        }
        this.f7009o = true;
        this.f7007m = true;
        if (this.f7006l || (i7 = this.f7002h) <= 0) {
            this.f6998d.run();
        } else {
            n2.q1(this.f6997c, this.f6998d, i7);
        }
        this.f7006l = true;
    }

    public abstract boolean a(int i7);

    public abstract boolean b(int i7);

    void c() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f6997c.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    public boolean i() {
        return this.f7010p;
    }

    public boolean j() {
        return this.f7011q;
    }

    public abstract void l(int i7, int i8);

    @m0
    public a m(int i7) {
        this.f7002h = i7;
        return this;
    }

    @m0
    public a n(int i7) {
        this.f7001g = i7;
        return this;
    }

    public a o(boolean z7) {
        if (this.f7010p && !z7) {
            k();
        }
        this.f7010p = z7;
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0016  */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.f7010p) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                k();
            } else if (actionMasked != 2) {
                if (actionMasked == 3) {
                    k();
                }
            }
            return this.f7011q && this.f7009o;
        }
        this.f7008n = true;
        this.f7006l = false;
        this.f6995a.l(d(0, motionEvent.getX(), view.getWidth(), this.f6997c.getWidth()), d(1, motionEvent.getY(), view.getHeight(), this.f6997c.getHeight()));
        if (!this.f7009o && x()) {
            y();
        }
        if (this.f7011q) {
            return false;
        }
    }

    public a p(boolean z7) {
        this.f7011q = z7;
        return this;
    }

    @m0
    public a q(float f8, float f9) {
        float[] fArr = this.f7000f;
        fArr[0] = f8;
        fArr[1] = f9;
        return this;
    }

    @m0
    public a r(float f8, float f9) {
        float[] fArr = this.f7005k;
        fArr[0] = f8 / 1000.0f;
        fArr[1] = f9 / 1000.0f;
        return this;
    }

    @m0
    public a s(float f8, float f9) {
        float[] fArr = this.f7004j;
        fArr[0] = f8 / 1000.0f;
        fArr[1] = f9 / 1000.0f;
        return this;
    }

    @m0
    public a t(int i7) {
        this.f6995a.j(i7);
        return this;
    }

    @m0
    public a u(int i7) {
        this.f6995a.k(i7);
        return this;
    }

    @m0
    public a v(float f8, float f9) {
        float[] fArr = this.f6999e;
        fArr[0] = f8;
        fArr[1] = f9;
        return this;
    }

    @m0
    public a w(float f8, float f9) {
        float[] fArr = this.f7003i;
        fArr[0] = f8 / 1000.0f;
        fArr[1] = f9 / 1000.0f;
        return this;
    }

    boolean x() {
        C0082a c0082a = this.f6995a;
        int iF = c0082a.f();
        int iD = c0082a.d();
        return (iF != 0 && b(iF)) || (iD != 0 && a(iD));
    }
}
