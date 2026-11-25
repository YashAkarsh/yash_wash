package kotlin.jvm.internal;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
final class d extends kotlin.collections.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final char[] f34845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f34846b;

    public d(@a7.d char[] array) {
        l0.p(array, "array");
        this.f34845a = array;
    }

    @Override // kotlin.collections.u
    public char b() {
        try {
            char[] cArr = this.f34845a;
            int i7 = this.f34846b;
            this.f34846b = i7 + 1;
            return cArr[i7];
        } catch (ArrayIndexOutOfBoundsException e8) {
            this.f34846b--;
            throw new NoSuchElementException(e8.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f34846b < this.f34845a.length;
    }
}
