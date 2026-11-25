package kotlinx.coroutines.test;

import a7.d;
import i5.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.b1;
import kotlin.jvm.internal.l0;
import kotlin.k;
import kotlin.l2;
import kotlin.m;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    @k(level = m.ERROR, message = "This API has been deprecated to integrate with Structured Concurrency.", replaceWith = @b1(expression = "testContext.runBlockingTest(testBody)", imports = {"kotlin.coroutines.test"}))
    public static final void a(@d a aVar, @d l<? super a, l2> lVar) {
        lVar.z(aVar);
        List<Throwable> listG = aVar.G();
        boolean z7 = true;
        if (!(listG instanceof Collection) || !listG.isEmpty()) {
            Iterator<T> it = listG.iterator();
            while (it.hasNext()) {
                if (!(((Throwable) it.next()) instanceof CancellationException)) {
                    z7 = false;
                    break;
                }
            }
        }
        if (!z7) {
            throw new AssertionError(l0.C("Coroutine encountered unhandled exceptions:\n", aVar.G()));
        }
    }

    public static /* synthetic */ void b(a aVar, l lVar, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            aVar = new a(null, 1, null);
        }
        a(aVar, lVar);
    }
}
