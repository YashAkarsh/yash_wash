package com.google.android.material.bottomappbar;

import c.m0;
import c.v;
import c.x0;
import com.google.android.material.shape.g;
import com.google.android.material.shape.q;

/* JADX INFO: loaded from: classes.dex */
public class a extends g implements Cloneable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f17104g = 90;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f17105h = 180;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f17106i = 270;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f17107j = 180;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final float f17108k = 1.75f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f17109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f17110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f17111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f17112d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f17113e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f17114f = -1.0f;

    public a(float f8, float f9, float f10) {
        this.f17110b = f8;
        this.f17109a = f9;
        o(f10);
        this.f17113e = 0.0f;
    }

    @Override // com.google.android.material.shape.g
    public void g(float f8, float f9, float f10, @m0 q qVar) {
        float f11;
        float f12;
        float f13 = this.f17111c;
        if (f13 == 0.0f) {
            qVar.n(f8, 0.0f);
            return;
        }
        float f14 = ((this.f17110b * 2.0f) + f13) / 2.0f;
        float f15 = f10 * this.f17109a;
        float f16 = f9 + this.f17113e;
        float f17 = (this.f17112d * f10) + ((1.0f - f10) * f14);
        if (f17 / f14 >= 1.0f) {
            qVar.n(f8, 0.0f);
            return;
        }
        float f18 = this.f17114f;
        float f19 = f18 * f10;
        boolean z7 = f18 == -1.0f || Math.abs((f18 * 2.0f) - f13) < 0.1f;
        if (z7) {
            f11 = f17;
            f12 = 0.0f;
        } else {
            f12 = f17108k;
            f11 = 0.0f;
        }
        float f20 = f14 + f15;
        float f21 = f11 + f15;
        float fSqrt = (float) Math.sqrt((f20 * f20) - (f21 * f21));
        float f22 = f16 - fSqrt;
        float f23 = f16 + fSqrt;
        float degrees = (float) Math.toDegrees(Math.atan(fSqrt / f21));
        float f24 = (90.0f - degrees) + f12;
        qVar.n(f22, 0.0f);
        float f25 = f15 * 2.0f;
        qVar.a(f22 - f15, 0.0f, f22 + f15, f25, 270.0f, degrees);
        if (z7) {
            qVar.a(f16 - f14, (-f14) - f11, f16 + f14, f14 - f11, 180.0f - f24, (f24 * 2.0f) - 180.0f);
        } else {
            float f26 = this.f17110b;
            float f27 = f19 * 2.0f;
            float f28 = f16 - f14;
            qVar.a(f28, -(f19 + f26), f28 + f26 + f27, f26 + f19, 180.0f - f24, ((f24 * 2.0f) - 180.0f) / 2.0f);
            float f29 = f16 + f14;
            float f30 = this.f17110b;
            qVar.n(f29 - ((f30 / 2.0f) + f19), f30 + f19);
            float f31 = this.f17110b;
            qVar.a(f29 - (f27 + f31), -(f19 + f31), f29, f31 + f19, 90.0f, f24 - 90.0f);
        }
        qVar.a(f23 - f15, 0.0f, f23 + f15, f25, 270.0f - degrees, degrees);
        qVar.n(f8, 0.0f);
    }

    float i() {
        return this.f17112d;
    }

    public float j() {
        return this.f17114f;
    }

    float k() {
        return this.f17110b;
    }

    float l() {
        return this.f17109a;
    }

    @x0({x0.a.LIBRARY_GROUP})
    public float m() {
        return this.f17111c;
    }

    @x0({x0.a.LIBRARY_GROUP})
    public float n() {
        return this.f17113e;
    }

    void o(@v(from = 0.0d) float f8) {
        if (f8 < 0.0f) {
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
        this.f17112d = f8;
    }

    public void p(float f8) {
        this.f17114f = f8;
    }

    void q(float f8) {
        this.f17110b = f8;
    }

    void r(float f8) {
        this.f17109a = f8;
    }

    @x0({x0.a.LIBRARY_GROUP})
    public void s(float f8) {
        this.f17111c = f8;
    }

    void t(float f8) {
        this.f17113e = f8;
    }
}
