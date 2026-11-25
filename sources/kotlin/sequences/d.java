package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.l0;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class d<T> implements m<T>, e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final m<T> f35108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f35109b;

    public static final class a implements Iterator<T>, j5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        private final Iterator<T> f35110a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f35111b;

        a(d<T> dVar) {
            this.f35110a = ((d) dVar).f35108a.iterator();
            this.f35111b = ((d) dVar).f35109b;
        }

        private final void a() {
            while (this.f35111b > 0 && this.f35110a.hasNext()) {
                this.f35110a.next();
                this.f35111b--;
            }
        }

        @a7.d
        public final Iterator<T> b() {
            return this.f35110a;
        }

        public final int d() {
            return this.f35111b;
        }

        public final void e(int i7) {
            this.f35111b = i7;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.f35110a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            a();
            return this.f35110a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(@a7.d m<? extends T> sequence, int i7) {
        l0.p(sequence, "sequence");
        this.f35108a = sequence;
        this.f35109b = i7;
        if (i7 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i7 + ClassUtils.PACKAGE_SEPARATOR_CHAR).toString());
    }

    @Override // kotlin.sequences.e
    @a7.d
    public m<T> a(int i7) {
        int i8 = this.f35109b;
        int i9 = i8 + i7;
        return i9 < 0 ? new w(this, i7) : new v(this.f35108a, i8, i9);
    }

    @Override // kotlin.sequences.e
    @a7.d
    public m<T> b(int i7) {
        int i8 = this.f35109b + i7;
        return i8 < 0 ? new d(this, i7) : new d(this.f35108a, i8);
    }

    @Override // kotlin.sequences.m
    @a7.d
    public Iterator<T> iterator() {
        return new a(this);
    }
}
