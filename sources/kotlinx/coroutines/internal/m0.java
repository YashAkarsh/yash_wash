package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes3.dex */
public final class m0<T> {

    @a7.d
    private volatile AtomicReferenceArray<T> array;

    public m0(int i7) {
        this.array = new AtomicReferenceArray<>(i7);
    }

    public final int a() {
        return this.array.length();
    }

    @a7.e
    public final T b(int i7) {
        AtomicReferenceArray<T> atomicReferenceArray = this.array;
        if (i7 < atomicReferenceArray.length()) {
            return atomicReferenceArray.get(i7);
        }
        return null;
    }

    public final void c(int i7, @a7.e T t7) {
        AtomicReferenceArray<T> atomicReferenceArray = this.array;
        int length = atomicReferenceArray.length();
        if (i7 < length) {
            atomicReferenceArray.set(i7, t7);
            return;
        }
        AtomicReferenceArray<T> atomicReferenceArray2 = new AtomicReferenceArray<>(kotlin.ranges.q.n(i7 + 1, length * 2));
        for (int i8 = 0; i8 < length; i8++) {
            atomicReferenceArray2.set(i8, atomicReferenceArray.get(i8));
        }
        atomicReferenceArray2.set(i7, t7);
        this.array = atomicReferenceArray2;
    }
}
