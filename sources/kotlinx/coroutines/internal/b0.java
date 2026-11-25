package kotlinx.coroutines.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes3.dex */
public final class b0<E> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f36943h = 8;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f36944i = 30;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f36945j = 1073741823;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f36946k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f36947l = 1073741823;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f36948m = 30;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long f36949n = 1152921503533105152L;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f36950o = 60;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final long f36951p = 1152921504606846976L;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f36952q = 61;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final long f36953r = 2305843009213693952L;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f36954s = 1024;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f36956u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f36957v = 1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f36958w = 2;

    @a7.d
    private volatile /* synthetic */ Object _next = null;

    @a7.d
    private volatile /* synthetic */ long _state = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f36959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f36960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f36961c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    private /* synthetic */ AtomicReferenceArray f36962d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    public static final a f36940e = new a(null);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @a7.d
    @h5.e
    public static final r0 f36955t = new r0("REMOVE_FROZEN");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f36941f = AtomicReferenceFieldUpdater.newUpdater(b0.class, Object.class, "_next");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f36942g = AtomicLongFieldUpdater.newUpdater(b0.class, "_state");

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.w wVar) {
            this();
        }

        public final int a(long j7) {
            return (j7 & b0.f36953r) != 0 ? 2 : 1;
        }

        public final long b(long j7, int i7) {
            return e(j7, b0.f36947l) | (((long) i7) << 0);
        }

        public final long c(long j7, int i7) {
            return e(j7, b0.f36949n) | (((long) i7) << 30);
        }

        public final <T> T d(long j7, @a7.d i5.p<? super Integer, ? super Integer, ? extends T> pVar) {
            return pVar.a0(Integer.valueOf((int) ((b0.f36947l & j7) >> 0)), Integer.valueOf((int) ((j7 & b0.f36949n) >> 30)));
        }

        public final long e(long j7, long j8) {
            return j7 & (~j8);
        }

        private a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @h5.e
        public final int f36963a;

        public b(int i7) {
            this.f36963a = i7;
        }
    }

    public b0(int i7, boolean z7) {
        this.f36959a = i7;
        this.f36960b = z7;
        int i8 = i7 - 1;
        this.f36961c = i8;
        this.f36962d = new AtomicReferenceArray(i7);
        if (!(i8 <= 1073741823)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!((i7 & i8) == 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final b0<E> b(long j7) {
        b0<E> b0Var = new b0<>(this.f36959a * 2, this.f36960b);
        int i7 = (int) ((f36947l & j7) >> 0);
        int i8 = (int) ((f36949n & j7) >> 30);
        while (true) {
            int i9 = this.f36961c;
            if ((i7 & i9) == (i8 & i9)) {
                b0Var._state = f36940e.e(j7, f36951p);
                return b0Var;
            }
            Object bVar = this.f36962d.get(i9 & i7);
            if (bVar == null) {
                bVar = new b(i7);
            }
            b0Var.f36962d.set(b0Var.f36961c & i7, bVar);
            i7++;
        }
    }

    private final b0<E> c(long j7) {
        while (true) {
            b0<E> b0Var = (b0) this._next;
            if (b0Var != null) {
                return b0Var;
            }
            androidx.concurrent.futures.b.a(f36941f, this, null, b(j7));
        }
    }

    private final b0<E> e(int i7, E e8) {
        Object obj = this.f36962d.get(this.f36961c & i7);
        if (!(obj instanceof b) || ((b) obj).f36963a != i7) {
            return null;
        }
        this.f36962d.set(i7 & this.f36961c, e8);
        return this;
    }

    private final long j() {
        long j7;
        long j8;
        do {
            j7 = this._state;
            if ((j7 & f36951p) != 0) {
                return j7;
            }
            j8 = j7 | f36951p;
        } while (!f36942g.compareAndSet(this, j7, j8));
        return j8;
    }

    private final b0<E> m(int i7, int i8) {
        long j7;
        int i9;
        do {
            j7 = this._state;
            i9 = (int) ((f36947l & j7) >> 0);
            if ((f36951p & j7) != 0) {
                return k();
            }
        } while (!f36942g.compareAndSet(this, j7, f36940e.b(j7, i8)));
        this.f36962d.set(i9 & this.f36961c, null);
        return null;
    }

    public final int a(@a7.d E e8) {
        while (true) {
            long j7 = this._state;
            if ((3458764513820540928L & j7) != 0) {
                return f36940e.a(j7);
            }
            int i7 = (int) ((f36947l & j7) >> 0);
            int i8 = (int) ((f36949n & j7) >> 30);
            int i9 = this.f36961c;
            if (((i8 + 2) & i9) == (i7 & i9)) {
                return 1;
            }
            if (!this.f36960b && this.f36962d.get(i8 & i9) != null) {
                int i10 = this.f36959a;
                if (i10 < 1024 || ((i8 - i7) & f36945j) > (i10 >> 1)) {
                    return 1;
                }
            } else if (f36942g.compareAndSet(this, j7, f36940e.c(j7, (i8 + 1) & f36945j))) {
                this.f36962d.set(i8 & i9, e8);
                b0<E> b0VarE = this;
                while ((b0VarE._state & f36951p) != 0 && (b0VarE = b0VarE.k().e(i8, e8)) != null) {
                }
                return 0;
            }
        }
    }

    public final boolean d() {
        long j7;
        do {
            j7 = this._state;
            if ((j7 & f36953r) != 0) {
                return true;
            }
            if ((f36951p & j7) != 0) {
                return false;
            }
        } while (!f36942g.compareAndSet(this, j7, j7 | f36953r));
        return true;
    }

    public final int f() {
        long j7 = this._state;
        return (((int) ((j7 & f36949n) >> 30)) - ((int) ((f36947l & j7) >> 0))) & f36945j;
    }

    public final boolean g() {
        return (this._state & f36953r) != 0;
    }

    public final boolean h() {
        long j7 = this._state;
        return ((int) ((f36947l & j7) >> 0)) == ((int) ((j7 & f36949n) >> 30));
    }

    @a7.d
    public final <R> List<R> i(@a7.d i5.l<? super E, ? extends R> lVar) {
        ArrayList arrayList = new ArrayList(this.f36959a);
        long j7 = this._state;
        int i7 = (int) ((f36947l & j7) >> 0);
        int i8 = (int) ((j7 & f36949n) >> 30);
        while (true) {
            int i9 = this.f36961c;
            if ((i7 & i9) == (i8 & i9)) {
                return arrayList;
            }
            a1.c cVar = (Object) this.f36962d.get(i9 & i7);
            if (cVar != null && !(cVar instanceof b)) {
                arrayList.add(lVar.z(cVar));
            }
            i7++;
        }
    }

    @a7.d
    public final b0<E> k() {
        return c(j());
    }

    @a7.e
    public final Object l() {
        while (true) {
            long j7 = this._state;
            if ((f36951p & j7) != 0) {
                return f36955t;
            }
            int i7 = (int) ((f36947l & j7) >> 0);
            int i8 = (int) ((f36949n & j7) >> 30);
            int i9 = this.f36961c;
            if ((i8 & i9) == (i7 & i9)) {
                return null;
            }
            Object obj = this.f36962d.get(i9 & i7);
            if (obj == null) {
                if (this.f36960b) {
                    return null;
                }
            } else {
                if (obj instanceof b) {
                    return null;
                }
                int i10 = (i7 + 1) & f36945j;
                if (f36942g.compareAndSet(this, j7, f36940e.b(j7, i10))) {
                    this.f36962d.set(this.f36961c & i7, null);
                    return obj;
                }
                if (this.f36960b) {
                    b0<E> b0VarM = this;
                    do {
                        b0VarM = b0VarM.m(i7, i10);
                    } while (b0VarM != null);
                    return obj;
                }
            }
        }
    }
}
