package androidx.collection;

/* JADX INFO: loaded from: classes.dex */
public final class c<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private E[] f2272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f2274c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2275d;

    public c() {
        this(8);
    }

    private void d() {
        E[] eArr = this.f2272a;
        int length = eArr.length;
        int i7 = this.f2273b;
        int i8 = length - i7;
        int i9 = length << 1;
        if (i9 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }
        E[] eArr2 = (E[]) new Object[i9];
        System.arraycopy(eArr, i7, eArr2, 0, i8);
        System.arraycopy(this.f2272a, 0, eArr2, i8, this.f2273b);
        this.f2272a = eArr2;
        this.f2273b = 0;
        this.f2274c = length;
        this.f2275d = i9 - 1;
    }

    public void a(E e8) {
        int i7 = (this.f2273b - 1) & this.f2275d;
        this.f2273b = i7;
        this.f2272a[i7] = e8;
        if (i7 == this.f2274c) {
            d();
        }
    }

    public void b(E e8) {
        E[] eArr = this.f2272a;
        int i7 = this.f2274c;
        eArr[i7] = e8;
        int i8 = this.f2275d & (i7 + 1);
        this.f2274c = i8;
        if (i8 == this.f2273b) {
            d();
        }
    }

    public void c() {
        l(m());
    }

    public E e(int i7) {
        if (i7 < 0 || i7 >= m()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.f2272a[this.f2275d & (this.f2273b + i7)];
    }

    public E f() {
        int i7 = this.f2273b;
        if (i7 != this.f2274c) {
            return this.f2272a[i7];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public E g() {
        int i7 = this.f2273b;
        int i8 = this.f2274c;
        if (i7 != i8) {
            return this.f2272a[(i8 - 1) & this.f2275d];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public boolean h() {
        return this.f2273b == this.f2274c;
    }

    public E i() {
        int i7 = this.f2273b;
        if (i7 == this.f2274c) {
            throw new ArrayIndexOutOfBoundsException();
        }
        E[] eArr = this.f2272a;
        E e8 = eArr[i7];
        eArr[i7] = null;
        this.f2273b = (i7 + 1) & this.f2275d;
        return e8;
    }

    public E j() {
        int i7 = this.f2273b;
        int i8 = this.f2274c;
        if (i7 == i8) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i9 = this.f2275d & (i8 - 1);
        E[] eArr = this.f2272a;
        E e8 = eArr[i9];
        eArr[i9] = null;
        this.f2274c = i9;
        return e8;
    }

    public void k(int i7) {
        int i8;
        if (i7 <= 0) {
            return;
        }
        if (i7 > m()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i9 = this.f2274c;
        int i10 = i7 < i9 ? i9 - i7 : 0;
        int i11 = i10;
        while (true) {
            i8 = this.f2274c;
            if (i11 >= i8) {
                break;
            }
            this.f2272a[i11] = null;
            i11++;
        }
        int i12 = i8 - i10;
        int i13 = i7 - i12;
        this.f2274c = i8 - i12;
        if (i13 > 0) {
            int length = this.f2272a.length;
            this.f2274c = length;
            int i14 = length - i13;
            for (int i15 = i14; i15 < this.f2274c; i15++) {
                this.f2272a[i15] = null;
            }
            this.f2274c = i14;
        }
    }

    public void l(int i7) {
        if (i7 <= 0) {
            return;
        }
        if (i7 > m()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int length = this.f2272a.length;
        int i8 = this.f2273b;
        if (i7 < length - i8) {
            length = i8 + i7;
        }
        while (i8 < length) {
            this.f2272a[i8] = null;
            i8++;
        }
        int i9 = this.f2273b;
        int i10 = length - i9;
        int i11 = i7 - i10;
        this.f2273b = this.f2275d & (i9 + i10);
        if (i11 > 0) {
            for (int i12 = 0; i12 < i11; i12++) {
                this.f2272a[i12] = null;
            }
            this.f2273b = i11;
        }
    }

    public int m() {
        return (this.f2274c - this.f2273b) & this.f2275d;
    }

    public c(int i7) {
        if (i7 < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }
        if (i7 > 1073741824) {
            throw new IllegalArgumentException("capacity must be <= 2^30");
        }
        i7 = Integer.bitCount(i7) != 1 ? Integer.highestOneBit(i7 - 1) << 1 : i7;
        this.f2275d = i7 - 1;
        this.f2272a = (E[]) new Object[i7];
    }
}
