package androidx.startup;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import c.m0;
import c.o0;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f9809d = "Startup";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile a f9810e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object f9811f = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @m0
    final Context f9814c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m0
    final Set<Class<? extends b<?>>> f9813b = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    final Map<Class<?>, Object> f9812a = new HashMap();

    a(@m0 Context context) {
        this.f9814c = context.getApplicationContext();
    }

    @m0
    private <T> T d(@m0 Class<? extends b<?>> cls, @m0 Set<Class<?>> set) {
        T t7;
        if (androidx.tracing.b.h()) {
            try {
                androidx.tracing.b.c(cls.getSimpleName());
            } catch (Throwable th) {
                androidx.tracing.b.f();
                throw th;
            }
        }
        if (set.contains(cls)) {
            throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", cls.getName()));
        }
        if (this.f9812a.containsKey(cls)) {
            t7 = (T) this.f9812a.get(cls);
        } else {
            set.add(cls);
            try {
                b<?> bVarNewInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                List<Class<? extends b<?>>> listA = bVarNewInstance.a();
                if (!listA.isEmpty()) {
                    for (Class<? extends b<?>> cls2 : listA) {
                        if (!this.f9812a.containsKey(cls2)) {
                            d(cls2, set);
                        }
                    }
                }
                t7 = (T) bVarNewInstance.b(this.f9814c);
                set.remove(cls);
                this.f9812a.put(cls, t7);
            } catch (Throwable th2) {
                throw new c(th2);
            }
        }
        androidx.tracing.b.f();
        return t7;
    }

    @m0
    public static a e(@m0 Context context) {
        if (f9810e == null) {
            synchronized (f9811f) {
                if (f9810e == null) {
                    f9810e = new a(context);
                }
            }
        }
        return f9810e;
    }

    static void h(@m0 a aVar) {
        synchronized (f9811f) {
            f9810e = aVar;
        }
    }

    void a() {
        try {
            try {
                androidx.tracing.b.c(f9809d);
                b(this.f9814c.getPackageManager().getProviderInfo(new ComponentName(this.f9814c.getPackageName(), InitializationProvider.class.getName()), 128).metaData);
                androidx.tracing.b.f();
            } catch (PackageManager.NameNotFoundException e8) {
                throw new c(e8);
            }
        } catch (Throwable th) {
            androidx.tracing.b.f();
            throw th;
        }
    }

    void b(@o0 Bundle bundle) {
        String string = this.f9814c.getString(R.string.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet = new HashSet();
                for (String str : bundle.keySet()) {
                    if (string.equals(bundle.getString(str, null))) {
                        Class<?> cls = Class.forName(str);
                        if (b.class.isAssignableFrom(cls)) {
                            this.f9813b.add((Class<? extends b<?>>) cls);
                        }
                    }
                }
                Iterator<Class<? extends b<?>>> it = this.f9813b.iterator();
                while (it.hasNext()) {
                    d(it.next(), hashSet);
                }
            } catch (ClassNotFoundException e8) {
                throw new c(e8);
            }
        }
    }

    @m0
    <T> T c(@m0 Class<? extends b<?>> cls) {
        T t7;
        synchronized (f9811f) {
            t7 = (T) this.f9812a.get(cls);
            if (t7 == null) {
                t7 = (T) d(cls, new HashSet());
            }
        }
        return t7;
    }

    @m0
    public <T> T f(@m0 Class<? extends b<T>> cls) {
        return (T) c(cls);
    }

    public boolean g(@m0 Class<? extends b<?>> cls) {
        return this.f9813b.contains(cls);
    }
}
