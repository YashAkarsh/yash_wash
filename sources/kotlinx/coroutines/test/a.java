package kotlinx.coroutines.test;

import a7.d;
import a7.e;
import i5.l;
import i5.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.b1;
import kotlin.coroutines.g;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;
import kotlin.k;
import kotlin.l2;
import kotlin.m;
import kotlinx.coroutines.f1;
import kotlinx.coroutines.internal.a1;
import kotlinx.coroutines.p0;
import kotlinx.coroutines.q;
import kotlinx.coroutines.q1;
import kotlinx.coroutines.u1;

/* JADX INFO: loaded from: classes3.dex */
@k(level = m.ERROR, message = "This API has been deprecated to integrate with Structured Concurrency.", replaceWith = @b1(expression = "TestCoroutineScope", imports = {"kotlin.coroutines.test"}))
public final class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @e
    private final String f37302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @d
    private final List<Throwable> f37303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @d
    private final C0495a f37304c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @d
    private final p0 f37305d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @d
    private final a1<c> f37306e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f37307f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f37308g;

    /* JADX INFO: renamed from: kotlinx.coroutines.test.a$a, reason: collision with other inner class name */
    private final class C0495a extends u1 implements f1 {

        /* JADX INFO: renamed from: kotlinx.coroutines.test.a$a$a, reason: collision with other inner class name */
        public static final class C0496a implements q1 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f37310a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ c f37311b;

            C0496a(a aVar, c cVar) {
                this.f37310a = aVar;
                this.f37311b = cVar;
            }

            @Override // kotlinx.coroutines.q1
            public void F() {
                this.f37310a.f37306e.j(this.f37311b);
            }
        }

        /* JADX INFO: renamed from: kotlinx.coroutines.test.a$a$b */
        public static final class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ q f37312a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ C0495a f37313b;

            public b(q qVar, C0495a c0495a) {
                this.f37312a = qVar;
                this.f37313b = c0495a;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f37312a.N(this.f37313b, l2.f34958a);
            }
        }

        public C0495a() {
            u1.A1(this, false, 1, null);
        }

        @Override // kotlinx.coroutines.o0
        public void T0(@d g gVar, @d Runnable runnable) {
            a.this.D(runnable);
        }

        @Override // kotlinx.coroutines.u1
        public long W1() {
            return a.this.M();
        }

        @Override // kotlinx.coroutines.u1
        public boolean Y1() {
            return true;
        }

        @Override // kotlinx.coroutines.f1
        @d
        public q1 p0(long j7, @d Runnable runnable, @d g gVar) {
            return new C0496a(a.this, a.this.L(runnable, j7));
        }

        @Override // kotlinx.coroutines.f1
        public void s(long j7, @d q<? super l2> qVar) {
            a.this.L(new b(qVar, this), j7);
        }

        @Override // kotlinx.coroutines.f1
        @k(level = m.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
        @e
        public Object s0(long j7, @d kotlin.coroutines.d<? super l2> dVar) {
            return f1.a.a(this, j7, dVar);
        }

        @Override // kotlinx.coroutines.o0
        @d
        public String toString() {
            return "Dispatcher(" + a.this + ')';
        }
    }

    public static final class b extends kotlin.coroutines.a implements p0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f37314a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(p0.b bVar, a aVar) {
            super(bVar);
            this.f37314a = aVar;
        }

        @Override // kotlinx.coroutines.p0
        public void handleException(@d g gVar, @d Throwable th) {
            this.f37314a.f37303b.add(th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void A(a aVar, String str, l lVar, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            str = "";
        }
        aVar.z(str, lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(Runnable runnable) {
        a1<c> a1Var = this.f37306e;
        long j7 = this.f37307f;
        this.f37307f = 1 + j7;
        a1Var.b(new c(runnable, j7, 0L, 4, null));
    }

    public static /* synthetic */ long J(a aVar, TimeUnit timeUnit, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        return aVar.I(timeUnit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final c L(Runnable runnable, long j7) {
        long j8 = this.f37307f;
        this.f37307f = 1 + j8;
        c cVar = new c(runnable, j8, this.f37308g + TimeUnit.MILLISECONDS.toNanos(j7));
        this.f37306e.b(cVar);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long M() {
        c cVar = (c) this.f37306e.h();
        if (cVar != null) {
            O(cVar.f37317c);
        }
        return this.f37306e.g() ? Long.MAX_VALUE : 0L;
    }

    private final void O(long j7) {
        kotlinx.coroutines.internal.b1 b1VarK;
        while (true) {
            a1<c> a1Var = this.f37306e;
            synchronized (a1Var) {
                kotlinx.coroutines.internal.b1 b1VarE = a1Var.e();
                b1VarK = null;
                if (b1VarE != null) {
                    b1VarK = (((c) b1VarE).f37317c > j7 ? 1 : (((c) b1VarE).f37317c == j7 ? 0 : -1)) <= 0 ? a1Var.k(0) : null;
                }
            }
            c cVar = (c) b1VarK;
            if (cVar == null) {
                return;
            }
            long j8 = cVar.f37317c;
            if (j8 != 0) {
                this.f37308g = j8;
            }
            cVar.run();
        }
    }

    public static /* synthetic */ long l(a aVar, long j7, TimeUnit timeUnit, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        return aVar.k(j7, timeUnit);
    }

    public static /* synthetic */ void o(a aVar, long j7, TimeUnit timeUnit, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        }
        aVar.n(j7, timeUnit);
    }

    public static /* synthetic */ void s(a aVar, String str, l lVar, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            str = "";
        }
        aVar.p(str, lVar);
    }

    public static /* synthetic */ void w(a aVar, String str, l lVar, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            str = "";
        }
        aVar.t(str, lVar);
    }

    public static /* synthetic */ void y(a aVar, String str, l lVar, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            str = "";
        }
        aVar.x(str, lVar);
    }

    public final void B() {
        if (this.f37306e.g()) {
            return;
        }
        this.f37306e.d();
    }

    @d
    public final List<Throwable> G() {
        return this.f37303b;
    }

    public final long I(@d TimeUnit timeUnit) {
        return timeUnit.convert(this.f37308g, TimeUnit.NANOSECONDS);
    }

    public final void N() {
        O(this.f37308g);
    }

    @Override // kotlin.coroutines.g
    public <R> R fold(R r7, @d p<? super R, ? super g.b, ? extends R> pVar) {
        return pVar.a0(pVar.a0(r7, this.f37304c), this.f37305d);
    }

    @Override // kotlin.coroutines.g
    @e
    public <E extends g.b> E get(@d g.c<E> cVar) {
        if (cVar == kotlin.coroutines.e.f34677q0) {
            return this.f37304c;
        }
        if (cVar == p0.f37107r0) {
            return this.f37305d;
        }
        return null;
    }

    public final long k(long j7, @d TimeUnit timeUnit) {
        long j8 = this.f37308g;
        long nanos = timeUnit.toNanos(j7) + j8;
        TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
        n(nanos, timeUnit2);
        return timeUnit.convert(this.f37308g - j8, timeUnit2);
    }

    @Override // kotlin.coroutines.g
    @d
    public g minusKey(@d g.c<?> cVar) {
        if (cVar == kotlin.coroutines.e.f34677q0) {
            return this.f37305d;
        }
        return cVar == p0.f37107r0 ? this.f37304c : this;
    }

    public final void n(long j7, @d TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j7);
        O(nanos);
        if (nanos > this.f37308g) {
            this.f37308g = nanos;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void p(@d String str, @d l<? super Throwable, Boolean> lVar) {
        List<Throwable> list = this.f37303b;
        boolean z7 = true;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (!lVar.z(it.next()).booleanValue()) {
                    z7 = false;
                    break;
                }
            }
        }
        if (!z7) {
            throw new AssertionError(str);
        }
        this.f37303b.clear();
    }

    @Override // kotlin.coroutines.g
    @d
    public g plus(@d g gVar) {
        return g.a.a(this, gVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void t(@d String str, @d l<? super Throwable, Boolean> lVar) {
        List<Throwable> list = this.f37303b;
        boolean z7 = false;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (lVar.z(it.next()).booleanValue()) {
                    z7 = true;
                    break;
                }
            }
        }
        if (!z7) {
            throw new AssertionError(str);
        }
        this.f37303b.clear();
    }

    @d
    public String toString() {
        String str = this.f37302a;
        return str == null ? l0.C("TestCoroutineContext@", kotlinx.coroutines.a1.b(this)) : str;
    }

    public final void x(@d String str, @d l<? super List<? extends Throwable>, Boolean> lVar) {
        if (!lVar.z(this.f37303b).booleanValue()) {
            throw new AssertionError(str);
        }
        this.f37303b.clear();
    }

    public final void z(@d String str, @d l<? super Throwable, Boolean> lVar) {
        if (this.f37303b.size() != 1 || !lVar.z(this.f37303b.get(0)).booleanValue()) {
            throw new AssertionError(str);
        }
        this.f37303b.clear();
    }

    public a(@e String str) {
        this.f37302a = str;
        this.f37303b = new ArrayList();
        this.f37304c = new C0495a();
        this.f37305d = new b(p0.f37107r0, this);
        this.f37306e = new a1<>();
    }

    public /* synthetic */ a(String str, int i7, w wVar) {
        this((i7 & 1) != 0 ? null : str);
    }
}
