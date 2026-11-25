package androidx.test.internal.runner.junit3;

import java.util.Enumeration;
import junit.framework.i;
import junit.framework.m;
import junit.framework.n;
import org.junit.k;
import org.junit.runner.manipulation.a;
import org.junit.runner.manipulation.c;

/* JADX INFO: loaded from: classes.dex */
@k
public class NonExecutingTestSuite extends DelegatingFilterableTestSuite {
    public NonExecutingTestSuite(Class<?> testClass) {
        this(new n(testClass));
    }

    @Override // androidx.test.internal.runner.junit3.DelegatingTestSuite, junit.framework.n, junit.framework.i
    public /* bridge */ /* synthetic */ int a() {
        return super.a();
    }

    @Override // androidx.test.internal.runner.junit3.DelegatingTestSuite, junit.framework.n
    public /* bridge */ /* synthetic */ void b(i test) {
        super.b(test);
    }

    @Override // androidx.test.internal.runner.junit3.DelegatingTestSuite, junit.framework.n, junit.framework.i
    public void c(m result) {
        super.c(new NonExecutingTestResult(result));
    }

    @Override // androidx.test.internal.runner.junit3.DelegatingFilterableTestSuite, org.junit.runner.manipulation.b
    public /* bridge */ /* synthetic */ void d(a filter) throws c {
        super.d(filter);
    }

    @Override // androidx.test.internal.runner.junit3.DelegatingTestSuite, junit.framework.n
    public /* bridge */ /* synthetic */ String j() {
        return super.j();
    }

    @Override // androidx.test.internal.runner.junit3.DelegatingTestSuite, junit.framework.n
    public /* bridge */ /* synthetic */ void n(i test, m result) {
        super.n(test, result);
    }

    @Override // androidx.test.internal.runner.junit3.DelegatingTestSuite, junit.framework.n
    public /* bridge */ /* synthetic */ void o(String name) {
        super.o(name);
    }

    @Override // androidx.test.internal.runner.junit3.DelegatingTestSuite, junit.framework.n
    public /* bridge */ /* synthetic */ i p(int index) {
        return super.p(index);
    }

    @Override // androidx.test.internal.runner.junit3.DelegatingTestSuite, junit.framework.n
    public /* bridge */ /* synthetic */ int r() {
        return super.r();
    }

    @Override // androidx.test.internal.runner.junit3.DelegatingTestSuite, junit.framework.n
    public /* bridge */ /* synthetic */ Enumeration s() {
        return super.s();
    }

    @Override // androidx.test.internal.runner.junit3.DelegatingTestSuite, junit.framework.n
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // androidx.test.internal.runner.junit3.DelegatingTestSuite
    public /* bridge */ /* synthetic */ n u() {
        return super.u();
    }

    @Override // androidx.test.internal.runner.junit3.DelegatingTestSuite
    public /* bridge */ /* synthetic */ void v(n newSuiteDelegate) {
        super.v(newSuiteDelegate);
    }

    public NonExecutingTestSuite(n s7) {
        super(s7);
    }
}
