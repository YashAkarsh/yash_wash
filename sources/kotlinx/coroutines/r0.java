package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
public final class r0 {

    public static final class a extends kotlin.coroutines.a implements p0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.p<kotlin.coroutines.g, Throwable, kotlin.l2> f37117a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(i5.p<? super kotlin.coroutines.g, ? super Throwable, kotlin.l2> pVar, p0.b bVar) {
            super(bVar);
            this.f37117a = pVar;
        }

        @Override // kotlinx.coroutines.p0
        public void handleException(@a7.d kotlin.coroutines.g gVar, @a7.d Throwable th) {
            this.f37117a.a0(gVar, th);
        }
    }

    @a7.d
    public static final p0 a(@a7.d i5.p<? super kotlin.coroutines.g, ? super Throwable, kotlin.l2> pVar) {
        return new a(pVar, p0.f37107r0);
    }

    @j2
    public static final void b(@a7.d kotlin.coroutines.g gVar, @a7.d Throwable th) {
        try {
            p0 p0Var = (p0) gVar.get(p0.f37107r0);
            if (p0Var == null) {
                q0.a(gVar, th);
            } else {
                p0Var.handleException(gVar, th);
            }
        } catch (Throwable th2) {
            q0.a(gVar, c(th, th2));
        }
    }

    @a7.d
    public static final Throwable c(@a7.d Throwable th, @a7.d Throwable th2) {
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        kotlin.p.a(runtimeException, th);
        return runtimeException;
    }
}
