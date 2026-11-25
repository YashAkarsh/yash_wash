package kotlin.jvm.internal;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
final class e extends kotlin.collections.h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final double[] f34847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f34848b;

    public e(@a7.d double[] array) {
        l0.p(array, "array");
        this.f34847a = array;
    }

    @Override // kotlin.collections.h0
    public double b() {
        try {
            double[] dArr = this.f34847a;
            int i7 = this.f34848b;
            this.f34848b = i7 + 1;
            return dArr[i7];
        } catch (ArrayIndexOutOfBoundsException e8) {
            this.f34848b--;
            throw new NoSuchElementException(e8.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f34848b < this.f34847a.length;
    }
}
