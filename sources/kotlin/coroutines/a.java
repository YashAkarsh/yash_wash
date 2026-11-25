package kotlin.coroutines;

import i5.p;
import kotlin.g1;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
@g1(version = "1.3")
public abstract class a implements g.b {

    @a7.d
    private final g.c<?> key;

    public a(@a7.d g.c<?> key) {
        l0.p(key, "key");
        this.key = key;
    }

    @Override // kotlin.coroutines.g.b, kotlin.coroutines.g
    public <R> R fold(R r7, @a7.d p<? super R, ? super g.b, ? extends R> pVar) {
        return (R) g.b.a.a(this, r7, pVar);
    }

    @Override // kotlin.coroutines.g.b, kotlin.coroutines.g
    @a7.e
    public <E extends g.b> E get(@a7.d g.c<E> cVar) {
        return (E) g.b.a.b(this, cVar);
    }

    @Override // kotlin.coroutines.g.b
    @a7.d
    public g.c<?> getKey() {
        return this.key;
    }

    @Override // kotlin.coroutines.g.b, kotlin.coroutines.g
    @a7.d
    public g minusKey(@a7.d g.c<?> cVar) {
        return g.b.a.c(this, cVar);
    }

    @Override // kotlin.coroutines.g
    @a7.d
    public g plus(@a7.d g gVar) {
        return g.b.a.d(this, gVar);
    }
}
