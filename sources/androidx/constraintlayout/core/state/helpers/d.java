package androidx.constraintlayout.core.state.helpers;

/* JADX INFO: loaded from: classes.dex */
public class d extends androidx.constraintlayout.core.state.c {

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    protected float f3345n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    protected androidx.constraintlayout.core.state.h.b f3346o0;

    public d(androidx.constraintlayout.core.state.h hVar, androidx.constraintlayout.core.state.h.e eVar) {
        super(hVar, eVar);
        this.f3345n0 = 0.5f;
        this.f3346o0 = androidx.constraintlayout.core.state.h.b.SPREAD;
    }

    @Override // androidx.constraintlayout.core.state.a
    /* JADX INFO: renamed from: P0, reason: merged with bridge method [inline-methods] */
    public d m(float f8) {
        this.f3345n0 = f8;
        return this;
    }

    public float Q0() {
        return this.f3345n0;
    }

    public androidx.constraintlayout.core.state.h.b R0() {
        return androidx.constraintlayout.core.state.h.b.SPREAD;
    }

    public d S0(androidx.constraintlayout.core.state.h.b bVar) {
        this.f3346o0 = bVar;
        return this;
    }
}
