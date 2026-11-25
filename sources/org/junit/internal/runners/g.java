package org.junit.internal.runners;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.runners.model.l;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f39866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final org.junit.runner.notification.c f39867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final org.junit.runner.c f39868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private k f39869d;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f39870a;

        /* JADX INFO: renamed from: org.junit.internal.runners.g$a$a, reason: collision with other inner class name */
        class CallableC0536a implements Callable<Object> {
            CallableC0536a() {
            }

            @Override // java.util.concurrent.Callable
            public Object call() throws Exception {
                g.this.g();
                return null;
            }
        }

        a(long j7) {
            this.f39870a = j7;
        }

        @Override // java.lang.Runnable
        public void run() {
            ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
            Future futureSubmit = executorServiceNewSingleThreadExecutor.submit(new CallableC0536a());
            executorServiceNewSingleThreadExecutor.shutdown();
            try {
                long j7 = this.f39870a;
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                if (!executorServiceNewSingleThreadExecutor.awaitTermination(j7, timeUnit)) {
                    executorServiceNewSingleThreadExecutor.shutdownNow();
                }
                futureSubmit.get(0L, timeUnit);
            } catch (TimeoutException unused) {
                g.this.a(new l(this.f39870a, TimeUnit.MILLISECONDS));
            } catch (Exception e8) {
                g.this.a(e8);
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.g();
        }
    }

    public g(Object obj, k kVar, org.junit.runner.notification.c cVar, org.junit.runner.c cVar2) {
        this.f39866a = obj;
        this.f39867b = cVar;
        this.f39868c = cVar2;
        this.f39869d = kVar;
    }

    private void c() {
        Iterator<Method> it = this.f39869d.b().iterator();
        while (it.hasNext()) {
            try {
                it.next().invoke(this.f39866a, new Object[0]);
            } catch (InvocationTargetException e8) {
                a(e8.getTargetException());
            } catch (Throwable th) {
                a(th);
            }
        }
    }

    private void d() throws c {
        try {
            try {
                Iterator<Method> it = this.f39869d.c().iterator();
                while (it.hasNext()) {
                    it.next().invoke(this.f39866a, new Object[0]);
                }
            } catch (InvocationTargetException e8) {
                throw e8.getTargetException();
            }
        } catch (org.junit.internal.b unused) {
            throw new c();
        } catch (Throwable th) {
            a(th);
            throw new c();
        }
    }

    private void h(long j7) {
        e(new a(j7));
    }

    protected void a(Throwable th) {
        this.f39867b.f(new org.junit.runner.notification.a(this.f39868c, th));
    }

    public void b() {
        if (this.f39869d.g()) {
            this.f39867b.i(this.f39868c);
            return;
        }
        this.f39867b.l(this.f39868c);
        try {
            long jE = this.f39869d.e();
            if (jE > 0) {
                h(jE);
            } else {
                f();
            }
        } finally {
            this.f39867b.h(this.f39868c);
        }
    }

    public void e(Runnable runnable) {
        try {
            try {
                d();
                runnable.run();
            } catch (c unused) {
            } catch (Exception unused2) {
                throw new RuntimeException("test should never throw an exception to this level");
            }
            c();
        } catch (Throwable th) {
            c();
            throw th;
        }
    }

    public void f() {
        e(new b());
    }

    protected void g() {
        try {
            this.f39869d.f(this.f39866a);
            if (this.f39869d.a()) {
                a(new AssertionError("Expected exception: " + this.f39869d.d().getName()));
            }
        } catch (InvocationTargetException e8) {
            Throwable targetException = e8.getTargetException();
            if (targetException instanceof org.junit.internal.b) {
                return;
            }
            if (!this.f39869d.a()) {
                a(targetException);
                return;
            }
            if (this.f39869d.h(targetException)) {
                a(new Exception("Unexpected exception, expected<" + this.f39869d.d().getName() + "> but was<" + targetException.getClass().getName() + ">", targetException));
            }
        } catch (Throwable th) {
            a(th);
        }
    }
}
