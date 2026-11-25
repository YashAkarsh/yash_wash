package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class f<T> implements m<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final m<T> f35112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final i5.l<T, Boolean> f35113b;

    public static final class a implements Iterator<T>, j5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        private final Iterator<T> f35114a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f35115b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @a7.e
        private T f35116c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ f<T> f35117d;

        a(f<T> fVar) {
            this.f35117d = fVar;
            this.f35114a = ((f) fVar).f35112a.iterator();
        }

        private final void a() {
            while (this.f35114a.hasNext()) {
                T next = this.f35114a.next();
                if (!((Boolean) ((f) this.f35117d).f35113b.z(next)).booleanValue()) {
                    this.f35116c = next;
                    this.f35115b = 1;
                    return;
                }
            }
            this.f35115b = 0;
        }

        public final int b() {
            return this.f35115b;
        }

        @a7.d
        public final Iterator<T> d() {
            return this.f35114a;
        }

        @a7.e
        public final T e() {
            return this.f35116c;
        }

        public final void f(int i7) {
            this.f35115b = i7;
        }

        public final void g(@a7.e T t7) {
            this.f35116c = t7;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f35115b == -1) {
                a();
            }
            return this.f35115b == 1 || this.f35114a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f35115b == -1) {
                a();
            }
            if (this.f35115b != 1) {
                return this.f35114a.next();
            }
            T t7 = this.f35116c;
            this.f35116c = null;
            this.f35115b = 0;
            return t7;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(@a7.d m<? extends T> sequence, @a7.d i5.l<? super T, Boolean> predicate) {
        l0.p(sequence, "sequence");
        l0.p(predicate, "predicate");
        this.f35112a = sequence;
        this.f35113b = predicate;
    }

    @Override // kotlin.sequences.m
    @a7.d
    public Iterator<T> iterator() {
        return new a(this);
    }
}
