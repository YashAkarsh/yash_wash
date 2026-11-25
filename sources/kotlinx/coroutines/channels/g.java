package kotlinx.coroutines.channels;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.l2;
import kotlinx.coroutines.internal.r0;

/* JADX INFO: loaded from: classes2.dex */
public final class g<E> extends c<E> implements i<E> {

    @a7.d
    private volatile /* synthetic */ long _head;

    @a7.d
    private volatile /* synthetic */ int _size;

    @a7.d
    private volatile /* synthetic */ long _tail;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f35588d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    private final ReentrantLock f35589e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @a7.d
    private final Object[] f35590f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @a7.d
    private final List<a<E>> f35591g;

    private static final class a<E> extends kotlinx.coroutines.channels.a<E> implements i0<E> {

        @a7.d
        private volatile /* synthetic */ long _subHead;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @a7.d
        private final g<E> f35592d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @a7.d
        private final ReentrantLock f35593e;

        public a(@a7.d g<E> gVar) {
            super(null);
            this.f35592d = gVar;
            this.f35593e = new ReentrantLock();
            this._subHead = 0L;
        }

        private final boolean u0() {
            if (t() != null) {
                return false;
            }
            return (g0() && this.f35592d.t() == null) ? false : true;
        }

        private final Object v0() {
            long jT0 = t0();
            w<?> wVarT = this.f35592d.t();
            if (jT0 >= this.f35592d.f0()) {
                if (wVarT == null) {
                    wVarT = t();
                }
                return wVarT == null ? b.f35565f : wVarT;
            }
            Object objA0 = this.f35592d.a0(jT0);
            w<?> wVarT2 = t();
            return wVarT2 != null ? wVarT2 : objA0;
        }

        @Override // kotlinx.coroutines.channels.c, kotlinx.coroutines.channels.m0
        public boolean B(@a7.e Throwable th) {
            boolean zB = super.B(th);
            if (zB) {
                g.k0(this.f35592d, null, this, 1, null);
                ReentrantLock reentrantLock = this.f35593e;
                reentrantLock.lock();
                try {
                    w0(this.f35592d.f0());
                    l2 l2Var = l2.f34958a;
                } finally {
                    reentrantLock.unlock();
                }
            }
            return zB;
        }

        @Override // kotlinx.coroutines.channels.c
        protected boolean F() {
            throw new IllegalStateException("Should not be used".toString());
        }

        @Override // kotlinx.coroutines.channels.c
        protected boolean H() {
            throw new IllegalStateException("Should not be used".toString());
        }

        @Override // kotlinx.coroutines.channels.a
        protected boolean f0() {
            return false;
        }

        @Override // kotlinx.coroutines.channels.a
        protected boolean g0() {
            return t0() >= this.f35592d.f0();
        }

