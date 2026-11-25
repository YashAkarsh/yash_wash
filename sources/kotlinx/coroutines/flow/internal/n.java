package kotlinx.coroutines.flow.internal;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements kotlin.coroutines.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    @h5.e
    public final Throwable f36384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ kotlin.coroutines.g f36385b;

    public n(@a7.d Throwable th, @a7.d kotlin.coroutines.g gVar) {
        this.f36384a = th;
        this.f36385b = gVar;
    }

    @Override // kotlin.coroutines.g
    public <R> R fold(R r7, @a7.d i5.p<? super R, ? super kotlin.coroutines.g.b, ? extends R> pVar) {
        return (R) this.f36385b.fold(r7, pVar);
    }

    @Override // kotlin.coroutines.g
    @a7.e
    public <E extends kotlin.coroutines.g.b> E get(@a7.d kotlin.coroutines.g.c<E> cVar) {
        return (E) this.f36385b.get(cVar);
    }

    @Override // kotlin.coroutines.g
    @a7.d
    public kotlin.coroutines.g minusKey(@a7.d kotlin.coroutines.g.c<?> cVar) {
        return this.f36385b.minusKey(cVar);
    }

    @Override // kotlin.coroutines.g
    @a7.d
    public kotlin.coroutines.g plus(@a7.d kotlin.coroutines.g gVar) {
        return this.f36385b.plus(gVar);
    }
}
