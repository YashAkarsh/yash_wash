package kotlin.jvm.internal;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
final class l extends kotlin.collections.p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final short[] f34874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f34875b;

    public l(@a7.d short[] array) {
        l0.p(array, "array");
        this.f34874a = array;
    }

    @Override // kotlin.collections.p1
    public short b() {
        try {
            short[] sArr = this.f34874a;
            int i7 = this.f34875b;
            this.f34875b = i7 + 1;
            return sArr[i7];
        } catch (ArrayIndexOutOfBoundsException e8) {
            this.f34875b--;
            throw new NoSuchElementException(e8.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f34875b < this.f34874a.length;
    }
}
