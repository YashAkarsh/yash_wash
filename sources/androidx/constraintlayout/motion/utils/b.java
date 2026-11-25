package androidx.constraintlayout.motion.utils;

import androidx.constraintlayout.core.motion.utils.p;
import androidx.constraintlayout.core.motion.utils.r;
import androidx.constraintlayout.core.motion.utils.s;
import androidx.constraintlayout.motion.widget.q;

/* JADX INFO: loaded from: classes.dex */
public class b extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private s f3815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private p f3816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private r f3817c;

    public b() {
        s sVar = new s();
        this.f3815a = sVar;
        this.f3817c = sVar;
    }

    @Override // androidx.constraintlayout.motion.widget.q
    public float a() {
        return this.f3817c.a();
    }

    public void b(float currentPos, float destination, float currentVelocity, float maxTime, float maxAcceleration, float maxVelocity) {
        s sVar = this.f3815a;
        this.f3817c = sVar;
        sVar.f(currentPos, destination, currentVelocity, maxTime, maxAcceleration, maxVelocity);
    }

    public String c(String desc, float time) {
        return this.f3817c.b(desc, time);
    }

    public float d(float x7) {
        return this.f3817c.c(x7);
    }

    public boolean e() {
        return this.f3817c.d();
    }

    public void f(float currentPos, float destination, float currentVelocity, float mass, float stiffness, float damping, float stopThreshold, int boundaryMode) {
        if (this.f3816b == null) {
            this.f3816b = new p();
        }
        p pVar = this.f3816b;
        this.f3817c = pVar;
        pVar.h(currentPos, destination, currentVelocity, mass, stiffness, damping, stopThreshold, boundaryMode);
    }

    @Override // androidx.constraintlayout.motion.widget.q, android.animation.TimeInterpolator
    public float getInterpolation(float v7) {
        return this.f3817c.getInterpolation(v7);
    }
}
