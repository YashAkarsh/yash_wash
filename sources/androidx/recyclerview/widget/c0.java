package androidx.recyclerview.widget;

import c.m0;
import c.o0;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class c0<T> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f9342j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f9343k = 10;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f9344l = 10;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f9345m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f9346n = 2;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f9347o = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    T[] f9348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private T[] f9349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f9350c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f9351d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f9352e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private b f9353f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private a f9354g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f9355h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Class<T> f9356i;

    public static class a<T2> extends b<T2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final b<T2> f9357a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final f f9358b;

        public a(b<T2> bVar) {
            this.f9357a = bVar;
            this.f9358b = new f(bVar);
        }

        @Override // androidx.recyclerview.widget.t
        public void a(int i7, int i8) {
            this.f9358b.a(i7, i8);
        }

        @Override // androidx.recyclerview.widget.t
        public void b(int i7, int i8) {
            this.f9358b.b(i7, i8);
        }

        @Override // androidx.recyclerview.widget.t
        public void c(int i7, int i8) {
            this.f9358b.c(i7, i8);
        }

        @Override // androidx.recyclerview.widget.c0.b, java.util.Comparator
        public int compare(T2 t7, T2 t8) {
            return this.f9357a.compare(t7, t8);
        }

        @Override // androidx.recyclerview.widget.c0.b, androidx.recyclerview.widget.t
        public void d(int i7, int i8, Object obj) {
            this.f9358b.d(i7, i8, obj);
        }

        @Override // androidx.recyclerview.widget.c0.b
        public boolean e(T2 t7, T2 t8) {
            return this.f9357a.e(t7, t8);
        }

        @Override // androidx.recyclerview.widget.c0.b
        public boolean f(T2 t7, T2 t8) {
            return this.f9357a.f(t7, t8);
        }

        @Override // androidx.recyclerview.widget.c0.b
        @o0
        public Object g(T2 t7, T2 t8) {
            return this.f9357a.g(t7, t8);
        }

        @Override // androidx.recyclerview.widget.c0.b
        public void h(int i7, int i8) {
            this.f9358b.d(i7, i8, null);
        }

        public void i() {
            this.f9358b.e();
        }
    }

    public static abstract class b<T2> implements Comparator<T2>, t {
        @Override // java.util.Comparator
        public abstract int compare(T2 t7, T2 t8);

        public void d(int i7, int i8, Object obj) {
            h(i7, i8);
        }

        public abstract boolean e(T2 t7, T2 t8);

        public abstract boolean f(T2 t7, T2 t8);

        @o0
        public Object g(T2 t7, T2 t8) {
            return null;
        }

        public abstract void h(int i7, int i8);
    }

    public c0(@m0 Class<T> cls, @m0 b<T> bVar) {
        this(cls, bVar, 10);
    }

    private void A(@m0 T[] tArr) {
        boolean z7 = !(this.f9353f instanceof a);
        if (z7) {
            h();
        }
        this.f9350c = 0;
        this.f9351d = this.f9355h;
        this.f9349b = this.f9348a;
        this.f9352e = 0;
        int iD = D(tArr);
        this.f9348a = (T[]) ((Object[]) Array.newInstance((Class<?>) this.f9356i, iD));
        while (true) {
            int i7 = this.f9352e;
            if (i7 >= iD && this.f9350c >= this.f9351d) {
                break;
            }
            int i8 = this.f9350c;
            int i9 = this.f9351d;
            if (i8 >= i9) {
                int i10 = iD - i7;
                System.arraycopy(tArr, i7, this.f9348a, i7, i10);
                this.f9352e += i10;
                this.f9355h += i10;
                this.f9353f.b(i7, i10);
                break;
            }
            if (i7 >= iD) {
                int i11 = i9 - i8;
                this.f9355h -= i11;
                this.f9353f.c(i7, i11);
                break;
            }
            T t7 = this.f9349b[i8];
            T t8 = tArr[i7];
            int iCompare = this.f9353f.compare(t7, t8);
            if (iCompare < 0) {
                B();
            } else if (iCompare > 0) {
                z(t8);
            } else if (this.f9353f.f(t7, t8)) {
                T[] tArr2 = this.f9348a;
                int i12 = this.f9352e;
                tArr2[i12] = t8;
                this.f9350c++;
                this.f9352e = i12 + 1;
                if (!this.f9353f.e(t7, t8)) {
                    b bVar = this.f9353f;
                    bVar.d(this.f9352e - 1, 1, bVar.g(t7, t8));
                }
            } else {
                B();
                z(t8);
            }
        }
        this.f9349b = null;
        if (z7) {
            k();
        }
    }

    private void B() {
        this.f9355h--;
        this.f9350c++;
        this.f9353f.c(this.f9352e, 1);
    }

    private int D(@m0 T[] tArr) {
        if (tArr.length == 0) {
            return 0;
        }
        Arrays.sort(tArr, this.f9353f);
        int i7 = 0;
        int i8 = 1;
        for (int i9 = 1; i9 < tArr.length; i9++) {
            T t7 = tArr[i9];
            if (this.f9353f.compare(tArr[i7], t7) == 0) {
                int iM = m(t7, tArr, i7, i8);
                if (iM != -1) {
                    tArr[iM] = t7;
                } else {
                    if (i8 != i9) {
                        tArr[i8] = t7;
                    }
                    i8++;
                }
            } else {
                if (i8 != i9) {
                    tArr[i8] = t7;
                }
                i7 = i8;
                i8++;
            }
        }
        return i8;
    }

    private void E() {
        if (this.f9349b != null) {
            throw new IllegalStateException("Data cannot be mutated in the middle of a batch update operation such as addAll or replaceAll.");
        }
    }

    private int b(T t7, boolean z7) {
        int iL = l(t7, this.f9348a, 0, this.f9355h, 1);
        if (iL == -1) {
            iL = 0;
        } else if (iL < this.f9355h) {
            T t8 = this.f9348a[iL];
            if (this.f9353f.f(t8, t7)) {
                if (this.f9353f.e(t8, t7)) {
                    this.f9348a[iL] = t7;
                    return iL;
                }
                this.f9348a[iL] = t7;
                b bVar = this.f9353f;
                bVar.d(iL, 1, bVar.g(t8, t7));
                return iL;
            }
        }
        g(iL, t7);
        if (z7) {
            this.f9353f.b(iL, 1);
        }
        return iL;
    }

    private void f(T[] tArr) {
        if (tArr.length < 1) {
            return;
        }
        int iD = D(tArr);
        if (this.f9355h != 0) {
            q(tArr, iD);
            return;
        }
        this.f9348a = tArr;
        this.f9355h = iD;
        this.f9353f.b(0, iD);
    }

    private void g(int i7, T t7) {
        int i8 = this.f9355h;
        if (i7 > i8) {
            throw new IndexOutOfBoundsException("cannot add item to " + i7 + " because size is " + this.f9355h);
        }
        T[] tArr = this.f9348a;
        if (i8 == tArr.length) {
            T[] tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) this.f9356i, tArr.length + 10));
            System.arraycopy(this.f9348a, 0, tArr2, 0, i7);
            tArr2[i7] = t7;
            System.arraycopy(this.f9348a, i7, tArr2, i7 + 1, this.f9355h - i7);
            this.f9348a = tArr2;
        } else {
            System.arraycopy(tArr, i7, tArr, i7 + 1, i8 - i7);
            this.f9348a[i7] = t7;
        }
        this.f9355h++;
    }

    private T[] j(T[] tArr) {
        T[] tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) this.f9356i, tArr.length));
        System.arraycopy(tArr, 0, tArr2, 0, tArr.length);
        return tArr2;
    }

    private int l(T t7, T[] tArr, int i7, int i8, int i9) {
        while (i7 < i8) {
            int i10 = (i7 + i8) / 2;
            T t8 = tArr[i10];
            int iCompare = this.f9353f.compare(t8, t7);
            if (iCompare < 0) {
                i7 = i10 + 1;
            } else {
                if (iCompare == 0) {
                    if (this.f9353f.f(t8, t7)) {
                        return i10;
                    }
                    int iP = p(t7, i10, i7, i8);
                    if (i9 == 1) {
                        return iP == -1 ? i10 : iP;
                    }
                    return iP;
                }
                i8 = i10;
            }
        }
        if (i9 == 1) {
            return i7;
        }
        return -1;
    }

    private int m(T t7, T[] tArr, int i7, int i8) {
        while (i7 < i8) {
            if (this.f9353f.f(tArr[i7], t7)) {
                return i7;
            }
            i7++;
        }
        return -1;
    }

    private int p(T t7, int i7, int i8, int i9) {
        T t8;
        for (int i10 = i7 - 1; i10 >= i8; i10--) {
            T t9 = this.f9348a[i10];
            if (this.f9353f.compare(t9, t7) != 0) {
                break;
            }
            if (this.f9353f.f(t9, t7)) {
                return i10;
            }
        }
        do {
            i7++;
            if (i7 >= i9) {
                return -1;
            }
            t8 = this.f9348a[i7];
            if (this.f9353f.compare(t8, t7) != 0) {
                return -1;
            }
        } while (!this.f9353f.f(t8, t7));
        return i7;
    }

    private void q(T[] tArr, int i7) {
        boolean z7 = !(this.f9353f instanceof a);
        if (z7) {
            h();
        }
        this.f9349b = this.f9348a;
        int i8 = 0;
        this.f9350c = 0;
        int i9 = this.f9355h;
        this.f9351d = i9;
        this.f9348a = (T[]) ((Object[]) Array.newInstance((Class<?>) this.f9356i, i9 + i7 + 10));
        this.f9352e = 0;
        while (true) {
            int i10 = this.f9350c;
            int i11 = this.f9351d;
            if (i10 >= i11 && i8 >= i7) {
                break;
            }
            if (i10 == i11) {
                int i12 = i7 - i8;
                System.arraycopy(tArr, i8, this.f9348a, this.f9352e, i12);
                int i13 = this.f9352e + i12;
                this.f9352e = i13;
                this.f9355h += i12;
                this.f9353f.b(i13 - i12, i12);
                break;
            }
            if (i8 == i7) {
                int i14 = i11 - i10;
                System.arraycopy(this.f9349b, i10, this.f9348a, this.f9352e, i14);
                this.f9352e += i14;
                break;
            }
            T t7 = this.f9349b[i10];
            T t8 = tArr[i8];
            int iCompare = this.f9353f.compare(t7, t8);
            if (iCompare > 0) {
                T[] tArr2 = this.f9348a;
                int i15 = this.f9352e;
                int i16 = i15 + 1;
                this.f9352e = i16;
                tArr2[i15] = t8;
                this.f9355h++;
                i8++;
                this.f9353f.b(i16 - 1, 1);
            } else if (iCompare == 0 && this.f9353f.f(t7, t8)) {
                T[] tArr3 = this.f9348a;
                int i17 = this.f9352e;
                this.f9352e = i17 + 1;
                tArr3[i17] = t8;
                i8++;
                this.f9350c++;
                if (!this.f9353f.e(t7, t8)) {
                    b bVar = this.f9353f;
                    bVar.d(this.f9352e - 1, 1, bVar.g(t7, t8));
                }
            } else {
                T[] tArr4 = this.f9348a;
                int i18 = this.f9352e;
                this.f9352e = i18 + 1;
                tArr4[i18] = t7;
                this.f9350c++;
            }
        }
        this.f9349b = null;
        if (z7) {
            k();
        }
    }

    private boolean t(T t7, boolean z7) {
        int iL = l(t7, this.f9348a, 0, this.f9355h, 2);
        if (iL == -1) {
            return false;
        }
        v(iL, z7);
        return true;
    }

    private void v(int i7, boolean z7) {
        T[] tArr = this.f9348a;
        System.arraycopy(tArr, i7 + 1, tArr, i7, (this.f9355h - i7) - 1);
        int i8 = this.f9355h - 1;
        this.f9355h = i8;
        this.f9348a[i8] = null;
        if (z7) {
            this.f9353f.c(i7, 1);
        }
    }

    private void z(T t7) {
        T[] tArr = this.f9348a;
        int i7 = this.f9352e;
        tArr[i7] = t7;
        int i8 = i7 + 1;
        this.f9352e = i8;
        this.f9355h++;
        this.f9353f.b(i8 - 1, 1);
    }

    public int C() {
        return this.f9355h;
    }

    public void F(int i7, T t7) {
        E();
        T tN = n(i7);
        boolean z7 = tN == t7 || !this.f9353f.e(tN, t7);
        if (tN != t7 && this.f9353f.compare(tN, t7) == 0) {
            this.f9348a[i7] = t7;
            if (z7) {
                b bVar = this.f9353f;
                bVar.d(i7, 1, bVar.g(tN, t7));
                return;
            }
            return;
        }
        if (z7) {
            b bVar2 = this.f9353f;
            bVar2.d(i7, 1, bVar2.g(tN, t7));
        }
        v(i7, false);
        int iB = b(t7, false);
        if (i7 != iB) {
            this.f9353f.a(i7, iB);
        }
    }

    public int a(T t7) {
        E();
        return b(t7, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void c(@m0 Collection<T> collection) {
        e(collection.toArray((Object[]) Array.newInstance((Class<?>) this.f9356i, collection.size())), true);
    }

    public void d(@m0 T... tArr) {
        e(tArr, false);
    }

    public void e(@m0 T[] tArr, boolean z7) {
        E();
        if (tArr.length == 0) {
            return;
        }
        if (z7) {
            f(tArr);
        } else {
            f(j(tArr));
        }
    }

    public void h() {
        E();
        b bVar = this.f9353f;
        if (bVar instanceof a) {
            return;
        }
        if (this.f9354g == null) {
            this.f9354g = new a(bVar);
        }
        this.f9353f = this.f9354g;
    }

    public void i() {
        E();
        int i7 = this.f9355h;
        if (i7 == 0) {
            return;
        }
        Arrays.fill(this.f9348a, 0, i7, (Object) null);
        this.f9355h = 0;
        this.f9353f.c(0, i7);
    }

    public void k() {
        E();
        b bVar = this.f9353f;
        if (bVar instanceof a) {
            ((a) bVar).i();
        }
        b bVar2 = this.f9353f;
        a aVar = this.f9354g;
        if (bVar2 == aVar) {
            this.f9353f = aVar.f9357a;
        }
    }

    public T n(int i7) throws IndexOutOfBoundsException {
        int i8;
        if (i7 < this.f9355h && i7 >= 0) {
            T[] tArr = this.f9349b;
            return (tArr == null || i7 < (i8 = this.f9352e)) ? this.f9348a[i7] : tArr[(i7 - i8) + this.f9350c];
        }
        throw new IndexOutOfBoundsException("Asked to get item at " + i7 + " but size is " + this.f9355h);
    }

    public int o(T t7) {
        if (this.f9349b == null) {
            return l(t7, this.f9348a, 0, this.f9355h, 4);
        }
        int iL = l(t7, this.f9348a, 0, this.f9352e, 4);
        if (iL != -1) {
            return iL;
        }
        int iL2 = l(t7, this.f9349b, this.f9350c, this.f9351d, 4);
        if (iL2 != -1) {
            return (iL2 - this.f9350c) + this.f9352e;
        }
        return -1;
    }

    public void r(int i7) {
        E();
        T tN = n(i7);
        v(i7, false);
        int iB = b(tN, false);
        if (i7 != iB) {
            this.f9353f.a(i7, iB);
        }
    }

    public boolean s(T t7) {
        E();
        return t(t7, true);
    }

    public T u(int i7) {
        E();
        T tN = n(i7);
        v(i7, true);
        return tN;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void w(@m0 Collection<T> collection) {
        y(collection.toArray((Object[]) Array.newInstance((Class<?>) this.f9356i, collection.size())), true);
    }

    public void x(@m0 T... tArr) {
        y(tArr, false);
    }

    public void y(@m0 T[] tArr, boolean z7) {
        E();
        if (z7) {
            A(tArr);
        } else {
            A(j(tArr));
        }
    }

    public c0(@m0 Class<T> cls, @m0 b<T> bVar, int i7) {
        this.f9356i = cls;
        this.f9348a = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i7));
        this.f9353f = bVar;
        this.f9355h = 0;
    }
}
