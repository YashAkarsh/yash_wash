package kotlin.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
final class k1<T> extends c<T> implements RandomAccess {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final Object[] f34551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f34552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f34553d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f34554e;

    public static final class a extends b<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f34555c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f34556d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ k1<T> f34557e;

        a(k1<T> k1Var) {
            this.f34557e = k1Var;
            this.f34555c = k1Var.size();
            this.f34556d = ((k1) k1Var).f34553d;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.collections.b
        protected void a() {
            if (this.f34555c == 0) {
                b();
                return;
            }
            d(((k1) this.f34557e).f34551b[this.f34556d]);
            this.f34556d = (this.f34556d + 1) % ((k1) this.f34557e).f34552c;
            this.f34555c--;
        }
    }

    public k1(@a7.d Object[] buffer, int i7) {
        kotlin.jvm.internal.l0.p(buffer, "buffer");
        this.f34551b = buffer;
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + i7).toString());
        }
        if (i7 <= buffer.length) {
            this.f34552c = buffer.length;
            this.f34554e = i7;
            return;
        }
        throw new IllegalArgumentException(("ring buffer filled size: " + i7 + " cannot be larger than the buffer size: " + buffer.length).toString());
    }

    private final int j(int i7, int i8) {
        return (i7 + i8) % this.f34552c;
    }

    @Override // kotlin.collections.c, kotlin.collections.a
    public int a() {
        return this.f34554e;
    }

    public final void g(T t7) {
        if (isFull()) {
            throw new IllegalStateException("ring buffer is full");
        }
        this.f34551b[(this.f34553d + size()) % this.f34552c] = t7;
        this.f34554e = size() + 1;
    }

    @Override // kotlin.collections.c, java.util.List
    public T get(int i7) {
        c.f34509a.b(i7, size());
        return (T) this.f34551b[(this.f34553d + i7) % this.f34552c];
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.d
    public final k1<T> h(int i7) {
        Object[] array;
        int i8 = this.f34552c;
        int iU = kotlin.ranges.q.u(i8 + (i8 >> 1) + 1, i7);
        if (this.f34553d == 0) {
            array = Arrays.copyOf(this.f34551b, iU);
            kotlin.jvm.internal.l0.o(array, "copyOf(this, newSize)");
        } else {
            array = toArray(new Object[iU]);
        }
        return new k1<>(array, size());
    }

    public final boolean isFull() {
        return size() == this.f34552c;
    }

    @Override // kotlin.collections.c, kotlin.collections.a, java.util.Collection, java.lang.Iterable
    @a7.d
    public Iterator<T> iterator() {
        return new a(this);
    }

    public final void k(int i7) {
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException(("n shouldn't be negative but it is " + i7).toString());
        }
        if (!(i7 <= size())) {
            throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + i7 + ", size = " + size()).toString());
        }
        if (i7 > 0) {
            int i8 = this.f34553d;
            int i9 = (i8 + i7) % this.f34552c;
            if (i8 > i9) {
                o.n2(this.f34551b, null, i8, this.f34552c);
                o.n2(this.f34551b, null, 0, i9);
            } else {
                o.n2(this.f34551b, null, i8, i9);
            }
            this.f34553d = i9;
            this.f34554e = size() - i7;
        }
    }

    @Override // kotlin.collections.a, java.util.Collection
    @a7.d
    public <T> T[] toArray(@a7.d T[] array) {
        kotlin.jvm.internal.l0.p(array, "array");
        if (array.length < size()) {
            array = (T[]) Arrays.copyOf(array, size());
            kotlin.jvm.internal.l0.o(array, "copyOf(this, newSize)");
        }
        int size = size();
        int i7 = 0;
        int i8 = 0;
        for (int i9 = this.f34553d; i8 < size && i9 < this.f34552c; i9++) {
            array[i8] = this.f34551b[i9];
            i8++;
        }
        while (i8 < size) {
            array[i8] = this.f34551b[i7];
            i8++;
            i7++;
        }
        if (array.length > size()) {
            array[size()] = null;
        }
        kotlin.jvm.internal.l0.n(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.RingBuffer.toArray>");
        return array;
    }

    public k1(int i7) {
        this(new Object[i7], 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.a, java.util.Collection
    @a7.d
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
