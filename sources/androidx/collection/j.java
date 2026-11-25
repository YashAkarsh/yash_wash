package androidx.collection;

import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public class j<E> implements Cloneable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Object f2323e = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f2324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int[] f2325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object[] f2326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2327d;

    public j() {
        this(10);
    }

    private void l() {
        int i7 = this.f2327d;
        int[] iArr = this.f2325b;
        Object[] objArr = this.f2326c;
        int i8 = 0;
        for (int i9 = 0; i9 < i7; i9++) {
            Object obj = objArr[i9];
            if (obj != f2323e) {
                if (i9 != i8) {
                    iArr[i8] = iArr[i9];
                    objArr[i8] = obj;
                    objArr[i9] = null;
                }
                i8++;
            }
        }
        this.f2324a = false;
        this.f2327d = i8;
    }

    public boolean A(int i7, E e8, E e9) {
        int iO = o(i7);
        if (iO < 0) {
            return false;
        }
        Object obj = this.f2326c[iO];
        if (obj != e8 && (e8 == null || !e8.equals(obj))) {
            return false;
        }
        this.f2326c[iO] = e9;
        return true;
    }

    public void B(int i7, E e8) {
        if (this.f2324a) {
            l();
        }
        this.f2326c[i7] = e8;
    }

    public int C() {
        if (this.f2324a) {
            l();
        }
        return this.f2327d;
    }

    public E D(int i7) {
        if (this.f2324a) {
            l();
        }
        return (E) this.f2326c[i7];
    }

    public void a(int i7, E e8) {
        int i8 = this.f2327d;
        if (i8 != 0 && i7 <= this.f2325b[i8 - 1]) {
            s(i7, e8);
            return;
        }
        if (this.f2324a && i8 >= this.f2325b.length) {
            l();
        }
        int i9 = this.f2327d;
        if (i9 >= this.f2325b.length) {
            int iE = e.e(i9 + 1);
            int[] iArr = new int[iE];
            Object[] objArr = new Object[iE];
            int[] iArr2 = this.f2325b;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.f2326c;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f2325b = iArr;
            this.f2326c = objArr;
        }
        this.f2325b[i9] = i7;
        this.f2326c[i9] = e8;
        this.f2327d = i9 + 1;
    }

    public void e() {
        int i7 = this.f2327d;
        Object[] objArr = this.f2326c;
        for (int i8 = 0; i8 < i7; i8++) {
            objArr[i8] = null;
        }
        this.f2327d = 0;
        this.f2324a = false;
    }

    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public j<E> clone() {
        try {
            j<E> jVar = (j) super.clone();
            jVar.f2325b = (int[]) this.f2325b.clone();
            jVar.f2326c = (Object[]) this.f2326c.clone();
            return jVar;
        } catch (CloneNotSupportedException e8) {
            throw new AssertionError(e8);
        }
    }

    public boolean i(int i7) {
        return o(i7) >= 0;
    }

    public boolean j(E e8) {
        return p(e8) >= 0;
    }

    @Deprecated
    public void k(int i7) {
        v(i7);
    }

    @o0
    public E m(int i7) {
        return n(i7, null);
    }

    public E n(int i7, E e8) {
        E e9;
        int iA = e.a(this.f2325b, this.f2327d, i7);
        return (iA < 0 || (e9 = (E) this.f2326c[iA]) == f2323e) ? e8 : e9;
    }

    public int o(int i7) {
        if (this.f2324a) {
            l();
        }
        return e.a(this.f2325b, this.f2327d, i7);
    }

    public int p(E e8) {
        if (this.f2324a) {
            l();
        }
        for (int i7 = 0; i7 < this.f2327d; i7++) {
            if (this.f2326c[i7] == e8) {
                return i7;
            }
        }
        return -1;
    }

    public boolean q() {
        return C() == 0;
    }

    public int r(int i7) {
        if (this.f2324a) {
            l();
        }
        return this.f2325b[i7];
    }

    public void s(int i7, E e8) {
        int iA = e.a(this.f2325b, this.f2327d, i7);
        if (iA >= 0) {
            this.f2326c[iA] = e8;
            return;
        }
        int i8 = ~iA;
        int i9 = this.f2327d;
        if (i8 < i9) {
            Object[] objArr = this.f2326c;
            if (objArr[i8] == f2323e) {
                this.f2325b[i8] = i7;
                objArr[i8] = e8;
                return;
            }
        }
        if (this.f2324a && i9 >= this.f2325b.length) {
            l();
            i8 = ~e.a(this.f2325b, this.f2327d, i7);
        }
        int i10 = this.f2327d;
        if (i10 >= this.f2325b.length) {
            int iE = e.e(i10 + 1);
            int[] iArr = new int[iE];
            Object[] objArr2 = new Object[iE];
            int[] iArr2 = this.f2325b;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f2326c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f2325b = iArr;
            this.f2326c = objArr2;
        }
        int i11 = this.f2327d;
        if (i11 - i8 != 0) {
            int[] iArr3 = this.f2325b;
            int i12 = i8 + 1;
            System.arraycopy(iArr3, i8, iArr3, i12, i11 - i8);
            Object[] objArr4 = this.f2326c;
            System.arraycopy(objArr4, i8, objArr4, i12, this.f2327d - i8);
        }
        this.f2325b[i8] = i7;
        this.f2326c[i8] = e8;
        this.f2327d++;
    }

    public void t(@m0 j<? extends E> jVar) {
        int iC = jVar.C();
        for (int i7 = 0; i7 < iC; i7++) {
            s(jVar.r(i7), jVar.D(i7));
        }
    }

    public String toString() {
        if (C() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f2327d * 28);
        sb.append('{');
        for (int i7 = 0; i7 < this.f2327d; i7++) {
            if (i7 > 0) {
                sb.append(", ");
            }
            sb.append(r(i7));
            sb.append('=');
            E eD = D(i7);
            if (eD != this) {
                sb.append(eD);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    @o0
    public E u(int i7, E e8) {
        E eM = m(i7);
        if (eM == null) {
            s(i7, e8);
        }
        return eM;
    }

    public void v(int i7) {
        int iA = e.a(this.f2325b, this.f2327d, i7);
        if (iA >= 0) {
            Object[] objArr = this.f2326c;
            Object obj = objArr[iA];
            Object obj2 = f2323e;
            if (obj != obj2) {
                objArr[iA] = obj2;
                this.f2324a = true;
            }
        }
    }

    public boolean w(int i7, Object obj) {
        int iO = o(i7);
        if (iO < 0) {
            return false;
        }
        E eD = D(iO);
        if (obj != eD && (obj == null || !obj.equals(eD))) {
            return false;
        }
        x(iO);
        return true;
    }

    public void x(int i7) {
        Object[] objArr = this.f2326c;
        Object obj = objArr[i7];
        Object obj2 = f2323e;
        if (obj != obj2) {
            objArr[i7] = obj2;
            this.f2324a = true;
        }
    }

    public void y(int i7, int i8) {
        int iMin = Math.min(this.f2327d, i8 + i7);
        while (i7 < iMin) {
            x(i7);
            i7++;
        }
    }

    @o0
    public E z(int i7, E e8) {
        int iO = o(i7);
        if (iO < 0) {
            return null;
        }
        Object[] objArr = this.f2326c;
        E e9 = (E) objArr[iO];
        objArr[iO] = e8;
        return e9;
    }

    public j(int i7) {
        this.f2324a = false;
        if (i7 == 0) {
            this.f2325b = e.f2280a;
            this.f2326c = e.f2282c;
        } else {
            int iE = e.e(i7);
            this.f2325b = new int[iE];
            this.f2326c = new Object[iE];
        }
    }
}