        @Override // kotlinx.coroutines.channels.a
        @a7.e
        protected Object m0() {
            boolean z7;
            ReentrantLock reentrantLock = this.f35593e;
            reentrantLock.lock();
            try {
                Object objV0 = v0();
                if ((objV0 instanceof w) || objV0 == b.f35565f) {
                    z7 = false;
                } else {
                    w0(t0() + 1);
                    z7 = true;
                }
                reentrantLock.unlock();
                w wVar = objV0 instanceof w ? (w) objV0 : null;
                if (wVar != null) {
                    B(wVar.f35875d);
                }
                if (s0() ? true : z7) {
                    g.k0(this.f35592d, null, null, 3, null);
                }
                return objV0;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }

        @Override // kotlinx.coroutines.channels.a
        @a7.e
        protected Object n0(@a7.d kotlinx.coroutines.selects.f<?> fVar) {
            ReentrantLock reentrantLock = this.f35593e;
            reentrantLock.lock();
            try {
                Object objV0 = v0();
                boolean z7 = false;
                if (!(objV0 instanceof w) && objV0 != b.f35565f) {
                    if (fVar.q()) {
                        w0(t0() + 1);
                        z7 = true;
                    } else {
                        objV0 = kotlinx.coroutines.selects.g.d();
                    }
                }
                reentrantLock.unlock();
                w wVar = objV0 instanceof w ? (w) objV0 : null;
                if (wVar != null) {
                    B(wVar.f35875d);
                }
                if (s0() ? true : z7) {
                    g.k0(this.f35592d, null, null, 3, null);
                }
                return objV0;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final boolean s0() {
            w wVar;
            boolean z7 = false;
            while (true) {
                wVar = null;
                if (!u0() || !this.f35593e.tryLock()) {
                    break;
                }
                try {
                    Object objV0 = v0();
                    if (objV0 != b.f35565f) {
                        if (objV0 instanceof w) {
                            wVar = (w) objV0;
                        } else {
                            j0<E> j0VarT = T();
                            if (j0VarT != 0 && !(j0VarT instanceof w)) {
                                if (j0VarT.m0(objV0, null) != null) {
                                    w0(t0() + 1);
                                    this.f35593e.unlock();
                                    j0VarT.R(objV0);
                                    z7 = true;
                                }
                            }
                        }
                        this.f35593e.unlock();
                        break;
                    }
                    this.f35593e.unlock();
                } catch (Throwable th) {
                    this.f35593e.unlock();
                    throw th;
                }
            }
            if (wVar != null) {
                B(wVar.f35875d);
            }
            return z7;
        }

        public final long t0() {
            return this._subHead;
        }

        public final void w0(long j7) {
            this._subHead = j7;
        }
    }

    public g(int i7) {
        super(null);
        this.f35588d = i7;
        if (!(i7 >= 1)) {
            throw new IllegalArgumentException(("ArrayBroadcastChannel capacity must be at least 1, but " + b0() + " was specified").toString());
        }
        this.f35589e = new ReentrantLock();
        this.f35590f = new Object[i7];
        this._head = 0L;
        this._tail = 0L;
        this._size = 0;
        this.f35591g = kotlinx.coroutines.internal.f.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // kotlinx.coroutines.channels.i
    /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
    public final boolean e(Throwable th) {
        boolean zB = B(th);
        Iterator<a<E>> it = this.f35591g.iterator();
        while (it.hasNext()) {
            it.next().e(th);
        }
        return zB;
    }

    private final void Y() {
        boolean z7;
        Iterator<a<E>> it = this.f35591g.iterator();
        boolean z8 = false;
        loop0: while (true) {
            z7 = z8;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                } else if (it.next().s0()) {
                    break;
                } else {
                    z7 = true;
                }
            }
            z8 = true;
        }
        if (z8 || !z7) {
            k0(this, null, null, 3, null);
        }
    }

    private final long Z() {
        Iterator<a<E>> it = this.f35591g.iterator();
        long jV = Long.MAX_VALUE;
        while (it.hasNext()) {
            jV = kotlin.ranges.q.v(jV, it.next().t0());
        }
        return jV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final E a0(long j7) {
        return (E) this.f35590f[(int) (j7 % ((long) this.f35588d))];
    }

    private final long c0() {
        return this._head;
    }

    private final int d0() {
        return this._size;
    }

    private static /* synthetic */ void e0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long f0() {
        return this._tail;
    }

    private final void g0(long j7) {
        this._head = j7;
    }

    private final void h0(int i7) {
        this._size = i7;
    }

    private final void i0(long j7) {
        this._tail = j7;
    }

    private final void j0(a<E> aVar, a<E> aVar2) {
        l0 l0VarU;
        while (true) {
            ReentrantLock reentrantLock = this.f35589e;
            reentrantLock.lock();
            if (aVar != null) {
                try {
                    aVar.w0(f0());
                    boolean zIsEmpty = this.f35591g.isEmpty();
                    this.f35591g.add(aVar);
                    if (!zIsEmpty) {
                        reentrantLock.unlock();
                        return;
                    }
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            }
            if (aVar2 != null) {
                this.f35591g.remove(aVar2);
                if (c0() != aVar2.t0()) {
                    reentrantLock.unlock();
                    return;
                }
            }
            long jZ = Z();
            long jF0 = f0();
            long jC0 = c0();
            long jV = kotlin.ranges.q.v(jZ, jF0);
            if (jV <= jC0) {
                reentrantLock.unlock();
                return;
            }
            int iD0 = d0();
            while (true) {
                if (jC0 >= jV) {
                    reentrantLock.unlock();
                    return;
                }
                this.f35590f[(int) (jC0 % ((long) b0()))] = null;
                boolean z7 = iD0 >= b0();
                jC0++;
                g0(jC0);
                iD0--;
                h0(iD0);
                if (z7) {
                    while (true) {
                        l0VarU = U();
                        if (l0VarU != null && !(l0VarU instanceof w)) {
                            if (l0VarU.Y0(null) != null) {
                                break;
                            }
                        }
                    }
                }
            }
            this.f35590f[(int) (jF0 % ((long) b0()))] = l0VarU.W0();
            h0(iD0 + 1);
            i0(jF0 + 1);
            l2 l2Var = l2.f34958a;
            reentrantLock.unlock();
            l0VarU.V0();
            Y();
            aVar = null;
            aVar2 = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void k0(g gVar, a aVar, a aVar2, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            aVar = null;
        }
        if ((i7 & 2) != 0) {
            aVar2 = null;
        }
        gVar.j0(aVar, aVar2);
    }

    @Override // kotlinx.coroutines.channels.c, kotlinx.coroutines.channels.m0
    public boolean B(@a7.e Throwable th) {
        if (!super.B(th)) {
            return false;
        }
        Y();
        return true;
    }

    @Override // kotlinx.coroutines.channels.c
    protected boolean F() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.i
    @a7.d
    public i0<E> G() {
        a aVar = new a(this);
        k0(this, aVar, null, 2, null);
        return aVar;
    }

    @Override // kotlinx.coroutines.channels.c
    protected boolean H() {
        return d0() >= this.f35588d;
    }

    @Override // kotlinx.coroutines.channels.c
    @a7.d
    protected Object J(E e8) {
        ReentrantLock reentrantLock = this.f35589e;
        reentrantLock.lock();
        try {
            w<?> wVarU = u();
            if (wVarU != null) {
                reentrantLock.unlock();
                return wVarU;
            }
            int iD0 = d0();
            if (iD0 >= b0()) {
                r0 r0Var = b.f35564e;
                reentrantLock.unlock();
                return r0Var;
            }
            long jF0 = f0();
            this.f35590f[(int) (jF0 % ((long) b0()))] = e8;
            h0(iD0 + 1);
            i0(jF0 + 1);
            l2 l2Var = l2.f34958a;
            reentrantLock.unlock();
            Y();
            return b.f35563d;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.channels.c
    @a7.d
    protected Object K(E e8, @a7.d kotlinx.coroutines.selects.f<?> fVar) {
        ReentrantLock reentrantLock = this.f35589e;
        reentrantLock.lock();
        try {
            w<?> wVarU = u();
            if (wVarU != null) {
                reentrantLock.unlock();
                return wVarU;
            }
            int iD0 = d0();
            if (iD0 >= b0()) {
                r0 r0Var = b.f35564e;
                reentrantLock.unlock();
                return r0Var;
            }
            if (!fVar.q()) {
                Object objD = kotlinx.coroutines.selects.g.d();
                reentrantLock.unlock();
                return objD;
            }
            long jF0 = f0();
            this.f35590f[(int) (jF0 % ((long) b0()))] = e8;
            h0(iD0 + 1);
            i0(jF0 + 1);
            l2 l2Var = l2.f34958a;
            reentrantLock.unlock();
            Y();
            return b.f35563d;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final int b0() {
        return this.f35588d;
    }

    @Override // kotlinx.coroutines.channels.i
    public void c(@a7.e CancellationException cancellationException) {
        e(cancellationException);
    }

    @Override // kotlinx.coroutines.channels.c
    @a7.d
    protected String r() {
        return "(buffer:capacity=" + this.f35590f.length + ",size=" + d0() + ')';
    }
}
