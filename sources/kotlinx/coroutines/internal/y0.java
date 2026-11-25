package kotlinx.coroutines.internal;

/* JADX INFO: loaded from: classes3.dex */
@kotlin.a1
public final class y0 implements kotlin.coroutines.g.c<x0<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final ThreadLocal<?> f37059a;

    public y0(@a7.d ThreadLocal<?> threadLocal) {
        this.f37059a = threadLocal;
    }

    private final ThreadLocal<?> a() {
        return this.f37059a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ y0 c(y0 y0Var, ThreadLocal threadLocal, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            threadLocal = y0Var.f37059a;
        }
        return y0Var.b(threadLocal);
    }

    @a7.d
    public final y0 b(@a7.d ThreadLocal<?> threadLocal) {
        return new y0(threadLocal);
    }

    public boolean equals(@a7.e Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof y0) && kotlin.jvm.internal.l0.g(this.f37059a, ((y0) obj).f37059a);
    }

    public int hashCode() {
        return this.f37059a.hashCode();
    }

    @a7.d
    public String toString() {
        return "ThreadLocalKey(threadLocal=" + this.f37059a + ')';
    }
}
