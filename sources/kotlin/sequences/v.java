package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class v<T> implements m<T>, e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final m<T> f35249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f35250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f35251c;

    public static final class a implements Iterator<T>, j5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        private final Iterator<T> f35252a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f35253b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ v<T> f35254c;

        a(v<T> vVar) {
            this.f35254c = vVar;
            this.f35252a = ((v) vVar).f35249a.iterator();
        }

        private final void a() {
            while (this.f35253b < ((v) this.f35254c).f35250b && this.f35252a.hasNext()) {
                this.f35252a.next();
                this.f35253b++;
            }
        }

        @a7.d
        public final Iterator<T> b() {
            return this.f35252a;
        }

        public final int d() {
            return this.f35253b;
        }

        public final void e(int i7) {
            this.f35253b = i7;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.f35253b < ((v) this.f35254c).f35251c && this.f35252a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            a();
            if (this.f35253b >= ((v) this.f35254c).f35251c) {
                throw new NoSuchElementException();
            }
            this.f35253b++;
            return this.f35252a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public v(@a7.d m<? extends T> sequence, int i7, int i8) {
        l0.p(sequence, "sequence");
        this.f35249a = sequence;
        this.f35250b = i7;
        this.f35251c = i8;
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException(("startIndex should be non-negative, but is " + i7).toString());
        }
        if (!(i8 >= 0)) {
            throw new IllegalArgumentException(("endIndex should be non-negative, but is " + i8).toString());
        }
        if (i8 >= i7) {
            return;
        }
        throw new IllegalArgumentException(("endIndex should be not less than startIndex, but was " + i8 + " < " + i7).toString());
    }

    private final int f() {
        return this.f35251c - this.f35250b;
    }

    @Override // kotlin.sequences.e
    @a7.d
    public m<T> a(int i7) {
        if (i7 >= f()) {
            return this;
        }
        m<T> mVar = this.f35249a;
        int i8 = this.f35250b;
        return new v(mVar, i8, i7 + i8);
    }

    @Override // kotlin.sequences.e
    @a7.d
    public m<T> b(int i7) {
        return i7 >= f() ? s.g() : new v(this.f35249a, this.f35250b + i7, this.f35251c);
    }

    @Override // kotlin.sequences.m
    @a7.d
    public Iterator<T> iterator() {
        return new a(this);
    }
}
