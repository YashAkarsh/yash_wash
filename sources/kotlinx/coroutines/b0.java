package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
public final class b0 {
    @a7.d
    public static final <T> z<T> a(T t7) {
        a0 a0Var = new a0(null);
        a0Var.G0(t7);
        return a0Var;
    }

    @a7.d
    public static final <T> z<T> b(@a7.e o2 o2Var) {
        return new a0(o2Var);
    }

    public static /* synthetic */ z c(o2 o2Var, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            o2Var = null;
        }
        return b(o2Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> boolean d(@a7.d z<T> zVar, @a7.d Object obj) {
        Throwable thE = kotlin.d1.e(obj);
        return thE == null ? zVar.G0(obj) : zVar.f(thE);
    }
}
