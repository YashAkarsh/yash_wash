package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
class e1<T> extends a<T> implements d1<T>, kotlinx.coroutines.selects.d<T> {
    public e1(@a7.d kotlin.coroutines.g gVar, boolean z7) {
        super(gVar, true, z7);
    }

    @Override // kotlinx.coroutines.d1
    @a7.d
    public kotlinx.coroutines.selects.d<T> C() {
        return this;
    }

    @Override // kotlinx.coroutines.selects.d
    public <R> void h(@a7.d kotlinx.coroutines.selects.f<? super R> fVar, @a7.d i5.p<? super T, ? super kotlin.coroutines.d<? super R>, ? extends Object> pVar) {
        m1(fVar, pVar);
    }

    @Override // kotlinx.coroutines.d1
    @a7.e
    public Object h0(@a7.d kotlin.coroutines.d<? super T> dVar) {
        return a0(dVar);
    }

    @Override // kotlinx.coroutines.d1
    public T u() {
        return (T) A0();
    }
}
