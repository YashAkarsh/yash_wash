package com.google.common.util.concurrent;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
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
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes2.dex */
@y1.f(y1.f.a.FULL)
@s1.b(emulated = true)
public abstract class d<V> extends com.google.common.util.concurrent.internal.a implements l1<V> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final boolean f22585d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", com.paytm.pgsdk.d.G));

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Logger f22586e = Logger.getLogger(d.class.getName());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final long f22587f = 1000;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final b f22588g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Object f22589h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile Object f22590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile e f22591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile l f22592c;

    private static abstract class b {
        private b() {
        }

        abstract boolean a(d<?> dVar, e eVar, e eVar2);

        abstract boolean b(d<?> dVar, Object obj, Object obj2);

        abstract boolean c(d<?> dVar, l lVar, l lVar2);

        abstract void d(l lVar, l lVar2);

        abstract void e(l lVar, Thread thread);
    }

    private static final class c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final c f22593c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final c f22594d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final boolean f22595a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Throwable f22596b;

        static {
            if (d.f22585d) {
                f22594d = null;
                f22593c = null;
            } else {
                f22594d = new c(false, null);
                f22593c = new c(true, null);
            }
        }

        c(boolean z7, Throwable th) {
            this.f22595a = z7;
            this.f22596b = th;
        }
    }

    /* JADX INFO: renamed from: com.google.common.util.concurrent.d$d, reason: collision with other inner class name */
    private static final class C0294d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final C0294d f22597b = new C0294d(new a("Failure occurred while trying to finish a future."));

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Throwable f22598a;

        /* JADX INFO: renamed from: com.google.common.util.concurrent.d$d$a */
        static class a extends Throwable {
            a(String str) {
                super(str);
            }

            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        C0294d(Throwable th) {
            this.f22598a = (Throwable) com.google.common.base.e0.E(th);
        }
    }

    private static final class e {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final e f22599d = new e(null, null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Runnable f22600a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Executor f22601b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        e f22602c;

        e(Runnable runnable, Executor executor) {
            this.f22600a = runnable;
            this.f22601b = executor;
        }
    }

    private static final class f extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<l, Thread> f22603a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<l, l> f22604b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<d, l> f22605c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<d, e> f22606d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<d, Object> f22607e;

        f(AtomicReferenceFieldUpdater<l, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<l, l> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<d, l> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<d, e> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<d, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f22603a = atomicReferenceFieldUpdater;
            this.f22604b = atomicReferenceFieldUpdater2;
            this.f22605c = atomicReferenceFieldUpdater3;
            this.f22606d = atomicReferenceFieldUpdater4;
            this.f22607e = atomicReferenceFieldUpdater5;
        }

        @Override // com.google.common.util.concurrent.d.b
        boolean a(d<?> dVar, e eVar, e eVar2) {
            return androidx.concurrent.futures.b.a(this.f22606d, dVar, eVar, eVar2);
        }

        @Override // com.google.common.util.concurrent.d.b
        boolean b(d<?> dVar, Object obj, Object obj2) {
            return androidx.concurrent.futures.b.a(this.f22607e, dVar, obj, obj2);
        }

        @Override // com.google.common.util.concurrent.d.b
        boolean c(d<?> dVar, l lVar, l lVar2) {
            return androidx.concurrent.futures.b.a(this.f22605c, dVar, lVar, lVar2);
        }

        @Override // com.google.common.util.concurrent.d.b
        void d(l lVar, l lVar2) {
            this.f22604b.lazySet(lVar, lVar2);
        }

        @Override // com.google.common.util.concurrent.d.b
        void e(l lVar, Thread thread) {
            this.f22603a.lazySet(lVar, thread);
        }
    }

    private static final class g<V> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final d<V> f22608a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final l1<? extends V> f22609b;

        g(d<V> dVar, l1<? extends V> l1Var) {
            this.f22608a = dVar;
            this.f22609b = l1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((d) this.f22608a).f22590a != this) {
                return;
            }
            if (d.f22588g.b(this.f22608a, this, d.s(this.f22609b))) {
                d.p(this.f22608a);
            }
        }
    }

    private static final class h extends b {
        private h() {
            super();
        }

        @Override // com.google.common.util.concurrent.d.b
        boolean a(d<?> dVar, e eVar, e eVar2) {
            synchronized (dVar) {
                if (((d) dVar).f22591b != eVar) {
                    return false;
                }
                ((d) dVar).f22591b = eVar2;
                return true;
            }
        }

        @Override // com.google.common.util.concurrent.d.b
        boolean b(d<?> dVar, Object obj, Object obj2) {
            synchronized (dVar) {
                if (((d) dVar).f22590a != obj) {
                    return false;
                }
                ((d) dVar).f22590a = obj2;
                return true;
            }
        }

        @Override // com.google.common.util.concurrent.d.b
        boolean c(d<?> dVar, l lVar, l lVar2) {
            synchronized (dVar) {
                if (((d) dVar).f22592c != lVar) {
                    return false;
                }
                ((d) dVar).f22592c = lVar2;
                return true;
            }
        }

        @Override // com.google.common.util.concurrent.d.b
        void d(l lVar, l lVar2) {
            lVar.f22618b = lVar2;
        }

        @Override // com.google.common.util.concurrent.d.b
        void e(l lVar, Thread thread) {
            lVar.f22617a = thread;
        }
    }

    interface i<V> extends l1<V> {
    }

    static abstract class j<V> extends d<V> implements i<V> {
        j() {
        }

        @Override // com.google.common.util.concurrent.d, com.google.common.util.concurrent.l1
        public final void I(Runnable runnable, Executor executor) {
            super.I(runnable, executor);
        }

        @Override // com.google.common.util.concurrent.d, java.util.concurrent.Future
        @u1.a
        public final boolean cancel(boolean z7) {
            return super.cancel(z7);
        }

        @Override // com.google.common.util.concurrent.d, java.util.concurrent.Future
        @u1.a
        public final V get() throws ExecutionException, InterruptedException {
            return (V) super.get();
        }

        @Override // com.google.common.util.concurrent.d, java.util.concurrent.Future
        public final boolean isCancelled() {
            return super.isCancelled();
        }

        @Override // com.google.common.util.concurrent.d, java.util.concurrent.Future
        public final boolean isDone() {
            return super.isDone();
        }

        @Override // com.google.common.util.concurrent.d, java.util.concurrent.Future
        @u1.a
        public final V get(long j7, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
            return (V) super.get(j7, timeUnit);
        }
    }

    private static final class k extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Unsafe f22610a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final long f22611b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final long f22612c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final long f22613d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        static final long f22614e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final long f22615f;

        static class a implements PrivilegedExceptionAction<Unsafe> {
            a() {
            }

            @Override // java.security.PrivilegedExceptionAction
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unsafe run() throws Exception {
                for (Field field : Unsafe.class.getDeclaredFields()) {
                    field.setAccessible(true);
                    Object obj = field.get(null);
                    if (Unsafe.class.isInstance(obj)) {
                        return (Unsafe) Unsafe.class.cast(obj);
                    }
                }
                throw new NoSuchFieldError("the Unsafe");
            }
        }

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (PrivilegedActionException e8) {
                    throw new RuntimeException("Could not initialize intrinsics", e8.getCause());
                }
            } catch (SecurityException unused) {
                unsafe = (Unsafe) AccessController.doPrivileged(new a());
            }
            try {
                f22612c = unsafe.objectFieldOffset(d.class.getDeclaredField("c"));
                f22611b = unsafe.objectFieldOffset(d.class.getDeclaredField("b"));
                f22613d = unsafe.objectFieldOffset(d.class.getDeclaredField("a"));
                f22614e = unsafe.objectFieldOffset(l.class.getDeclaredField("a"));
                f22615f = unsafe.objectFieldOffset(l.class.getDeclaredField("b"));
                f22610a = unsafe;
            } catch (Exception e9) {
                com.google.common.base.r0.w(e9);
                throw new RuntimeException(e9);
            }
        }

        private k() {
            super();
        }

        @Override // com.google.common.util.concurrent.d.b
        boolean a(d<?> dVar, e eVar, e eVar2) {
            return com.google.common.util.concurrent.e.a(f22610a, dVar, f22611b, eVar, eVar2);
        }

        @Override // com.google.common.util.concurrent.d.b
        boolean b(d<?> dVar, Object obj, Object obj2) {
            return com.google.common.util.concurrent.e.a(f22610a, dVar, f22613d, obj, obj2);
        }

        @Override // com.google.common.util.concurrent.d.b
        boolean c(d<?> dVar, l lVar, l lVar2) {
            return com.google.common.util.concurrent.e.a(f22610a, dVar, f22612c, lVar, lVar2);
        }

        @Override // com.google.common.util.concurrent.d.b
        void d(l lVar, l lVar2) {
            f22610a.putObject(lVar, f22615f, lVar2);
        }

        @Override // com.google.common.util.concurrent.d.b
        void e(l lVar, Thread thread) {
            f22610a.putObject(lVar, f22614e, thread);
        }
    }

    private static final class l {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final l f22616c = new l(false);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        volatile Thread f22617a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        volatile l f22618b;

        l(boolean z7) {
        }

        void a(l lVar) {
            d.f22588g.d(this, lVar);
        }

        void b() {
            Thread thread = this.f22617a;
            if (thread != null) {
                this.f22617a = null;
                LockSupport.unpark(thread);
            }
        }

        l() {
            d.f22588g.e(this, Thread.currentThread());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.logging.Logger] */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.google.common.util.concurrent.d$a] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r2v6 */
    static {
        b hVar;
        ?? r7 = 0;
        r7 = 0;
        try {
            hVar = new k();
            th = null;
        } catch (Throwable th) {
            th = th;
            try {
                hVar = new f(AtomicReferenceFieldUpdater.newUpdater(l.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(l.class, l.class, "b"), AtomicReferenceFieldUpdater.newUpdater(d.class, l.class, "c"), AtomicReferenceFieldUpdater.newUpdater(d.class, e.class, "b"), AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "a"));
            } catch (Throwable th2) {
                hVar = new h();
                r7 = th2;
            }
        }
        f22588g = hVar;
        if (r7 != 0) {
            ?? r8 = f22586e;
            Level level = Level.SEVERE;
            r8.log(level, "UnsafeAtomicHelper is broken!", th);
            r8.log(level, "SafeAtomicHelper is broken!", r7);
        }
        f22589h = new Object();
    }

    protected d() {
    }

    private String D(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    private void l(StringBuilder sb) {
        try {
            Object objT = t(this);
            sb.append("SUCCESS, result=[");
            sb.append(D(objT));
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

    private static CancellationException n(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    private e o(e eVar) {
        e eVar2;
        do {
            eVar2 = this.f22591b;
        } while (!f22588g.a(this, eVar2, e.f22599d));
        e eVar3 = eVar;
        e eVar4 = eVar2;
        while (eVar4 != null) {
            e eVar5 = eVar4.f22602c;
            eVar4.f22602c = eVar3;
            eVar3 = eVar4;
            eVar4 = eVar5;
        }
        return eVar3;
    }

    /* JADX INFO: Access modifiers changed from: private */
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
    public static void p(d<?> dVar) {
        e eVar = null;
        while (true) {
            dVar.y();
            dVar.m();
            e eVarO = dVar.o(eVar);
            while (eVarO != null) {
                eVar = eVarO.f22602c;
                Runnable runnable = eVarO.f22600a;
                if (runnable instanceof g) {
                    g gVar = (g) runnable;
                    dVar = gVar.f22608a;
                    if (((d) dVar).f22590a == gVar) {
                        if (f22588g.b(dVar, gVar, s(gVar.f22609b))) {
                        }
                    } else {
                        continue;
                    }
                } else {
                    q(runnable, eVarO.f22601b);
                }
                eVarO = eVar;
            }
            return;
        }
    }

    private static void q(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e8) {
            f22586e.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private V r(Object obj) throws ExecutionException {
        if (obj instanceof c) {
            throw n("Task was cancelled.", ((c) obj).f22596b);
        }
        if (obj instanceof C0294d) {
            throw new ExecutionException(((C0294d) obj).f22598a);
        }
        if (obj == f22589h) {
            return null;
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static Object s(l1<?> l1Var) {
        Throwable thA;
        if (l1Var instanceof i) {
            Object obj = ((d) l1Var).f22590a;
            if (!(obj instanceof c)) {
                return obj;
            }
            c cVar = (c) obj;
            if (cVar.f22595a) {
                return cVar.f22596b != null ? new c(false, cVar.f22596b) : c.f22594d;
            }
            return obj;
        }
        if ((l1Var instanceof com.google.common.util.concurrent.internal.a) && (thA = com.google.common.util.concurrent.internal.b.a((com.google.common.util.concurrent.internal.a) l1Var)) != null) {
            return new C0294d(thA);
        }
        boolean zIsCancelled = l1Var.isCancelled();
        if ((!f22585d) && zIsCancelled) {
            return c.f22594d;
        }
        try {
            Object objT = t(l1Var);
            if (!zIsCancelled) {
                return objT == null ? f22589h : objT;
            }
            return new c(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + l1Var));
        } catch (CancellationException e8) {
            if (zIsCancelled) {
                return new c(false, e8);
            }
            return new C0294d(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + l1Var, e8));
        } catch (ExecutionException e9) {
            if (!zIsCancelled) {
                return new C0294d(e9.getCause());
            }
            return new c(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + l1Var, e9));
        } catch (Throwable th) {
            return new C0294d(th);
        }
    }

    private static <V> V t(Future<V> future) throws ExecutionException {
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

    private void y() {
        l lVar;
        do {
            lVar = this.f22592c;
        } while (!f22588g.c(this, lVar, l.f22616c));
        while (lVar != null) {
            lVar.b();
            lVar = lVar.f22618b;
        }
    }

    private void z(l lVar) {
        lVar.f22617a = null;
        while (true) {
            l lVar2 = this.f22592c;
            if (lVar2 == l.f22616c) {
                return;
            }
            l lVar3 = null;
            while (lVar2 != null) {
                l lVar4 = lVar2.f22618b;
                if (lVar2.f22617a != null) {
                    lVar3 = lVar2;
                } else if (lVar3 != null) {
                    lVar3.f22618b = lVar4;
                    if (lVar3.f22617a == null) {
                    }
                } else if (!f22588g.c(this, lVar2, lVar4)) {
                }
                lVar2 = lVar4;
            }
            return;
        }
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
    @u1.a
    protected boolean A(V v7) {
        if (v7 == null) {
            v7 = (V) f22589h;
        }
        if (!f22588g.b(this, null, v7)) {
            return false;
        }
        p(this);
        return true;
    }

    @u1.a
    protected boolean B(Throwable th) {
        if (!f22588g.b(this, null, new C0294d((Throwable) com.google.common.base.e0.E(th)))) {
            return false;
        }
        p(this);
        return true;
    }

    @s1.a
    @u1.a
    protected boolean C(l1<? extends V> l1Var) {
        C0294d c0294d;
        com.google.common.base.e0.E(l1Var);
        Object obj = this.f22590a;
        if (obj == null) {
            if (l1Var.isDone()) {
                if (!f22588g.b(this, null, s(l1Var))) {
                    return false;
                }
                p(this);
                return true;
            }
            g gVar = new g(this, l1Var);
            if (f22588g.b(this, null, gVar)) {
                try {
                    l1Var.I(gVar, n0.INSTANCE);
                } catch (Throwable th) {
                    try {
                        c0294d = new C0294d(th);
                    } catch (Throwable unused) {
                        c0294d = C0294d.f22597b;
                    }
                    f22588g.b(this, gVar, c0294d);
                }
                return true;
            }
            obj = this.f22590a;
        }
        if (obj instanceof c) {
            l1Var.cancel(((c) obj).f22595a);
        }
        return false;
    }

    protected final boolean E() {
        Object obj = this.f22590a;
        return (obj instanceof c) && ((c) obj).f22595a;
    }

    @Override // com.google.common.util.concurrent.l1
    public void I(Runnable runnable, Executor executor) {
        e eVar;
        com.google.common.base.e0.F(runnable, "Runnable was null.");
        com.google.common.base.e0.F(executor, "Executor was null.");
        if (!isDone() && (eVar = this.f22591b) != e.f22599d) {
            e eVar2 = new e(runnable, executor);
            do {
                eVar2.f22602c = eVar;
                if (f22588g.a(this, eVar, eVar2)) {
                    return;
                } else {
                    eVar = this.f22591b;
                }
            } while (eVar != e.f22599d);
        }
        q(runnable, executor);
    }

    @Override // com.google.common.util.concurrent.internal.a
    protected final Throwable a() {
        if (!(this instanceof i)) {
            return null;
        }
        Object obj = this.f22590a;
        if (obj instanceof C0294d) {
            return ((C0294d) obj).f22598a;
        }
        return null;
    }

    @Override // java.util.concurrent.Future
    @u1.a
    public boolean cancel(boolean z7) {
        c cVar;
        Object obj = this.f22590a;
        if (!(obj == null) && !(obj instanceof g)) {
            return false;
        }
        if (f22585d) {
            cVar = new c(z7, new CancellationException("Future.cancel() was called."));
        } else {
            cVar = z7 ? c.f22593c : c.f22594d;
        }
        d<V> dVar = this;
        boolean z8 = false;
        while (true) {
            if (f22588g.b(dVar, obj, cVar)) {
                if (z7) {
                    dVar.u();
                }
                p(dVar);
                if (!(obj instanceof g)) {
                    return true;
                }
                l1<? extends V> l1Var = ((g) obj).f22609b;
                if (!(l1Var instanceof i)) {
                    l1Var.cancel(z7);
                    return true;
                }
                dVar = (d) l1Var;
                obj = dVar.f22590a;
                if (!(obj == null) && !(obj instanceof g)) {
                    return true;
                }
                z8 = true;
            } else {
                obj = dVar.f22590a;
                if (!(obj instanceof g)) {
                    return z8;
                }
            }
        }
    }

    @Override // java.util.concurrent.Future
    @u1.a
    public V get(long j7, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j7);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f22590a;
        if ((obj != null) && (!(obj instanceof g))) {
            return r(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            l lVar = this.f22592c;
            if (lVar != l.f22616c) {
                l lVar2 = new l();
                while (true) {
                    lVar2.a(lVar);
                    if (f22588g.c(this, lVar, lVar2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                z(lVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f22590a;
                            if ((obj2 != null) && (!(obj2 instanceof g))) {
                                return r(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        z(lVar2);
                        break;
                    }
                    lVar = this.f22592c;
                    if (lVar == l.f22616c) {
                    }
                }
            }
            return r(this.f22590a);
        }
        while (nanos > 0) {
            Object obj3 = this.f22590a;
            if ((obj3 != null) && (!(obj3 instanceof g))) {
                return r(obj3);
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
    public boolean isCancelled() {
        return this.f22590a instanceof c;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        Object obj = this.f22590a;
        return (!(obj instanceof g)) & (obj != null);
    }

    @s1.a
    @u1.g
    protected void m() {
    }

    public String toString() {
        String strX;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            l(sb);
        } else {
            try {
                strX = x();
            } catch (RuntimeException e8) {
                strX = "Exception thrown from implementation: " + e8.getClass();
            }
            if (strX != null && !strX.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(strX);
                sb.append("]");
            } else if (isDone()) {
                l(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    protected void u() {
    }

    final void v(Future<?> future) {
        if ((future != null) && isCancelled()) {
            future.cancel(E());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected String x() {
        Object obj = this.f22590a;
        if (obj instanceof g) {
            return "setFuture=[" + D(((g) obj).f22609b) + "]";
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    @Override // java.util.concurrent.Future
    @u1.a
    public V get() throws ExecutionException, InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f22590a;
            if ((obj2 != null) & (!(obj2 instanceof g))) {
                return r(obj2);
            }
            l lVar = this.f22592c;
            if (lVar != l.f22616c) {
                l lVar2 = new l();
                do {
                    lVar2.a(lVar);
                    if (f22588g.c(this, lVar, lVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f22590a;
                            } else {
                                z(lVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof g))));
                        return r(obj);
                    }
                    lVar = this.f22592c;
                } while (lVar != l.f22616c);
            }
            return r(this.f22590a);
        }
        throw new InterruptedException();
    }
}
