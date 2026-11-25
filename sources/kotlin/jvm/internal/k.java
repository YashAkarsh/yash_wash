package kotlin.jvm.internal;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
final class k extends kotlin.collections.v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final long[] f34862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f34863b;

    public k(@a7.d long[] array) {
        l0.p(array, "array");
        this.f34862a = array;
    }

    @Override // kotlin.collections.v0
    public long b() {
        try {
            long[] jArr = this.f34862a;
            int i7 = this.f34863b;
            this.f34863b = i7 + 1;
            return jArr[i7];
        } catch (ArrayIndexOutOfBoundsException e8) {
            this.f34863b--;
            throw new NoSuchElementException(e8.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f34863b < this.f34862a.length;
    }
}
