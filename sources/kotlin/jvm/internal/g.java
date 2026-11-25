package kotlin.jvm.internal;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
final class g extends kotlin.collections.u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final int[] f34851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f34852b;

    public g(@a7.d int[] array) {
        l0.p(array, "array");
        this.f34851a = array;
    }

    @Override // kotlin.collections.u0
    public int b() {
        try {
            int[] iArr = this.f34851a;
            int i7 = this.f34852b;
            this.f34852b = i7 + 1;
            return iArr[i7];
        } catch (ArrayIndexOutOfBoundsException e8) {
            this.f34852b--;
            throw new NoSuchElementException(e8.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f34852b < this.f34851a.length;
    }
}
