package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;

/* JADX INFO: loaded from: classes.dex */
public final class j extends b<j> {

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static final float f7422J = Float.MAX_VALUE;
    private k G;
    private float H;
    private boolean I;

    public j(h hVar) {
        super(hVar);
        this.G = null;
        this.H = Float.MAX_VALUE;
        this.I = false;
    }

    private void C() {
        k kVar = this.G;
        if (kVar == null) {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
        double d8 = kVar.d();
        if (d8 > this.f7404g) {
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        if (d8 < this.f7405h) {
            throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
        }
    }

    public boolean A() {
        return this.G.f7434b > 0.0d;
    }

    public k B() {
        return this.G;
    }

    public j D(k kVar) {
        this.G = kVar;
        return this;
    }

    public void E() {
        if (!A()) {
            throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        if (this.f7403f) {
            this.I = true;
        }
    }

    @Override // androidx.dynamicanimation.animation.b
    float f(float f8, float f9) {
        return this.G.b(f8, f9);
    }

    @Override // androidx.dynamicanimation.animation.b
    boolean j(float f8, float f9) {
        return this.G.a(f8, f9);
    }

    @Override // androidx.dynamicanimation.animation.b
    void v(float f8) {
    }

    @Override // androidx.dynamicanimation.animation.b
    public void w() {
        C();
        this.G.j(i());
        super.w();
    }

    @Override // androidx.dynamicanimation.animation.b
    boolean y(long j7) {
        if (this.I) {
            float f8 = this.H;
            if (f8 != Float.MAX_VALUE) {
                this.G.h(f8);
                this.H = Float.MAX_VALUE;
            }
            this.f7399b = this.G.d();
            this.f7398a = 0.0f;
            this.I = false;
            return true;
        }
        if (this.H != Float.MAX_VALUE) {
            this.G.d();
            long j8 = j7 / 2;
            b.p pVarK = this.G.k(this.f7399b, this.f7398a, j8);
            this.G.h(this.H);
            this.H = Float.MAX_VALUE;
            b.p pVarK2 = this.G.k(pVarK.f7412a, pVarK.f7413b, j8);
            this.f7399b = pVarK2.f7412a;
            this.f7398a = pVarK2.f7413b;
        } else {
            b.p pVarK3 = this.G.k(this.f7399b, this.f7398a, j7);
            this.f7399b = pVarK3.f7412a;
            this.f7398a = pVarK3.f7413b;
        }
        float fMax = Math.max(this.f7399b, this.f7405h);
        this.f7399b = fMax;
        float fMin = Math.min(fMax, this.f7404g);
        this.f7399b = fMin;
        if (!j(fMin, this.f7398a)) {
            return false;
        }
        this.f7399b = this.G.d();
        this.f7398a = 0.0f;
        return true;
    }

    public void z(float f8) {
        if (k()) {
            this.H = f8;
            return;
        }
        if (this.G == null) {
            this.G = new k(f8);
        }
        this.G.h(f8);
        w();
    }

    public <K> j(K k7, g<K> gVar) {
        super(k7, gVar);
        this.G = null;
        this.H = Float.MAX_VALUE;
        this.I = false;
    }

    public <K> j(K k7, g<K> gVar, float f8) {
        super(k7, gVar);
        this.G = null;
        this.H = Float.MAX_VALUE;
        this.I = false;
        this.G = new k(f8);
    }
}
