package kotlinx.coroutines.flow.internal;

import java.util.Arrays;
import kotlin.d1;
import kotlin.jvm.internal.l0;
import kotlin.l2;
import kotlinx.coroutines.flow.internal.d;
import kotlinx.coroutines.flow.t0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b<S extends d<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.e
    private S[] f36262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f36263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f36264c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.e
    private a0 f36265d;

    protected static /* synthetic */ void r() {
    }

    @a7.d
    protected final S h() {
        S s7;
        a0 a0Var;
        synchronized (this) {
            S[] sArr = (S[]) p();
            if (sArr == null) {
                sArr = (S[]) k(2);
                this.f36262a = sArr;
            } else if (o() >= sArr.length) {
                Object[] objArrCopyOf = Arrays.copyOf(sArr, sArr.length * 2);
                l0.o(objArrCopyOf, "copyOf(this, newSize)");
                this.f36262a = (S[]) ((d[]) objArrCopyOf);
                sArr = (S[]) ((d[]) objArrCopyOf);
            }
            int i7 = this.f36264c;
            do {
                s7 = sArr[i7];
                if (s7 == null) {
                    s7 = (S) i();
                    sArr[i7] = s7;
                }
                i7++;
                if (i7 >= sArr.length) {
                    i7 = 0;
                }
            } while (!s7.a(this));
            this.f36264c = i7;
            this.f36263b = o() + 1;
            a0Var = this.f36265d;
        }
        if (a0Var != null) {
            a0Var.h0(1);
        }
        return s7;
    }

    @a7.d
    protected abstract S i();

    @a7.d
    protected abstract S[] k(int i7);

    protected final void l(@a7.d i5.l<? super S, l2> lVar) {
        d[] dVarArr;
        if (this.f36263b == 0 || (dVarArr = this.f36262a) == null) {
            return;
        }
        int length = dVarArr.length;
        int i7 = 0;
        while (i7 < length) {
            d dVar = dVarArr[i7];
            i7++;
            if (dVar != null) {
                lVar.z(dVar);
            }
        }
    }

    protected final void n(@a7.d S s7) {
        a0 a0Var;
        int i7;
        kotlin.coroutines.d<l2>[] dVarArrB;
        synchronized (this) {
            this.f36263b = o() - 1;
            a0Var = this.f36265d;
            i7 = 0;
            if (o() == 0) {
                this.f36264c = 0;
            }
            dVarArrB = s7.b(this);
        }
        int length = dVarArrB.length;
        while (i7 < length) {
            kotlin.coroutines.d<l2> dVar = dVarArrB[i7];
            i7++;
            if (dVar != null) {
                d1.a aVar = d1.f34719b;
                dVar.w(d1.b(l2.f34958a));
            }
        }
        if (a0Var == null) {
            return;
        }
        a0Var.h0(-1);
    }

    protected final int o() {
        return this.f36263b;
    }

    @a7.e
    protected final S[] p() {
        return this.f36262a;
    }

    @a7.d
    public final t0<Integer> q() {
        a0 a0Var;
        synchronized (this) {
            a0Var = this.f36265d;
            if (a0Var == null) {
                a0Var = new a0(o());
                this.f36265d = a0Var;
            }
        }
        return a0Var;
    }
}
