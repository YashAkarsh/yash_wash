package androidx.collection;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f2276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f2278c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2279d;

    public d() {
        this(8);
    }

    private void d() {
        int[] iArr = this.f2276a;
        int length = iArr.length;
        int i7 = this.f2277b;
        int i8 = length - i7;
        int i9 = length << 1;
        if (i9 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }
        int[] iArr2 = new int[i9];
        System.arraycopy(iArr, i7, iArr2, 0, i8);
        System.arraycopy(this.f2276a, 0, iArr2, i8, this.f2277b);
        this.f2276a = iArr2;
        this.f2277b = 0;
        this.f2278c = length;
        this.f2279d = i9 - 1;
    }

    public void a(int i7) {
        int i8 = (this.f2277b - 1) & this.f2279d;
        this.f2277b = i8;
        this.f2276a[i8] = i7;
        if (i8 == this.f2278c) {
            d();
        }
    }

    public void b(int i7) {
        int[] iArr = this.f2276a;
        int i8 = this.f2278c;
        iArr[i8] = i7;
        int i9 = this.f2279d & (i8 + 1);
        this.f2278c = i9;
        if (i9 == this.f2277b) {
            d();
        }
    }

    public void c() {
        this.f2278c = this.f2277b;
    }

    public int e(int i7) {
        if (i7 < 0 || i7 >= m()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.f2276a[this.f2279d & (this.f2277b + i7)];
    }

    public int f() {
        int i7 = this.f2277b;
        if (i7 != this.f2278c) {
            return this.f2276a[i7];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int g() {
        int i7 = this.f2277b;
        int i8 = this.f2278c;
        if (i7 != i8) {
            return this.f2276a[(i8 - 1) & this.f2279d];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public boolean h() {
        return this.f2277b == this.f2278c;
    }

    public int i() {
        int i7 = this.f2277b;
        if (i7 == this.f2278c) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i8 = this.f2276a[i7];
        this.f2277b = (i7 + 1) & this.f2279d;
        return i8;
    }

    public int j() {
        int i7 = this.f2277b;
        int i8 = this.f2278c;
        if (i7 == i8) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i9 = this.f2279d & (i8 - 1);
        int i10 = this.f2276a[i9];
        this.f2278c = i9;
        return i10;
    }

    public void k(int i7) {
        if (i7 <= 0) {
            return;
        }
        if (i7 > m()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.f2278c = this.f2279d & (this.f2278c - i7);
    }

    public void l(int i7) {
        if (i7 <= 0) {
            return;
        }
        if (i7 > m()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.f2277b = this.f2279d & (this.f2277b + i7);
    }

    public int m() {
        return (this.f2278c - this.f2277b) & this.f2279d;
    }

    public d(int i7) {
        if (i7 < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }
        if (i7 > 1073741824) {
            throw new IllegalArgumentException("capacity must be <= 2^30");
        }
        i7 = Integer.bitCount(i7) != 1 ? Integer.highestOneBit(i7 - 1) << 1 : i7;
        this.f2279d = i7 - 1;
        this.f2276a = new int[i7];
    }
}
