package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class y<T, R> implements m<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final m<T> f35265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final i5.p<Integer, T, R> f35266b;

    public static final class a implements Iterator<R>, j5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        private final Iterator<T> f35267a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f35268b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ y<T, R> f35269c;

        a(y<T, R> yVar) {
            this.f35269c = yVar;
            this.f35267a = ((y) yVar).f35265a.iterator();
        }

        public final int a() {
            return this.f35268b;
        }

        @a7.d
        public final Iterator<T> b() {
            return this.f35267a;
        }

        public final void d(int i7) {
            this.f35268b = i7;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f35267a.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            i5.p pVar = ((y) this.f35269c).f35266b;
            int i7 = this.f35268b;
            this.f35268b = i7 + 1;
            if (i7 < 0) {
                kotlin.collections.y.X();
            }
            return (R) pVar.a0(Integer.valueOf(i7), this.f35267a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public y(@a7.d m<? extends T> sequence, @a7.d i5.p<? super Integer, ? super T, ? extends R> transformer) {
        l0.p(sequence, "sequence");
        l0.p(transformer, "transformer");
        this.f35265a = sequence;
        this.f35266b = transformer;
    }

    @Override // kotlin.sequences.m
    @a7.d
    public Iterator<R> iterator() {
        return new a(this);
    }
}
