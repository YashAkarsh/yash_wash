package androidx.concurrent.futures;

import c.m0;
import c.o0;
import c.x0;
import com.google.common.util.concurrent.l1;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
public abstract class a<V> implements l1<V> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final boolean f2328d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", com.paytm.pgsdk.d.G));

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Logger f2329e = Logger.getLogger(a.class.getName());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final long f2330f = 1000;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final b f2331g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Object f2332h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @o0
    volatile Object f2333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @o0
    volatile e f2334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @o0
    volatile i f2335c;

    private static abstract class b {
        private b() {
        }

        abstract boolean a(a<?> aVar, e eVar, e eVar2);

        abstract boolean b(a<?> aVar, Object obj, Object obj2);

        abstract boolean c(a<?> aVar, i iVar, i iVar2);

        abstract void d(i iVar, i iVar2);

        abstract void e(i iVar, Thread thread);
    }

    private static final class c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final c f2336c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final c f2337d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final boolean f2338a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @o0
        final Throwable f2339b;

        static {
            if (a.f2328d) {
                f2337d = null;
                f2336c = null;
            } else {
                f2337d = new c(false, null);
                f2336c = new c(true, null);
            }
        }

        c(boolean z7, @o0 Throwable th) {
            this.f2338a = z7;
            this.f2339b = th;
        }
    }

    private static final class d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final d f2340b = new d(new C0035a("Failure occurred while trying to finish a future."));

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Throwable f2341a;

        /* JADX INFO: renamed from: androidx.concurrent.futures.a$d$a, reason: collision with other inner class name */
        static class C0035a extends Throwable {
            C0035a(String str) {
                super(str);
            }

            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        d(Throwable th) {
            this.f2341a = (Throwable) a.d(th);
        }
    }

    private static final class e {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final e f2342d = new e(null, null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Runnable f2343a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Executor f2344b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @o0
        e f2345c;

        e(Runnable runnable, Executor executor) {
            this.f2343a = runnable;
            this.f2344b = executor;
        }
    }

    private static final class f extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<i, Thread> f2346a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<i, i> f2347b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, i> f2348c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, e> f2349d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, Object> f2350e;

        f(AtomicReferenceFieldUpdater<i, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<i, i> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<a, i> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<a, e> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<a, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f2346a = atomicReferenceFieldUpdater;
            this.f2347b = atomicReferenceFieldUpdater2;
            this.f2348c = atomicReferenceFieldUpdater3;
            this.f2349d = atomicReferenceFieldUpdater4;
            this.f2350e = atomicReferenceFieldUpdater5;
        }

        @Override // androidx.concurrent.futures.a.b
        boolean a(a<?> aVar, e eVar, e eVar2) {
            return androidx.concurrent.futures.b.a(this.f2349d, aVar, eVar, eVar2);
        }

        @Override // androidx.concurrent.futures.a.b
        boolean b(a<?> aVar, Object obj, Object obj2) {
            return androidx.concurrent.futures.b.a(this.f2350e, aVar, obj, obj2);
        }

        @Override // androidx.concurrent.futures.a.b
        boolean c(a<?> aVar, i iVar, i iVar2) {
            return androidx.concurrent.futures.b.a(this.f2348c, aVar, iVar, iVar2);
        }

        @Override // androidx.concurrent.futures.a.b
        void d(i iVar, i iVar2) {
            this.f2347b.lazySet(iVar, iVar2);
        }

        @Override // androidx.concurrent.futures.a.b
        void e(i iVar, Thread thread) {
            this.f2346a.lazySet(iVar, thread);
        }
    }

    private static final class g<V> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final a<V> f2351a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final l1<? extends V> f2352b;

        g(a<V> aVar, l1<? extends V> l1Var) {
            this.f2351a = aVar;
            this.f2352b = l1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f2351a.f2333a != this) {
                return;
            }
            if (a.f2331g.b(this.f2351a, this, a.i(this.f2352b))) {
                a.f(this.f2351a);
            }
        }
    }

    private static final class h extends b {
        h() {
            super();
        }

        @Override // androidx.concurrent.futures.a.b
        boolean a(a<?> aVar, e eVar, e eVar2) {
            synchronized (aVar) {
                if (aVar.f2334b != eVar) {
                    return false;
                }
                aVar.f2334b = eVar2;
                return true;
            }
        }

        @Override // androidx.concurrent.futures.a.b
        boolean b(a<?> aVar, Object obj, Object obj2) {
            synchronized (aVar) {
                if (aVar.f2333a != obj) {
                    return false;
                }
                aVar.f2333a = obj2;
                return true;
            }
        }

        @Override // androidx.concurrent.futures.a.b
        boolean c(a<?> aVar, i iVar, i iVar2) {
            synchronized (aVar) {
                if (aVar.f2335c != iVar) {
                    return false;
                }
                aVar.f2335c = iVar2;
                return true;
            }
        }

        @Override // androidx.concurrent.futures.a.b
        void d(i iVar, i iVar2) {
            iVar.f2355b = iVar2;
        }

        @Override // androidx.concurrent.futures.a.b
        void e(i iVar, Thread thread) {
            iVar.f2354a = thread;
        }
    }

    private static final class i {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final i f2353c = new i(false);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @o0
        volatile Thread f2354a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @o0
        volatile i f2355b;

        i(boolean z7) {
        }

        void a(i iVar) {
            a.f2331g.d(this, iVar);
        }

        void b() {
            Thread thread = this.f2354a;
            if (thread != null) {
                this.f2354a = null;
                LockSupport.unpark(thread);
            }
        }

        i() {
            a.f2331g.e(this, Thread.currentThread());
        }
    }

    static {
        b hVar;
        try {
            hVar = new f(AtomicReferenceFieldUpdater.newUpdater(i.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(i.class, i.class, "b"), AtomicReferenceFieldUpdater.newUpdater(a.class, i.class, "c"), AtomicReferenceFieldUpdater.newUpdater(a.class, e.class, "b"), AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "a"));
            th = null;
        } catch (Throwable th) {
            th = th;
            hVar = new h();
        }
        f2331g = hVar;
        if (th != null) {
            f2329e.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f2332h = new Object();
    }

    protected a() {
    }

    private void a(StringBuilder sb) {
        try {
            Object objJ = j(this);
            sb.append("SUCCESS, result=[");
            sb.append(s(objJ));
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e8) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e8.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e9) {
            sb.append("FAILURE, cause=[");
            sb.append(e9.getCause());
            sb.append("]");
        }
    }

    private static CancellationException c(@o0 String str, @o0 Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    @m0
    static <T> T d(@o0 T t7) {
        t7.getClass();
        return t7;
    }

    private e e(e eVar) {
        e eVar2;
        do {
            eVar2 = this.f2334b;
        } while (!f2331g.a(this, eVar2, e.f2342d));
        e eVar3 = eVar;
        e eVar4 = eVar2;
        while (eVar4 != null) {
            e eVar5 = eVar4.f2345c;
            eVar4.f2345c = eVar3;
            eVar3 = eVar4;
            eVar4 = eVar5;
        }
        return eVar3;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    static void f(a<?> aVar) {
        e eVar = null;
        while (true) {
            aVar.n();
            aVar.b();
            e eVarE = aVar.e(eVar);
            while (eVarE != null) {
                eVar = eVarE.f2345c;
                Runnable runnable = eVarE.f2343a;
                if (runnable instanceof g) {
                    g gVar = (g) runnable;
                    aVar = gVar.f2351a;
                    if (aVar.f2333a == gVar) {
                        if (f2331g.b(aVar, gVar, i(gVar.f2352b))) {
                        }
                    } else {
                        continue;
                    }
                } else {
                    g(runnable, eVarE.f2344b);
                }
                eVarE = eVar;
            }
            return;
        }
    }

    private static void g(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e8) {
            f2329e.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private V h(Object obj) throws ExecutionException {
        if (obj instanceof c) {
            throw c("Task was cancelled.", ((c) obj).f2339b);
        }
        if (obj instanceof d) {
            throw new ExecutionException(((d) obj).f2341a);
        }
        if (obj == f2332h) {
            return null;
        }
        return obj;
    }

    static Object i(l1<?> l1Var) {
        if (l1Var instanceof a) {
            Object obj = ((a) l1Var).f2333a;
            if (!(obj instanceof c)) {
                return obj;
            }
            c cVar = (c) obj;
            if (cVar.f2338a) {
                return cVar.f2339b != null ? new c(false, cVar.f2339b) : c.f2337d;
            }
            return obj;
        }
        boolean zIsCancelled = l1Var.isCancelled();
        if ((!f2328d) && zIsCancelled) {
            return c.f2337d;
        }
        try {
            Object objJ = j(l1Var);
            return objJ == null ? f2332h : objJ;
        } catch (CancellationException e8) {
            if (zIsCancelled) {
                return new c(false, e8);
            }
            return new d(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + l1Var, e8));
        } catch (ExecutionException e9) {
            return new d(e9.getCause());
        } catch (Throwable th) {
            return new d(th);
        }
    }

    private static <V> V j(Future<V> future) throws ExecutionException {
        V v7;
        boolean z7 = false;
        while (true) {
            try {
                v7 = future.get();
                break;
            } catch (InterruptedException unused) {
                z7 = true;
            } catch (Throwable th) {
                if (z7) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z7) {
            Thread.currentThread().interrupt();
        }
        return v7;
    }

    private void n() {
        i iVar;
        do {
            iVar = this.f2335c;
        } while (!f2331g.c(this, iVar, i.f2353c));
        while (iVar != null) {
            iVar.b();
            iVar = iVar.f2355b;
        }
    }

    private void o(i iVar) {
        iVar.f2354a = null;
        while (true) {
            i iVar2 = this.f2335c;
            if (iVar2 == i.f2353c) {
                return;
            }
            i iVar3 = null;
            while (iVar2 != null) {
                i iVar4 = iVar2.f2355b;
                if (iVar2.f2354a != null) {
                    iVar3 = iVar2;
                } else if (iVar3 != null) {
                    iVar3.f2355b = iVar4;
                    if (iVar3.f2354a == null) {
                    }
                } else if (!f2331g.c(this, iVar2, iVar4)) {
                }
                iVar2 = iVar4;
            }
            return;
        }
    }

    private String s(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    @Override // com.google.common.util.concurrent.l1
    public final void I(Runnable runnable, Executor executor) {
        d(runnable);
        d(executor);
        e eVar = this.f2334b;
        if (eVar != e.f2342d) {
            e eVar2 = new e(runnable, executor);
            do {
                eVar2.f2345c = eVar;
                if (f2331g.a(this, eVar, eVar2)) {
                    return;
                } else {
                    eVar = this.f2334b;
                }
            } while (eVar != e.f2342d);
        }
        g(runnable, executor);
    }

    protected void b() {
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z7) {
        c cVar;
        Object obj = this.f2333a;
        if (!(obj == null) && !(obj instanceof g)) {
            return false;
        }
        if (f2328d) {
            cVar = new c(z7, new CancellationException("Future.cancel() was called."));
        } else {
            cVar = z7 ? c.f2336c : c.f2337d;
        }
        a<V> aVar = this;
        boolean z8 = false;
        while (true) {
            if (f2331g.b(aVar, obj, cVar)) {
                if (z7) {
                    aVar.k();
                }
                f(aVar);
                if (!(obj instanceof g)) {
                    return true;
                }
                l1<? extends V> l1Var = ((g) obj).f2352b;
                if (!(l1Var instanceof a)) {
                    l1Var.cancel(z7);
                    return true;
                }
                aVar = (a) l1Var;
                obj = aVar.f2333a;
                if (!(obj == null) && !(obj instanceof g)) {
                    return true;
                }
                z8 = true;
            } else {
                obj = aVar.f2333a;
                if (!(obj instanceof g)) {
                    return z8;
                }
            }
        }
    }

    @Override // java.util.concurrent.Future
    public final V get(long j7, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j7);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f2333a;
        if ((obj != null) && (!(obj instanceof g))) {
            return h(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            i iVar = this.f2335c;
            if (iVar != i.f2353c) {
                i iVar2 = new i();
                while (true) {
                    iVar2.a(iVar);
                    if (f2331g.c(this, iVar, iVar2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                o(iVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f2333a;
                            if ((obj2 != null) && (!(obj2 instanceof g))) {
                                return h(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        o(iVar2);
                        break;
                    }
                    iVar = this.f2335c;
                    if (iVar == i.f2353c) {
                    }
                }
            }
            return h(this.f2333a);
        }
        while (nanos > 0) {
            Object obj3 = this.f2333a;
            if ((obj3 != null) && (!(obj3 instanceof g))) {
                return h(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String string2 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        String str = "Waited " + j7 + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String str2 = str + " (plus ";
            long j8 = -nanos;
            long jConvert = timeUnit.convert(j8, TimeUnit.NANOSECONDS);
            long nanos2 = j8 - timeUnit.toNanos(jConvert);
            boolean z7 = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String str3 = str2 + jConvert + " " + lowerCase;
                if (z7) {
                    str3 = str3 + ",";
                }
                str2 = str3 + " ";
            }
            if (z7) {
                str2 = str2 + nanos2 + " nanoseconds ";
            }
            str = str2 + "delay)";
        }
        if (isDone()) {
            throw new TimeoutException(str + " but future completed as timeout expired");
        }
        throw new TimeoutException(str + " for " + string);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f2333a instanceof c;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        Object obj = this.f2333a;
        return (!(obj instanceof g)) & (obj != null);
    }

    protected void k() {
    }

    final void l(@o0 Future<?> future) {
        if ((future != null) && isCancelled()) {
            future.cancel(t());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @o0
    protected String m() {
        Object obj = this.f2333a;
        if (obj instanceof g) {
            return "setFuture=[" + s(((g) obj).f2352b) + "]";
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    protected boolean p(@o0 V v7) {
        if (v7 == null) {
            v7 = (V) f2332h;
        }
        if (!f2331g.b(this, null, v7)) {
            return false;
        }
        f(this);
        return true;
    }

    protected boolean q(Throwable th) {
        if (!f2331g.b(this, null, new d((Throwable) d(th)))) {
            return false;
        }
        f(this);
        return true;
    }

    protected boolean r(l1<? extends V> l1Var) {
        d dVar;
        d(l1Var);
        Object obj = this.f2333a;
        if (obj == null) {
            if (l1Var.isDone()) {
                if (!f2331g.b(this, null, i(l1Var))) {
                    return false;
                }
                f(this);
                return true;
            }
            g gVar = new g(this, l1Var);
            if (f2331g.b(this, null, gVar)) {
                try {
                    l1Var.I(gVar, androidx.concurrent.futures.d.INSTANCE);
                } catch (Throwable th) {
                    try {
                        dVar = new d(th);
                    } catch (Throwable unused) {
                        dVar = d.f2340b;
                    }
                    f2331g.b(this, gVar, dVar);
                }
                return true;
            }
            obj = this.f2333a;
        }
        if (obj instanceof c) {
            l1Var.cancel(((c) obj).f2338a);
        }
        return false;
    }

    protected final boolean t() {
        Object obj = this.f2333a;
        return (obj instanceof c) && ((c) obj).f2338a;
    }

    public String toString() {
        String strM;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            a(sb);
        } else {
            try {
                strM = m();
            } catch (RuntimeException e8) {
                strM = "Exception thrown from implementation: " + e8.getClass();
            }
            if (strM != null && !strM.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(strM);
                sb.append("]");
            } else if (isDone()) {
                a(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // java.util.concurrent.Future
    public final V get() throws ExecutionException, InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f2333a;
            if ((obj2 != null) & (!(obj2 instanceof g))) {
                return h(obj2);
            }
            i iVar = this.f2335c;
            if (iVar != i.f2353c) {
                i iVar2 = new i();
                do {
                    iVar2.a(iVar);
                    if (f2331g.c(this, iVar, iVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f2333a;
                            } else {
                                o(iVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof g))));
                        return h(obj);
                    }
                    iVar = this.f2335c;
                } while (iVar != i.f2353c);
            }
            return h(this.f2333a);
        }
        throw new InterruptedException();
    }
}
