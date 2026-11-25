package kotlinx.coroutines.internal;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f36982a = 16;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private static final r0 f36983b = new r0("CLOSED");

    @a7.d
    public static final <N extends h<N>> N b(@a7.d N n7) {
        while (true) {
            Object objE = n7.e();
            if (objE == f36983b) {
                return n7;
            }
            h hVar = (h) objE;
            if (hVar != null) {
                n7 = (N) hVar;
            } else if (n7.j()) {
                return n7;
            }
        }
    }

    private static final <S extends o0<S>> Object c(S s7, long j7, i5.p<? super Long, ? super S, ? extends S> pVar) {
        while (true) {
            if (s7.o() >= j7 && !s7.g()) {
                return p0.b(s7);
            }
            Object objE = s7.e();
            if (objE == f36983b) {
                return p0.b(f36983b);
            }
            S sA0 = (S) ((h) objE);
            if (sA0 == null) {
                sA0 = pVar.a0(Long.valueOf(s7.o() + 1), s7);
                if (s7.m(sA0)) {
                    if (s7.g()) {
                        s7.l();
                    }
                }
            }
            s7 = (Object) sA0;
        }
    }

    private static /* synthetic */ void d() {
    }
}
