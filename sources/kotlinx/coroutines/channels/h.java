package kotlinx.coroutines.channels;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.l2;
import kotlinx.coroutines.internal.d1;
import kotlinx.coroutines.internal.r0;

/* JADX INFO: loaded from: classes2.dex */
public class h<E> extends kotlinx.coroutines.channels.a<E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f35594d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    private final m f35595e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @a7.d
    private final ReentrantLock f35596f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @a7.d
    private Object[] f35597g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f35598h;

    @a7.d
    private volatile /* synthetic */ int size;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f35599a;

        static {
            int[] iArr = new int[m.values().length];
            iArr[m.SUSPEND.ordinal()] = 1;
            iArr[m.DROP_LATEST.ordinal()] = 2;
            iArr[m.DROP_OLDEST.ordinal()] = 3;
            f35599a = iArr;
        }
    }

    public h(int i7, @a7.d m mVar, @a7.e i5.l<? super E, l2> lVar) {
        super(lVar);
        this.f35594d = i7;
        this.f35595e = mVar;
        if (!(i7 >= 1)) {
            throw new IllegalArgumentException(("ArrayChannel capacity must be at least 1, but " + i7 + " was specified").toString());
        }
        this.f35596f = new ReentrantLock();
        Object[] objArr = new Object[Math.min(i7, 8)];
        kotlin.collections.o.w2(objArr, b.f35562c, 0, 0, 6, null);
        this.f35597g = objArr;
        this.size = 0;
    }

    private final void s0(int i7, E e8) {
        if (i7 < this.f35594d) {
            t0(i7);
            Object[] objArr = this.f35597g;
            objArr[(this.f35598h + i7) % objArr.length] = e8;
        } else {
            Object[] objArr2 = this.f35597g;
            int i8 = this.f35598h;
            objArr2[i8 % objArr2.length] = null;
            objArr2[(i7 + i8) % objArr2.length] = e8;
            this.f35598h = (i8 + 1) % objArr2.length;
        }
    }

    private final void t0(int i7) {
        Object[] objArr = this.f35597g;
        if (i7 >= objArr.length) {
            int iMin = Math.min(objArr.length * 2, this.f35594d);
            Object[] objArr2 = new Object[iMin];
            for (int i8 = 0; i8 < i7; i8++) {
                Object[] objArr3 = this.f35597g;
                objArr2[i8] = objArr3[(this.f35598h + i8) % objArr3.length];
            }
            kotlin.collections.o.n2(objArr2, b.f35562c, i7, iMin);
            this.f35597g = objArr2;
            this.f35598h = 0;
        }
    }

    private final r0 u0(int i7) {
        if (i7 < this.f35594d) {
            this.size = i7 + 1;
            return null;
        }
        int i8 = a.f35599a[this.f35595e.ordinal()];
        if (i8 == 1) {
            return b.f35564e;
        }
        if (i8 == 2) {
            return b.f35563d;
        }
        if (i8 == 3) {
            return null;
        }
        throw new kotlin.j0();
    }

    @Override // kotlinx.coroutines.channels.c
    protected final boolean F() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.c
    protected final boolean H() {
        return this.size == this.f35594d && this.f35595e == m.SUSPEND;
    }

    @Override // kotlinx.coroutines.channels.c
    @a7.d
    protected Object J(E e8) {
        ReentrantLock reentrantLock = this.f35596f;
        reentrantLock.lock();
        try {
            int i7 = this.size;
            w<?> wVarU = u();
            if (wVarU != null) {
                reentrantLock.unlock();
                return wVarU;
            }
            r0 r0VarU0 = u0(i7);
            if (r0VarU0 != null) {
                reentrantLock.unlock();
                return r0VarU0;
            }
            if (i7 == 0) {
                while (true) {
                    j0<E> j0VarT = T();
                    if (j0VarT == null) {
                        break;
                    }
                    if (j0VarT instanceof w) {
                        this.size = i7;
                        reentrantLock.unlock();
                        return j0VarT;
                    }
                    if (j0VarT.m0(e8, null) != null) {
                        this.size = i7;
                        l2 l2Var = l2.f34958a;
                        reentrantLock.unlock();
                        j0VarT.R(e8);
                        return j0VarT.j();
                    }
                }
            }
            s0(i7, e8);
            r0 r0Var = b.f35563d;
            reentrantLock.unlock();
            return r0Var;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.channels.c
    @a7.d
    protected Object K(E e8, @a7.d kotlinx.coroutines.selects.f<?> fVar) {
        ReentrantLock reentrantLock = this.f35596f;
        reentrantLock.lock();
        try {
            int i7 = this.size;
            w<?> wVarU = u();
            if (wVarU != null) {
                reentrantLock.unlock();
                return wVarU;
            }
            r0 r0VarU0 = u0(i7);
            if (r0VarU0 != null) {
                reentrantLock.unlock();
                return r0VarU0;
            }
            if (i7 == 0) {
                while (true) {
                    c.d<E> dVarM = m(e8);
                    Object objE0 = fVar.e0(dVarM);
                    if (objE0 == null) {
                        this.size = i7;
                        j0<? super E> j0VarO = dVarM.o();
                        l2 l2Var = l2.f34958a;
                        reentrantLock.unlock();
                        kotlin.jvm.internal.l0.m(j0VarO);
                        j0<? super E> j0Var = j0VarO;
                        j0Var.R(e8);
                        return j0Var.j();
                    }
                    if (objE0 == b.f35564e) {
                        break;
                    }
                    if (objE0 != kotlinx.coroutines.internal.c.f36965b) {
                        if (objE0 != kotlinx.coroutines.selects.g.d() && !(objE0 instanceof w)) {
                            throw new IllegalStateException(kotlin.jvm.internal.l0.C("performAtomicTrySelect(describeTryOffer) returned ", objE0).toString());
                        }
                        this.size = i7;
                        reentrantLock.unlock();
                        return objE0;
                    }
                }
            }
            if (fVar.q()) {
                s0(i7, e8);
                r0 r0Var = b.f35563d;
                reentrantLock.unlock();
                return r0Var;
            }
            this.size = i7;
            Object objD = kotlinx.coroutines.selects.g.d();
            reentrantLock.unlock();
            return objD;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.channels.a
    protected boolean c0(@a7.d h0<? super E> h0Var) {
        ReentrantLock reentrantLock = this.f35596f;
        reentrantLock.lock();
        try {
            return super.c0(h0Var);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.a
    protected final boolean f0() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.a
    protected final boolean g0() {
        return this.size == 0;
    }

    @Override // kotlinx.coroutines.channels.a
    protected void i0(boolean z7) {
        i5.l<E, l2> lVar = this.f35570a;
        ReentrantLock reentrantLock = this.f35596f;
        reentrantLock.lock();
        try {
            int i7 = this.size;
            d1 d1VarC = null;
            int i8 = 0;
            while (i8 < i7) {
                i8++;
                Object obj = this.f35597g[this.f35598h];
                if (lVar != null && obj != b.f35562c) {
                    d1VarC = kotlinx.coroutines.internal.i0.c(lVar, obj, d1VarC);
                }
                Object[] objArr = this.f35597g;
                int i9 = this.f35598h;
                objArr[i9] = b.f35562c;
                this.f35598h = (i9 + 1) % objArr.length;
            }
            this.size = 0;
            l2 l2Var = l2.f34958a;
            reentrantLock.unlock();
            super.i0(z7);
            if (d1VarC != null) {
                throw d1VarC;
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.channels.a, kotlinx.coroutines.channels.i0
    public boolean isEmpty() {
        ReentrantLock reentrantLock = this.f35596f;
        reentrantLock.lock();
        try {
            return h0();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.a, kotlinx.coroutines.channels.i0
    public boolean j() {
        ReentrantLock reentrantLock = this.f35596f;
        reentrantLock.lock();
        try {
            return super.j();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.a
    @a7.e
    protected Object m0() {
        ReentrantLock reentrantLock = this.f35596f;
        reentrantLock.lock();
        try {
            int i7 = this.size;
            if (i7 == 0) {
                Object objU = u();
                if (objU == null) {
                    objU = b.f35565f;
                }
                reentrantLock.unlock();
                return objU;
            }
            Object[] objArr = this.f35597g;
            int i8 = this.f35598h;
            Object obj = objArr[i8];
            l0 l0Var = null;
            objArr[i8] = null;
            this.size = i7 - 1;
            Object objW0 = b.f35565f;
            boolean z7 = false;
            if (i7 == this.f35594d) {
                l0 l0Var2 = null;
                while (true) {
                    l0 l0VarU = U();
                    if (l0VarU == null) {
                        l0Var = l0Var2;
                        break;
                    }
                    if (l0VarU.Y0(null) != null) {
                        objW0 = l0VarU.W0();
                        z7 = true;
                        l0Var = l0VarU;
                        break;
                    }
                    l0VarU.Z0();
                    l0Var2 = l0VarU;
                }
            }
            if (objW0 != b.f35565f && !(objW0 instanceof w)) {
                this.size = i7;
                Object[] objArr2 = this.f35597g;
                objArr2[(this.f35598h + i7) % objArr2.length] = objW0;
            }
            this.f35598h = (this.f35598h + 1) % this.f35597g.length;
            l2 l2Var = l2.f34958a;
            reentrantLock.unlock();
            if (z7) {
                kotlin.jvm.internal.l0.m(l0Var);
                l0Var.V0();
            }
            return obj;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.channels.a
    @a7.e
    protected Object n0(@a7.d kotlinx.coroutines.selects.f<?> fVar) {
        boolean z7;
        ReentrantLock reentrantLock = this.f35596f;
        reentrantLock.lock();
        try {
            int i7 = this.size;
            if (i7 == 0) {
                Object objU = u();
                if (objU == null) {
                    objU = b.f35565f;
                }
                reentrantLock.unlock();
                return objU;
            }
            Object[] objArr = this.f35597g;
            int i8 = this.f35598h;
            Object obj = objArr[i8];
            Object objO = null;
            objArr[i8] = null;
            this.size = i7 - 1;
            Object objW0 = b.f35565f;
            if (i7 != this.f35594d) {
                z7 = false;
                break;
            }
            while (true) {
                kotlinx.coroutines.channels.a.g<E> gVarA0 = a0();
                Object objE0 = fVar.e0(gVarA0);
                if (objE0 == null) {
                    objO = gVarA0.o();
                    kotlin.jvm.internal.l0.m(objO);
                    objW0 = ((l0) objO).W0();
                    z7 = true;
                    break;
                }
                if (objE0 == b.f35565f) {
                    z7 = false;
                    break;
                }
                if (objE0 != kotlinx.coroutines.internal.c.f36965b) {
                    if (objE0 == kotlinx.coroutines.selects.g.d()) {
                        this.size = i7;
                        this.f35597g[this.f35598h] = obj;
                        reentrantLock.unlock();
                        return objE0;
                    }
                    if (!(objE0 instanceof w)) {
                        throw new IllegalStateException(kotlin.jvm.internal.l0.C("performAtomicTrySelect(describeTryOffer) returned ", objE0).toString());
                    }
                    z7 = true;
                    objW0 = objE0;
                    objO = objW0;
                    break;
                }
            }
            if (objW0 != b.f35565f && !(objW0 instanceof w)) {
                this.size = i7;
                Object[] objArr2 = this.f35597g;
                objArr2[(this.f35598h + i7) % objArr2.length] = objW0;
            } else if (!fVar.q()) {
                this.size = i7;
                this.f35597g[this.f35598h] = obj;
                Object objD = kotlinx.coroutines.selects.g.d();
                reentrantLock.unlock();
                return objD;
            }
            this.f35598h = (this.f35598h + 1) % this.f35597g.length;
            l2 l2Var = l2.f34958a;
            reentrantLock.unlock();
            if (z7) {
                kotlin.jvm.internal.l0.m(objO);
                ((l0) objO).V0();
            }
            return obj;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.channels.c
    @a7.e
    protected Object q(@a7.d l0 l0Var) {
        ReentrantLock reentrantLock = this.f35596f;
        reentrantLock.lock();
        try {
            return super.q(l0Var);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.c
    @a7.d
    protected String r() {
        return "(buffer:capacity=" + this.f35594d + ",size=" + this.size + ')';
    }
}
