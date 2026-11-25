package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
final class j<T> implements m<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final i5.a<T> f35132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final i5.l<T, T> f35133b;

    public static final class a implements Iterator<T>, j5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.e
        private T f35134a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f35135b = -2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ j<T> f35136c;

        a(j<T> jVar) {
            this.f35136c = jVar;
        }

        private final void a() {
            T t7;
            if (this.f35135b == -2) {
                t7 = (T) ((j) this.f35136c).f35132a.invoke();
            } else {
                i5.l lVar = ((j) this.f35136c).f35133b;
                T t8 = this.f35134a;
                l0.m(t8);
                t7 = (T) lVar.z(t8);
            }
            this.f35134a = t7;
            this.f35135b = t7 == null ? 0 : 1;
        }

        @a7.e
        public final T b() {
            return this.f35134a;
        }

        public final int d() {
            return this.f35135b;
        }

        public final void e(@a7.e T t7) {
            this.f35134a = t7;
        }

        public final void f(int i7) {
            this.f35135b = i7;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f35135b < 0) {
                a();
            }
            return this.f35135b == 1;
        }

        @Override // java.util.Iterator
        @a7.d
        public T next() {
            if (this.f35135b < 0) {
                a();
            }
            if (this.f35135b == 0) {
                throw new NoSuchElementException();
            }
            T t7 = this.f35134a;
            l0.n(t7, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
            this.f35135b = -1;
            return t7;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(@a7.d i5.a<? extends T> getInitialValue, @a7.d i5.l<? super T, ? extends T> getNextValue) {
        l0.p(getInitialValue, "getInitialValue");
        l0.p(getNextValue, "getNextValue");
        this.f35132a = getInitialValue;
        this.f35133b = getNextValue;
    }

    @Override // kotlin.sequences.m
    @a7.d
    public Iterator<T> iterator() {
        return new a(this);
    }
}
