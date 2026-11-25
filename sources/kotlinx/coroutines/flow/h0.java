package kotlinx.coroutines.flow;

import kotlin.l2;

/* JADX INFO: loaded from: classes3.dex */
final class h0<T> extends a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final i5.p<j<? super T>, kotlin.coroutines.d<? super l2>, Object> f36260a;

    /* JADX WARN: Multi-variable type inference failed */
    public h0(@a7.d i5.p<? super j<? super T>, ? super kotlin.coroutines.d<? super l2>, ? extends Object> pVar) {
        this.f36260a = pVar;
    }

    @Override // kotlinx.coroutines.flow.a
    @a7.e
    public Object d(@a7.d j<? super T> jVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        Object objA0 = this.f36260a.a0(jVar, dVar);
        return objA0 == kotlin.coroutines.intrinsics.d.h() ? objA0 : l2.f34958a;
    }
}
