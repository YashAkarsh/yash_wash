package kotlinx.coroutines.flow;

import java.util.List;
import kotlinx.coroutines.o2;

/* JADX INFO: loaded from: classes3.dex */
final class g0<T> implements t0<T>, c<T>, kotlinx.coroutines.flow.internal.r<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.e
    private final o2 f36257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ t0<T> f36258b;

    /* JADX WARN: Multi-variable type inference failed */
    public g0(@a7.d t0<? extends T> t0Var, @a7.e o2 o2Var) {
        this.f36257a = o2Var;
        this.f36258b = t0Var;
    }

    @Override // kotlinx.coroutines.flow.i0, kotlinx.coroutines.flow.i
    @a7.e
    public Object a(@a7.d j<? super T> jVar, @a7.d kotlin.coroutines.d<?> dVar) {
        return this.f36258b.a(jVar, dVar);
    }

    @Override // kotlinx.coroutines.flow.i0
    @a7.d
    public List<T> b() {
        return this.f36258b.b();
    }

    @Override // kotlinx.coroutines.flow.internal.r
    @a7.d
    public i<T> c(@a7.d kotlin.coroutines.g gVar, int i7, @a7.d kotlinx.coroutines.channels.m mVar) {
        return v0.d(this, gVar, i7, mVar);
    }

    @Override // kotlinx.coroutines.flow.t0
    public T getValue() {
        return this.f36258b.getValue();
    }
}
