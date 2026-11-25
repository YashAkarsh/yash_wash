package kotlin.collections;

import java.util.Iterator;
import kotlin.l2;

/* JADX INFO: loaded from: classes2.dex */
class b0 extends a0 {
    public static final <T> void e0(@a7.d Iterator<? extends T> it, @a7.d i5.l<? super T, l2> operation) {
        kotlin.jvm.internal.l0.p(it, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        while (it.hasNext()) {
            operation.z(it.next());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.internal.f
    private static final <T> Iterator<T> f0(Iterator<? extends T> it) {
        kotlin.jvm.internal.l0.p(it, "<this>");
        return it;
    }

    @a7.d
    public static final <T> Iterator<r0<T>> g0(@a7.d Iterator<? extends T> it) {
        kotlin.jvm.internal.l0.p(it, "<this>");
        return new t0(it);
    }
}
