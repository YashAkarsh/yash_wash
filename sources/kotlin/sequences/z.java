package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class z<T, R> implements m<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final m<T> f35270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final i5.l<T, R> f35271b;

    public static final class a implements Iterator<R>, j5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        private final Iterator<T> f35272a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ z<T, R> f35273b;

        a(z<T, R> zVar) {
            this.f35273b = zVar;
            this.f35272a = ((z) zVar).f35270a.iterator();
        }

        @a7.d
        public final Iterator<T> a() {
            return this.f35272a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f35272a.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) ((z) this.f35273b).f35271b.z(this.f35272a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public z(@a7.d m<? extends T> sequence, @a7.d i5.l<? super T, ? extends R> transformer) {
        l0.p(sequence, "sequence");
        l0.p(transformer, "transformer");
        this.f35270a = sequence;
        this.f35271b = transformer;
    }

    @a7.d
    public final <E> m<E> e(@a7.d i5.l<? super R, ? extends Iterator<? extends E>> iterator) {
        l0.p(iterator, "iterator");
        return new i(this.f35270a, this.f35271b, iterator);
    }

    @Override // kotlin.sequences.m
    @a7.d
    public Iterator<R> iterator() {
        return new a(this);
    }
}
