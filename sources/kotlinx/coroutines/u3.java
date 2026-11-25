package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
public final class u3 {
    @a7.d
    public static final <T> t3<T> a(@a7.d ThreadLocal<T> threadLocal, T t7) {
        return new kotlinx.coroutines.internal.x0(t7, threadLocal);
    }

    public static /* synthetic */ t3 b(ThreadLocal threadLocal, Object obj, int i7, Object obj2) {
        if ((i7 & 1) != 0) {
            obj = threadLocal.get();
        }
        return a(threadLocal, obj);
    }

    @a7.e
    public static final Object c(@a7.d ThreadLocal<?> threadLocal, @a7.d kotlin.coroutines.d<? super kotlin.l2> dVar) {
        if (dVar.d().get(new kotlinx.coroutines.internal.y0(threadLocal)) != null) {
            return kotlin.l2.f34958a;
        }
        throw new IllegalStateException(("ThreadLocal " + threadLocal + " is missing from context " + dVar.d()).toString());
    }

    private static final Object d(ThreadLocal<?> threadLocal, kotlin.coroutines.d<? super kotlin.l2> dVar) {
        kotlin.jvm.internal.i0.e(3);
        throw null;
    }

    @a7.e
    public static final Object e(@a7.d ThreadLocal<?> threadLocal, @a7.d kotlin.coroutines.d<? super Boolean> dVar) {
        return kotlin.coroutines.jvm.internal.b.a(dVar.d().get(new kotlinx.coroutines.internal.y0(threadLocal)) != null);
    }

    private static final Object f(ThreadLocal<?> threadLocal, kotlin.coroutines.d<? super Boolean> dVar) {
        kotlin.jvm.internal.i0.e(3);
        throw null;
    }
}
