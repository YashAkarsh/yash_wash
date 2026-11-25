package kotlinx.coroutines.channels;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.l2;
import kotlinx.coroutines.internal.d1;
import kotlinx.coroutines.internal.r0;

/* JADX INFO: loaded from: classes2.dex */
public class a0<E> extends a<E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    private final ReentrantLock f35558d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.e
    private Object f35559e;

    public a0(@a7.e i5.l<? super E, l2> lVar) {
        super(lVar);
        this.f35558d = new ReentrantLock();
        this.f35559e = b.f35562c;
    }

    private final d1 s0(Object obj) {
        i5.l<E, l2> lVar;
        Object obj2 = this.f35559e;
        d1 d1VarD = null;
        if (obj2 != b.f35562c && (lVar = this.f35570a) != null) {
            d1VarD = kotlinx.coroutines.internal.i0.d(lVar, obj2, null, 2, null);
        }
        this.f35559e = obj;
        return d1VarD;
    }

    @Override // kotlinx.coroutines.channels.c
    protected final boolean F() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.c
    protected final boolean H() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.c
    @a7.d
    protected Object J(E e8) {
        ReentrantLock reentrantLock = this.f35558d;
        reentrantLock.lock();
        try {
            w<?> wVarU = u();
            if (wVarU != null) {
                reentrantLock.unlock();
                return wVarU;
            }
            if (this.f35559e == b.f35562c) {
                while (true) {
                    j0<E> j0VarT = T();
                    if (j0VarT == null) {
                        break;
                    }
                    if (j0VarT instanceof w) {
                        reentrantLock.unlock();
                        return j0VarT;
                    }
                    if (j0VarT.m0(e8, null) != null) {
                        l2 l2Var = l2.f34958a;
                        reentrantLock.unlock();
                        j0VarT.R(e8);
                        return j0VarT.j();
                    }
                }
            }
            d1 d1VarS0 = s0(e8);
            if (d1VarS0 != null) {
                throw d1VarS0;
            }
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
        ReentrantLock reentrantLock = this.f35558d;
        reentrantLock.lock();
        try {
            w<?> wVarU = u();
            if (wVarU != null) {
                reentrantLock.unlock();
                return wVarU;
            }
            if (this.f35559e == b.f35562c) {
                while (true) {
                    c.d<E> dVarM = m(e8);
                    Object objE0 = fVar.e0(dVarM);
                    if (objE0 == null) {
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
                        reentrantLock.unlock();
                        return objE0;
                    }
                }
            }
            if (!fVar.q()) {
                Object objD = kotlinx.coroutines.selects.g.d();
                reentrantLock.unlock();
                return objD;
            }
            d1 d1VarS0 = s0(e8);
            if (d1VarS0 != null) {
                throw d1VarS0;
            }
            r0 r0Var = b.f35563d;
            reentrantLock.unlock();
            return r0Var;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.channels.a
    protected boolean c0(@a7.d h0<? super E> h0Var) {
        ReentrantLock reentrantLock = this.f35558d;
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
        return this.f35559e == b.f35562c;
    }

    @Override // kotlinx.coroutines.channels.a
    protected void i0(boolean z7) {
        ReentrantLock reentrantLock = this.f35558d;
        reentrantLock.lock();
        try {
            d1 d1VarS0 = s0(b.f35562c);
            l2 l2Var = l2.f34958a;
            reentrantLock.unlock();
            super.i0(z7);
            if (d1VarS0 != null) {
                throw d1VarS0;
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.channels.a, kotlinx.coroutines.channels.i0
    public boolean isEmpty() {
        ReentrantLock reentrantLock = this.f35558d;
        reentrantLock.lock();
        try {
            return h0();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.a
    @a7.e
    protected Object m0() {
        ReentrantLock reentrantLock = this.f35558d;
        reentrantLock.lock();
        try {
            Object obj = this.f35559e;
            r0 r0Var = b.f35562c;
            if (obj != r0Var) {
                this.f35559e = r0Var;
                l2 l2Var = l2.f34958a;
                return obj;
            }
            Object objU = u();
            if (objU == null) {
                objU = b.f35565f;
            }
            return objU;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.a
    @a7.e
    protected Object n0(@a7.d kotlinx.coroutines.selects.f<?> fVar) {
        ReentrantLock reentrantLock = this.f35558d;
        reentrantLock.lock();
        try {
            Object obj = this.f35559e;
            r0 r0Var = b.f35562c;
            if (obj == r0Var) {
                Object objU = u();
                if (objU == null) {
                    objU = b.f35565f;
                }
                return objU;
            }
            if (!fVar.q()) {
                return kotlinx.coroutines.selects.g.d();
            }
            Object obj2 = this.f35559e;
            this.f35559e = r0Var;
            l2 l2Var = l2.f34958a;
            return obj2;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.c
    @a7.d
    protected String r() {
        return "(value=" + this.f35559e + ')';
    }
}
