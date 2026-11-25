package kotlin.collections;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class s0<T> implements Iterable<r0<? extends T>>, j5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final i5.a<Iterator<T>> f34619a;

    /* JADX WARN: Multi-variable type inference failed */
    public s0(@a7.d i5.a<? extends Iterator<? extends T>> iteratorFactory) {
        kotlin.jvm.internal.l0.p(iteratorFactory, "iteratorFactory");
        this.f34619a = iteratorFactory;
    }

    @Override // java.lang.Iterable
    @a7.d
    public Iterator<r0<T>> iterator() {
        return new t0(this.f34619a.invoke());
    }
}
