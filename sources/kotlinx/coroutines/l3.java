package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
public final class l3 {

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.a<kotlin.l2> f37082a;

        public a(i5.a<kotlin.l2> aVar) {
            this.f37082a = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f37082a.invoke();
        }
    }

    @a7.d
    public static final Runnable a(@a7.d i5.a<kotlin.l2> aVar) {
        return new a(aVar);
    }
}
