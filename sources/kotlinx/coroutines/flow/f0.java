package kotlinx.coroutines.flow;

import java.util.List;
import kotlinx.coroutines.o2;

/* JADX INFO: loaded from: classes3.dex */
final class f0<T> implements i0<T>, c<T>, kotlinx.coroutines.flow.internal.r<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.e
    private final o2 f36246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ i0<T> f36247b;

    /* JADX WARN: Multi-variable type inference failed */
    public f0(@a7.d i0<? extends T> i0Var, @a7.e o2 o2Var) {
        this.f36246a = o2Var;
        this.f36247b = i0Var;
    }

    @Override // kotlinx.coroutines.flow.i0, kotlinx.coroutines.flow.i
    @a7.e
    public Object a(@a7.d j<? super T> jVar, @a7.d kotlin.coroutines.d<?> dVar) {
        return this.f36247b.a(jVar, dVar);
    }

    @Override // kotlinx.coroutines.flow.i0
    @a7.d
    public List<T> b() {
        return this.f36247b.b();
    }

    @Override // kotlinx.coroutines.flow.internal.r
    @a7.d
    public i<T> c(@a7.d kotlin.coroutines.g gVar, int i7, @a7.d kotlinx.coroutines.channels.m mVar) {
        return k0.e(this, gVar, i7, mVar);
    }
}
