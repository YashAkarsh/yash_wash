package androidx.test.internal.runner.junit3;

import java.util.Enumeration;
import junit.framework.i;
import junit.framework.m;
import junit.framework.n;
import org.junit.k;

/* JADX INFO: loaded from: classes.dex */
@k
class DelegatingTestSuite extends n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private n f10127c;

    public DelegatingTestSuite(n suiteDelegate) {
        this.f10127c = suiteDelegate;
    }

    @Override // junit.framework.n, junit.framework.i
    public int a() {
        return this.f10127c.a();
    }

    @Override // junit.framework.n
    public void b(i test) {
        this.f10127c.b(test);
    }

    @Override // junit.framework.n, junit.framework.i
    public void c(m result) {
        this.f10127c.c(result);
    }

    @Override // junit.framework.n
    public String j() {
        return this.f10127c.j();
    }

    @Override // junit.framework.n
    public void n(i test, m result) {
        this.f10127c.n(test, result);
    }

    @Override // junit.framework.n
    public void o(String name) {
        this.f10127c.o(name);
    }

    @Override // junit.framework.n
    public i p(int index) {
        return this.f10127c.p(index);
    }

    @Override // junit.framework.n
    public int r() {
        return this.f10127c.r();
    }

    @Override // junit.framework.n
    public Enumeration<i> s() {
        return this.f10127c.s();
    }

    @Override // junit.framework.n
    public String toString() {
        return this.f10127c.toString();
    }

    public n u() {
        return this.f10127c;
    }

    public void v(n newSuiteDelegate) {
        this.f10127c = newSuiteDelegate;
    }
}
