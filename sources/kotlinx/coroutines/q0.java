package kotlinx.coroutines;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/* JADX INFO: loaded from: classes2.dex */
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private static final List<p0> f37111a = kotlin.sequences.u.c3(kotlin.sequences.s.e(ServiceLoader.load(p0.class, p0.class.getClassLoader()).iterator()));

    public static final void a(@a7.d kotlin.coroutines.g gVar, @a7.d Throwable th) {
        Iterator<p0> it = f37111a.iterator();
        while (it.hasNext()) {
            try {
                it.next().handleException(gVar, th);
            } catch (Throwable th2) {
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, r0.c(th, th2));
            }
        }
        Thread threadCurrentThread2 = Thread.currentThread();
        try {
            kotlin.d1.a aVar = kotlin.d1.f34719b;
            kotlin.p.a(th, new i1(gVar));
            kotlin.d1.b(kotlin.l2.f34958a);
        } catch (Throwable th3) {
            kotlin.d1.a aVar2 = kotlin.d1.f34719b;
            kotlin.d1.b(kotlin.e1.a(th3));
        }
        threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
    }
}
