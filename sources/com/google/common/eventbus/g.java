package com.google.common.eventbus;

import com.google.common.base.e0;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @y1.i
    private e f21563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @s1.d
    final Object f21564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Method f21565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Executor f21566d;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f21567a;

        a(Object obj) {
            this.f21567a = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                g.this.f(this.f21567a);
            } catch (InvocationTargetException e8) {
                g.this.f21563a.b(e8.getCause(), g.this.c(this.f21567a));
            }
        }
    }

    @s1.d
    static final class b extends g {
        /* synthetic */ b(e eVar, Object obj, Method method, a aVar) {
            this(eVar, obj, method);
        }

        @Override // com.google.common.eventbus.g
        void f(Object obj) throws InvocationTargetException {
            synchronized (this) {
                super.f(obj);
            }
        }

        private b(e eVar, Object obj, Method method) {
            super(eVar, obj, method, null);
        }
    }

    /* synthetic */ g(e eVar, Object obj, Method method, a aVar) {
        this(eVar, obj, method);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public h c(Object obj) {
        return new h(this.f21563a, obj, this.f21564b, this.f21565c);
    }

    static g d(e eVar, Object obj, Method method) {
        return g(method) ? new g(eVar, obj, method) : new b(eVar, obj, method, null);
    }

    private static boolean g(Method method) {
        return method.getAnnotation(com.google.common.eventbus.a.class) != null;
    }

    final void e(Object obj) {
        this.f21566d.execute(new a(obj));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f21564b == gVar.f21564b && this.f21565c.equals(gVar.f21565c);
    }

    @s1.d
    void f(Object obj) throws InvocationTargetException {
        try {
            this.f21565c.invoke(this.f21564b, e0.E(obj));
        } catch (IllegalAccessException e8) {
            throw new Error("Method became inaccessible: " + obj, e8);
        } catch (IllegalArgumentException e9) {
            throw new Error("Method rejected target/argument: " + obj, e9);
        } catch (InvocationTargetException e10) {
            if (!(e10.getCause() instanceof Error)) {
                throw e10;
            }
            throw ((Error) e10.getCause());
        }
    }

    public final int hashCode() {
        return ((this.f21565c.hashCode() + 31) * 31) + System.identityHashCode(this.f21564b);
    }

    private g(e eVar, Object obj, Method method) {
        this.f21563a = eVar;
        this.f21564b = e0.E(obj);
        this.f21565c = method;
        method.setAccessible(true);
        this.f21566d = eVar.a();
    }
}
