package com.google.common.base;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes.dex */
@s1.c
public class p implements Closeable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f19506e = "com.google.common.base.internal.Finalizer";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ReferenceQueue<Object> f19508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final PhantomReference<Object> f19509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f19510c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Logger f19505d = Logger.getLogger(p.class.getName());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Method f19507f = f(g(new d(), new a(), new b()));

    static class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String f19511a = "Could not load Finalizer in its own class loader. Loading Finalizer in the current class loader instead. As a result, you will not be able to garbage collect this class loader. To support reclaiming this class loader, either resolve the underlying issue, or move Guava to your system class path.";

        a() {
        }

        @Override // com.google.common.base.p.c
        public Class<?> a() {
            try {
                return c(b()).loadClass(p.f19506e);
            } catch (Exception e8) {
                p.f19505d.log(Level.WARNING, f19511a, (Throwable) e8);
                return null;
            }
        }

        URL b() throws IOException {
            String str = p.f19506e.replace(ClassUtils.PACKAGE_SEPARATOR_CHAR, '/') + ".class";
            URL resource = getClass().getClassLoader().getResource(str);
            if (resource == null) {
                throw new FileNotFoundException(str);
            }
            String string = resource.toString();
            if (string.endsWith(str)) {
                return new URL(resource, string.substring(0, string.length() - str.length()));
            }
            throw new IOException("Unsupported path style: " + string);
        }

        URLClassLoader c(URL url) {
            return new URLClassLoader(new URL[]{url}, null);
        }
    }

    static class b implements c {
        b() {
        }

        @Override // com.google.common.base.p.c
        public Class<?> a() {
            try {
                return Class.forName("t1.a");
            } catch (ClassNotFoundException e8) {
                throw new AssertionError(e8);
            }
        }
    }

    interface c {
        Class<?> a();
    }

    static class d implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @s1.d
        static boolean f19512a;

        d() {
        }

        @Override // com.google.common.base.p.c
        public Class<?> a() {
            if (f19512a) {
                return null;
            }
            try {
                ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
                if (systemClassLoader != null) {
                    try {
                        return systemClassLoader.loadClass(p.f19506e);
                    } catch (ClassNotFoundException unused) {
                    }
                }
                return null;
            } catch (SecurityException unused2) {
                p.f19505d.info("Not allowed to access system class loader.");
                return null;
            }
        }
    }

    public p() {
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        this.f19508a = referenceQueue;
        PhantomReference<Object> phantomReference = new PhantomReference<>(this, referenceQueue);
        this.f19509b = phantomReference;
        boolean z7 = false;
        try {
            f19507f.invoke(null, o.class, referenceQueue, phantomReference);
            z7 = true;
        } catch (IllegalAccessException e8) {
            throw new AssertionError(e8);
        } catch (Throwable th) {
            f19505d.log(Level.INFO, "Failed to start reference finalizer thread. Reference cleanup will only occur when new references are created.", th);
        }
        this.f19510c = z7;
    }

    static Method f(Class<?> cls) {
        try {
            return cls.getMethod("startFinalizer", Class.class, ReferenceQueue.class, PhantomReference.class);
        } catch (NoSuchMethodException e8) {
            throw new AssertionError(e8);
        }
    }

    private static Class<?> g(c... cVarArr) {
        for (c cVar : cVarArr) {
            Class<?> clsA = cVar.a();
            if (clsA != null) {
                return clsA;
            }
        }
        throw new AssertionError();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f19509b.enqueue();
        e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    void e() {
        if (this.f19510c) {
            return;
        }
        while (true) {
            Reference<? extends Object> referencePoll = this.f19508a.poll();
            if (referencePoll == 0) {
                return;
            }
            referencePoll.clear();
            try {
                ((o) referencePoll).a();
            } catch (Throwable th) {
                f19505d.log(Level.SEVERE, "Error cleaning up after reference.", th);
            }
        }
    }
}
