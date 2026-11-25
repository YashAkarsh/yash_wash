package kotlin.jvm.internal;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
final class c extends kotlin.collections.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final byte[] f34839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f34840b;

    public c(@a7.d byte[] array) {
        l0.p(array, "array");
        this.f34839a = array;
    }

    @Override // kotlin.collections.t
    public byte b() {
        try {
            byte[] bArr = this.f34839a;
            int i7 = this.f34840b;
            this.f34840b = i7 + 1;
            return bArr[i7];
        } catch (ArrayIndexOutOfBoundsException e8) {
            this.f34840b--;
            throw new NoSuchElementException(e8.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f34840b < this.f34839a.length;
    }
}
