package kotlinx.coroutines.scheduling;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    @h5.h(name = "isSchedulerWorker")
    public static final boolean a(@a7.d Thread thread) {
        return thread instanceof a.c;
    }

    @h5.h(name = "mayNotBlock")
    public static final boolean b(@a7.d Thread thread) {
        return (thread instanceof a.c) && ((a.c) thread).f37153b == a.d.CPU_ACQUIRED;
    }
}
