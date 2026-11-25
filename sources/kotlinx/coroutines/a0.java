package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
final class a0<T> extends w2 implements z<T>, kotlinx.coroutines.selects.d<T> {
    public a0(@a7.e o2 o2Var) {
        super(true);
        R0(o2Var);
    }

    @Override // kotlinx.coroutines.d1
    @a7.d
    public kotlinx.coroutines.selects.d<T> C() {
        return this;
    }

    @Override // kotlinx.coroutines.z
    public boolean G0(T t7) {
        return Z0(t7);
    }

    @Override // kotlinx.coroutines.w2
    public boolean H0() {
        return true;
    }

    @Override // kotlinx.coroutines.z
    public boolean f(@a7.d Throwable th) {
        return Z0(new e0(th, false, 2, null));
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
