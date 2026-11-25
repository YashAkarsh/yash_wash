package androidx.test.internal.runner.junit3;

import junit.framework.h;
import junit.framework.i;
import junit.framework.j;
import junit.framework.m;

/* JADX INFO: loaded from: classes.dex */
class NonExecutingTestResult extends DelegatingTestResult {
    NonExecutingTestResult(m wrappedResult) {
        super(wrappedResult);
    }

    @Override // junit.framework.m
    protected void k(final j test) {
        o(test);
        e(test);
    }

    @Override // androidx.test.internal.runner.junit3.DelegatingTestResult, junit.framework.m
    public void m(i test, h p7) {
    }
}
