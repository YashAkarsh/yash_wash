package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class l<T1, T2, V> implements m<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final m<T1> f35140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final m<T2> f35141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    private final i5.p<T1, T2, V> f35142c;

    public static final class a implements Iterator<V>, j5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        private final Iterator<T1> f35143a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @a7.d
        private final Iterator<T2> f35144b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ l<T1, T2, V> f35145c;

        a(l<T1, T2, V> lVar) {
            this.f35145c = lVar;
            this.f35143a = ((l) lVar).f35140a.iterator();
            this.f35144b = ((l) lVar).f35141b.iterator();
        }

        @a7.d
        public final Iterator<T1> a() {
            return this.f35143a;
        }

        @a7.d
        public final Iterator<T2> b() {
            return this.f35144b;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f35143a.hasNext() && this.f35144b.hasNext();
        }

        @Override // java.util.Iterator
        public V next() {
            return (V) ((l) this.f35145c).f35142c.a0(this.f35143a.next(), this.f35144b.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(@a7.d m<? extends T1> sequence1, @a7.d m<? extends T2> sequence2, @a7.d i5.p<? super T1, ? super T2, ? extends V> transform) {
        l0.p(sequence1, "sequence1");
        l0.p(sequence2, "sequence2");
        l0.p(transform, "transform");
        this.f35140a = sequence1;
        this.f35141b = sequence2;
        this.f35142c = transform;
    }

    @Override // kotlin.sequences.m
    @a7.d
    public Iterator<V> iterator() {
        return new a(this);
    }
}
