package com.airbnb.lottie.utils;

import android.view.Choreographer;
import c.g1;
import c.j0;
import c.o0;
import c.v;

/* JADX INFO: loaded from: classes.dex */
public class g extends c implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @o0
    private com.airbnb.lottie.f f12334j;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f12327c = 1.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f12328d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f12329e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f12330f = 0.0f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f12331g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f12332h = -2.1474836E9f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f12333i = 2.1474836E9f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g1
    protected boolean f12335k = false;

    private void G() {
        if (this.f12334j == null) {
            return;
        }
        float f8 = this.f12330f;
        if (f8 < this.f12332h || f8 > this.f12333i) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.f12332h), Float.valueOf(this.f12333i), Float.valueOf(this.f12330f)));
        }
    }

    private float o() {
        com.airbnb.lottie.f fVar = this.f12334j;
        if (fVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / fVar.h()) / Math.abs(this.f12327c);
    }

    private boolean s() {
        return r() < 0.0f;
    }

    public void A(com.airbnb.lottie.f fVar) {
        boolean z7 = this.f12334j == null;
        this.f12334j = fVar;
        if (z7) {
            D((int) Math.max(this.f12332h, fVar.p()), (int) Math.min(this.f12333i, fVar.f()));
        } else {
            D((int) fVar.p(), (int) fVar.f());
        }
        float f8 = this.f12330f;
        this.f12330f = 0.0f;
        B((int) f8);
        j();
    }

    public void B(float f8) {
        if (this.f12330f == f8) {
            return;
        }
        this.f12330f = i.b(f8, q(), p());
        this.f12329e = 0L;
        j();
    }

    public void C(float f8) {
        D(this.f12332h, f8);
    }

    public void D(float f8, float f9) {
        if (f8 > f9) {
            throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f8), Float.valueOf(f9)));
        }
        com.airbnb.lottie.f fVar = this.f12334j;
        float fP = fVar == null ? -3.4028235E38f : fVar.p();
        com.airbnb.lottie.f fVar2 = this.f12334j;
        float f10 = fVar2 == null ? Float.MAX_VALUE : fVar2.f();
        this.f12332h = i.b(f8, fP, f10);
        this.f12333i = i.b(f9, fP, f10);
        B((int) i.b(this.f12330f, f8, f9));
    }

    public void E(int i7) {
        D(i7, (int) this.f12333i);
    }

    public void F(float f8) {
        this.f12327c = f8;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    @j0
    public void cancel() {
        e();
        w();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j7) {
        v();
        if (this.f12334j == null || !isRunning()) {
            return;
        }
        com.airbnb.lottie.e.a("LottieValueAnimator#doFrame");
        long j8 = this.f12329e;
        float fO = (j8 != 0 ? j7 - j8 : 0L) / o();
        float f8 = this.f12330f;
        if (s()) {
            fO = -fO;
        }
        float f9 = f8 + fO;
        this.f12330f = f9;
        boolean z7 = !i.d(f9, q(), p());
        this.f12330f = i.b(this.f12330f, q(), p());
        this.f12329e = j7;
        j();
        if (z7) {
            if (getRepeatCount() == -1 || this.f12331g < getRepeatCount()) {
                h();
                this.f12331g++;
                if (getRepeatMode() == 2) {
                    this.f12328d = !this.f12328d;
                    z();
                } else {
                    this.f12330f = s() ? p() : q();
                }
                this.f12329e = j7;
            } else {
                this.f12330f = this.f12327c < 0.0f ? q() : p();
                w();
                g(s());
            }
        }
        G();
        com.airbnb.lottie.e.b("LottieValueAnimator#doFrame");
    }

    @Override // android.animation.ValueAnimator
    @v(from = 0.0d, to = 1.0d)
    public float getAnimatedFraction() {
        float fQ;
        float fP;
        float fQ2;
        if (this.f12334j == null) {
            return 0.0f;
        }
        if (s()) {
            fQ = p() - this.f12330f;
            fP = p();
            fQ2 = q();
        } else {
            fQ = this.f12330f - q();
            fP = p();
            fQ2 = q();
        }
        return fQ / (fP - fQ2);
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(m());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        com.airbnb.lottie.f fVar = this.f12334j;
        if (fVar == null) {
            return 0L;
        }
        return (long) fVar.d();
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.f12335k;
    }

    public void k() {
        this.f12334j = null;
        this.f12332h = -2.1474836E9f;
        this.f12333i = 2.1474836E9f;
    }

    @j0
    public void l() {
        w();
        g(s());
    }

    @v(from = 0.0d, to = 1.0d)
    public float m() {
        com.airbnb.lottie.f fVar = this.f12334j;
        if (fVar == null) {
            return 0.0f;
        }
        return (this.f12330f - fVar.p()) / (this.f12334j.f() - this.f12334j.p());
    }

    public float n() {
        return this.f12330f;
    }

    public float p() {
        com.airbnb.lottie.f fVar = this.f12334j;
        if (fVar == null) {
            return 0.0f;
        }
        float f8 = this.f12333i;
        return f8 == 2.1474836E9f ? fVar.f() : f8;
    }

    public float q() {
        com.airbnb.lottie.f fVar = this.f12334j;
        if (fVar == null) {
            return 0.0f;
        }
        float f8 = this.f12332h;
        return f8 == -2.1474836E9f ? fVar.p() : f8;
    }

    public float r() {
        return this.f12327c;
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i7) {
        super.setRepeatMode(i7);
        if (i7 == 2 || !this.f12328d) {
            return;
        }
        this.f12328d = false;
        z();
    }

    @j0
    public void t() {
        w();
    }

    @j0
    public void u() {
        this.f12335k = true;
        i(s());
        B((int) (s() ? p() : q()));
        this.f12329e = 0L;
        this.f12331g = 0;
        v();
    }

    protected void v() {
        if (isRunning()) {
            x(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @j0
    protected void w() {
        x(true);
    }

    @j0
    protected void x(boolean z7) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z7) {
            this.f12335k = false;
        }
    }

    @j0
    public void y() {
        this.f12335k = true;
        v();
        this.f12329e = 0L;
        if (s() && n() == q()) {
            this.f12330f = p();
        } else {
            if (s() || n() != p()) {
                return;
            }
            this.f12330f = q();
        }
    }

    public void z() {
        F(-r());
    }
}
