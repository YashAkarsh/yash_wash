package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.b1;
import kotlin.jvm.internal.t1;
import kotlin.l2;
import kotlinx.coroutines.f3;
import kotlinx.coroutines.internal.r0;

/* JADX INFO: loaded from: classes2.dex */
@f3
public final class z<E> implements i<E> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f35877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f35878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f35879d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @a7.d
    @Deprecated
    private static final r0 f35881f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @a7.d
    @Deprecated
    private static final c<Object> f35882g;

    @a7.d
    private volatile /* synthetic */ Object _state;

    @a7.d
    private volatile /* synthetic */ int _updating;

    @a7.d
    private volatile /* synthetic */ Object onCloseHandler;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private static final b f35876a = new b(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    @Deprecated
    private static final a f35880e = new a(null);

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @h5.e
        @a7.e
        public final Throwable f35883a;

        public a(@a7.e Throwable th) {
            this.f35883a = th;
        }

        @a7.d
        public final Throwable a() {
            Throwable th = this.f35883a;
            return th == null ? new y(s.f35660a) : th;
        }

        @a7.d
        public final Throwable b() {
            Throwable th = this.f35883a;
            return th == null ? new IllegalStateException(s.f35660a) : th;
        }
    }

    private static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.w wVar) {
            this();
        }

        private b() {
        }
    }

    private static final class c<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @h5.e
        @a7.e
        public final Object f35884a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @h5.e
        @a7.e
        public final d<E>[] f35885b;

        public c(@a7.e Object obj, @a7.e d<E>[] dVarArr) {
            this.f35884a = obj;
            this.f35885b = dVarArr;
        }
    }

    private static final class d<E> extends a0<E> implements i0<E> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @a7.d
        private final z<E> f35886f;

        public d(@a7.d z<E> zVar) {
            super(null);
            this.f35886f = zVar;
        }

        @Override // kotlinx.coroutines.channels.a0, kotlinx.coroutines.channels.c
        @a7.d
        public Object J(E e8) {
            return super.J(e8);
        }

        @Override // kotlinx.coroutines.channels.a0, kotlinx.coroutines.channels.a
        protected void i0(boolean z7) {
            if (z7) {
                this.f35886f.g(this);
            }
        }
    }

    public static final class e implements kotlinx.coroutines.selects.e<E, m0<? super E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ z<E> f35887a;

        e(z<E> zVar) {
            this.f35887a = zVar;
        }

        @Override // kotlinx.coroutines.selects.e
        public <R> void y(@a7.d kotlinx.coroutines.selects.f<? super R> fVar, E e8, @a7.d i5.p<? super m0<? super E>, ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar) {
            this.f35887a.m(fVar, e8, pVar);
        }
    }

    static {
        r0 r0Var = new r0("UNDEFINED");
        f35881f = r0Var;
        f35882g = new c<>(r0Var, null);
        f35877b = AtomicReferenceFieldUpdater.newUpdater(z.class, Object.class, "_state");
        f35878c = AtomicIntegerFieldUpdater.newUpdater(z.class, "_updating");
        f35879d = AtomicReferenceFieldUpdater.newUpdater(z.class, Object.class, "onCloseHandler");
    }

    public z() {
        this._state = f35882g;
        this._updating = 0;
        this.onCloseHandler = null;
    }

    private final d<E>[] f(d<E>[] dVarArr, d<E> dVar) {
        return dVarArr == null ? new d[]{dVar} : (d[]) kotlin.collections.o.X3(dVarArr, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(d<E> dVar) {
        Object obj;
        Object obj2;
        d<E>[] dVarArr;
        do {
            obj = this._state;
            if (obj instanceof a) {
                return;
            }
            if (!(obj instanceof c)) {
                throw new IllegalStateException(kotlin.jvm.internal.l0.C("Invalid state ", obj).toString());
            }
            c cVar = (c) obj;
            obj2 = cVar.f35884a;
            dVarArr = cVar.f35885b;
            kotlin.jvm.internal.l0.m(dVarArr);
        } while (!androidx.concurrent.futures.b.a(f35877b, this, obj, new c(obj2, n(dVarArr, dVar))));
    }

    public static /* synthetic */ void i() {
    }

    private final void k(Throwable th) {
        r0 r0Var;
        Object obj = this.onCloseHandler;
        if (obj == null || obj == (r0Var = kotlinx.coroutines.channels.b.f35567h) || !androidx.concurrent.futures.b.a(f35879d, this, obj, r0Var)) {
            return;
        }
        ((i5.l) t1.q(obj, 1)).z(th);
    }

    private final a l(E e8) {
        Object obj;
        if (!f35878c.compareAndSet(this, 0, 1)) {
            return null;
        }
        do {
            try {
                obj = this._state;
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    this._updating = 0;
                    return aVar;
                }
                if (!(obj instanceof c)) {
                    throw new IllegalStateException(kotlin.jvm.internal.l0.C("Invalid state ", obj).toString());
                }
            } catch (Throwable th) {
                this._updating = 0;
                throw th;
            }
        } while (!androidx.concurrent.futures.b.a(f35877b, this, obj, new c(e8, ((c) obj).f35885b)));
        d<E>[] dVarArr = ((c) obj).f35885b;
        if (dVarArr != null) {
            int length = dVarArr.length;
            int i7 = 0;
            while (i7 < length) {
                d<E> dVar = dVarArr[i7];
                i7++;
                dVar.J(e8);
            }
        }
        this._updating = 0;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <R> void m(kotlinx.coroutines.selects.f<? super R> fVar, E e8, i5.p<? super m0<? super E>, ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar) {
        if (fVar.q()) {
            a aVarL = l(e8);
            if (aVarL == null) {
                r5.b.d(pVar, this, fVar.G());
            } else {
                fVar.Z(aVarL.a());
            }
        }
    }

    private final d<E>[] n(d<E>[] dVarArr, d<E> dVar) {
        int length = dVarArr.length;
        int iJg = kotlin.collections.p.jg(dVarArr, dVar);
        if (length == 1) {
            return null;
        }
        d<E>[] dVarArr2 = new d[length - 1];
        kotlin.collections.o.l1(dVarArr, dVarArr2, 0, 0, iJg, 6, null);
        kotlin.collections.o.l1(dVarArr, dVarArr2, iJg, iJg + 1, 0, 8, null);
        return dVarArr2;
    }

    @Override // kotlinx.coroutines.channels.i
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public boolean e(@a7.e Throwable th) {
        Object obj;
        int i7;
        do {
            obj = this._state;
            i7 = 0;
            if (obj instanceof a) {
                return false;
            }
            if (!(obj instanceof c)) {
                throw new IllegalStateException(kotlin.jvm.internal.l0.C("Invalid state ", obj).toString());
            }
        } while (!androidx.concurrent.futures.b.a(f35877b, this, obj, th == null ? f35880e : new a(th)));
        d<E>[] dVarArr = ((c) obj).f35885b;
        if (dVarArr != null) {
            int length = dVarArr.length;
            while (i7 < length) {
                d<E> dVar = dVarArr[i7];
                i7++;
                dVar.e(th);
            }
        }
        k(th);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.i
    @a7.d
    public i0<E> G() {
        Object obj;
        c cVar;
        d dVar = new d(this);
        do {
            obj = this._state;
            if (obj instanceof a) {
                dVar.e(((a) obj).f35883a);
                return dVar;
            }
            if (!(obj instanceof c)) {
                throw new IllegalStateException(kotlin.jvm.internal.l0.C("Invalid state ", obj).toString());
            }
            cVar = (c) obj;
            Object obj2 = cVar.f35884a;
            if (obj2 != f35881f) {
                dVar.J(obj2);
            }
        } while (!androidx.concurrent.futures.b.a(f35877b, this, obj, new c(cVar.f35884a, f(cVar.f35885b, dVar))));
        return dVar;
    }

    @Override // kotlinx.coroutines.channels.m0
    public void M(@a7.d i5.l<? super Throwable, l2> lVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f35879d;
        if (!androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, null, lVar)) {
            Object obj = this.onCloseHandler;
            if (obj != kotlinx.coroutines.channels.b.f35567h) {
                throw new IllegalStateException(kotlin.jvm.internal.l0.C("Another handler was already registered: ", obj));
            }
            throw new IllegalStateException("Another handler was already registered and successfully invoked");
        }
        Object obj2 = this._state;
        if ((obj2 instanceof a) && androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, lVar, kotlinx.coroutines.channels.b.f35567h)) {
            lVar.z(((a) obj2).f35883a);
        }
    }

    @Override // kotlinx.coroutines.channels.m0
    @a7.d
    public Object Q(E e8) {
        a aVarL = l(e8);
        return aVarL == null ? r.f35656b.c(l2.f34958a) : r.f35656b.a(aVarL.a());
    }

    @Override // kotlinx.coroutines.channels.m0
    @a7.e
    public Object R(E e8, @a7.d kotlin.coroutines.d<? super l2> dVar) throws Throwable {
        a aVarL = l(e8);
        if (aVarL != null) {
            throw aVarL.a();
        }
        if (kotlin.coroutines.intrinsics.d.h() == null) {
            return null;
        }
        return l2.f34958a;
    }

    @Override // kotlinx.coroutines.channels.m0
    public boolean S() {
        return this._state instanceof a;
    }

    @Override // kotlinx.coroutines.channels.i
    public void c(@a7.e CancellationException cancellationException) {
        e(cancellationException);
    }

    public final E h() throws Throwable {
        Object obj = this._state;
        if (obj instanceof a) {
            throw ((a) obj).b();
        }
        if (!(obj instanceof c)) {
            throw new IllegalStateException(kotlin.jvm.internal.l0.C("Invalid state ", obj).toString());
        }
        E e8 = (E) ((c) obj).f35884a;
        if (e8 != f35881f) {
            return e8;
        }
        throw new IllegalStateException("No value");
    }

    @a7.e
    public final E j() {
        Object obj = this._state;
        if (obj instanceof a) {
            return null;
        }
        if (!(obj instanceof c)) {
            throw new IllegalStateException(kotlin.jvm.internal.l0.C("Invalid state ", obj).toString());
        }
        r0 r0Var = f35881f;
        E e8 = (E) ((c) obj).f35884a;
        if (e8 == r0Var) {
            return null;
        }
        return e8;
    }

    @Override // kotlinx.coroutines.channels.m0
    @kotlin.k(level = kotlin.m.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @b1(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E e8) {
        return i.a.c(this, e8);
    }

    @Override // kotlinx.coroutines.channels.m0
    @a7.d
    public kotlinx.coroutines.selects.e<E, m0<E>> z() {
        return new e(this);
    }

    public z(E e8) {
        this();
        f35877b.lazySet(this, new c(e8, null));
    }
}
