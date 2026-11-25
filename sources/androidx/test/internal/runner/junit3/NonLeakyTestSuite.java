package androidx.test.internal.runner.junit3;

import junit.framework.i;
import junit.framework.m;
import junit.framework.n;
import org.junit.k;
import org.junit.runner.b;
import org.junit.runner.c;

/* JADX INFO: loaded from: classes.dex */
@k
public class NonLeakyTestSuite extends n {

    private static class NonLeakyTest implements i, b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private i f10132a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final c f10133b;

        NonLeakyTest(i delegate) {
            this.f10132a = delegate;
            this.f10133b = JUnit38ClassRunner.j(delegate);
        }

        @Override // junit.framework.i
        public int a() {
            i iVar = this.f10132a;
            if (iVar != null) {
                return iVar.a();
            }
            return 0;
        }

        @Override // org.junit.runner.b
        public c b() {
            return this.f10133b;
        }

        @Override // junit.framework.i
        public void c(m result) {
            this.f10132a.c(result);
            this.f10132a = null;
        }

        public String toString() {
            i iVar = this.f10132a;
            return iVar != null ? iVar.toString() : this.f10133b.toString();
        }
    }

    public NonLeakyTestSuite(Class<?> testClass) {
        super(testClass);
    }

    @Override // junit.framework.n
    public void b(i test) {
        super.b(new NonLeakyTest(test));
    }
}
