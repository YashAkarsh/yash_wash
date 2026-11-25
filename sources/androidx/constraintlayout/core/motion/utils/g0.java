package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: loaded from: classes.dex */
public class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f2817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2819c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2820d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2821e;

    public void a(androidx.constraintlayout.core.motion.f fVar) {
        this.f2818b = fVar.l();
        this.f2819c = fVar.w();
        this.f2820d = fVar.q();
        this.f2821e = fVar.h();
        this.f2817a = (int) fVar.t();
    }

    public int b() {
        return this.f2821e - this.f2819c;
    }

    public int c() {
        return this.f2820d - this.f2818b;
    }
}
