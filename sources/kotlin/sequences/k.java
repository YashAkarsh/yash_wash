package kotlin.sequences;

import java.util.Iterator;
import kotlin.collections.r0;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class k<T> implements m<r0<? extends T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final m<T> f35137a;

    public static final class a implements Iterator<r0<? extends T>>, j5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        private final Iterator<T> f35138a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f35139b;

        a(k<T> kVar) {
            this.f35138a = ((k) kVar).f35137a.iterator();
        }

        public final int a() {
            return this.f35139b;
        }

        @a7.d
        public final Iterator<T> b() {
            return this.f35138a;
        }

        @Override // java.util.Iterator
        @a7.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public r0<T> next() {
            int i7 = this.f35139b;
            this.f35139b = i7 + 1;
            if (i7 < 0) {
                kotlin.collections.y.X();
            }
            return new r0<>(i7, this.f35138a.next());
        }

        public final void e(int i7) {
            this.f35139b = i7;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f35138a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(@a7.d m<? extends T> sequence) {
        l0.p(sequence, "sequence");
        this.f35137a = sequence;
    }

    @Override // kotlin.sequences.m
    @a7.d
    public Iterator<r0<T>> iterator() {
        return new a(this);
    }
}
