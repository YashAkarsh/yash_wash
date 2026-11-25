package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class i<T, R, E> implements m<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final m<T> f35126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final i5.l<T, R> f35127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    private final i5.l<R, Iterator<E>> f35128c;

    public static final class a implements Iterator<E>, j5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        private final Iterator<T> f35129a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @a7.e
        private Iterator<? extends E> f35130b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ i<T, R, E> f35131c;

        a(i<T, R, E> iVar) {
            this.f35131c = iVar;
            this.f35129a = ((i) iVar).f35126a.iterator();
        }

        private final boolean a() {
            Iterator<? extends E> it = this.f35130b;
            if ((it == null || it.hasNext()) ? false : true) {
                this.f35130b = null;
            }
            while (this.f35130b == null) {
                if (!this.f35129a.hasNext()) {
                    return false;
                }
                Iterator<? extends E> it2 = (Iterator) ((i) this.f35131c).f35128c.z(((i) this.f35131c).f35127b.z(this.f35129a.next()));
                if (it2.hasNext()) {
                    this.f35130b = it2;
                    break;
                }
            }
            return true;
        }

        @a7.e
        public final Iterator<E> b() {
            return this.f35130b;
        }

        @a7.d
        public final Iterator<T> d() {
            return this.f35129a;
        }

        public final void e(@a7.e Iterator<? extends E> it) {
            this.f35130b = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return a();
        }

        @Override // java.util.Iterator
        public E next() {
            if (!a()) {
                throw new NoSuchElementException();
            }
            Iterator<? extends E> it = this.f35130b;
            l0.m(it);
            return it.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(@a7.d m<? extends T> sequence, @a7.d i5.l<? super T, ? extends R> transformer, @a7.d i5.l<? super R, ? extends Iterator<? extends E>> iterator) {
        l0.p(sequence, "sequence");
        l0.p(transformer, "transformer");
        l0.p(iterator, "iterator");
        this.f35126a = sequence;
        this.f35127b = transformer;
        this.f35128c = iterator;
    }

    @Override // kotlin.sequences.m
    @a7.d
    public Iterator<E> iterator() {
        return new a(this);
    }
}
