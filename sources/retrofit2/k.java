package retrofit2;

import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final k f40215a = c();

    static class a extends k {

        /* JADX INFO: renamed from: retrofit2.k$a$a, reason: collision with other inner class name */
        static class ExecutorC0548a implements Executor {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Handler f40216a = new Handler(Looper.getMainLooper());

            ExecutorC0548a() {
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                this.f40216a.post(runnable);
            }
        }

        a() {
        }

        @Override // retrofit2.k
        c.a a(@Nullable Executor executor) {
            if (executor != null) {
                return new g(executor);
            }
            throw new AssertionError();
        }

        @Override // retrofit2.k
        public Executor b() {
            return new ExecutorC0548a();
        }
    }

    @z6.a
    static class b extends k {
        b() {
        }

        @Override // retrofit2.k
        Object e(Method method, Class<?> cls, Object obj, @Nullable Object... objArr) throws Throwable {
            Constructor declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
            declaredConstructor.setAccessible(true);
            return m.a(declaredConstructor.newInstance(cls, -1)).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
        }

        @Override // retrofit2.k
        boolean f(Method method) {
            return method.isDefault();
        }
    }

    k() {
    }

    private static k c() {
        try {
            try {
                Class.forName("android.os.Build");
                return new a();
            } catch (ClassNotFoundException unused) {
                return new k();
            }
        } catch (ClassNotFoundException unused2) {
            Class.forName("java.util.Optional");
            return new b();
        }
    }

    static k d() {
        return f40215a;
    }

    c.a a(@Nullable Executor executor) {
        return executor != null ? new g(executor) : f.f40159a;
    }

    @Nullable
    Executor b() {
        return null;
    }

    @Nullable
    Object e(Method method, Class<?> cls, Object obj, @Nullable Object... objArr) throws Throwable {
        throw new UnsupportedOperationException();
    }

    boolean f(Method method) {
        return false;
    }
}
