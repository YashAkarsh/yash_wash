package kotlinx.coroutines.flow.internal;

import kotlin.l2;
import kotlinx.coroutines.channels.m0;
import kotlinx.coroutines.j2;

/* JADX INFO: loaded from: classes3.dex */
@j2
public final class y<T> implements kotlinx.coroutines.flow.j<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final m0<T> f36410a;

    /* JADX WARN: Multi-variable type inference failed */
    public y(@a7.d m0<? super T> m0Var) {
        this.f36410a = m0Var;
    }

    @Override // kotlinx.coroutines.flow.j
    @a7.e
    public Object f(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        Object objR = this.f36410a.R(t7, dVar);
        return objR == kotlin.coroutines.intrinsics.d.h() ? objR : l2.f34958a;
    }
}
