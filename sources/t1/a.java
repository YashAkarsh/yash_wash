package t1;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public class a implements Runnable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Logger f40347d = Logger.getLogger(a.class.getName());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f40348e = "com.google.common.base.FinalizableReference";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Constructor<Thread> f40349f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Field f40350g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakReference<Class<?>> f40351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PhantomReference<Object> f40352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ReferenceQueue<Object> f40353c;

    static {
        Constructor<Thread> constructorB = b();
        f40349f = constructorB;
        f40350g = constructorB == null ? d() : null;
    }

    private a(Class<?> cls, ReferenceQueue<Object> referenceQueue, PhantomReference<Object> phantomReference) {
        this.f40353c = referenceQueue;
        this.f40351a = new WeakReference<>(cls);
        this.f40352b = phantomReference;
    }

    private boolean a(Reference<?> reference) {
        Method methodC = c();
        if (methodC == null) {
            return false;
        }
        do {
            reference.clear();
            if (reference == this.f40352b) {
                return false;
            }
            try {
                methodC.invoke(reference, new Object[0]);
            } catch (Throwable th) {
                f40347d.log(Level.SEVERE, "Error cleaning up after reference.", th);
            }
            reference = this.f40353c.poll();
        } while (reference != null);
        return true;
    }

    private static Constructor<Thread> b() {
        try {
            return Thread.class.getConstructor(ThreadGroup.class, Runnable.class, String.class, Long.TYPE, Boolean.TYPE);
        } catch (Throwable unused) {
            return null;
        }
    }

    private Method c() {
        Class<?> cls = this.f40351a.get();
        if (cls == null) {
            return null;
        }
        try {
            return cls.getMethod("finalizeReferent", new Class[0]);
        } catch (NoSuchMethodException e8) {
            throw new AssertionError(e8);
        }
    }

    private static Field d() {
        try {
            Field declaredField = Thread.class.getDeclaredField("inheritableThreadLocals");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            f40347d.log(Level.INFO, "Couldn't access Thread.inheritableThreadLocals. Reference finalizer threads will inherit thread local values.");
            return null;
        }
    }

    public static void e(Class<?> cls, ReferenceQueue<Object> referenceQueue, PhantomReference<Object> phantomReference) {
        Thread thread;
        if (!cls.getName().equals("com.google.common.base.o")) {
            throw new IllegalArgumentException("Expected com.google.common.base.FinalizableReference.");
        }
        a aVar = new a(cls, referenceQueue, phantomReference);
        String name = a.class.getName();
        Constructor<Thread> constructor = f40349f;
        if (constructor != null) {
            try {
                thread = constructor.newInstance(null, aVar, name, 0L, Boolean.FALSE);
            } catch (Throwable th) {
                f40347d.log(Level.INFO, "Failed to create a thread without inherited thread-local values", th);
                thread = null;
            }
        } else {
            thread = null;
        }
        if (thread == null) {
            thread = new Thread(null, aVar, name);
        }
        thread.setDaemon(true);
        try {
            Field field = f40350g;
            if (field != null) {
                field.set(thread, null);
            }
        } catch (Throwable th2) {
            f40347d.log(Level.INFO, "Failed to clear thread local values inherited by reference finalizer thread.", th2);
        }
        thread.start();
    }

    @Override // java.lang.Runnable
    public void run() {
        while (a(this.f40353c.remove())) {
        }
    }
}
