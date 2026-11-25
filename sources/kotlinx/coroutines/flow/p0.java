package kotlinx.coroutines.flow;

/* JADX INFO: loaded from: classes3.dex */
public final class p0 {
    @a7.d
    public static final o0 a(@a7.d o0.a aVar, long j7, long j8) {
        return new s0(kotlin.time.d.I(j7), kotlin.time.d.I(j8));
    }

    public static /* synthetic */ o0 b(o0.a aVar, long j7, long j8, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            j7 = kotlin.time.d.f35456b.W();
        }
        if ((i7 & 2) != 0) {
            j8 = kotlin.time.d.f35456b.q();
        }
        return a(aVar, j7, j8);
    }
}
