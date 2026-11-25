package androidx.collection;

import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public class f<E> implements Cloneable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Object f2283e = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f2284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long[] f2285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object[] f2286c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2287d;

    public f() {
        this(10);
    }

    private void l() {
        int i7 = this.f2287d;
        long[] jArr = this.f2285b;
        Object[] objArr = this.f2286c;
        int i8 = 0;
        for (int i9 = 0; i9 < i7; i9++) {
            Object obj = objArr[i9];
            if (obj != f2283e) {
                if (i9 != i8) {
                    jArr[i8] = jArr[i9];
                    objArr[i8] = obj;
                    objArr[i9] = null;
                }
                i8++;
            }
        }
        this.f2284a = false;
        this.f2287d = i8;
    }

    public void A(int i7, E e8) {
        if (this.f2284a) {
            l();
        }
        this.f2286c[i7] = e8;
    }

    public int B() {
        if (this.f2284a) {
            l();
        }
        return this.f2287d;
    }

    public E C(int i7) {
        if (this.f2284a) {
            l();
        }
        return (E) this.f2286c[i7];
    }

    public void a(long j7, E e8) {
        int i7 = this.f2287d;
        if (i7 != 0 && j7 <= this.f2285b[i7 - 1]) {
            s(j7, e8);
            return;
        }
        if (this.f2284a && i7 >= this.f2285b.length) {
            l();
        }
        int i8 = this.f2287d;
        if (i8 >= this.f2285b.length) {
            int iF = e.f(i8 + 1);
            long[] jArr = new long[iF];
            Object[] objArr = new Object[iF];
            long[] jArr2 = this.f2285b;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.f2286c;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f2285b = jArr;
            this.f2286c = objArr;
        }
        this.f2285b[i8] = j7;
        this.f2286c[i8] = e8;
        this.f2287d = i8 + 1;
    }

    public void e() {
        int i7 = this.f2287d;
        Object[] objArr = this.f2286c;
        for (int i8 = 0; i8 < i7; i8++) {
            objArr[i8] = null;
        }
        this.f2287d = 0;
        this.f2284a = false;
    }

    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public f<E> clone() {
        try {
            f<E> fVar = (f) super.clone();
            fVar.f2285b = (long[]) this.f2285b.clone();
            fVar.f2286c = (Object[]) this.f2286c.clone();
            return fVar;
        } catch (CloneNotSupportedException e8) {
            throw new AssertionError(e8);
        }
    }

    public boolean i(long j7) {
        return o(j7) >= 0;
    }

    public boolean j(E e8) {
        return p(e8) >= 0;
    }

    @Deprecated
    public void k(long j7) {
        v(j7);
    }

    @o0
    public E m(long j7) {
        return n(j7, null);
    }

    public E n(long j7, E e8) {
        E e9;
        int iB = e.b(this.f2285b, this.f2287d, j7);
        return (iB < 0 || (e9 = (E) this.f2286c[iB]) == f2283e) ? e8 : e9;
    }

    public int o(long j7) {
        if (this.f2284a) {
            l();
        }
        return e.b(this.f2285b, this.f2287d, j7);
    }

    public int p(E e8) {
        if (this.f2284a) {
            l();
        }
        for (int i7 = 0; i7 < this.f2287d; i7++) {
            if (this.f2286c[i7] == e8) {
                return i7;
            }
        }
        return -1;
    }

    public boolean q() {
        return B() == 0;
    }

    public long r(int i7) {
        if (this.f2284a) {
            l();
        }
        return this.f2285b[i7];
    }

    public void s(long j7, E e8) {
        int iB = e.b(this.f2285b, this.f2287d, j7);
        if (iB >= 0) {
            this.f2286c[iB] = e8;
            return;
        }
        int i7 = ~iB;
        int i8 = this.f2287d;
        if (i7 < i8) {
            Object[] objArr = this.f2286c;
            if (objArr[i7] == f2283e) {
                this.f2285b[i7] = j7;
                objArr[i7] = e8;
                return;
            }
        }
        if (this.f2284a && i8 >= this.f2285b.length) {
            l();
            i7 = ~e.b(this.f2285b, this.f2287d, j7);
        }
        int i9 = this.f2287d;
        if (i9 >= this.f2285b.length) {
            int iF = e.f(i9 + 1);
            long[] jArr = new long[iF];
            Object[] objArr2 = new Object[iF];
            long[] jArr2 = this.f2285b;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f2286c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f2285b = jArr;
            this.f2286c = objArr2;
        }
        int i10 = this.f2287d;
        if (i10 - i7 != 0) {
            long[] jArr3 = this.f2285b;
            int i11 = i7 + 1;
            System.arraycopy(jArr3, i7, jArr3, i11, i10 - i7);
            Object[] objArr4 = this.f2286c;
            System.arraycopy(objArr4, i7, objArr4, i11, this.f2287d - i7);
        }
        this.f2285b[i7] = j7;
        this.f2286c[i7] = e8;
        this.f2287d++;
    }

    public void t(@m0 f<? extends E> fVar) {
        int iB = fVar.B();
        for (int i7 = 0; i7 < iB; i7++) {
            s(fVar.r(i7), fVar.C(i7));
        }
    }

    public String toString() {
        if (B() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f2287d * 28);
        sb.append('{');
        for (int i7 = 0; i7 < this.f2287d; i7++) {
            if (i7 > 0) {
                sb.append(", ");
            }
            sb.append(r(i7));
            sb.append('=');
            E eC = C(i7);
            if (eC != this) {
                sb.append(eC);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    @o0
    public E u(long j7, E e8) {
        E eM = m(j7);
        if (eM == null) {
            s(j7, e8);
        }
        return eM;
    }

    public void v(long j7) {
        int iB = e.b(this.f2285b, this.f2287d, j7);
        if (iB >= 0) {
            Object[] objArr = this.f2286c;
            Object obj = objArr[iB];
            Object obj2 = f2283e;
            if (obj != obj2) {
                objArr[iB] = obj2;
                this.f2284a = true;
            }
        }
    }

    public boolean w(long j7, Object obj) {
        int iO = o(j7);
        if (iO < 0) {
            return false;
        }
        E eC = C(iO);
        if (obj != eC && (obj == null || !obj.equals(eC))) {
            return false;
        }
        x(iO);
        return true;
    }

    public void x(int i7) {
        Object[] objArr = this.f2286c;
        Object obj = objArr[i7];
        Object obj2 = f2283e;
        if (obj != obj2) {
            objArr[i7] = obj2;
            this.f2284a = true;
        }
    }

    @o0
    public E y(long j7, E e8) {
        int iO = o(j7);
        if (iO < 0) {
            return null;
        }
        Object[] objArr = this.f2286c;
        E e9 = (E) objArr[iO];
        objArr[iO] = e8;
        return e9;
    }

    public boolean z(long j7, E e8, E e9) {
        int iO = o(j7);
        if (iO < 0) {
            return false;
        }
        Object obj = this.f2286c[iO];
        if (obj != e8 && (e8 == null || !e8.equals(obj))) {
            return false;
        }
        this.f2286c[iO] = e9;
        return true;
    }

    public f(int i7) {
        this.f2284a = false;
        if (i7 == 0) {
            this.f2285b = e.f2281b;
            this.f2286c = e.f2282c;
        } else {
            int iF = e.f(i7);
            this.f2285b = new long[iF];
            this.f2286c = new Object[iF];
        }
    }
}
