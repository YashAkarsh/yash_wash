package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
public final class x1 {
    @a7.d
    public static final u1 a() {
        return new i(Thread.currentThread());
    }

    public static final void b(@a7.d i5.a<kotlin.l2> aVar) {
        aVar.invoke();
    }

    @j2
    public static final long c() {
        u1 u1VarA = v3.f37337a.a();
        if (u1VarA == null) {
            return Long.MAX_VALUE;
        }
        return u1VarA.W1();
    }
}
