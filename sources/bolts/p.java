package bolts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class p<TResult> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static volatile q f11392l;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f11398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f11399c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TResult f11400d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Exception f11401e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f11402f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private r f11403g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ExecutorService f11389i = bolts.h.a();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Executor f11390j = bolts.h.b();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Executor f11391k = bolts.b.d();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static p<?> f11393m = new p<>((Object) null);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static p<Boolean> f11394n = new p<>(Boolean.TRUE);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static p<Boolean> f11395o = new p<>(Boolean.FALSE);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static p<?> f11396p = new p<>(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f11397a = new Object();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<bolts.m<TResult, Void>> f11404h = new ArrayList();

    class a implements bolts.m<TResult, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ bolts.q f11405a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ bolts.m f11406b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Executor f11407c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ bolts.i f11408d;

        a(bolts.q qVar, bolts.m mVar, Executor executor, bolts.i iVar) {
            this.f11405a = qVar;
            this.f11406b = mVar;
            this.f11407c = executor;
            this.f11408d = iVar;
        }

        @Override // bolts.m
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void a(p<TResult> pVar) {
            p.l(this.f11405a, this.f11406b, pVar, this.f11407c, this.f11408d);
            return null;
        }
    }

    class b implements bolts.m<TResult, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ bolts.q f11410a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ bolts.m f11411b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Executor f11412c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ bolts.i f11413d;

        b(bolts.q qVar, bolts.m mVar, Executor executor, bolts.i iVar) {
            this.f11410a = qVar;
            this.f11411b = mVar;
            this.f11412c = executor;
            this.f11413d = iVar;
        }

        @Override // bolts.m
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void a(p<TResult> pVar) {
            p.k(this.f11410a, this.f11411b, pVar, this.f11412c, this.f11413d);
            return null;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [TContinuationResult] */
    class c<TContinuationResult> implements bolts.m<TResult, p<TContinuationResult>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ bolts.i f11415a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ bolts.m f11416b;

        c(bolts.i iVar, bolts.m mVar) {
            this.f11415a = iVar;
            this.f11416b = mVar;
        }

        @Override // bolts.m
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public p<TContinuationResult> a(p<TResult> pVar) {
            bolts.i iVar = this.f11415a;
            if (iVar != null && iVar.a()) {
                return p.i();
            }
            if (pVar.J()) {
                return p.C(pVar.E());
            }
            return pVar.H() ? p.i() : pVar.q(this.f11416b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [TContinuationResult] */
    class d<TContinuationResult> implements bolts.m<TResult, p<TContinuationResult>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ bolts.i f11418a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ bolts.m f11419b;

        d(bolts.i iVar, bolts.m mVar) {
            this.f11418a = iVar;
            this.f11419b = mVar;
        }

        @Override // bolts.m
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public p<TContinuationResult> a(p<TResult> pVar) {
            bolts.i iVar = this.f11418a;
            if (iVar != null && iVar.a()) {
                return p.i();
            }
            if (pVar.J()) {
                return p.C(pVar.E());
            }
            return pVar.H() ? p.i() : pVar.u(this.f11419b);
        }
    }

    static class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ bolts.i f11421a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ bolts.q f11422b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ bolts.m f11423c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ p f11424d;

        e(bolts.i iVar, bolts.q qVar, bolts.m mVar, p pVar) {
            this.f11421a = iVar;
            this.f11422b = qVar;
            this.f11423c = mVar;
            this.f11424d = pVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            bolts.i iVar = this.f11421a;
            if (iVar != null && iVar.a()) {
                this.f11422b.b();
                return;
            }
            try {
                this.f11422b.d(this.f11423c.a(this.f11424d));
            } catch (CancellationException unused) {
                this.f11422b.b();
            } catch (Exception e8) {
                this.f11422b.c(e8);
            }
        }
    }

    static class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ bolts.i f11425a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ bolts.q f11426b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ bolts.m f11427c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ p f11428d;

        /* JADX INFO: Add missing generic type declarations: [TContinuationResult] */
        class a<TContinuationResult> implements bolts.m<TContinuationResult, Void> {
            a() {
            }

            @Override // bolts.m
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Void a(p<TContinuationResult> pVar) {
                bolts.i iVar = f.this.f11425a;
                if (iVar != null && iVar.a()) {
                    f.this.f11426b.b();
                    return null;
                }
                if (pVar.H()) {
                    f.this.f11426b.b();
                } else if (pVar.J()) {
                    f.this.f11426b.c(pVar.E());
                } else {
                    f.this.f11426b.d(pVar.F());
                }
                return null;
            }
        }

        f(bolts.i iVar, bolts.q qVar, bolts.m mVar, p pVar) {
            this.f11425a = iVar;
            this.f11426b = qVar;
            this.f11427c = mVar;
            this.f11428d = pVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            bolts.i iVar = this.f11425a;
            if (iVar != null && iVar.a()) {
                this.f11426b.b();
                return;
            }
            try {
                p pVar = (p) this.f11427c.a(this.f11428d);
                if (pVar == null) {
                    this.f11426b.d(null);
                } else {
                    pVar.q(new a());
                }
            } catch (CancellationException unused) {
                this.f11426b.b();
            } catch (Exception e8) {
                this.f11426b.c(e8);
            }
        }
    }

    static class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ bolts.q f11430a;

        g(bolts.q qVar) {
            this.f11430a = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f11430a.g(null);
        }
    }

    static class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ScheduledFuture f11431a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ bolts.q f11432b;

        h(ScheduledFuture scheduledFuture, bolts.q qVar) {
            this.f11431a = scheduledFuture;
            this.f11432b = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f11431a.cancel(true);
            this.f11432b.e();
        }
    }

    class i implements bolts.m<TResult, p<Void>> {
        i() {
        }

        @Override // bolts.m
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public p<Void> a(p<TResult> pVar) throws Exception {
            if (pVar.H()) {
                return p.i();
            }
            return pVar.J() ? p.C(pVar.E()) : p.D(null);
        }
    }

    static class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ bolts.i f11434a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ bolts.q f11435b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Callable f11436c;

        j(bolts.i iVar, bolts.q qVar, Callable callable) {
            this.f11434a = iVar;
            this.f11435b = qVar;
            this.f11436c = callable;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            bolts.i iVar = this.f11434a;
            if (iVar != null && iVar.a()) {
                this.f11435b.b();
                return;
            }
            try {
                this.f11435b.d(this.f11436c.call());
            } catch (CancellationException unused) {
                this.f11435b.b();
            } catch (Exception e8) {
                this.f11435b.c(e8);
            }
        }
    }

    static class k implements bolts.m<TResult, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f11437a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ bolts.q f11438b;

        k(AtomicBoolean atomicBoolean, bolts.q qVar) {
            this.f11437a = atomicBoolean;
            this.f11438b = qVar;
        }

        @Override // bolts.m
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void a(p<TResult> pVar) {
            if (this.f11437a.compareAndSet(false, true)) {
                this.f11438b.d(pVar);
                return null;
            }
            pVar.E();
            return null;
        }
    }

    static class l implements bolts.m<Object, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f11439a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ bolts.q f11440b;

        l(AtomicBoolean atomicBoolean, bolts.q qVar) {
            this.f11439a = atomicBoolean;
            this.f11440b = qVar;
        }

        @Override // bolts.m
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void a(p<Object> pVar) {
            if (this.f11439a.compareAndSet(false, true)) {
                this.f11440b.d(pVar);
                return null;
            }
            pVar.E();
            return null;
        }
    }

    static class m implements bolts.m<Void, List<TResult>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Collection f11441a;

        m(Collection collection) {
            this.f11441a = collection;
        }

        @Override // bolts.m
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public List<TResult> a(p<Void> pVar) throws Exception {
            if (this.f11441a.size() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f11441a.iterator();
            while (it.hasNext()) {
                arrayList.add(((p) it.next()).F());
            }
            return arrayList;
        }
    }

    static class n implements bolts.m<Object, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f11442a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f11443b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f11444c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ AtomicInteger f11445d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ bolts.q f11446e;

        n(Object obj, ArrayList arrayList, AtomicBoolean atomicBoolean, AtomicInteger atomicInteger, bolts.q qVar) {
            this.f11442a = obj;
            this.f11443b = arrayList;
            this.f11444c = atomicBoolean;
            this.f11445d = atomicInteger;
            this.f11446e = qVar;
        }

        @Override // bolts.m
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void a(p<Object> pVar) {
            if (pVar.J()) {
                synchronized (this.f11442a) {
                    this.f11443b.add(pVar.E());
                }
            }
            if (pVar.H()) {
                this.f11444c.set(true);
            }
            if (this.f11445d.decrementAndGet() == 0) {
                if (this.f11443b.size() != 0) {
                    if (this.f11443b.size() == 1) {
                        this.f11446e.c((Exception) this.f11443b.get(0));
                    } else {
                        this.f11446e.c(new bolts.a(String.format("There were %d exceptions.", Integer.valueOf(this.f11443b.size())), this.f11443b));
                    }
                } else if (this.f11444c.get()) {
                    this.f11446e.b();
                } else {
                    this.f11446e.d(null);
                }
            }
            return null;
        }
    }

    class o implements bolts.m<Void, p<Void>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ bolts.i f11447a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Callable f11448b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ bolts.m f11449c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Executor f11450d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ bolts.l f11451e;

        o(bolts.i iVar, Callable callable, bolts.m mVar, Executor executor, bolts.l lVar) {
            this.f11447a = iVar;
            this.f11448b = callable;
            this.f11449c = mVar;
            this.f11450d = executor;
            this.f11451e = lVar;
        }

        @Override // bolts.m
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public p<Void> a(p<Void> pVar) throws Exception {
            bolts.i iVar = this.f11447a;
            if (iVar == null || !iVar.a()) {
                return ((Boolean) this.f11448b.call()).booleanValue() ? p.D(null).R(this.f11449c, this.f11450d).R((bolts.m) this.f11451e.a(), this.f11450d) : p.D(null);
            }
            return p.i();
        }
    }

    /* JADX INFO: renamed from: bolts.p$p, reason: collision with other inner class name */
    public class C0137p extends bolts.q<TResult> {
        C0137p() {
        }
    }

    public interface q {
        void a(p<?> pVar, s sVar);
    }

    p() {
    }

    public static p<Void> A(long j7, bolts.i iVar) {
        return B(j7, bolts.h.d(), iVar);
    }

    static p<Void> B(long j7, ScheduledExecutorService scheduledExecutorService, bolts.i iVar) {
        if (iVar != null && iVar.a()) {
            return i();
        }
        if (j7 <= 0) {
            return D(null);
        }
        bolts.q qVar = new bolts.q();
        ScheduledFuture<?> scheduledFutureSchedule = scheduledExecutorService.schedule(new g(qVar), j7, TimeUnit.MILLISECONDS);
        if (iVar != null) {
            iVar.b(new h(scheduledFutureSchedule, qVar));
        }
        return qVar.a();
    }

    public static <TResult> p<TResult> C(Exception exc) {
        bolts.q qVar = new bolts.q();
        qVar.c(exc);
        return qVar.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <TResult> p<TResult> D(TResult tresult) {
        if (tresult == 0) {
            return (p<TResult>) f11393m;
        }
        if (tresult instanceof Boolean) {
            return ((Boolean) tresult).booleanValue() ? (p<TResult>) f11394n : (p<TResult>) f11395o;
        }
        bolts.q qVar = new bolts.q();
        qVar.d(tresult);
        return qVar.a();
    }

    public static q G() {
        return f11392l;
    }

    private void T() {
        synchronized (this.f11397a) {
            Iterator<bolts.m<TResult, Void>> it = this.f11404h.iterator();
            while (it.hasNext()) {
                try {
                    it.next().a(this);
                } catch (RuntimeException e8) {
                    throw e8;
                } catch (Exception e9) {
                    throw new RuntimeException(e9);
                }
            }
            this.f11404h = null;
        }
    }

    public static void U(q qVar) {
        f11392l = qVar;
    }

    public static p<Void> a0(Collection<? extends p<?>> collection) {
        if (collection.size() == 0) {
            return D(null);
        }
        bolts.q qVar = new bolts.q();
        ArrayList arrayList = new ArrayList();
        Object obj = new Object();
        AtomicInteger atomicInteger = new AtomicInteger(collection.size());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        Iterator<? extends p<?>> it = collection.iterator();
        while (it.hasNext()) {
            it.next().q(new n(obj, arrayList, atomicBoolean, atomicInteger, qVar));
        }
        return qVar.a();
    }

    public static <TResult> p<List<TResult>> b0(Collection<? extends p<TResult>> collection) {
        return (p<List<TResult>>) a0(collection).L(new m(collection));
    }

    public static <TResult> p<TResult> c(Callable<TResult> callable) {
        return f(callable, f11390j, null);
    }

    public static p<p<?>> c0(Collection<? extends p<?>> collection) {
        if (collection.size() == 0) {
            return D(null);
        }
        bolts.q qVar = new bolts.q();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        Iterator<? extends p<?>> it = collection.iterator();
        while (it.hasNext()) {
            it.next().q(new l(atomicBoolean, qVar));
        }
        return qVar.a();
    }

    public static <TResult> p<TResult> d(Callable<TResult> callable, bolts.i iVar) {
        return f(callable, f11390j, iVar);
    }

    public static <TResult> p<p<TResult>> d0(Collection<? extends p<TResult>> collection) {
        if (collection.size() == 0) {
            return D(null);
        }
        bolts.q qVar = new bolts.q();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        Iterator<? extends p<TResult>> it = collection.iterator();
        while (it.hasNext()) {
            it.next().q(new k(atomicBoolean, qVar));
        }
        return qVar.a();
    }

    public static <TResult> p<TResult> e(Callable<TResult> callable, Executor executor) {
        return f(callable, executor, null);
    }

    public static <TResult> p<TResult> f(Callable<TResult> callable, Executor executor, bolts.i iVar) {
        bolts.q qVar = new bolts.q();
        try {
            executor.execute(new j(iVar, qVar, callable));
        } catch (Exception e8) {
            qVar.c(new bolts.n(e8));
        }
        return qVar.a();
    }

    public static <TResult> p<TResult> g(Callable<TResult> callable) {
        return f(callable, f11389i, null);
    }

    public static <TResult> p<TResult> h(Callable<TResult> callable, bolts.i iVar) {
        return f(callable, f11389i, iVar);
    }

    public static <TResult> p<TResult> i() {
        return (p<TResult>) f11396p;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <TContinuationResult, TResult> void k(bolts.q<TContinuationResult> qVar, bolts.m<TResult, p<TContinuationResult>> mVar, p<TResult> pVar, Executor executor, bolts.i iVar) {
        try {
            executor.execute(new f(iVar, qVar, mVar, pVar));
        } catch (Exception e8) {
            qVar.c(new bolts.n(e8));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <TContinuationResult, TResult> void l(bolts.q<TContinuationResult> qVar, bolts.m<TResult, TContinuationResult> mVar, p<TResult> pVar, Executor executor, bolts.i iVar) {
        try {
            executor.execute(new e(iVar, qVar, mVar, pVar));
        } catch (Exception e8) {
            qVar.c(new bolts.n(e8));
        }
    }

    public static <TResult> p<TResult>.C0137p y() {
        return new C0137p();
    }

    public static p<Void> z(long j7) {
        return B(j7, bolts.h.d(), null);
    }

    public Exception E() {
        Exception exc;
        synchronized (this.f11397a) {
            if (this.f11401e != null) {
                this.f11402f = true;
                r rVar = this.f11403g;
                if (rVar != null) {
                    rVar.a();
                    this.f11403g = null;
                }
            }
            exc = this.f11401e;
        }
        return exc;
    }

    public TResult F() {
        TResult tresult;
        synchronized (this.f11397a) {
            tresult = this.f11400d;
        }
        return tresult;
    }

    public boolean H() {
        boolean z7;
        synchronized (this.f11397a) {
            z7 = this.f11399c;
        }
        return z7;
    }

    public boolean I() {
        boolean z7;
        synchronized (this.f11397a) {
            z7 = this.f11398b;
        }
        return z7;
    }

    public boolean J() {
        boolean z7;
        synchronized (this.f11397a) {
            z7 = E() != null;
        }
        return z7;
    }

    public p<Void> K() {
        return u(new i());
    }

    public <TContinuationResult> p<TContinuationResult> L(bolts.m<TResult, TContinuationResult> mVar) {
        return O(mVar, f11390j, null);
    }

    public <TContinuationResult> p<TContinuationResult> M(bolts.m<TResult, TContinuationResult> mVar, bolts.i iVar) {
        return O(mVar, f11390j, iVar);
    }

    public <TContinuationResult> p<TContinuationResult> N(bolts.m<TResult, TContinuationResult> mVar, Executor executor) {
        return O(mVar, executor, null);
    }

    public <TContinuationResult> p<TContinuationResult> O(bolts.m<TResult, TContinuationResult> mVar, Executor executor, bolts.i iVar) {
        return w(new c(iVar, mVar), executor);
    }

    public <TContinuationResult> p<TContinuationResult> P(bolts.m<TResult, p<TContinuationResult>> mVar) {
        return R(mVar, f11390j);
    }

    public <TContinuationResult> p<TContinuationResult> Q(bolts.m<TResult, p<TContinuationResult>> mVar, bolts.i iVar) {
        return S(mVar, f11390j, iVar);
    }

    public <TContinuationResult> p<TContinuationResult> R(bolts.m<TResult, p<TContinuationResult>> mVar, Executor executor) {
        return S(mVar, executor, null);
    }

    public <TContinuationResult> p<TContinuationResult> S(bolts.m<TResult, p<TContinuationResult>> mVar, Executor executor, bolts.i iVar) {
        return w(new d(iVar, mVar), executor);
    }

    boolean V() {
        synchronized (this.f11397a) {
            if (this.f11398b) {
                return false;
            }
            this.f11398b = true;
            this.f11399c = true;
            this.f11397a.notifyAll();
            T();
            return true;
        }
    }

    boolean W(Exception exc) {
        synchronized (this.f11397a) {
            if (this.f11398b) {
                return false;
            }
            this.f11398b = true;
            this.f11401e = exc;
            this.f11402f = false;
            this.f11397a.notifyAll();
            T();
            if (!this.f11402f && G() != null) {
                this.f11403g = new r(this);
            }
            return true;
        }
    }

    boolean X(TResult tresult) {
        synchronized (this.f11397a) {
            if (this.f11398b) {
                return false;
            }
            this.f11398b = true;
            this.f11400d = tresult;
            this.f11397a.notifyAll();
            T();
            return true;
        }
    }

    public void Y() throws InterruptedException {
        synchronized (this.f11397a) {
            if (!I()) {
                this.f11397a.wait();
            }
        }
    }

    public boolean Z(long j7, TimeUnit timeUnit) throws InterruptedException {
        boolean zI;
        synchronized (this.f11397a) {
            if (!I()) {
                this.f11397a.wait(timeUnit.toMillis(j7));
            }
            zI = I();
        }
        return zI;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <TOut> p<TOut> j() {
        return this;
    }

    public p<Void> m(Callable<Boolean> callable, bolts.m<Void, p<Void>> mVar) {
        return p(callable, mVar, f11390j, null);
    }

    public p<Void> n(Callable<Boolean> callable, bolts.m<Void, p<Void>> mVar, bolts.i iVar) {
        return p(callable, mVar, f11390j, iVar);
    }

    public p<Void> o(Callable<Boolean> callable, bolts.m<Void, p<Void>> mVar, Executor executor) {
        return p(callable, mVar, executor, null);
    }

    public p<Void> p(Callable<Boolean> callable, bolts.m<Void, p<Void>> mVar, Executor executor, bolts.i iVar) {
        bolts.l lVar = new bolts.l();
        lVar.b(new o(iVar, callable, mVar, executor, lVar));
        return K().w((bolts.m) lVar.a(), executor);
    }

    public <TContinuationResult> p<TContinuationResult> q(bolts.m<TResult, TContinuationResult> mVar) {
        return t(mVar, f11390j, null);
    }

    public <TContinuationResult> p<TContinuationResult> r(bolts.m<TResult, TContinuationResult> mVar, bolts.i iVar) {
        return t(mVar, f11390j, iVar);
    }

    public <TContinuationResult> p<TContinuationResult> s(bolts.m<TResult, TContinuationResult> mVar, Executor executor) {
        return t(mVar, executor, null);
    }

    public <TContinuationResult> p<TContinuationResult> t(bolts.m<TResult, TContinuationResult> mVar, Executor executor, bolts.i iVar) {
        boolean zI;
        bolts.q qVar = new bolts.q();
        synchronized (this.f11397a) {
            zI = I();
            if (!zI) {
                this.f11404h.add(new a(qVar, mVar, executor, iVar));
            }
        }
        if (zI) {
            l(qVar, mVar, this, executor, iVar);
        }
        return qVar.a();
    }

    public <TContinuationResult> p<TContinuationResult> u(bolts.m<TResult, p<TContinuationResult>> mVar) {
        return x(mVar, f11390j, null);
    }

    public <TContinuationResult> p<TContinuationResult> v(bolts.m<TResult, p<TContinuationResult>> mVar, bolts.i iVar) {
        return x(mVar, f11390j, iVar);
    }

    public <TContinuationResult> p<TContinuationResult> w(bolts.m<TResult, p<TContinuationResult>> mVar, Executor executor) {
        return x(mVar, executor, null);
    }

    public <TContinuationResult> p<TContinuationResult> x(bolts.m<TResult, p<TContinuationResult>> mVar, Executor executor, bolts.i iVar) {
        boolean zI;
        bolts.q qVar = new bolts.q();
        synchronized (this.f11397a) {
            zI = I();
            if (!zI) {
                this.f11404h.add(new b(qVar, mVar, executor, iVar));
            }
        }
        if (zI) {
            k(qVar, mVar, this, executor, iVar);
        }
        return qVar.a();
    }

    private p(TResult tresult) {
        X(tresult);
    }

    private p(boolean z7) {
        if (z7) {
            V();
        } else {
            X(null);
        }
    }
}
