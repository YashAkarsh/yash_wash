package kotlinx.coroutines.internal;

import java.lang.Comparable;
import java.util.Arrays;
import kotlin.l2;
import kotlinx.coroutines.internal.b1;
import kotlinx.coroutines.j2;

/* JADX INFO: loaded from: classes3.dex */
@j2
public class a1<T extends b1 & Comparable<? super T>> {

    @a7.d
    private volatile /* synthetic */ int _size = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.e
    private T[] f36938a;

    private final T[] i() {
        T[] tArr = this.f36938a;
        if (tArr == null) {
            T[] tArr2 = (T[]) new b1[4];
            this.f36938a = tArr2;
            return tArr2;
        }
        if (f() < tArr.length) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, f() * 2);
        kotlin.jvm.internal.l0.o(objArrCopyOf, "copyOf(this, newSize)");
        T[] tArr3 = (T[]) ((b1[]) objArrCopyOf);
        this.f36938a = tArr3;
        return tArr3;
    }

    private final void n(int i7) {
        this._size = i7;
    }

    private final void o(int i7) {
        while (true) {
            int i8 = (i7 * 2) + 1;
            if (i8 >= f()) {
                return;
            }
            T[] tArr = this.f36938a;
            kotlin.jvm.internal.l0.m(tArr);
            int i9 = i8 + 1;
            if (i9 < f()) {
                T t7 = tArr[i9];
                kotlin.jvm.internal.l0.m(t7);
                T t8 = tArr[i8];
                kotlin.jvm.internal.l0.m(t8);
                if (((Comparable) t7).compareTo(t8) < 0) {
                    i8 = i9;
                }
            }
            T t9 = tArr[i7];
            kotlin.jvm.internal.l0.m(t9);
            T t10 = tArr[i8];
            kotlin.jvm.internal.l0.m(t10);
            if (((Comparable) t9).compareTo(t10) <= 0) {
                return;
            }
            q(i7, i8);
            i7 = i8;
        }
    }

    private final void p(int i7) {
        while (i7 > 0) {
            T[] tArr = this.f36938a;
            kotlin.jvm.internal.l0.m(tArr);
            int i8 = (i7 - 1) / 2;
            T t7 = tArr[i8];
            kotlin.jvm.internal.l0.m(t7);
            T t8 = tArr[i7];
            kotlin.jvm.internal.l0.m(t8);
            if (((Comparable) t7).compareTo(t8) <= 0) {
                return;
            }
            q(i7, i8);
            i7 = i8;
        }
    }

    private final void q(int i7, int i8) {
        T[] tArr = this.f36938a;
        kotlin.jvm.internal.l0.m(tArr);
        T t7 = tArr[i8];
        kotlin.jvm.internal.l0.m(t7);
        T t8 = tArr[i7];
        kotlin.jvm.internal.l0.m(t8);
        tArr[i7] = t7;
        tArr[i8] = t8;
        t7.c(i7);
        t8.c(i8);
    }

    @kotlin.a1
    public final void a(@a7.d T t7) {
        t7.a(this);
        b1[] b1VarArrI = i();
        int iF = f();
        n(iF + 1);
        b1VarArrI[iF] = t7;
        t7.c(iF);
        p(iF);
    }

    public final void b(@a7.d T t7) {
        synchronized (this) {
            a(t7);
            l2 l2Var = l2.f34958a;
        }
    }

    public final boolean c(@a7.d T t7, @a7.d i5.l<? super T, Boolean> lVar) {
        boolean z7;
        synchronized (this) {
            try {
                if (lVar.z(e()).booleanValue()) {
                    a(t7);
                    z7 = true;
                } else {
                    z7 = false;
                }
                kotlin.jvm.internal.i0.d(1);
            } catch (Throwable th) {
                kotlin.jvm.internal.i0.d(1);
                kotlin.jvm.internal.i0.c(1);
                throw th;
            }
        }
        kotlin.jvm.internal.i0.c(1);
        return z7;
    }

    public final void d() {
        synchronized (this) {
            T[] tArr = this.f36938a;
            if (tArr != null) {
                kotlin.collections.o.w2(tArr, null, 0, 0, 6, null);
            }
            this._size = 0;
            l2 l2Var = l2.f34958a;
        }
    }

    @a7.e
    @kotlin.a1
    public final T e() {
        T[] tArr = this.f36938a;
        if (tArr == null) {
            return null;
        }
        return tArr[0];
    }

    public final int f() {
        return this._size;
    }

    public final boolean g() {
        return f() == 0;
    }

    @a7.e
    public final T h() {
        T t7;
        synchronized (this) {
            t7 = (T) e();
        }
        return t7;
    }

    public final boolean j(@a7.d T t7) {
        boolean z7;
        synchronized (this) {
            if (t7.b() == null) {
                z7 = false;
            } else {
                k(t7.g());
                z7 = true;
            }
        }
        return z7;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x003a  */
    @a7.d
    @kotlin.a1
    public final T k(int i7) {
        T[] tArr = this.f36938a;
        kotlin.jvm.internal.l0.m(tArr);
        n(f() - 1);
        if (i7 < f()) {
            q(i7, f());
            int i8 = (i7 - 1) / 2;
            if (i7 > 0) {
                T t7 = tArr[i7];
                kotlin.jvm.internal.l0.m(t7);
                T t8 = tArr[i8];
                kotlin.jvm.internal.l0.m(t8);
                if (((Comparable) t7).compareTo(t8) < 0) {
                    q(i7, i8);
                    p(i8);
                } else {
                    o(i7);
                }
            } else {
                o(i7);
            }
        }
        T t9 = tArr[f()];
        kotlin.jvm.internal.l0.m(t9);
        t9.a(null);
        t9.c(-1);
        tArr[f()] = null;
        return t9;
    }

    @a7.e
    public final T l(@a7.d i5.l<? super T, Boolean> lVar) {
        synchronized (this) {
            int i7 = 1;
            try {
                b1 b1VarE = e();
                T t7 = null;
                if (b1VarE == null) {
                    kotlin.jvm.internal.i0.d(2);
                    return null;
                }
                if (lVar.z(b1VarE).booleanValue()) {
                    t7 = (T) k(0);
                }
                kotlin.jvm.internal.i0.d(i7);
                return t7;
            } finally {
                kotlin.jvm.internal.i0.d(i7);
                kotlin.jvm.internal.i0.c(i7);
            }
        }
    }

    @a7.e
    public final T m() {
        T t7;
        synchronized (this) {
            t7 = f() > 0 ? (T) k(0) : null;
        }
        return t7;
    }
}
