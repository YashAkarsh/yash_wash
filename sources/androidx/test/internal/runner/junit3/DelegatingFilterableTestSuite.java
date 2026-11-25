package androidx.test.internal.runner.junit3;

import junit.framework.i;
import junit.framework.n;
import org.junit.k;
import org.junit.runner.c;
import org.junit.runner.manipulation.a;
import org.junit.runner.manipulation.b;

/* JADX INFO: loaded from: classes.dex */
@k
class DelegatingFilterableTestSuite extends DelegatingTestSuite implements b {
    public DelegatingFilterableTestSuite(n suiteDelegate) {
        super(suiteDelegate);
    }

    private static c w(i test) {
        return JUnit38ClassRunner.j(test);
    }

    @Override // org.junit.runner.manipulation.b
    public void d(a filter) throws org.junit.runner.manipulation.c {
        n nVarU = u();
        n nVar = new n(nVarU.j());
        int iR = nVarU.r();
        for (int i7 = 0; i7 < iR; i7++) {
            i iVarP = nVarU.p(i7);
            if (filter.e(w(iVarP))) {
                nVar.b(iVarP);
            }
        }
        v(nVar);
        if (nVar.r() == 0) {
            throw new org.junit.runner.manipulation.c();
        }
    }
}
