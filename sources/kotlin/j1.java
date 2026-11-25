package kotlin;

/* JADX INFO: loaded from: classes2.dex */
class j1 extends i1 {
    @kotlin.internal.f
    private static final <R> R l(Object lock, i5.a<? extends R> block) {
        R rInvoke;
        kotlin.jvm.internal.l0.p(lock, "lock");
        kotlin.jvm.internal.l0.p(block, "block");
        synchronized (lock) {
            try {
                rInvoke = block.invoke();
                kotlin.jvm.internal.i0.d(1);
            } finally {
                kotlin.jvm.internal.i0.d(1);
                kotlin.jvm.internal.i0.c(1);
            }
        }
        return rInvoke;
    }
}
