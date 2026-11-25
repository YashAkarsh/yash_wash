package kotlin.jvm.internal;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
final class b extends kotlin.collections.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final boolean[] f34834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f34835b;

    public b(@a7.d boolean[] array) {
        l0.p(array, "array");
        this.f34834a = array;
    }

    @Override // kotlin.collections.r
    public boolean b() {
        try {
            boolean[] zArr = this.f34834a;
            int i7 = this.f34835b;
            this.f34835b = i7 + 1;
            return zArr[i7];
        } catch (ArrayIndexOutOfBoundsException e8) {
            this.f34835b--;
            throw new NoSuchElementException(e8.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f34835b < this.f34834a.length;
    }
}
