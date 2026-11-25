package com.google.common.io;

import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.c
public final class s implements Closeable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final c f22017d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @s1.d
    final c f22018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Deque<Closeable> f22019b = new ArrayDeque(4);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Throwable f22020c;

    @s1.d
    static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final a f22021a = new a();

        a() {
        }

        @Override // com.google.common.io.s.c
        public void a(Closeable closeable, Throwable th, Throwable th2) {
            r.f22016a.log(Level.WARNING, "Suppressing exception thrown when closing " + closeable, th2);
        }
    }

    @s1.d
    static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final b f22022a = new b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final Method f22023b = b();

        b() {
        }

        private static Method b() {
            try {
                return Throwable.class.getMethod("addSuppressed", Throwable.class);
            } catch (Throwable unused) {
                return null;
            }
        }

        static boolean c() {
            return f22023b != null;
        }

        @Override // com.google.common.io.s.c
        public void a(Closeable closeable, Throwable th, Throwable th2) {
            if (th == th2) {
                return;
            }
            try {
                f22023b.invoke(th, th2);
            } catch (Throwable unused) {
                a.f22021a.a(closeable, th, th2);
            }
        }
    }

    @s1.d
    interface c {
        void a(Closeable closeable, Throwable th, Throwable th2);
    }

    static {
        f22017d = b.c() ? b.f22022a : a.f22021a;
    }

    @s1.d
    s(c cVar) {
        this.f22018a = (c) com.google.common.base.e0.E(cVar);
    }

    public static s b() {
        return new s(f22017d);
    }

    @u1.a
    public <C extends Closeable> C c(C c8) {
        if (c8 != null) {
            this.f22019b.addFirst(c8);
        }
        return c8;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        Throwable th = this.f22020c;
        while (!this.f22019b.isEmpty()) {
            Closeable closeableRemoveFirst = this.f22019b.removeFirst();
            try {
                closeableRemoveFirst.close();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                } else {
                    this.f22018a.a(closeableRemoveFirst, th, th2);
                }
            }
        }
        if (this.f22020c != null || th == null) {
            return;
        }
        com.google.common.base.r0.t(th, IOException.class);
        throw new AssertionError(th);
    }

    public RuntimeException e(Throwable th) throws Throwable {
        com.google.common.base.e0.E(th);
        this.f22020c = th;
        com.google.common.base.r0.t(th, IOException.class);
        throw new RuntimeException(th);
    }

    public <X extends Exception> RuntimeException f(Throwable th, Class<X> cls) throws Exception {
        com.google.common.base.e0.E(th);
        this.f22020c = th;
        com.google.common.base.r0.t(th, IOException.class);
        com.google.common.base.r0.t(th, cls);
        throw new RuntimeException(th);
    }

    public <X1 extends Exception, X2 extends Exception> RuntimeException g(Throwable th, Class<X1> cls, Class<X2> cls2) throws Exception {
        com.google.common.base.e0.E(th);
        this.f22020c = th;
        com.google.common.base.r0.t(th, IOException.class);
        com.google.common.base.r0.u(th, cls, cls2);
        throw new RuntimeException(th);
    }
}
