package kotlinx.coroutines.internal;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.e
    private static final Method f36979a;

    static {
        Method method;
        try {
            method = ScheduledThreadPoolExecutor.class.getMethod("setRemoveOnCancelPolicy", Boolean.TYPE);
        } catch (Throwable unused) {
            method = null;
        }
        f36979a = method;
    }

    public static /* synthetic */ void a() {
    }

    @a7.d
    public static final <E> Set<E> b(int i7) {
        return Collections.newSetFromMap(new IdentityHashMap(i7));
    }

    public static final boolean c(@a7.d Executor executor) {
        Method method;
        try {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = executor instanceof ScheduledThreadPoolExecutor ? (ScheduledThreadPoolExecutor) executor : null;
            if (scheduledThreadPoolExecutor == null || (method = f36979a) == null) {
                return false;
            }
            method.invoke(scheduledThreadPoolExecutor, Boolean.TRUE);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    @a7.d
    public static final <E> List<E> d() {
        return new CopyOnWriteArrayList();
    }

    public static final <T> T e(@a7.d ReentrantLock reentrantLock, @a7.d i5.a<? extends T> aVar) {
        reentrantLock.lock();
        try {
            return aVar.invoke();
        } finally {
            kotlin.jvm.internal.i0.d(1);
            reentrantLock.unlock();
            kotlin.jvm.internal.i0.c(1);
        }
    }
}
