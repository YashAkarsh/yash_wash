package com.google.android.gms.tasks;

/* JADX INFO: loaded from: classes.dex */
public class n<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s0<TResult> f16807a = new s0<>();

    public n() {
    }

    @c.m0
    public m<TResult> a() {
        return this.f16807a;
    }

    public void b(@c.m0 Exception exc) {
        this.f16807a.y(exc);
    }

    public void c(@c.o0 TResult tresult) {
        this.f16807a.z(tresult);
    }

    public boolean d(@c.m0 Exception exc) {
        return this.f16807a.B(exc);
    }

    public boolean e(@c.o0 TResult tresult) {
        return this.f16807a.C(tresult);
    }

    public n(@c.m0 a aVar) {
        aVar.b(new o0(this));
    }
}
