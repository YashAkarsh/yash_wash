package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class c<T, K> implements m<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final m<T> f35106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final i5.l<T, K> f35107b;

    /* JADX WARN: Multi-variable type inference failed */
    public c(@a7.d m<? extends T> source, @a7.d i5.l<? super T, ? extends K> keySelector) {
        l0.p(source, "source");
        l0.p(keySelector, "keySelector");
        this.f35106a = source;
        this.f35107b = keySelector;
    }

    @Override // kotlin.sequences.m
    @a7.d
    public Iterator<T> iterator() {
        return new b(this.f35106a.iterator(), this.f35107b);
    }
}
