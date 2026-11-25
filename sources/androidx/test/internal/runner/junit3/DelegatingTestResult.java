package androidx.test.internal.runner.junit3;

import java.util.Enumeration;
import junit.framework.b;
import junit.framework.h;
import junit.framework.i;
import junit.framework.k;
import junit.framework.l;
import junit.framework.m;

/* JADX INFO: loaded from: classes.dex */
class DelegatingTestResult extends m {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private m f10126f;

    DelegatingTestResult(m wrappedResult) {
        this.f10126f = wrappedResult;
    }

    @Override // junit.framework.m
    public void a(i test, Throwable t7) {
        this.f10126f.a(test, t7);
    }

    @Override // junit.framework.m
    public void b(i test, b t7) {
        this.f10126f.b(test, t7);
    }

    @Override // junit.framework.m
    public void c(l listener) {
        this.f10126f.c(listener);
    }

    @Override // junit.framework.m
    public void e(i test) {
        this.f10126f.e(test);
    }

    @Override // junit.framework.m
    public int f() {
        return this.f10126f.f();
    }

    @Override // junit.framework.m
    public Enumeration<k> g() {
        return this.f10126f.g();
    }

    @Override // junit.framework.m
    public int h() {
        return this.f10126f.h();
    }

    @Override // junit.framework.m
    public Enumeration<k> i() {
        return this.f10126f.i();
    }

    @Override // junit.framework.m
    public void j(l listener) {
        this.f10126f.j(listener);
    }

    @Override // junit.framework.m
    public int l() {
        return this.f10126f.l();
    }

    @Override // junit.framework.m
    public void m(final i test, h p7) {
        this.f10126f.m(test, p7);
    }

    @Override // junit.framework.m
    public boolean n() {
        return this.f10126f.n();
    }

    @Override // junit.framework.m
    public void o(i test) {
        this.f10126f.o(test);
    }

    @Override // junit.framework.m
    public void p() {
        this.f10126f.p();
    }

    @Override // junit.framework.m
    public boolean q() {
        return this.f10126f.q();
    }
}
