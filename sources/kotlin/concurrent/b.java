package kotlin.concurrent;

import a7.d;
import a7.e;
import h5.h;
import kotlin.internal.f;
import kotlin.jvm.internal.l0;
import kotlin.l2;

/* JADX INFO: loaded from: classes2.dex */
@h(name = "ThreadsKt")
public final class b {

    public static final class a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.a<l2> f34665a;

        a(i5.a<l2> aVar) {
            this.f34665a = aVar;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.f34665a.invoke();
        }
    }

    @f
    private static final <T> T a(ThreadLocal<T> threadLocal, i5.a<? extends T> aVar) {
        l0.p(threadLocal, "<this>");
        l0.p(aVar, "default");
        T t7 = threadLocal.get();
        if (t7 != null) {
            return t7;
        }
        T tInvoke = aVar.invoke();
        threadLocal.set(tInvoke);
        return tInvoke;
    }

    @d
    public static final Thread b(boolean z7, boolean z8, @e ClassLoader classLoader, @e String str, int i7, @d i5.a<l2> block) {
        l0.p(block, "block");
        a aVar = new a(block);
        if (z8) {
            aVar.setDaemon(true);
        }
        if (i7 > 0) {
            aVar.setPriority(i7);
        }
        if (str != null) {
            aVar.setName(str);
        }
        if (classLoader != null) {
            aVar.setContextClassLoader(classLoader);
        }
        if (z7) {
            aVar.start();
        }
        return aVar;
    }

    public static /* synthetic */ Thread c(boolean z7, boolean z8, ClassLoader classLoader, String str, int i7, i5.a aVar, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            z7 = true;
        }
        boolean z9 = z7;
        if ((i8 & 2) != 0) {
            z8 = false;
        }
        boolean z10 = z8;
        ClassLoader classLoader2 = (i8 & 4) != 0 ? null : classLoader;
        String str2 = (i8 & 8) != 0 ? null : str;
        if ((i8 & 16) != 0) {
            i7 = -1;
        }
        return b(z9, z10, classLoader2, str2, i7, aVar);
    }
}
