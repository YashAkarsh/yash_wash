package kotlin.sequences;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class a<T> implements m<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final AtomicReference<m<T>> f35102a;

    public a(@a7.d m<? extends T> sequence) {
        l0.p(sequence, "sequence");
        this.f35102a = new AtomicReference<>(sequence);
    }

    @Override // kotlin.sequences.m
    @a7.d
    public Iterator<T> iterator() {
        m<T> andSet = this.f35102a.getAndSet(null);
        if (andSet != null) {
            return andSet.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
