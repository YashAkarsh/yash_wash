package kotlin.jvm.internal;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
final class f extends kotlin.collections.m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final float[] f34849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f34850b;

    public f(@a7.d float[] array) {
        l0.p(array, "array");
        this.f34849a = array;
    }

    @Override // kotlin.collections.m0
    public float b() {
        try {
            float[] fArr = this.f34849a;
            int i7 = this.f34850b;
            this.f34850b = i7 + 1;
            return fArr[i7];
        } catch (ArrayIndexOutOfBoundsException e8) {
            this.f34850b--;
            throw new NoSuchElementException(e8.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f34850b < this.f34849a.length;
    }
}
