package androidx.concurrent.futures;

import c.o0;
import c.x0;
import com.google.common.util.concurrent.l1;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
public final class e<V> extends a<V> {
    private e() {
    }

    public static <V> e<V> u() {
        return new e<>();
    }

    @Override // androidx.concurrent.futures.a
    public boolean p(@o0 V v7) {
        return super.p(v7);
    }

    @Override // androidx.concurrent.futures.a
    public boolean q(Throwable th) {
        return super.q(th);
    }

    @Override // androidx.concurrent.futures.a
    public boolean r(l1<? extends V> l1Var) {
        return super.r(l1Var);
    }
}
