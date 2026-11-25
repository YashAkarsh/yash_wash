package com.google.common.base;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@s1.b(emulated = true)
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @s1.c
    private static final String f19534a = "sun.misc.JavaLangAccess";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @s1.c
    @s1.d
    static final String f19535b = "sun.misc.SharedSecrets";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @s1.c
    private static final Object f19536c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @s1.c
    private static final Method f19537d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @s1.c
    private static final Method f19538e;

    static class a extends AbstractList<StackTraceElement> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Throwable f19539a;

        a(Throwable th) {
            this.f19539a = th;
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public StackTraceElement get(int i7) {
            return (StackTraceElement) r0.m(r0.f19537d, r0.f19536c, this.f19539a, Integer.valueOf(i7));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return ((Integer) r0.m(r0.f19538e, r0.f19536c, this.f19539a)).intValue();
        }
    }

    static {
        Object objH = h();
        f19536c = objH;
        f19537d = objH == null ? null : g();
        f19538e = objH != null ? k() : null;
    }

    private r0() {
    }

    @s1.a
    public static List<Throwable> e(Throwable th) {
        e0.E(th);
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(th);
        boolean z7 = false;
        Throwable cause = th;
        while (true) {
            th = th.getCause();
            if (th == null) {
                return Collections.unmodifiableList(arrayList);
            }
            arrayList.add(th);
            if (th == cause) {
                throw new IllegalArgumentException("Loop in causal chain detected.", th);
            }
            if (z7) {
                cause = cause.getCause();
            }
            z7 = !z7;
        }
    }

    @s1.a
    @s1.c
    public static <X extends Throwable> X f(Throwable th, Class<X> cls) {
        try {
            return cls.cast(th.getCause());
        } catch (ClassCastException e8) {
            e8.initCause(th);
            throw e8;
        }
    }

    @s1.c
    private static Method g() {
        return i("getStackTraceElement", Throwable.class, Integer.TYPE);
    }

    @s1.c
    private static Object h() {
        try {
            return Class.forName(f19535b, false, null).getMethod("getJavaLangAccess", new Class[0]).invoke(null, new Object[0]);
        } catch (ThreadDeath e8) {
            throw e8;
        } catch (Throwable unused) {
            return null;
        }
    }

    @s1.c
    private static Method i(String str, Class<?>... clsArr) throws ThreadDeath {
        try {
            return Class.forName(f19534a, false, null).getMethod(str, clsArr);
        } catch (ThreadDeath e8) {
            throw e8;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Throwable j(Throwable th) {
        boolean z7 = false;
        Throwable cause = th;
        while (true) {
            Throwable cause2 = th.getCause();
            if (cause2 == null) {
                return th;
            }
            if (cause2 == cause) {
                throw new IllegalArgumentException("Loop in causal chain detected.", cause2);
            }
            if (z7) {
                cause = cause.getCause();
            }
            z7 = !z7;
            th = cause2;
        }
    }

    @s1.c
    private static Method k() {
        try {
            Method methodI = i("getStackTraceDepth", Throwable.class);
            if (methodI == null) {
                return null;
            }
            methodI.invoke(h(), new Throwable());
            return methodI;
        } catch (IllegalAccessException | UnsupportedOperationException | InvocationTargetException unused) {
            return null;
        }
    }

    @s1.c
    public static String l(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @s1.c
    public static Object m(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e8) {
            throw new RuntimeException(e8);
        } catch (InvocationTargetException e9) {
            throw q(e9.getCause());
        }
    }

    @s1.c
    private static List<StackTraceElement> n(Throwable th) {
        e0.E(th);
        return new a(th);
    }

    @s1.a
    @s1.c
    public static List<StackTraceElement> o(Throwable th) {
        return p() ? n(th) : Collections.unmodifiableList(Arrays.asList(th.getStackTrace()));
    }

    @s1.a
    @s1.c
    public static boolean p() {
        return (f19537d == null || f19538e == null) ? false : true;
    }

    @u1.a
    @s1.c
    @Deprecated
    public static RuntimeException q(Throwable th) {
        w(th);
        throw new RuntimeException(th);
    }

    @s1.c
    @Deprecated
    public static <X extends Throwable> void r(Throwable th, Class<X> cls) throws Throwable {
        if (th != null) {
            v(th, cls);
        }
    }

    @s1.c
    @Deprecated
    public static void s(Throwable th) {
        if (th != null) {
            w(th);
        }
    }

    @s1.c
    public static <X extends Throwable> void t(Throwable th, Class<X> cls) throws Throwable {
        r(th, cls);
        s(th);
    }

    @s1.c
    public static <X1 extends Throwable, X2 extends Throwable> void u(Throwable th, Class<X1> cls, Class<X2> cls2) throws Throwable {
        e0.E(cls2);
        r(th, cls);
        t(th, cls2);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: X extends java.lang.Throwable */
    @s1.c
    public static <X extends Throwable> void v(Throwable th, Class<X> cls) throws Throwable {
        e0.E(th);
        if (cls.isInstance(th)) {
            throw cls.cast(th);
        }
    }

    public static void w(Throwable th) {
        e0.E(th);
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        if (th instanceof Error) {
            throw ((Error) th);
        }
    }
}
