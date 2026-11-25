package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.l0;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class w<T> implements m<T>, e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final m<T> f35255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f35256b;

    public static final class a implements Iterator<T>, j5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f35257a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @a7.d
        private final Iterator<T> f35258b;

        a(w<T> wVar) {
            this.f35257a = ((w) wVar).f35256b;
            this.f35258b = ((w) wVar).f35255a.iterator();
        }

        @a7.d
        public final Iterator<T> a() {
            return this.f35258b;
        }

        public final int b() {
            return this.f35257a;
        }

        public final void d(int i7) {
            this.f35257a = i7;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f35257a > 0 && this.f35258b.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            int i7 = this.f35257a;
            if (i7 == 0) {
                throw new NoSuchElementException();
            }
            this.f35257a = i7 - 1;
            return this.f35258b.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public w(@a7.d m<? extends T> sequence, int i7) {
        l0.p(sequence, "sequence");
        this.f35255a = sequence;
        this.f35256b = i7;
        if (i7 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i7 + ClassUtils.PACKAGE_SEPARATOR_CHAR).toString());
    }

    @Override // kotlin.sequences.e
    @a7.d
    public m<T> a(int i7) {
        return i7 >= this.f35256b ? this : new w(this.f35255a, i7);
    }

    @Override // kotlin.sequences.e
    @a7.d
    public m<T> b(int i7) {
        int i8 = this.f35256b;
        return i7 >= i8 ? s.g() : new v(this.f35255a, i7, i8);
    }

    @Override // kotlin.sequences.m
    @a7.d
    public Iterator<T> iterator() {
        return new a(this);
    }
}
