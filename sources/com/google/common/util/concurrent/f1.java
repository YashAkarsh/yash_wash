package com.google.common.util.concurrent;

import com.google.common.collect.td;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
@s1.c
final class f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final td<Constructor<?>> f22660a = td.A().E(new a()).F();

    static class a implements com.google.common.base.s<Constructor<?>, Boolean> {
        a() {
        }

        @Override // com.google.common.base.s, java.util.function.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean apply(Constructor<?> constructor) {
            return Boolean.valueOf(Arrays.asList(constructor.getParameterTypes()).contains(String.class));
        }
    }

    @s1.d
    interface b {
        void a(Class<? extends Exception> cls);
    }

    @s1.d
    static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final String f22661a = c.class.getName() + "$ClassValueValidator";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final b f22662b = a();

        @z6.a
        enum a implements b {
            INSTANCE;


            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private static final ClassValue<Boolean> f22664b = new C0297a();

            /* JADX INFO: renamed from: com.google.common.util.concurrent.f1$c$a$a, reason: collision with other inner class name */
            static class C0297a extends ClassValue<Boolean> {
                C0297a() {
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // java.lang.ClassValue
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Boolean computeValue(Class<?> cls) {
                    f1.b(cls.asSubclass(Exception.class));
                    return Boolean.TRUE;
                }
            }

            @Override // com.google.common.util.concurrent.f1.b
            public void a(Class<? extends Exception> cls) {
                f22664b.get(cls);
            }
        }

        enum b implements b {
            INSTANCE;


            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private static final Set<WeakReference<Class<? extends Exception>>> f22667b = new CopyOnWriteArraySet();

            @Override // com.google.common.util.concurrent.f1.b
            public void a(Class<? extends Exception> cls) {
                Iterator<WeakReference<Class<? extends Exception>>> it = f22667b.iterator();
                while (it.hasNext()) {
                    if (cls.equals(it.next().get())) {
                        return;
                    }
                }
                f1.b(cls);
                Set<WeakReference<Class<? extends Exception>>> set = f22667b;
                if (set.size() > 1000) {
                    set.clear();
                }
                set.add(new WeakReference<>(cls));
            }
        }

        c() {
        }

        static b a() {
            try {
                return (b) Class.forName(f22661a).getEnumConstants()[0];
            } catch (Throwable unused) {
                return f1.l();
            }
        }
    }

    private f1() {
    }

    private static b a() {
        return c.f22662b;
    }

    @s1.d
    static void b(Class<? extends Exception> cls) {
        com.google.common.base.e0.u(h(cls), "Futures.getChecked exception type (%s) must not be a RuntimeException", cls);
        com.google.common.base.e0.u(g(cls), "Futures.getChecked exception type (%s) must be an accessible class with an accessible constructor whose parameters (if any) must be of type String and/or Throwable", cls);
    }

    @s1.d
    static b c() {
        return c.a.INSTANCE;
    }

    @u1.a
    @s1.d
    static <V, X extends Exception> V d(b bVar, Future<V> future, Class<X> cls) throws Exception {
        bVar.a(cls);
        try {
            return future.get();
        } catch (InterruptedException e8) {
            Thread.currentThread().interrupt();
            throw j(cls, e8);
        } catch (ExecutionException e9) {
            m(e9.getCause(), cls);
            throw new AssertionError();
        }
    }

    @u1.a
    static <V, X extends Exception> V e(Future<V> future, Class<X> cls) throws Exception {
        return (V) d(a(), future, cls);
    }

    @u1.a
    static <V, X extends Exception> V f(Future<V> future, Class<X> cls, long j7, TimeUnit timeUnit) throws Exception {
        a().a(cls);
        try {
            return future.get(j7, timeUnit);
        } catch (InterruptedException e8) {
            Thread.currentThread().interrupt();
            throw j(cls, e8);
        } catch (ExecutionException e9) {
            m(e9.getCause(), cls);
            throw new AssertionError();
        } catch (TimeoutException e10) {
            throw j(cls, e10);
        }
    }

    private static boolean g(Class<? extends Exception> cls) {
        try {
            j(cls, new Exception());
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @s1.d
    static boolean h(Class<? extends Exception> cls) {
        return !RuntimeException.class.isAssignableFrom(cls);
    }

    private static <X> X i(Constructor<X> constructor, Throwable th) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        Object[] objArr = new Object[parameterTypes.length];
        for (int i7 = 0; i7 < parameterTypes.length; i7++) {
            Class<?> cls = parameterTypes[i7];
            if (cls.equals(String.class)) {
                objArr[i7] = th.toString();
            } else {
                if (!cls.equals(Throwable.class)) {
                    return null;
                }
                objArr[i7] = th;
            }
        }
        try {
            return constructor.newInstance(objArr);
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private static <X extends Exception> X j(Class<X> cls, Throwable th) {
        Iterator it = k(Arrays.asList(cls.getConstructors())).iterator();
        while (it.hasNext()) {
            X x7 = (X) i((Constructor) it.next(), th);
            if (x7 != null) {
                if (x7.getCause() == null) {
                    x7.initCause(th);
                }
                return x7;
            }
        }
        throw new IllegalArgumentException("No appropriate constructor for exception of type " + cls + " in response to chained exception", th);
    }

    private static <X extends Exception> List<Constructor<X>> k(List<Constructor<X>> list) {
        return (List<Constructor<X>>) f22660a.H(list);
    }

    @s1.d
    static b l() {
        return c.b.INSTANCE;
    }

    private static <X extends Exception> void m(Throwable th, Class<X> cls) throws Exception {
        if (th instanceof Error) {
            throw new o0((Error) th);
        }
        if (!(th instanceof RuntimeException)) {
            throw j(cls, th);
        }
        throw new n2(th);
    }
}
