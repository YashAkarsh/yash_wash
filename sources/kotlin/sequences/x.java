package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class x<T> implements m<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final m<T> f35259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final i5.l<T, Boolean> f35260b;

    public static final class a implements Iterator<T>, j5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        private final Iterator<T> f35261a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f35262b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @a7.e
        private T f35263c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ x<T> f35264d;

        a(x<T> xVar) {
            this.f35264d = xVar;
            this.f35261a = ((x) xVar).f35259a.iterator();
        }

        private final void a() {
            if (this.f35261a.hasNext()) {
                T next = this.f35261a.next();
                if (((Boolean) ((x) this.f35264d).f35260b.z(next)).booleanValue()) {
                    this.f35262b = 1;
                    this.f35263c = next;
                    return;
                }
            }
            this.f35262b = 0;
        }

        @a7.d
        public final Iterator<T> b() {
            return this.f35261a;
        }

        @a7.e
        public final T d() {
            return this.f35263c;
        }

        public final int e() {
            return this.f35262b;
        }

        public final void f(@a7.e T t7) {
            this.f35263c = t7;
        }

        public final void g(int i7) {
            this.f35262b = i7;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f35262b == -1) {
                a();
            }
            return this.f35262b == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f35262b == -1) {
                a();
            }
            if (this.f35262b == 0) {
                throw new NoSuchElementException();
            }
            T t7 = this.f35263c;
            this.f35263c = null;
            this.f35262b = -1;
            return t7;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public x(@a7.d m<? extends T> sequence, @a7.d i5.l<? super T, Boolean> predicate) {
        l0.p(sequence, "sequence");
        l0.p(predicate, "predicate");
        this.f35259a = sequence;
        this.f35260b = predicate;
    }

    @Override // kotlin.sequences.m
    @a7.d
    public Iterator<T> iterator() {
        return new a(this);
    }
}
