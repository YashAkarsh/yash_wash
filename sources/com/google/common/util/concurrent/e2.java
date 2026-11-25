package com.google.common.util.concurrent;

import com.google.common.collect.af;
import com.google.common.collect.sd;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.c
public final class e2 implements j2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExecutorService f22642a;

    class a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f22643a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f22644b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ TimeUnit f22645c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Set f22646d;

        /* JADX INFO: renamed from: com.google.common.util.concurrent.e2$a$a, reason: collision with other inner class name */
        class CallableC0295a implements Callable<Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Method f22648a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Object[] f22649b;

            CallableC0295a(Method method, Object[] objArr) {
                this.f22648a = method;
                this.f22649b = objArr;
            }

            @Override // java.util.concurrent.Callable
            public Object call() throws Exception {
                try {
                    return this.f22648a.invoke(a.this.f22643a, this.f22649b);
                } catch (InvocationTargetException e8) {
                    throw e2.n(e8, false);
                }
            }
        }

        a(Object obj, long j7, TimeUnit timeUnit, Set set) {
            this.f22643a = obj;
            this.f22644b = j7;
            this.f22645c = timeUnit;
            this.f22646d = set;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            return e2.this.h(new CallableC0295a(method, objArr), this.f22644b, this.f22645c, this.f22646d.contains(method));
        }
    }

    private e2(ExecutorService executorService) {
        this.f22642a = (ExecutorService) com.google.common.base.e0.E(executorService);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> T h(Callable<T> callable, long j7, TimeUnit timeUnit, boolean z7) throws Exception {
        com.google.common.base.e0.E(callable);
        com.google.common.base.e0.E(timeUnit);
        i(j7);
        Future<T> futureSubmit = this.f22642a.submit(callable);
        try {
            if (!z7) {
                return (T) p2.e(futureSubmit, j7, timeUnit);
            }
            try {
                return futureSubmit.get(j7, timeUnit);
            } catch (InterruptedException e8) {
                futureSubmit.cancel(true);
                throw e8;
            }
        } catch (ExecutionException e9) {
            throw n(e9, true);
        } catch (TimeoutException e10) {
            futureSubmit.cancel(true);
            throw new o2(e10);
        }
    }

    private static void i(long j7) {
        com.google.common.base.e0.p(j7 > 0, "timeout must be positive: %s", j7);
    }

    public static e2 j(ExecutorService executorService) {
        return new e2(executorService);
    }

    private static boolean k(Method method) {
        for (Class<?> cls : method.getExceptionTypes()) {
            if (cls == InterruptedException.class) {
                return true;
            }
        }
        return false;
    }

    private static Set<Method> l(Class<?> cls) {
        HashSet hashSetU = af.u();
        for (Method method : cls.getMethods()) {
            if (k(method)) {
                hashSetU.add(method);
            }
        }
        return hashSetU;
    }

    private static <T> T m(Class<T> cls, InvocationHandler invocationHandler) {
        return cls.cast(Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, invocationHandler));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Exception n(Exception exc, boolean z7) throws Exception {
        Throwable cause = exc.getCause();
        if (cause == null) {
            throw exc;
        }
        if (z7) {
            cause.setStackTrace((StackTraceElement[]) sd.f(cause.getStackTrace(), exc.getStackTrace(), StackTraceElement.class));
        }
        if (cause instanceof Exception) {
            throw ((Exception) cause);
        }
        if (cause instanceof Error) {
            throw ((Error) cause);
        }
        throw exc;
    }

    private void o(Throwable th) throws ExecutionException {
        if (th instanceof Error) {
            throw new o0((Error) th);
        }
        if (!(th instanceof RuntimeException)) {
            throw new ExecutionException(th);
        }
        throw new n2(th);
    }

    private void p(Throwable th) {
        if (!(th instanceof Error)) {
            throw new n2(th);
        }
        throw new o0((Error) th);
    }

    @Override // com.google.common.util.concurrent.j2
    @u1.a
    public <T> T a(Callable<T> callable, long j7, TimeUnit timeUnit) throws ExecutionException, TimeoutException {
        com.google.common.base.e0.E(callable);
        com.google.common.base.e0.E(timeUnit);
        i(j7);
        Future<T> futureSubmit = this.f22642a.submit(callable);
        try {
            return (T) p2.e(futureSubmit, j7, timeUnit);
        } catch (ExecutionException e8) {
            o(e8.getCause());
            throw new AssertionError();
        } catch (TimeoutException e9) {
            futureSubmit.cancel(true);
            throw e9;
        }
    }

    @Override // com.google.common.util.concurrent.j2
    public void b(Runnable runnable, long j7, TimeUnit timeUnit) throws Throwable {
        com.google.common.base.e0.E(runnable);
        com.google.common.base.e0.E(timeUnit);
        i(j7);
        Future<?> futureSubmit = this.f22642a.submit(runnable);
        try {
            futureSubmit.get(j7, timeUnit);
        } catch (InterruptedException e8) {
            e = e8;
            futureSubmit.cancel(true);
            throw e;
        } catch (ExecutionException e9) {
            p(e9.getCause());
            throw new AssertionError();
        } catch (TimeoutException e10) {
            e = e10;
            futureSubmit.cancel(true);
            throw e;
        }
    }

    @Override // com.google.common.util.concurrent.j2
    @u1.a
    public <T> T c(Callable<T> callable, long j7, TimeUnit timeUnit) throws Throwable {
        com.google.common.base.e0.E(callable);
        com.google.common.base.e0.E(timeUnit);
        i(j7);
        Future<T> futureSubmit = this.f22642a.submit(callable);
        try {
            return futureSubmit.get(j7, timeUnit);
        } catch (InterruptedException e8) {
            e = e8;
            futureSubmit.cancel(true);
            throw e;
        } catch (ExecutionException e9) {
            o(e9.getCause());
            throw new AssertionError();
        } catch (TimeoutException e10) {
            e = e10;
            futureSubmit.cancel(true);
            throw e;
        }
    }

    @Override // com.google.common.util.concurrent.j2
    public <T> T d(T t7, Class<T> cls, long j7, TimeUnit timeUnit) {
        com.google.common.base.e0.E(t7);
        com.google.common.base.e0.E(cls);
        com.google.common.base.e0.E(timeUnit);
        i(j7);
        com.google.common.base.e0.e(cls.isInterface(), "interfaceType must be an interface type");
        return (T) m(cls, new a(t7, j7, timeUnit, l(cls)));
    }

    @Override // com.google.common.util.concurrent.j2
    public void e(Runnable runnable, long j7, TimeUnit timeUnit) throws TimeoutException {
        com.google.common.base.e0.E(runnable);
        com.google.common.base.e0.E(timeUnit);
        i(j7);
        Future<?> futureSubmit = this.f22642a.submit(runnable);
        try {
            p2.e(futureSubmit, j7, timeUnit);
        } catch (ExecutionException e8) {
            p(e8.getCause());
            throw new AssertionError();
        } catch (TimeoutException e9) {
            futureSubmit.cancel(true);
            throw e9;
        }
    }
}
