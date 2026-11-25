package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
final class e4 implements kotlin.coroutines.g.b, kotlin.coroutines.g.c<e4> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    public static final e4 f35989a = new e4();

    private e4() {
    }

    @Override // kotlin.coroutines.g.b, kotlin.coroutines.g
    public <R> R fold(R r7, @a7.d i5.p<? super R, ? super kotlin.coroutines.g.b, ? extends R> pVar) {
        return (R) kotlin.coroutines.g.b.a.a(this, r7, pVar);
    }

    @Override // kotlin.coroutines.g.b, kotlin.coroutines.g
    @a7.e
    public <E extends kotlin.coroutines.g.b> E get(@a7.d kotlin.coroutines.g.c<E> cVar) {
        return (E) kotlin.coroutines.g.b.a.b(this, cVar);
    }

    @Override // kotlin.coroutines.g.b
    @a7.d
    public kotlin.coroutines.g.c<?> getKey() {
        return this;
    }

    @Override // kotlin.coroutines.g.b, kotlin.coroutines.g
    @a7.d
    public kotlin.coroutines.g minusKey(@a7.d kotlin.coroutines.g.c<?> cVar) {
        return kotlin.coroutines.g.b.a.c(this, cVar);
    }

    @Override // kotlin.coroutines.g
    @a7.d
    public kotlin.coroutines.g plus(@a7.d kotlin.coroutines.g gVar) {
        return kotlin.coroutines.g.b.a.d(this, gVar);
    }
}
