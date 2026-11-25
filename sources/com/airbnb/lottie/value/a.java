package com.airbnb.lottie.value;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import c.o0;
import c.v;

/* JADX INFO: loaded from: classes.dex */
public class a<T> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final float f12346o = -3987645.8f;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int f12347p = 784923401;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @o0
    private final com.airbnb.lottie.f f12348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @o0
    public final T f12349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @o0
    public T f12350c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @o0
    public final Interpolator f12351d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f12352e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @o0
    public Float f12353f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f12354g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f12355h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f12356i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f12357j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f12358k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f12359l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public PointF f12360m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public PointF f12361n;

    public a(com.airbnb.lottie.f fVar, @o0 T t7, @o0 T t8, @o0 Interpolator interpolator, float f8, @o0 Float f9) {
        this.f12354g = f12346o;
        this.f12355h = f12346o;
        this.f12356i = f12347p;
        this.f12357j = f12347p;
        this.f12358k = Float.MIN_VALUE;
        this.f12359l = Float.MIN_VALUE;
        this.f12360m = null;
        this.f12361n = null;
        this.f12348a = fVar;
        this.f12349b = t7;
        this.f12350c = t8;
        this.f12351d = interpolator;
        this.f12352e = f8;
        this.f12353f = f9;
    }

    public boolean a(@v(from = 0.0d, to = 1.0d) float f8) {
        return f8 >= e() && f8 < b();
    }

    public float b() {
        if (this.f12348a == null) {
            return 1.0f;
        }
        if (this.f12359l == Float.MIN_VALUE) {
            if (this.f12353f == null) {
                this.f12359l = 1.0f;
            } else {
                this.f12359l = e() + ((this.f12353f.floatValue() - this.f12352e) / this.f12348a.e());
            }
        }
        return this.f12359l;
    }

    public float c() {
        if (this.f12355h == f12346o) {
            this.f12355h = ((Float) this.f12350c).floatValue();
        }
        return this.f12355h;
    }

    public int d() {
        if (this.f12357j == f12347p) {
            this.f12357j = ((Integer) this.f12350c).intValue();
        }
        return this.f12357j;
    }

    public float e() {
        com.airbnb.lottie.f fVar = this.f12348a;
        if (fVar == null) {
            return 0.0f;
        }
        if (this.f12358k == Float.MIN_VALUE) {
            this.f12358k = (this.f12352e - fVar.p()) / this.f12348a.e();
        }
        return this.f12358k;
    }

    public float f() {
        if (this.f12354g == f12346o) {
            this.f12354g = ((Float) this.f12349b).floatValue();
        }
        return this.f12354g;
    }

    public int g() {
        if (this.f12356i == f12347p) {
            this.f12356i = ((Integer) this.f12349b).intValue();
        }
        return this.f12356i;
    }

    public boolean h() {
        return this.f12351d == null;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f12349b + ", endValue=" + this.f12350c + ", startFrame=" + this.f12352e + ", endFrame=" + this.f12353f + ", interpolator=" + this.f12351d + '}';
    }

    public a(T t7) {
        this.f12354g = f12346o;
        this.f12355h = f12346o;
        this.f12356i = f12347p;
        this.f12357j = f12347p;
        this.f12358k = Float.MIN_VALUE;
        this.f12359l = Float.MIN_VALUE;
        this.f12360m = null;
        this.f12361n = null;
        this.f12348a = null;
        this.f12349b = t7;
        this.f12350c = t7;
        this.f12351d = null;
        this.f12352e = Float.MIN_VALUE;
        this.f12353f = Float.valueOf(Float.MAX_VALUE);
    }
}
